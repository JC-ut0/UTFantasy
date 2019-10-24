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
    float x;

    /**
     * the y coordinate of this UnitDraw
     */
    float y;


    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    UnitDraw(Bitmap bitmap, float x, float y) {
        this.bitmap = bitmap;
        this.x = x;
        this.y = y;
    }

    /**
     * draw this UnitDraw at its location
     */
    void draw(Canvas canvas, int screenX, int screenY) {
        canvas.drawBitmap(bitmap, (x + screenX) * MapView.unitWidth, (screenY + y) * MapView.unitHeight, null);
    }
}
