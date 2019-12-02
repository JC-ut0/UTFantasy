package csc207.phase2.UTFantasy.mapUseCase;

import csc207.phase2.UTFantasy.Character.Player;

/**
 * Responsible for track and updating the status of player's movement There are 4 status in total,
 * represented by progress valued from 0 - 3 Each time progress gets updated, progress should be
 * added by 1 Progress set to back be 0 and player moves one step if progress get added to be 4
 */
class MovementManager {
  private Player player;
  private int progress;
  private boolean isMoving;

  MovementManager(Player player) {
    this.player = player;
  }

  void startMove(String direction) {
    isMoving = true;
    player.setDirection(direction);
  }

  void endMoving() {
    isMoving = false;
  }

  void updateProgress(boolean moveAble) {
    if (isMoving) progress += 1;
    else if (progress != 0) progress += 1;
    if (progress == 4) {
      // one whole step is finished and player should move one step forward
      progress = 0;
      if (moveAble) {
        move();
      }
    }
  }

  int getProgress() {
    return progress;
  }

  void setProgress(int progress) {
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
