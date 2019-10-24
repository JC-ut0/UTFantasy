package csc207.phase1.UTFantasy;

import android.graphics.Canvas;

import java.util.ArrayList;

public class MapManager {

    /**
     * the array list that represents the elements of this map that are at a low height
     */
    static ArrayList<UnitDraw> lowMap = new ArrayList<>();

    /**
     * the array list that represents the elements of this map that are at a high height
     */
    static ArrayList<UnitDraw> highMap = new ArrayList<>();

    public ArrayList<int[]> blockMap;

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
    int mapHeight = 100;

    /**
     * the width of the screen
     */
    int width;
    /**
     * the height of the screen
     */
    int height;


    /**
     * the map view of this map manager
     */
    private MapView mapView;

    /**
     * Initialize a new MapManager
     *
     * @param w the width of the map
     * @param h the height of the map
     */
    MapManager(int w, int h, MapView mapView) {
        this.width = w;
        this.height = h;
        lowMap = new ArrayList<>();
        this.mapView = mapView;
    }

    void update(int x, int y) {
        currentLow = new ArrayList<>();
        currentHigh = new ArrayList<>();
        for (UnitDraw unit : lowMap) {
            if ((x - 2 - width / 2 <= unit.x) && (unit.x <= x + 2 + width / 2) &&
                    (y - 2 - height / 2 <= unit.y) && (unit.y <= y + 2 + height / 2)) {
                currentLow.add(unit);
            }
        }
        for (UnitDraw unit : highMap) {
            if ((x - 2 - width / 2 <= unit.x) && (unit.x <= x + 2 + width / 2) &&
                    (y - 2 - height / 2 <= unit.y) && (unit.y <= y + 2 + height / 2)) {
                currentHigh.add(unit);
            }
        }
    }


    void draw(Canvas canvas, int screenX, int screenY) {
        for (UnitDraw unit : currentLow) {
            unit.draw(canvas, screenX, screenY);
        }
        for (UnitDraw unit : currentHigh) {
            unit.draw(canvas, screenX, screenY);
        }
        switch (mapView.player.direction){
            case("down"):
                canvas.drawBitmap(mapView.getPlayerDownDirection(),MapView.screenWidth/2,MapView.screenHeight/2,null);
                break;
            case("up"):
                canvas.drawBitmap(mapView.getPlayerUpDirection(),MapView.screenWidth/2,MapView.screenHeight/2,null);
                break;
            case("left"):
                canvas.drawBitmap(mapView.getPlayerLeftDirection(),MapView.screenWidth/2,MapView.screenHeight/2,null);
                break;
            case("right"):
                canvas.drawBitmap(mapView.getPlayerRightDirection(),MapView.screenWidth/2,MapView.screenHeight/2,null);
                break;
        }
    }

    public void addItems() {
        // add low elements
        for (float a = 0; a < mapWidth; a += 0.75) {
            for (float b = 0; b < mapHeight; b += 0.75) {
                lowMap.add(new UnitDraw(mapView.getLawn(), a, b));
            }
        }
        // add high elements
        int[] block;
        for (float a = 0; a < mapWidth; a += 1.5) {
            for (float b = 0; b <= 3; b += 1.5) {
                highMap.add(new UnitDraw(mapView.getTree(), a, b));
            }
            block = {0,mapWidth,0,3};
            blockMap.add(block);
            for (float b = 97; b <= 100; b += 1.5) {
                highMap.add(new UnitDraw(mapView.getTree(), a, b));
            }
            block = {0,mapWidth,97,100};
            blockMap.add(0,mapWidth,97,100);
        }
        for (float b = (float) 4.5; b < 97; b += 1.5) {
            for (float a = 0; a <= 3; a += 1.5) {
                highMap.add(new UnitDraw(mapView.getTree(), a, b));
            }
            blockMap.add(new int[]{0,3,4,97});
            for (float a = 23; a <= 26; a += 1.5) {
                highMap.add(new UnitDraw(mapView.getTree(), a, b));
            }
            blockMap.add(new int[]{23,26,4,97});
            for (float a = 101; a <= 104; a += 1.5) {
                highMap.add(new UnitDraw(mapView.getTree(), a, b));
            }
            blockMap.add(new int[]{101,104,4,97});
        }
    }
}
