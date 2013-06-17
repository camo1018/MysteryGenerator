package pp.mysterygenerator;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

	private GameThread thread;
	private Player player;
	private Level level;
	
	public GamePanel(Context context) {
		super(context);
		getHolder().addCallback(this);
		player = new Player(BitmapFactory.decodeResource(getResources(), R.drawable.gumshoe_sprite), 50, 50);
		level = new Level(BitmapFactory.decodeResource(getResources(), R.drawable.room));
		thread = new GameThread(getHolder(), this);
		setFocusable(true);
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		
	}
	
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		thread.setRunning(true);
		thread.start();
	}
	
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		while (retry) {
			try {
				thread.join();
				retry = false;
			}
			catch (InterruptedException e) {
			}
		}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		player.setX((int)event.getX());
		player.setY((int)event.getY());
		return true;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		//canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.droid_1), 10, 10, null);
		canvas.drawColor(Color.BLACK);
		level.draw(canvas);
		player.draw(canvas);
	}
	
}
