package pp.mysterygenerator;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameThread extends Thread {
	
	private boolean running;
	private SurfaceHolder surfaceHolder;
	private GamePanel gamePanel;
	
	private static final String TAG = GameThread.class.getSimpleName();
	
	public GameThread(SurfaceHolder surfaceHolder, GamePanel gamePanel) {
		this.surfaceHolder = surfaceHolder;
		this.gamePanel = gamePanel;
	}
	
	public void setRunning(boolean running) {
		this.running = running;
	}
	
	@Override
	public void run() {
		Canvas canvas;
		Log.d(TAG, "Game loop starting...");
		while (running) {
			canvas = null;
			// Try to lock the canvas
			try {
				canvas = this.surfaceHolder.lockCanvas();
				synchronized (surfaceHolder) {
					this.gamePanel.onDraw(canvas);
				}
			}
			finally {
				if (canvas != null) {
					surfaceHolder.unlockCanvasAndPost(canvas);
				}
			}
		}
	}
}
