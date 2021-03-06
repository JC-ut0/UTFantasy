package csc207.phase1.UTFantasy.Map;

import java.io.Serializable;

public class UnitDraw implements Serializable {

    /**
     * the element this unitDraw represents
     */
    private String draw;
    /**
     * the x coordinate of this UnitDraw
     */
    private int x;

    /**
     * the y coordinate of this UnitDraw
     */
    private int y;

    /**
     * the x coordinate of this UnitDraw on the screen coordinate system
     */
    private int screenX;

    /**
     * the Y coordinate of this UnitDraw on the screen coordinate system
     */
    private int screenY;


    // ======================================================================

    /**
     * construct a new UnitDraw
     *
     * @param draw the element this unitDraw represents
     * @param x    the x value of this unitDraw
     * @param y    the y value of this unitDraw
     */
    public UnitDraw(String draw, int x, int y) {
        this.draw = draw;
        this.x = x;
        this.y = y;
    }

    /**
     * @return return the x value of this unitDraw on the screen
     */
    public int getScreenX() {
        return screenX;
    }

    /**
     * @return return the y value of this unitDraw on the screen
     */
    public int getScreenY() {
        return screenY;
    }

    /**
     * set the x value of this unitDraw on the screen
     *
     * @param screenX the x coordinate of this UnitDraw on the screen coordinate system
     */
    public void setScreenX(int screenX) {
        this.screenX = screenX;
    }

    /**
     * set the y value of this unitDraw on the screen
     *
     * @param screenY the y coordinate of this UnitDraw on the screen coordinate system
     */
    public void setScreenY (int screenY) {
        this.screenY = screenY;
    }

    /**
     * @return the x value of this unitDraw in the map coordinate system
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y value of this unitDraw in the map coordinate system
     */
    public int getY() {
        return y;
    }

    /**
     * @return the element that this unitDraw represents
     */
    public String getDraw() {
        return draw;
    }


}
