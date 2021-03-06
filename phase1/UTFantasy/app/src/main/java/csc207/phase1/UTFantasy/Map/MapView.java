package csc207.phase1.UTFantasy.Map;


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
import csc207.phase1.UTFantasy.MainThread;
import csc207.phase1.UTFantasy.MapManager;
import csc207.phase1.UTFantasy.R;


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

    public MapView(Context context) {
        super(context);
    }

    public MapView(Context context, Player p) {
        super(context);
        this.player = p;
        getHolder().addCallback(this);
        setThread();
        unitWidth = 88;
        unitHeight = 88;

        width = screenWidth / unitWidth;
        height = screenHeight / unitHeight;
        mapManager = new MapManager(width + 4, height + 4, this);
        mapManager.mapInitialization();
        setFocusable(true);
    }

    /**
     * getter of MapManager
     *
     * @return a MapManager
     */
    public MapManager getMapManager() {
        return mapManager;
    }

    /**
     * getter of MainThread
     *
     * @return a MainThread
     */
    public MainThread getThread() {
        return thread;
    }

    public void setThread() {
        this.thread = new MainThread(getHolder(), this);
    }

    public void update() {
        mapManager.update(player.getX(), player.getY());
    }


    /**
     * get coordinate width
     *
     * @return coordinate width
     */
    public static int getCoordinateWidth() {
        return width;
    }

    /**
     * get coordinate height
     *
     * @return coordinate height
     */
    public static int getCoordinateHeight() {
        return height;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

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
