package csc207.phase2.UTFantasy.Battle;

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
        battleData.getPlayer().addItem(product, -1);
        String text = null;
        if (product != null) {
            text = battleData.getPlayer().getName() + " used " + product.getName();
            if (product instanceof PokemonBall) {
                if (!battleData.getCurrRivalPoke().hasMaster()) {
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
        battleData.getPlayer().setSelectedProduct(null);
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
                battleData.getPlayer().addPokemon(battleData.getCurrRivalPoke());
                battleData.setAction(BattleData.Action.END);
                text =
                        "Congratulations! You have caught "
                                + battleData.getCurrRivalPoke().getPokemonName()
                                + "!!!";
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
            playerPoke.setHp(playerPoke.getHp() + ((Potion) potion).getHealthPoint());
            text = playerPoke.getPokemonName() + " has been healed!";
        }
        return text;
    }

    public boolean isCaught() {
        return isCaught;
    }
}
