package csc207.phase2.UTFantasy.mapDomain;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public interface MapDrawer {
    SurfaceHolder getHolder();
    void draw(Canvas canvas, UnitDraw[][] map);

    void drawPlayer(Canvas canvas, Icon playerIcon, int x, int y);

    void popText(String text);

    void openDialogue(String dialogue);

    void hideDialogue();

    void display(int iconId);

    void goToBattleActivity(String npcName);

    void goToShopActivity(String npcName);
}
