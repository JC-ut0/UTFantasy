package csc207.phase1.UTFantasy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;

import java.util.ArrayList;

import csc207.phase1.UTFantasy.Map.MapView;
import csc207.phase1.UTFantasy.Map.UnitDraw;

public class MapManager {
    /**
     * the array list that represents the elements of this map that are at a low height
     */
    static ArrayList<UnitDraw> lowMap = new ArrayList<>();

    /**
     * the array list that represents the elements of this map that are at a high height
     */
    static ArrayList<UnitDraw> highMap = new ArrayList<>();

    public ArrayList<double[]> blockMap = new ArrayList<>();

    /**
     * the array list that represents the low elements shown on the screen currently
     */
    public ArrayList<UnitDraw> currentLow;

    /**
     * the array list that represents the high elements shown on the screen currently
     */
    public ArrayList<UnitDraw> currentHigh;

    /**
     * the width of the whole map
     */
    private int mapWidth = 104;

    /**
     * the height of the whole map
     */
    int mapHeight = 102;

    /**
     * the width of the screen
     */
    int width;
    /**
     * the height of the screen
     */
    int height;

    /**
     * the map view this map manager manages
     */
    private MapView mapView;

    /**
     * the Bitmap of a lawn
     */
    private Bitmap lawn;

    /**
     * the Bitmap of a tree
     */
    private Bitmap tree;

    /**
     * the Bitmap of the character upwards
     */
    private Bitmap upPlayer;

    /**
     * the Bitmap of the character downwards
     */
    private Bitmap downPlayer;

    /**
     * the Bitmap of the character leftwards
     */
    private Bitmap leftPlayer;

    /**
     * the Bitmap of the character rightwards
     */
    private Bitmap rightPlayer;

    /**
     * Initialize a new MapManager
     *
     * @param w the width of the map
     * @param h the height of the map
     */
    public MapManager(int w, int h, MapView mapView) {
        this.width = w;
        this.height = h;
        this.mapView = mapView;
        lawn = getBitmap(R.drawable.lawn, (float) 1.5, (float) 1.5);
        tree = getBitmap(R.drawable.tree, (float) 1.5, (float) 1.5);
        upPlayer = getBitmap(R.drawable.player_up, 1, 1);
        downPlayer = getBitmap(R.drawable.player_down, 1, 1);
        leftPlayer = getBitmap(R.drawable.player_left, 1, 1);
        rightPlayer = getBitmap(R.drawable.player_right, 1, 1);
    }

    /**
     * return the mapView of this map manager
     */
    public MapView getMapView() {
        return mapView;
    }

    /**
     * return a resized Bitmap with its returned size be widthIndex * heightIndex times the original size
     *
     * @param id          the id of this bitmap drawable
     * @param widthIndex  the times that this bitmap's width should be resized by
     * @param heightIndex the times that this bitmap's height should be resized by
     * @return
     */
    private Bitmap getBitmap(int id, float widthIndex, float heightIndex) {
        Bitmap bitmap = BitmapFactory.decodeResource(mapView.getResources(), id);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(widthIndex, heightIndex);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
    }

    public void update(int x, int y) {
        // lawns and grass
        currentLow = new ArrayList<>();
        // trees and houses and npc
        currentHigh = new ArrayList<>();
        for (UnitDraw unit : lowMap) {
            if ((x - 2 - width / 2 <= unit.getX()) && (unit.getX() <= x + 2 + width / 2) &&
                    (y - 2 - height / 2 <= unit.getY()) && (unit.getY() <= y + 2 + height / 2)) {
                unit.setScreenX(width / 2 + unit.getX() - x);
                unit.setScreenY(height / 2 + unit.getY() - y);
                currentLow.add(unit);
            }
        }
        for (UnitDraw unit : highMap) {
            if ((x - 2 - width / 2 <= unit.getX()) && (unit.getX() <= x + 2 + width / 2) &&
                    (y - 2 - height / 2 <= unit.getY()) && (unit.getY() <= y + 2 + height / 2)) {
                unit.setScreenX(width / 2 + unit.getX() - x);
                unit.setScreenY(height / 2 + unit.getY() - y);
                currentHigh.add(unit);
            }
        }
    }


    public void draw(Canvas canvas) {

        for (UnitDraw unit : currentLow) {
            canvas.drawBitmap(lawn, unit.getScreenX() * MapView.unitWidth, unit.getScreenY() * MapView.unitHeight, null);
        }
        for (UnitDraw unit : currentHigh) {
            if (unit.getDraw().equals("tree")) {
                canvas.drawBitmap(tree, unit.getScreenX() * MapView.unitWidth, unit.getScreenY() * MapView.unitHeight, null);
            }
        }
        switch (mapView.player.direction) {
            case ("down"):
                canvas.drawBitmap(downPlayer, width / 2 * MapView.unitWidth, height / 2 * MapView.unitHeight, null);
                break;
            case ("up"):
                canvas.drawBitmap(upPlayer, width / 2 * MapView.unitWidth, height / 2 * MapView.unitHeight, null);
                break;
            case ("left"):
                canvas.drawBitmap(leftPlayer, width / 2 * MapView.unitWidth, height / 2 * MapView.unitHeight, null);
                break;
            case ("right"):
                canvas.drawBitmap(rightPlayer, width / 2 * MapView.unitWidth, height / 2 * MapView.unitHeight, null);
                break;
        }
    }

    public void mapInitialization() {
        // add low elements
        for (float a = 0; a < mapWidth; a += 0.75) {
            for (float b = 0; b < mapHeight; b += 0.75) {
                lowMap.add(new UnitDraw("lawn", a, b));
            }
        }
        // add high elements
        double[] block;
        for (float a = 0; a < mapWidth; a += 1.5) {
            for (float b = 0; b <= 3; b += 1.5) {
                highMap.add(new UnitDraw("tree", a, b));
            }
            for (float b = 97; b <= 100; b += 1.5) {
                highMap.add(new UnitDraw("tree", a, b));
            }
        }
        block = new double[]{0, mapWidth, 0, 3};
        blockMap.add(block);
        block = new double[]{0, mapWidth, 97, 100};
        blockMap.add(block);
        for (float b = (float) 4.5; b < 97; b += 1.5) {
            for (float a = 0; a <= 3; a += 1.5) {
                highMap.add(new UnitDraw("tree", a, b));
            }
            for (float a = 23; a <= 26; a += 1.5) {
                highMap.add(new UnitDraw("tree", a, b));
            }
            for (float a = 101; a <= 104; a += 1.5) {
                highMap.add(new UnitDraw("tree", a, b));
            }
        }
        block = new double[]{0, 3, 4.5, 97};
        blockMap.add(block);
        block = new double[]{23, 26, 4, 97};
        blockMap.add(block);
        block = new double[]{101, 104, 4, 97};
        blockMap.add(block);
    }
}
