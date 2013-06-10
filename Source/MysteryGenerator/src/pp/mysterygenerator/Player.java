package pp.mysterygenerator;

import android.graphics.Bitmap;

public class Player {
	
	private Bitmap bitmap;
	private int x;
	private int y;
	
	public Player(Bitmap bitmap, int x, int y) {
		this.bitmap = bitmap;
		this.x = x;
		this.y = y;
	}
	
	public Bitmap getBitmap() {
		return bitmap;
	}
	
	public void setBitmap(Bitmap bitmap) {
		
	}
	
}
