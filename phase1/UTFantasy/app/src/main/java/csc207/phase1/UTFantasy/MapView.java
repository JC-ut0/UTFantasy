package csc207.phase1.UTFantasy;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import csc207.phase1.UTFantasy.Character.Player;


public class MapView extends SurfaceView implements SurfaceHolder.Callback {

    public Player player;

    /**
     * Screen width.
     */
    static private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    /**
     * Screen height.
     */
    static private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

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
        Bitmap lawn = getLawn();

        unitWidth = lawn.getWidth();
        unitHeight = lawn.getHeight();

        width = screenWidth / unitWidth;
        height = screenHeight / unitHeight;
        player.setLocation(width/2, height/2 );
        mapManager = new MapManager(width, height, this);
        setFocusable(true);
    }

    public void update() {
        mapManager.update(player.getX(), player.getY());
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        mapManager.addItems();

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
        int screenX = width/2 - player.getX();
        int screenY = height/2 - player.getY();
        mapManager.draw(canvas, screenX, screenY);
    }

    public Bitmap getLawn() {
        return BitmapFactory.decodeResource(getResources(), R.drawable.lawn);
    }

    // it pronounces pikaCHOU
    public Bitmap getPikachu() {
        Bitmap pikachu = BitmapFactory.decodeResource(getResources(), R.drawable.pikachu);
//        pikachu = pikachu.copy(Bitmap.Config.ARGB_8888, true);
//        pikachu.setWidth(unitWidth);
//        pikachu.setHeight(unitHeight);
        return pikachu;
    }
}
