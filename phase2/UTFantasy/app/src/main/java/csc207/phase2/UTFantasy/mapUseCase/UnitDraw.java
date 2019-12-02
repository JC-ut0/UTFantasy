package csc207.phase2.UTFantasy.mapUseCase;

import java.io.Serializable;

/** One unit that contains information about what is being drawn on the screen */
public class UnitDraw implements Serializable {

  /** the element this unitDraw represents */
  protected Icon icon;

  /** the x coordinate of this UnitDraw on the screen coordinate system */
  private float screenX;

  /** the Y coordinate of this UnitDraw on the screen coordinate system */
  private float screenY;

  public UnitDraw() {}

  /**
   * construct a new UnitDraw
   *
   * @param icon the element this unitDraw represents
   */
  UnitDraw(Icon icon) {
    this.icon = icon;
  }

  public float getScreenX() {
    return screenX;
  }

  void setScreenX(float screenX) {
    this.screenX = screenX;
  }

  public float getScreenY() {
    return screenY;
  }

  void setScreenY(float screenY) {
    this.screenY = screenY;
  }

  public int getUnitWidth() {
    return 88;
  }

  public int getUnitHeight() {
    return 88;
  }

  /** @return the element that this unitDraw represents */
  public Icon getIcon() {
    return icon;
  }
}
