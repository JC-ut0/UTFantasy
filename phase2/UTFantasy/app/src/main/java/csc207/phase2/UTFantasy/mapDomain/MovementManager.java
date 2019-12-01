package csc207.phase2.UTFantasy.mapDomain;

import csc207.phase2.UTFantasy.Character.Player;

public class MovementManager {
  private Player player;
  private int progress;
  private boolean isMoving;

  public MovementManager(Player player) {
    this.player = player;
  }

  public void startMove(String direction) {
    isMoving = true;
    player.setDirection(direction);
  }

  public void endMoving() {
    isMoving = false;
  }

  public void updateProgress(boolean moveAble) {

    if (isMoving) {
      progress += 1;
    } else if (progress != 0) {
      progress += 1;
    }

    if (progress == 4) {
      progress = 0;
      if (moveAble) {
        move();
      }
    }
  }

  public int getProgress() {
    return progress;
  }

  public void setProgress(int progress) {
    this.progress = progress;
  }

  /** move the player in the specified direction by 1 unit */
  private void move() {
    switch (player.getDirection()) {
      case ("left"):
        player.setX(player.getX() - 1);
        break;
      case ("right"):
        player.setX(player.getX() + 1);
        break;
      case ("up"):
        player.setY(player.getY() - 1);
        break;
      case ("down"):
        player.setY(player.getY() + 1);
        break;
    }
    player.notifyChange();
  }
}
