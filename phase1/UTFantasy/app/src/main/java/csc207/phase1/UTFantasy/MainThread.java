package csc207.phase1.UTFantasy;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread {

    private SurfaceHolder surfaceHolder;

    private boolean isRunning;

    private MapView mapView;

    private Canvas canvas;

    public MainThread(SurfaceHolder holder, MapView mapView){
        this.surfaceHolder = holder;
        this.mapView = mapView;
    }

    @Override
    public void run() {

        while (isRunning ) {
            canvas = null;
            try {
                canvas = surfaceHolder.lockCanvas();
                mapView.update();
                mapView.draw(canvas);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas != null) {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }

    public void setRunning(boolean isRunning){
        this.isRunning = isRunning;
    }
}
