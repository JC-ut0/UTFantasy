package csc207.phase2.UTFantasy.Map;

import java.io.Serializable;

public class UnitDraw implements Serializable {

  /** the element this unitDraw represents */
  protected Icon icon;

  /** the x coordinate of this UnitDraw on the screen coordinate system */
  private float screenX;

  /** the Y coordinate of this UnitDraw on the screen coordinate system */
  private float screenY;


  public UnitDraw() {
  }

  ;
  /**
   * construct a new UnitDraw
   *
   * @param icon the element this unitDraw represents
   */
  public UnitDraw(Icon icon) {
    this.icon = icon;
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
  public Icon getDraw() {
    return icon;
  }

  public boolean isNPC() {
    System.out.println("im not");
    return false;
  }
}
