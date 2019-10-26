package csc207.phase1.UTFantasy;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import csc207.phase1.UTFantasy.Character.Player;


public class MapView extends SurfaceView implements SurfaceHolder.Callback{

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

        width = screenWidth/unitWidth;
        height = screenHeight/unitHeight;
        player.setLocation(5, 5);
        mapManager = new MapManager(width, height, this);
        player.mapManager = mapManager;
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
        mapManager.draw(canvas);
    }

    public Bitmap getLawn() {
        Bitmap lawn = BitmapFactory.decodeResource(getResources(), R.drawable.lawn);
        int width = lawn.getWidth();
        int height = lawn.getHeight();
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        matrix.postScale((float) 1.5, (float) 1.5);

        // resize lawn
        lawn = Bitmap.createBitmap(
                lawn, 0, 0, width, height, matrix, false);
        return lawn;
    }

    public Bitmap getTree() {
        Bitmap tree = BitmapFactory.decodeResource(getResources(), R.drawable.tree);
        int width = tree.getWidth();
        int height = tree.getHeight();
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        matrix.postScale((float) 1.5, (float) 1.5);

        // resize lawn
        tree = Bitmap.createBitmap(
                tree, 0, 0, width, height, matrix, false);
        return tree;
    }

    public Bitmap getPlayerDownDirection(){
        return BitmapFactory.decodeResource(getResources(),R.drawable.player_down);
    }
    public Bitmap getPlayerUpDirection(){
        return BitmapFactory.decodeResource(getResources(),R.drawable.player_up);
    }
    public Bitmap getPlayerLeftDirection(){
        return BitmapFactory.decodeResource(getResources(),R.drawable.player_left);
    }
    public Bitmap getPlayerRightDirection(){
        return BitmapFactory.decodeResource(getResources(),R.drawable.player_right);
    }
}
