package csc207.phase1.UTFantasy;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.Serializable;

import csc207.phase1.UTFantasy.Character.Player;


public class MapView extends SurfaceView implements SurfaceHolder.Callback, Serializable {

    public Player player;

    /**
     * Screen width.
     */
    static int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    /**
     * Screen height.
     */
    static int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    /**
     * the largest x value of the screen coordinate system
     */
    static private int width;

    /**
     * the largest y value of the screen coordinate system
     */
    static private int height;

    /**
     * the width of one unit
     */
    static public int unitWidth;

    /**
     * the height of one unit;
     */
    static public int unitHeight;

    /**
     * the MapManager this MapView corresponds to
     */
    private MapManager mapManager;

    /**
     * The part of the program that manages time.
     */
    private MainThread thread;

    public MapView(Context context, Player p) {
        super(context);
        this.player = p;
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        unitWidth = 88;
        unitHeight = 88;

        width = screenWidth / unitWidth;
        height = screenHeight / unitHeight;
        player.setLocation(5, 5);
        mapManager = new MapManager(width, height, this);
        player.mapManager = mapManager;
        setFocusable(true);
    }

    public MapManager getMapManager() {
        return mapManager;
    }

    public MainThread getThread() {
        return thread;
    }

    public void setThread(MainThread thread) {
        this.thread = thread;
    }

    public void update() {
        mapManager.update(player.getX(), player.getY());
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        mapManager.mapInitialization();
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

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
    public void draw(Canvas canvas) {
        super.draw(canvas);
        mapManager.draw(canvas);
    }
}
