package csc207.phase2.UTFantasy.BattleUseCase;

import csc207.phase2.UTFantasy.Pet.Pokemon;
import csc207.phase2.UTFantasy.Products.Ball;
import csc207.phase2.UTFantasy.Products.Potion;
import csc207.phase2.UTFantasy.Products.Product;

/**
 * A manager responsible for updating message about using items An item can be either a potion or a
 * ball Update the corresponding battle data
 */
class ItemManager {
  private BattleData battleData;
  private boolean isCaught;

  ItemManager(BattleData battleData) {
    this.battleData = battleData;
  }

  /**
   * use the selected product by user update the corresponding battleData action
   *
   * @return the message if the product is successfully used
   */
  String useItem() {
    Product product = battleData.getPlayer().getSelectedProduct();
    String text;
    if (product != null) {
      battleData.getPlayer().useItem(product);
      text = battleData.getPlayer().getName() + " used " + product.getName();
      if (product instanceof Ball) {
        if (battleData.getCurrRivalPoke().setNotWild()) {
          productFailedToUse(product);
          text = "You can only catch wild pokemon.";
        } else {
          battleData.setAction(BattleData.Action.CATCH);
        }

      } else if (product instanceof Potion) {
        Pokemon playerPoke = battleData.getCurrPlayerPoke();
        if (playerPoke.getHp() == playerPoke.getMaximumHp()) {
          productFailedToUse(product);
          text = playerPoke.getPokemonName() + " is already full hp.";
        } else {
          battleData.setAction(BattleData.Action.HEAL);
        }
      }
    } else {
      battleData.setAction(BattleData.Action.OPENMENU);
      text = "You didn't select any item.";
    }
    return text;
  }

  private void productFailedToUse(Product product) {
    battleData.setAction(BattleData.Action.OPENMENU);
    battleData.getPlayer().addItem(product, 1);
  }

  /**
   * called when ball is successfully used update the usage of ball
   *
   * @return the message informing if the pokemon is used
   */
  String useBall() {
    Product pokemonBall = battleData.getPlayer().getSelectedProduct();
    String text = null;
    if (pokemonBall instanceof Ball) {
      double rate = ((Ball) pokemonBall).getRate();
      double random = Math.random();
      if (random < rate) {
        // the pokemon is successfully caught
        isCaught = true;
        battleData.getPlayer().addPokemon(battleData.getCurrRivalPoke());
        battleData.setAction(BattleData.Action.END);
        text =
            "Congratulations! You have caught "
                + battleData.getCurrRivalPoke().getPokemonName()
                + "!!!";
        // delete this pokemon npc from player's npc repository
        battleData
            .getPlayer()
            .getPlayerMap()
            .getNpcRepository()
            .deleteNPC(battleData.getRival().getName());
      } else {
        // the pokemon is failed to be caught
        isCaught = false;
        battleData.setAction(BattleData.Action.OPENMENU);
        text = battleData.getCurrRivalPoke().getPokemonName() + " has escaped...";
      }
    }
    battleData.getPlayer().setSelectedProduct(null);
    return text;
  }

  /**
   * called when potion is successfully used update the usage of potion
   *
   * @return the message informing usage of potion
   */
  String usePotion() {
    Product potion = battleData.getPlayer().getSelectedProduct();
    String text = null;
    if (potion instanceof Potion) {
      battleData.setAction(BattleData.Action.OPENMENU);
      Pokemon playerPoke = battleData.getCurrPlayerPoke();
      int healedHp = playerPoke.getHp() + ((Potion) potion).getHealthPoint();
      playerPoke.setHp(Math.min(healedHp, playerPoke.getMaximumHp()));
      playerPoke.notifyObserverHpChange();
      text = playerPoke.getPokemonName() + " has been healed!";
    }
    battleData.getPlayer().setSelectedProduct(null);
    return text;
  }

  boolean isCaught() {
    return isCaught;
  }
}
