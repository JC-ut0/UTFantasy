package csc207.phase1.UTFantasy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;

import java.io.Serializable;
import java.util.ArrayList;

import csc207.phase1.UTFantasy.Character.Player;
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
     * the Bitmaps of the character upwards
     */
    private Bitmap upPlayer0;
    private Bitmap upPlayer1;
    private Bitmap upPlayer2;
    private Bitmap upPlayer3;

    /**
     * the Bitmaps of the character downwards
     */
    private Bitmap downPlayer0;
    private Bitmap downPlayer1;
    private Bitmap downPlayer2;
    private Bitmap downPlayer3;

    /**
     * the Bitmap of the character leftwards
     */
    private Bitmap leftPlayer0;
    private Bitmap leftPlayer1;
    private Bitmap leftPlayer2;
    private Bitmap leftPlayer3;

    /**
     * the Bitmap of the character rightwards
     */
    private Bitmap rightPlayer0;
    private Bitmap rightPlayer1;
    private Bitmap rightPlayer2;
    private Bitmap rightPlayer3;

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
     * the player of this map manager
     */
    private Player player;

    /**
     * the direction of the player
     */
    private String direction = "down";

    /**
     * the progress of the movement of the player
     */
    private int progress = 0;

    /**
     * determine if the player is moving
     */
    private boolean moving;


    // =====================================================================================


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
        this.player = mapView.player;
        lawn = getBitmap(R.drawable.lawn, (float) 2, (float) 2);
        tree = getBitmap(R.drawable.tree, (float) 1.8, (float) 1.8);
        initializePlayerImage();

        fightNpc = getBitmap(R.drawable.professor, 2, 2);
        sellerNpc = getBitmap(R.drawable.big_mom, (float) 2.5, (float) 2.5);
        healerNpc = getBitmap(R.drawable.joy, 1, 1);

        mapInitialization();
    }

    /**
     * initialize the image of the player
     */
    private void initializePlayerImage() {
        upPlayer0 = getBitmap(R.drawable.boy_up_0, 1, 1);
        upPlayer1 = getBitmap(R.drawable.boy_up_1, 1, 1);
        upPlayer2 = getBitmap(R.drawable.boy_up_2, 1, 1);
        upPlayer3 = getBitmap(R.drawable.boy_up_3, 1, 1);

        downPlayer0 = getBitmap(R.drawable.boy_down_0, 1, 1);
        downPlayer1 = getBitmap(R.drawable.boy_down_1, 1, 1);
        downPlayer2 = getBitmap(R.drawable.boy_down_2, 1, 1);
        downPlayer3 = getBitmap(R.drawable.boy_down_3, 1, 1);

        leftPlayer0 = getBitmap(R.drawable.boy_left_0, 1, 1);
        leftPlayer1 = getBitmap(R.drawable.boy_left_1, 1, 1);
        leftPlayer2 = getBitmap(R.drawable.boy_left_2, 1, 1);
        leftPlayer3 = getBitmap(R.drawable.boy_left_3, 1, 1);

        rightPlayer0 = getBitmap(R.drawable.boy_right_0, 1, 1);
        rightPlayer1 = getBitmap(R.drawable.boy_right_1, 1, 1);
        rightPlayer2 = getBitmap(R.drawable.boy_right_2, 1, 1);
        rightPlayer3 = getBitmap(R.drawable.boy_right_3, 1, 1);
    }

    /**
     * return the mapView of this map manager
     */
    public MapView getMapView() {
        return mapView;
    }

    /**
     * @return true iff the player is moving
     */
    public boolean isMoving() {
        return moving;
    }

    /**
     * set the player's moving status
     */
    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    /**
     * set the progress of the movement
     */
    public void setProgress(int progress) {
        this.progress = progress;
    }

    /**
     * set the direction of the player
     */
    public void setDirection(String direction) {
        this.direction = direction;
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
                    // expected, do nothing
                }
            }
        }
    }

    public void draw(Canvas canvas) {

        for (int x = 0; x < screenWidth; x++) {
            for (int y = 0; y < screenHeight; y++) {
                if (currentLow[x][y] != null) {
                    if (currentLow[x][y].equals("lawn")) {
                        float extendedX = x - 2;
                        float extendedY = y - 2;
                        ExtendPosition extendPosition = new ExtendPosition(extendedX, extendedY).invoke();
                        extendedX = extendPosition.getExtendedX();
                        extendedY = extendPosition.getExtendedY();
                        canvas.drawBitmap(
                                lawn,
                                extendedX * MapView.unitWidth,
                                extendedY * MapView.unitHeight,
                                null);
                    }
                }
            }
        }
        for (int y = 0; y < screenHeight; y++) {
            for (int x = 0; x < screenWidth; x++) {
                if (currentHigh[x][y] != null) {
                    float extendedX = x - 2;
                    float extendedY = y - 2;
                    ExtendPosition extendPosition = new ExtendPosition(extendedX, extendedY).invoke();
                    extendedX = extendPosition.getExtendedX();
                    extendedY = extendPosition.getExtendedY();
                    switch (currentHigh[x][y]) {
                        case "tree":
                            canvas.drawBitmap(
                                    tree,
                                    extendedX * MapView.unitWidth,
                                    extendedY * MapView.unitHeight,
                                    null);
                            break;
                        case "Professor. P":
                            canvas.drawBitmap(
                                    fightNpc,
                                    extendedX * MapView.unitWidth,
                                    extendedY * MapView.unitHeight,
                                    null);
                            break;
                        case "Alice":
                            canvas.drawBitmap(
                                    sellerNpc,
                                    extendedX * MapView.unitWidth,
                                    extendedY * MapView.unitHeight,
                                    null);
                            break;
                        case "SecondCup":
                            canvas.drawBitmap(
                                    healerNpc,
                                    extendedX * MapView.unitWidth,
                                    extendedY * MapView.unitHeight,
                                    null);
                            break;
                    }
                }
            }
        }

        drawPlayer(canvas);

        updateProgress();
    }

    /**
     * update the progress of movement if needed
     */
    private void updateProgress() {
        if (moving) {
            progress += 1;
            if (progress == 4) {
                progress = 0;
                move(direction);
            }
        } else {
            if (!movementFinished()) {
                if (progress == 4) {
                    progress = 0;
                    move(direction);
                } else {
                    progress += 1;
                }
            }
        }
    }

    private void drawPlayer(Canvas canvas) {
        switch (direction) {
            case ("down"):
                switch (progress) {
                    case 0:
                        canvas.drawBitmap(
                                downPlayer0, (screenWidth / 2 - 2) * MapView.unitWidth, (screenHeight / 2 - 2) * MapView.unitHeight, null);
                        break;
                    case 1:
                        canvas.drawBitmap(
                                downPlayer1, (screenWidth / 2 - 2) * MapView.unitWidth, (screenHeight / 2 - 2) * MapView.unitHeight, null);
                        break;
                    case 2:
                        canvas.drawBitmap(
                                downPlayer2, (screenWidth / 2 - 2) * MapView.unitWidth, (screenHeight / 2 - 2) * MapView.unitHeight, null);
                        break;
                    case 3:
                    case 4:
                        canvas.drawBitmap(
                                downPlayer3, (screenWidth / 2 - 2) * MapView.unitWidth, (screenHeight / 2 - 2) * MapView.unitHeight, null);
                        break;
                }
                break;
            case ("up"):
                switch (progress) {
                    case 0:
                        canvas.drawBitmap(
                                upPlayer0, (screenWidth / 2 - 2) * MapView.unitWidth, (screenHeight / 2 - 2) * MapView.unitHeight, null);
                        break;
                    case 1:
                        canvas.drawBitmap(
                                upPlayer1, (screenWidth / 2 - 2) * MapView.unitWidth, (screenHeight / 2 - 2) * MapView.unitHeight, null);
                        break;
                    case 2:
                        canvas.drawBitmap(
                                upPlayer2, (screenWidth / 2 - 2) * MapView.unitWidth, (screenHeight / 2 - 2) * MapView.unitHeight, null);
                        break;
                    case 3:
                    case 4:
                        canvas.drawBitmap(
                                upPlayer3, (screenWidth / 2 - 2) * MapView.unitWidth, (screenHeight / 2 - 2) * MapView.unitHeight, null);
                        break;
                }
                break;
            case ("left"):
                switch (progress) {
                    case 0:
                        canvas.drawBitmap(
                                leftPlayer0, (screenWidth / 2 - 2) * MapView.unitWidth, (screenHeight / 2 - 2) * MapView.unitHeight, null);
                        break;
                    case 1:
                        canvas.drawBitmap(
                                leftPlayer1, (screenWidth / 2 - 2) * MapView.unitWidth, (screenHeight / 2 - 2) * MapView.unitHeight, null);
                        break;
                    case 2:
                        canvas.drawBitmap(
                                leftPlayer2, (screenWidth / 2 - 2) * MapView.unitWidth, (screenHeight / 2 - 2) * MapView.unitHeight, null);
                        break;
                    case 3:
                    case 4:
                        canvas.drawBitmap(
                                leftPlayer3, (screenWidth / 2 - 2) * MapView.unitWidth, (screenHeight / 2 - 2) * MapView.unitHeight, null);
                        break;
                }
                break;
            case ("right"):
                switch (progress) {
                    case 0:
                        canvas.drawBitmap(
                                rightPlayer0, (screenWidth / 2 - 2) * MapView.unitWidth, (screenHeight / 2 - 2) * MapView.unitHeight, null);
                        break;
                    case 1:
                        canvas.drawBitmap(
                                rightPlayer1, (screenWidth / 2 - 2) * MapView.unitWidth, (screenHeight / 2 - 2) * MapView.unitHeight, null);
                        break;
                    case 2:
                        canvas.drawBitmap(
                                rightPlayer2, (screenWidth / 2 - 2) * MapView.unitWidth, (screenHeight / 2 - 2) * MapView.unitHeight, null);
                        break;
                    case 3:
                    case 4:
                        canvas.drawBitmap(
                                rightPlayer3, (screenWidth / 2 - 2) * MapView.unitWidth, (screenHeight / 2 - 2) * MapView.unitHeight, null);
                        break;
                }
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

    /**
     * move the player in the specified direction by 1 unit
     *
     * @param direction the direction that this player is moving towards
     */
    public void move(String direction) {
        switch (direction) {
            case ("left"):
                if (checkForward("left") == null) {
                    player.setX(player.getX() - 1);
                }
                break;
            case ("right"):
                if (checkForward("right") == null) {
                    player.setX(player.getX() + 1);
                }
                break;
            case ("up"):
                if (checkForward("up") == null) {
                    player.setY(player.getY() - 1);
                }
                break;
            case ("down"):
                if (checkForward("down") == null) {
                    player.setY(player.getY() + 1);
                    break;
                }
                break;
        }
        player.setDirection(direction);
    }

    /**
     * determine if a movement is finished
     *
     * @return true iff a movement is finished
     */
    public boolean movementFinished() {
        return progress == 0;
    }

    /**
     * extended position of a unitDraw so that the position of it on screen can reflex the movement of the player
     */
    private class ExtendPosition {
        private float extendedX;
        private float extendedY;

        public ExtendPosition(float extendedX, float extendedY) {
            this.extendedX = extendedX;
            this.extendedY = extendedY;
        }

        public float getExtendedX() {
            return extendedX;
        }

        public float getExtendedY() {
            return extendedY;
        }

        public ExtendPosition invoke() {
            switch (direction) {
                case "left":
                    if (checkForward("left") == null) {
                        extendedX += progress / 4.0;
                    }
                    break;
                case "right":
                    if (checkForward("right") == null) {
                        extendedX -= progress / 4.0;
                    }
                    break;
                case "up":
                    if (checkForward("up") == null) {
                        extendedY += progress / 4.0;
                    }
                    break;
                case "down":
                    if (checkForward("down") == null) {
                        extendedY -= progress / 4.0;
                    }
                    break;
            }
            return this;
        }
    }
}
