package csc207.phase1.UTFantasy.Character;

import csc207.phase1.UTFantasy.MapManager;
import csc207.phase1.UTFantasy.Pet.Pokemon;

public class Player extends Person {
    /**
     * the map manager this player belongs to
     */
    public MapManager mapManager;
    /**
     * the amount this player has
     */
    private int money;

    /**
     * the direction that the player is facing to
     */
    public String direction = "down";

    public Player(String name, String gender) {
        super(name, gender);
        this.money = 0;
    }

    public void move(String direction) {
        switch (direction) {
            case ("left"):
                for (double[] block : mapManager.blockMap) {
                    if (block[0] - 0.5 < getX() - 1 && getX() - 1 <
                            block[1] + 1 && block[2] - 0.75 < getY() && getY() < block[3] + 2) {
                        x += 1;
                        break;
                    }
                }
                x -= 1;
                break;
            case ("right"):
                for (double[] block : mapManager.blockMap) {
                    if (block[0] - 0.5 < getX() + 1 && getX() + 1 <
                            block[1] + 1 && block[2] - 0.75 < getY() && getY() < block[3] + 2) {
                        x -= 1;
                    }
                }
                x += 1;
                break;
            case ("up"):
                for (double[] block : mapManager.blockMap) {
                    if (block[0] - 0.5 < getX() && getX() <
                            block[1] + 1 && block[2] - 0.75 < getY() - 1 && getY() - 1 < block[3] + 2) {
                        y += 1;
                    }
                }
                y -= 1;
                break;
            case ("down"):
                for (double[] block : mapManager.blockMap) {
                    if (block[0] - 0.5 < getX() - 1 && getX() <
                            block[1] + 1 && block[2] - 0.75 < getY() + 1 && getY() + 1 < block[3] + 2) {
                        y -= 1;
                    }
                }
                y += 1;
                break;
        }
        this.direction = direction;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


    /**
     * Fight,
     * 1. choose pokemonList,
     * 2. choose skill want to use or item want to use,
     * 3. wait for opponent,
     * 4. start this round, check for speed of the pokemonList, start attack with the higher one.
     * 5. hp get reduced
     * 6. check whether the blood == 0 ,
     * 7. exp
     */
    void fight(Pokemon pokemon) {

    }

    public void addPokemon(Pokemon pokemon) {
        if (this.pokemon.size() >= maxSizeOfPokmonList) {
            return;
        }
        this.pokemon.add(pokemon);
        pokemon.setMaster(this);
    }

}
