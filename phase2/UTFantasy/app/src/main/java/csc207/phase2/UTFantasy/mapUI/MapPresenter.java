package csc207.phase2.UTFantasy.mapUI;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.SurfaceHolder;

import csc207.phase2.UTFantasy.R;
import csc207.phase2.UTFantasy.mapDomain.Icon;
import csc207.phase2.UTFantasy.mapDomain.MapDrawer;
import csc207.phase2.UTFantasy.mapDomain.UnitDraw;

public class MapPresenter implements MapDrawer {

  private MapViewModel mapView;
  private MainActivityModel activityModel;
  // all the bitmaps used to draw
  private Bitmap lawn;
  private Bitmap tree;
  private Bitmap redtree;
  private Bitmap fightNpc;
  private Bitmap sellerNpc;
  private Bitmap healerNpc;
  private Bitmap yimi;
  private Bitmap jesse;
  private Bitmap deniska;
  private Bitmap quincy;
  private Bitmap joy;
  private Bitmap pokemonBall;
  private Bitmap pokemonBallOnMap;
  private Bitmap hallOfFame;
  private Bitmap library;
  private Bitmap pokemonCenter;
  private Bitmap store;
  private Bitmap houseWDoor;
  private Bitmap houseWODoor;
  private Bitmap greenHouse;
  private Bitmap gym;
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

  public MapPresenter(MapViewModel mapView, MainActivityModel activityModel) {
    this.mapView = mapView;
    this.activityModel = activityModel;
    initializeBitMap();
  }

  /**
   * return a resized Bitmap with its returned size be widthIndex * heightIndex times the original
   * size
   *
   * @param id the icon of this bitmap drawable
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
    redtree = getBitmap(R.drawable.redtree, (float) 2, (float) 2);
    // initialize the bitmap of NPCs.
    fightNpc = getBitmap(R.drawable.professor, (float) 1.85, (float) 1.85);
    sellerNpc = getBitmap(R.drawable.saler, (float) 1.9, (float) 1.9);
    healerNpc = getBitmap(R.drawable.beauty, (float) 1.9, (float) 1.95);
    yimi = getBitmap(R.drawable.yimi, (float) 1.2, (float) 1.22);
    jesse = getBitmap(R.drawable.jesse, (float) 2.0, (float) 1.73);
    joy = getBitmap(R.drawable.yyqx, (float) 1.9, (float) 1.75);
    deniska = getBitmap(R.drawable.dd, (float) 1.9, (float) 1.8);
    quincy = getBitmap(R.drawable.psyduck, (float) 1.0, (float) 1.1);
    pokemonBallOnMap = getBitmap(R.drawable.pokeballonmap, (float) 0.4, (float) 0.4);
    pokemonBall = getBitmap(R.drawable.pokeball, (float) 0.3, (float) 0.3);
    // initialize the bitmap of buildings.
    hallOfFame = getBitmap(R.drawable.halloffame, (float) 2.2, (float) 2);
    library = getBitmap(R.drawable.mp_building, (float) 1.1, (float) 1.0);
    houseWDoor = getBitmap(R.drawable.house, (float) 2.5, (float) 2.7);
    houseWODoor = getBitmap(R.drawable.house5, (float) 2.4, (float) 2.7);
    greenHouse = getBitmap(R.drawable.house2, (float) 1.0, (float) 1.0);
    pokemonCenter = getBitmap(R.drawable.house3, (float) 2.4, (float) 2.3);
    store = getBitmap(R.drawable.house1, (float) 1.0, (float) 1.0);
    gym = getBitmap(R.drawable.house4, (float) 1.0, (float) 1.0);
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
  public void draw(Canvas canvas, UnitDraw[][] map, int translatedX, int translatedY) {
    // draw the screen except the player
    for (UnitDraw[] unitDraws : map) {
      for (UnitDraw unit : unitDraws) {
        if (unit != null) {
          Bitmap bitmap = null;
          switch (unit.getIcon()) {
            case LAWN:
              bitmap = lawn;
              break;
            case TREE:
              bitmap = tree;
              break;
            case REDTREE:
              bitmap = redtree;
              break;
            case PROFESSOR:
              bitmap = fightNpc;
              break;
            case SELLER:
              bitmap = sellerNpc;
              break;
            case HEALER:
              bitmap = healerNpc;
              break;
            case JOY:
              bitmap = joy;
              break;
            case JESSE:
              bitmap = jesse;
              break;
            case YIMI:
              bitmap = yimi;
              break;
            case QUINCY:
              bitmap = quincy;
              break;
            case DENISKA:
              bitmap = deniska;
              break;
            case POKEMONBALL:
              bitmap = pokemonBall;
              break;
            case POKEMONBALLONMAP:
              bitmap = pokemonBallOnMap;
              break;
            case HALLOFFAME:
              bitmap = hallOfFame;
              break;
            case LIBRARY:
              bitmap = library;
              break;
            case GYM:
              bitmap = gym;
              break;
            case STORE:
              bitmap = store;
              break;
            case POKEMONCENTER:
              bitmap = pokemonCenter;
              break;
            case HOUSEWDOOR:
              bitmap = houseWDoor;
              break;
            case HOUSEWODOOR:
              bitmap = houseWODoor;
              break;
            case GREENHOUSE:
              bitmap = greenHouse;
              break;
          }

          if (bitmap != null) {
            canvas.drawBitmap(
                bitmap,
                (unit.getScreenX() - translatedX) * unit.getUnitWidth(),
                (unit.getScreenY() - translatedY) * unit.getUnitHeight(),
                null);
          }
        }
      }
    }
  }

  @Override
  public void drawPlayer(Canvas canvas, Icon playerIcon, int x, int y) {
    Bitmap bitmap = null;
    switch (playerIcon) {
      case UPPLAYER0:
        bitmap = upPlayer0;
        break;
      case UPPLAYER1:
        bitmap = upPlayer1;
        break;
      case UPPLAYER2:
        bitmap = upPlayer2;
        break;
      case UPPLAYER3:
        bitmap = upPlayer3;
        break;
      case DOWNPLAYER0:
        bitmap = downPlayer0;
        break;
      case DOWNPLAYER1:
        bitmap = downPlayer1;
        break;
      case DOWNPLAYER2:
        bitmap = downPlayer2;
        break;
      case DOWNPLAYER3:
        bitmap = downPlayer3;
        break;
      case LEFTPLAYER0:
        bitmap = leftPlayer0;
        break;
      case LEFTPLAYER1:
        bitmap = leftPlayer1;
        break;
      case LEFTPLAYER2:
        bitmap = leftPlayer2;
        break;
      case LEFTPLAYER3:
        bitmap = leftPlayer3;
        break;
      case RIGHTPLAYER0:
        bitmap = rightPlayer0;
        break;
      case RIGHTPLAYER1:
        bitmap = rightPlayer1;
        break;
      case RIGHTPLAYER2:
        bitmap = rightPlayer2;
        break;
      case RIGHTPLAYER3:
        bitmap = rightPlayer3;
        break;
    }
    if (bitmap != null) {
      UnitDraw unit = new UnitDraw();
      canvas.drawBitmap(bitmap, x * unit.getUnitWidth(), y * unit.getUnitHeight(), null);
    }
  }

  @Override
  public void popText(String text) {
    activityModel.popText(text);
  }

  @Override
  public void openDialogue(String dialogue) {
    activityModel.hideButtons();
    activityModel.openDialogue(dialogue);
  }

  public void hideDialogue() {
    activityModel.showButtons();
    activityModel.closeDialogue();
  }

  @Override
  public void display(int iconId) {
    activityModel.display(iconId);
  }

  @Override
  public void goToBattleActivity(String npcName) {
    activityModel.goToBattleActivity(npcName);
  }

  @Override
  public void goToShopActivity(String npcName) {
    activityModel.goToShopActivity(npcName);
  }

  @Override
  public SurfaceHolder getHolder() {
    return mapView.getHolder();
  }
}
