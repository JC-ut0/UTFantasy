package csc207.phase2.utFantasy.map;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public interface MapDrawer {
    SurfaceHolder getHolder();
    void draw(Canvas canvas, UnitDraw[][] map);
    void drawPlayer(Canvas canvas, String playerIcon,int x, int y);
}
