package csc207.phase1.UTFantasy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

public class UnitDraw {

    /**
     * the Bitmap this unitDraw represents
     */
    private Bitmap bitmap;
    /**
     * the x coordinate of this UnitDraw
     */
    public float x;

    /**
     * the y coordinate of this UnitDraw
     */
    public float y;

    /**
     * the x coordinate of this UnitDraw on the screen coordinate system
     */
    float screenX;

    /**
     * the Y coordinate of this UnitDraw on the screen coordinate system
     */
    float screenY;

    public double getScreenX() {
        return screenX;
    }

    public double getScreenY() {
        return screenY;
    }

    public void setScreenX(float screenX) {
        this.screenX = screenX;
    }

    public void setScreenY(float screenY) {
        this.screenY = screenY;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public UnitDraw(Bitmap bitmap, float x, float y) {
        this.bitmap = bitmap;
        this.x = x;
        this.y = y;
    }

    /**
     * draw this UnitDraw at its location
     */
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, screenX * MapView.unitWidth, screenY * MapView.unitHeight, null);
    }
}
