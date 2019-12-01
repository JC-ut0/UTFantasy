package csc207.phase2.UTFantasy.mapUseCase;

import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;

public interface MapInteractor {
    boolean checkMoveAble();

    NPC getFacingNpc();

    Player getPlayer();

    UnitDraw[][] updateScreenOverLowMap();

    UnitDraw[][] updateScreenOverHighMap();

    int getScreenUnitWidth();

    int getScreenUnitHeight();

    int getExtendedWidth();

    int getExtendedHeight();

    void startMove(String direction);

    void endMove();

    void updateProgress(boolean moveAble);

    int getProgress();

    void setProgress(int Progress);

    void transScreen(UnitDraw[][] map, int progress, boolean moveAble);

    Icon getPlayerIcon(int progress);
}
