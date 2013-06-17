package pp.mysterygenerator;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Contains information about a level, which can be anything from a room to a hotel.
 * 
 * @author PaulPa
 *
 */
public class Level {

	private Bitmap bitmap;
	
	public Level(Bitmap bitmap) {
		// TODO: Be able to change the structure of the level.
		this.bitmap = bitmap;
	}
	
	public Bitmap getBitmap() {
		return bitmap;
	}
	
	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}
	
	public void draw(Canvas canvas) {
		canvas.drawBitmap(bitmap, 0, 0, null);
	}
}
