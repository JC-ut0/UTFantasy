package csc207.phase1.UTFantasy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;

import java.io.Serializable;
import java.util.ArrayList;

import csc207.phase1.UTFantasy.Character.NPC;
import csc207.phase1.UTFantasy.Map.MapView;
import csc207.phase1.UTFantasy.Map.UnitDraw;

public class MapManager implements Serializable {
    /**
     * the width of the whole map
     */
    private int mapWidth = 104;

    /**
     * the height of the whole map
     */
    private int mapHeight = 102;

    /**
     * the width of the screen
     */
    private int screenWidth;

    /**
     * the height of the screen
     */
    private int screenHeight;

    /**
     * the array list of npc unit draw on the map
     */
    private ArrayList<UnitDraw> npcList = new ArrayList<>();

    /**
     * the array list that represents the elements of this map that are at a low height
     */
    private String[][] lowMap = new String[mapWidth][mapHeight];

    /**
     * the array list that represents the elements of this map that are at a high height
     */
    private String[][] highMap = new String[mapWidth][mapHeight];

    /**
     * the array list that represents all the elements that should be shown on the screen currently
     */
    private String[][] currentLow;

    private String[][] currentHigh;

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
     * the Bitmap of the fightNpc
     */
    private Bitmap fightNpc;

    /**
     * the Bitmap of the seller
     */
    private Bitmap sellerNpc;

    /**
     * the Bitmap of the healer
     */
    private Bitmap healerNpc;

    /**
     * Initialize a new MapManager
     *
     * @param w the width of the map
     * @param h the height of the map
     */
    public MapManager(int w, int h, MapView mapView) {
        this.screenWidth = w;
        this.screenHeight = h;
        this.mapView = mapView;
        lawn = getBitmap(R.drawable.lawn, (float) 2, (float) 2);
        tree = getBitmap(R.drawable.tree, (float) 1.8, (float) 1.8);
        upPlayer = getBitmap(R.drawable.player_up, 1, 1);
        downPlayer = getBitmap(R.drawable.player_down, 1, 1);
        leftPlayer = getBitmap(R.drawable.player_left, 1, 1);
        rightPlayer = getBitmap(R.drawable.player_right, 1, 1);
        fightNpc = getBitmap(R.drawable.professor, 2, 2);
        sellerNpc = getBitmap(R.drawable.big_mom, (float) 2.5, (float) 2.5);
        healerNpc = getBitmap(R.drawable.joy, 1, 1);

        mapInitialization();
    }

    /**
     * return the mapView of this map manager
     */
    public MapView getMapView() {
        return mapView;
    }

    /**
     * return a resized Bitmap with its returned size be widthIndex * heightIndex times the original
     * size
     *
     * @param id          the id of this bitmap drawable
     * @param widthIndex  the times that this bitmap's width should be resized by
     * @param heightIndex the times that this bitmap's height should be resized by
     * @return a resized bitmap
     */
    private Bitmap getBitmap(int id, float widthIndex, float heightIndex) {
        Bitmap bitmap = BitmapFactory.decodeResource(mapView.getResources(), id);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(widthIndex, heightIndex);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
    }

    /**
     * player position is always at the center of the screen update to get all the unitDraw that need
     * to be drawled on the screen
     *
     * @param playerX the x value of player
     * @param playerY the y value of player
     */
    public void update(int playerX, int playerY) {
        currentLow = new String[screenWidth][screenHeight];
        currentHigh = new String[screenWidth][screenHeight];
        for (int x = 0; x < screenWidth; x++) {
            for (int y = 0; y < screenHeight; y++) {
                try {
                    if (lowMap[playerX + x - screenWidth / 2][playerY + y - screenHeight / 2] != null) {
                        currentLow[x][y] = lowMap[playerX + x - screenWidth / 2][playerY + y - screenHeight / 2];
                    }
                    if (highMap[playerX + x - screenWidth / 2][playerY + y - screenHeight / 2] != null) {
                        currentHigh[x][y] = highMap[playerX + x - screenWidth / 2][playerY + y - screenHeight / 2];
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    public void draw(Canvas canvas) {
        for (int x = 0; x < screenWidth; x++) {
            for (int y = 0; y < screenHeight; y++) {
                if (currentLow[x][y] != null) {
                    if (currentLow[x][y].equals("lawn")) {
                        canvas.drawBitmap(
                                lawn,
                                x * MapView.unitWidth,
                                y * MapView.unitHeight,
                                null);
                    }
                }
            }
        }
        for (int y = 0; y < screenHeight; y++) {
            for (int x = 0; x < screenWidth; x++) {
                if (currentHigh[x][y] != null) {
                    switch (currentHigh[x][y]) {
                        case "tree":
                            canvas.drawBitmap(
                                    tree,
                                    x * MapView.unitWidth,
                                    y * MapView.unitHeight,
                                    null);
                            break;
                        case "Professor. P":
                            canvas.drawBitmap(
                                    fightNpc,
                                    x * MapView.unitWidth,
                                    y * MapView.unitHeight,
                                    null);
                            break;
                        case "Alice":
                            canvas.drawBitmap(
                                    sellerNpc,
                                    x * MapView.unitWidth,
                                    y * MapView.unitHeight,
                                    null);
                            break;
                        case "SecondCup":
                            canvas.drawBitmap(
                                    healerNpc,
                                    x * MapView.unitWidth,
                                    y * MapView.unitHeight,
                                    null);
                            break;
                    }
                }
            }
        }
        switch (mapView.player.direction) {
            case ("down"):
                canvas.drawBitmap(
                        downPlayer, screenWidth / 2 * MapView.unitWidth, screenHeight / 2 * MapView.unitHeight, null);
                break;
            case ("up"):
                canvas.drawBitmap(
                        upPlayer, screenWidth / 2 * MapView.unitWidth, screenHeight / 2 * MapView.unitHeight, null);
                break;
            case ("left"):
                canvas.drawBitmap(
                        leftPlayer, screenWidth / 2 * MapView.unitWidth, screenHeight / 2 * MapView.unitHeight, null);
                break;
            case ("right"):
                canvas.drawBitmap(
                        rightPlayer, screenWidth / 2 * MapView.unitWidth, screenHeight / 2 * MapView.unitHeight, null);
                break;
        }
    }

    public void mapInitialization() {
        // add low elements
        for (int x = 0; x < mapWidth; x += 1) {
            for (int y = 0; y < mapHeight; y += 1) {
                lowMap[x][y] = "lawn";
            }
        }
        // add high elements
        for (int x = 0; x < mapWidth; x++) {
            for (int y = 0; y <= 4; y++) {
                if (x % 2 == 0 && y % 2 == 0) {
                    highMap[x][y] = "tree";
                } else {
                    highMap[x][y] = "treeImage";
                }
            }
            for (int y = 96; y <= 100; y++) {
                if (x % 2.0 == 0 && y % 2 == 0) {
                    highMap[x][y] = "tree";
                } else {
                    highMap[x][y] = "treeImage";
                }
            }
        }
        for (int y = 6; y <= 94; y++) {
            for (int x = 0; x <= 4; x++) {
                if (x % 2 == 0 && y % 2 == 0) {
                    highMap[x][y] = "tree";
                } else {
                    highMap[x][y] = "treeImage";
                }
            }
            for (int x = 22; x <= 26; x++) {
                if (x % 2 == 0 && y % 2 == 0) {
                    highMap[x][y] = "tree";
                } else {
                    highMap[x][y] = "treeImage";
                }
            }
            for (int x = 98; x < 104; x++) {
                if (x % 2 == 0 && y % 2 == 0) {
                    highMap[x][y] = "tree";
                } else {
                    highMap[x][y] = "treeImage";
                }
            }
        }

        // add npc to the map
        highMap[7][7] = "Professor. P";
        highMap[12][7] = "Alice";
        highMap[17][7] = "SecondCup";
    }

    /**
     * @return the npc in front of the player, return null if there isn't any npc in front of the
     * player
     */
    public String checkForward(String direction) {
        int playerX = mapView.player.getX();
        int playerY = mapView.player.getY();
        switch (direction) {
            case "up":
                return highMap[playerX][playerY - 1];
            case "down":
                return highMap[playerX][playerY + 1];
            case "left":
                return highMap[playerX - 1][playerY];
            case "right":
                return highMap[playerX + 1][playerY];
        }
        return null;
    }
}
