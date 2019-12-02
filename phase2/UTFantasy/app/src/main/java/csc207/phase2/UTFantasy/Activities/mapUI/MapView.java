package csc207.phase2.UTFantasy.Activities.mapUI;

import android.content.Context;
import android.content.res.Resources;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.Serializable;

import csc207.phase2.UTFantasy.mapUseCase.MainThread;

public class MapView extends SurfaceView
    implements SurfaceHolder.Callback, Serializable, MapViewModel {
  /** The part of the program that manages time. */
  private MainThread thread;

  public MapView(Context context) {
    super(context);
    getHolder().addCallback(this);
    setFocusable(true);
  }

  public MainThread getThread() {
    return thread;
  }

  public void setThread(MainThread mainThread) {
    this.thread = mainThread;
  }

  @Override
  public void surfaceCreated(SurfaceHolder holder) {
    try {
      thread.start();
    } catch (NullPointerException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

  @Override
  public void surfaceDestroyed(SurfaceHolder holder) {
    boolean retry = true;
    while (retry) {
      try {
        thread.setRunning(false);
        thread.join();

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      retry = false;
    }
  }

  @Override
  public Resources getResource() {
    return this.getResources();
  }
}
