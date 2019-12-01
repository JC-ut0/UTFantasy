package csc207.phase2.UTFantasy.Battle;

import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Pet.Pokemon;
import csc207.phase2.UTFantasy.Products.PokemonBall;
import csc207.phase2.UTFantasy.Products.Potion;
import csc207.phase2.UTFantasy.Products.Product;

public class ItemManager {
  private BattleData battleData;
  private boolean isCaught;

  public ItemManager(BattleData battleData) {
    this.battleData = battleData;
  }

  public String useItem() {
    Product product = battleData.getPlayer().getSelectedProduct();
    battleData.getPlayer().setSelectedProduct(null);
    String text = null;
    if (product != null) {
      battleData.getPlayer().deleteItem(product);
      text = battleData.getPlayer().getName() + " used " + product.getName();
      if (product instanceof PokemonBall) {
        if (!battleData.getCurrRivalPoke().isWild()) {
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

  public String useBall() {
    Product pokemonBall = battleData.getPlayer().getSelectedProduct();
    String text = null;
    if (pokemonBall instanceof PokemonBall) {
      double rate = ((PokemonBall) pokemonBall).getRate();
      double random = Math.random();
      if (random < rate) {
        // the pokemon is successfully caught
        isCaught = true;
        battleData.getCurrRivalPoke().setMaster(battleData.getPlayer());
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
    return text;
  }

  public String usePotion() {
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
    return text;
  }

  public boolean isCaught() {
    return isCaught;
  }
}
