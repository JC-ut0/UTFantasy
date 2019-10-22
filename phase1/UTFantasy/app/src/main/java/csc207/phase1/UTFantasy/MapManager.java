package csc207.phase1.UTFantasy;

import android.graphics.Canvas;

import java.sql.SQLOutput;
import java.util.ArrayList;

import csc207.phase1.UTFantasy.Character.Player;

public class MapManager {

    /**
     * the 2-d list that represents the land of this map
     */
    ArrayList<UnitDraw> land;

    /**
     * the 2-d list that represents the trees in this map
     */
    ArrayList<UnitDraw> trees;

    /**
     * the width of the whole map
     */
    private int mapWidth = 50;

    /**
     * the height of the whole map
     */
    int mapHeight = 50;

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
     * the list of UnitDraw that need to be drawed for the current screen
     */
    ArrayList<UnitDraw> currentDraw;

    /**
     * Initialize a new MapManager
     *
     * @param w the width of the map
     * @param h the height of the map
     */
    MapManager(int w, int h, MapView mapView) {
        this.width = w;
        this.height = h;
        land = new ArrayList<>();
        this.mapView = mapView;
    }

    void update(int x, int y) {
        ArrayList<UnitDraw> screenUnits = new ArrayList<>();
        for (UnitDraw unit : land) {
            if ((x - width / 2 < unit.x) && (unit.x < x + width / 2) &&
                    (y - height / 2 < unit.y) && (unit.y < y + height / 2)) {
                screenUnits.add(unit);
            }
        }
        currentDraw = screenUnits;
    }


    void draw(Canvas canvas, int screenX, int screenY) {
        for (UnitDraw unit : currentDraw) {
            unit.draw(canvas, screenX, screenY);
        }
    }

    public void addItems() {
        for (int a = 0; a < mapWidth; a++) {
            for (int b = 0; b < mapHeight; b++) {
                land.add(new UnitDraw(mapView.getLawn(), a, b));
            }
        }
        land.add(new UnitDraw(mapView.getPikachu(), 23, 12));
    }
}
