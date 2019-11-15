package csc207.phase2.UTFantasy;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import csc207.phase2.UTFantasy.Map.MapView;

public class MainThread extends Thread {

  /** The canvas container. */
  private SurfaceHolder surfaceHolder;
  /** Whether the thread is running. */
  private boolean isRunning;
  /** Where the characters are drawn. */
  private MapView mapView;
  /** The canvas on which to draw all characters. */
  private Canvas canvas;

  /**
   * Construct the thread.
   *
   * @param holder the canvas container.
   * @param mapView where the characters are drawn.
   */
  public MainThread(SurfaceHolder holder, MapView mapView) {
    this.surfaceHolder = holder;
    this.mapView = mapView;
  }

  @Override
  public void run() {

    while (isRunning) {
      canvas = null;
      try {
        canvas = surfaceHolder.lockCanvas();
        mapView.update();
        mapView.draw(canvas);
        sleep(30);
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        if (canvas != null) {
          surfaceHolder.unlockCanvasAndPost(canvas);
        }
      }
    }
  }

  /**
   * Check if the thread is running.
   *
   * @return true if the thread is running, false otherwise.
   */
  public boolean getRunning() {
    return isRunning;
  }

  public void setRunning(boolean isRunning) {
    this.isRunning = isRunning;
  }
}
