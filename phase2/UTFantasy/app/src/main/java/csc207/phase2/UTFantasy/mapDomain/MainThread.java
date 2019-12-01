package csc207.phase2.UTFantasy.mapDomain;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;

public class MainThread extends Thread {

  /** The canvas container. */
  private SurfaceHolder surfaceHolder;
  /** Whether the thread is running. */
  private boolean isRunning;
  /** The canvas on which to draw all characters. */
  private Canvas canvas;
  /** the drawer that is used by this MainThread to present. */
  private MapDrawer drawer;
  /** the interactor that is used by this MainThread to update. */
  private MapInteractor interactor;

  /** Construct the thread. */
  public MainThread(MapDrawer drawer, MapInteractor interactor) {
    this.drawer = drawer;
    this.interactor = interactor;
    this.surfaceHolder = drawer.getHolder();
  }

  @Override
  public void run() {
    while (isRunning) {
      canvas = null;
      try {
        canvas = surfaceHolder.lockCanvas();
        canvas.drawColor(Color.BLACK);
        boolean moveAble = interactor.checkMoveAble();
        interactor.updateProgress(moveAble);
        int progress = interactor.getProgress();
        UnitDraw[][] lowScreen = interactor.updateScreenOverLowMap();
        UnitDraw[][] highScreen = interactor.updateScreenOverHighMap();
        interactor.transScreen(lowScreen, progress, moveAble);
        interactor.transScreen(highScreen, progress, moveAble);
        int translatedWidth = interactor.getExtendedWidth() / 2;
        int translatedHeight = interactor.getExtendedHeight() / 2;
        drawer.draw(canvas, lowScreen, translatedWidth, translatedHeight);
        drawer.draw(canvas, highScreen, translatedWidth, translatedHeight);
        drawer.drawPlayer(
            canvas,
            interactor.getPlayerIcon(progress),
                interactor.getScreenUnitWidth() / 2 - translatedWidth,
                interactor.getScreenUnitHeight() / 2 - translatedHeight);
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
