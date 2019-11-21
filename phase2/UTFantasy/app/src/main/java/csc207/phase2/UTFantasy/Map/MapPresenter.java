package csc207.phase2.UTFantasy.Map;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.SurfaceHolder;

import csc207.phase2.UTFantasy.R;

public class MapPresenter implements MapDrawer {

  private MapViewModel mapView;
  // all the bitmaps used to draw
  private Bitmap lawn;
  private Bitmap tree;
  private Bitmap fightNpc;
  private Bitmap sellerNpc;
  private Bitmap healerNpc;
  /** the Bitmaps of the character upwards */
  private Bitmap upPlayer0;

  private Bitmap upPlayer1;
  private Bitmap upPlayer2;
  private Bitmap upPlayer3;

  /** the Bitmaps of the character downwards */
  private Bitmap downPlayer0;

  private Bitmap downPlayer1;
  private Bitmap downPlayer2;
  private Bitmap downPlayer3;

  /** the Bitmap of the character leftwards */
  private Bitmap leftPlayer0;

  private Bitmap leftPlayer1;
  private Bitmap leftPlayer2;
  private Bitmap leftPlayer3;

  /** the Bitmap of the character rightwards */
  private Bitmap rightPlayer0;

  private Bitmap rightPlayer1;
  private Bitmap rightPlayer2;
  private Bitmap rightPlayer3;

  public MapPresenter(MapViewModel mapView) {
    this.mapView = mapView;
    initializeBitMap();
  }

  /**
   * return a resized Bitmap with its returned size be widthIndex * heightIndex times the original
   * size
   *
   * @param id the id of this bitmap drawable
   * @param widthIndex the times that this bitmap's width should be resized by
   * @param heightIndex the times that this bitmap's height should be resized by
   * @return a resized bitmap
   */
  private Bitmap getBitmap(int id, float widthIndex, float heightIndex) {
    Bitmap bitmap = BitmapFactory.decodeResource(mapView.getResource(), id);
    int width = bitmap.getWidth();
    int height = bitmap.getHeight();
    Matrix matrix = new Matrix();
    matrix.postScale(widthIndex, heightIndex);
    return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
  }

  /** initialize the image of the player */
  private void initializeBitMap() {
    lawn = getBitmap(R.drawable.lawn, (float) 2, (float) 2);
    tree = getBitmap(R.drawable.tree, (float) 2, (float) 2);
    fightNpc = getBitmap(R.drawable.professor, 2, 2);
    sellerNpc = getBitmap(R.drawable.big_mom, (float) 2.5, (float) 2.5);
    healerNpc = getBitmap(R.drawable.joy, 1, 1);
    // initialize the bitmap of player
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
   * draw the map on the canvas
   *
   * @param canvas the canvas that is gonna be drawn on
   * @param map the collection of elements that need to be drawn
   */
  @Override
  public void draw(Canvas canvas, UnitDraw[][] map) {
    // draw the screen except the player
    for (UnitDraw[] unitDraws : map) {
      for (UnitDraw unit : unitDraws) {
        if (unit != null) {
          Bitmap bitmap = null;
          switch (unit.getDraw()) {
            case "lawn":
              bitmap = lawn;
              break;
            case "tree":
              bitmap = tree;
              break;
            case "Professor.P":
              bitmap = fightNpc;
              break;
            case "Alice":
              bitmap = sellerNpc;
              break;
            case "SecondCup":
              bitmap = healerNpc;
              break;
          }

          if (bitmap != null ) {
            canvas.drawBitmap(
                bitmap,
                (unit.getScreenX() - 2) * UnitDraw.getUnitWidth(),
                (unit.getScreenY() - 2) * UnitDraw.getUnitHeight(),
                null);
          }
        }
      }
    }
  }

  @Override
  public void drawPlayer(Canvas canvas, String playerIcon, int x, int y) {
    Bitmap bitmap = null;
    switch (playerIcon) {
      case "upPlayer0":
        bitmap = upPlayer0;
        break;
      case "upPlayer1":
        bitmap = upPlayer1;
        break;
      case "upPlayer2":
        bitmap = upPlayer2;
        break;
      case "upPlayer3":
        bitmap = upPlayer3;
        break;
      case "downPlayer0":
        bitmap = downPlayer0;
        break;
      case "downPlayer1":
        bitmap = downPlayer1;
        break;
      case "downPlayer2":
        bitmap = downPlayer2;
        break;
      case "downPlayer3":
        bitmap = downPlayer3;
        break;
      case "leftPlayer0":
        bitmap = leftPlayer0;
        break;
      case "leftPlayer1":
        bitmap = leftPlayer1;
        break;
      case "leftPlayer2":
        bitmap = leftPlayer2;
        break;
      case "leftPlayer3":
        bitmap = leftPlayer3;
        break;
      case "rightPlayer0":
        bitmap = rightPlayer0;
        break;
      case "rightPlayer1":
        bitmap = rightPlayer1;
        break;
      case "rightPlayer2":
        bitmap = rightPlayer2;
        break;
      case "rightPlayer3":
        bitmap = rightPlayer3;
        break;
    }
    canvas.drawBitmap(bitmap, x * UnitDraw.getUnitWidth(), y * UnitDraw.getUnitHeight(), null);
  }

  @Override
  public SurfaceHolder getHolder() {
    return mapView.getHolder();
  }
}
