package csc207.phase2.UTFantasy.Map;

import java.io.Serializable;

public class UnitDraw implements Serializable {

  /** the element this unitDraw represents */
  private String draw;

  /** the x coordinate of this UnitDraw on the screen coordinate system */
  private float screenX;

  /** the Y coordinate of this UnitDraw on the screen coordinate system */
  private float screenY;

  /**
   * construct a new UnitDraw
   *
   * @param draw the element this unitDraw represents
   */
  public UnitDraw(String draw) {
    this.draw = draw;
  }

  public float getScreenX() {
    return screenX;
  }

  public void setScreenX(float screenX) {
    this.screenX = screenX;
  }

  public float getScreenY() {
    return screenY;
  }

  public void setScreenY(float screenY) {
    this.screenY = screenY;
  }

  public static int getUnitWidth() {
    int unitWidth = 88;
    return unitWidth;
  }

  public static int getUnitHeight() {
    int unitHeight = 88;
    return unitHeight;
  }

  /** @return the element that this unitDraw represents */
  public String getDraw() {
    return draw;
  }
}
