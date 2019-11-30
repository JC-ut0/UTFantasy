package csc207.phase2.UTFantasy.Pet;

public class PokemonFactory {
    enum PokemonClass {
        METANG,
        HAUNTER,
        GOLDUCK,
        DRATINI,
        KADABRA,
        MEWTWO,
        LAPRAS,
        DRAGONITE,
        PSYDUCK,
        TORCHIC,
        PIDGEOT,
        BLAZIKEN,
        METAGROSS,
        PIDGEY,
        PIDGEOTTO,
        BULBASAUR,
        BLASTOISE,
        WARTORTLE,
        ONIX,
        SQUIRTLE,
        PIKACHU,
        SCEPTILE,
        COMBUSKEN,
        BELDUM,
        CHARMANDER,
        TREECKO,
        GENGAR,
        ALAKAZAM,
        RAICHU,
        ABRA,
        DRAGONAIR,
        GROVYLE,
        GASTLY,
        VENUSAUR,
        IVYSAUR,
        CHARIZARDSHINY,
        MEW,
        CHARIZARD,
        CHARMELEON
    }

    public Pokemon getPokemon(PokemonClass pokemonClass) {
        return getPokemon(pokemonClass, 1);
    }

    public Pokemon getPokemon(PokemonClass pokemonClass, int level) {
        switch (pokemonClass) {
            case METANG:
                return new Metang(level);
            case HAUNTER:
                break;
            case GOLDUCK:
                break;
            case DRATINI:
                break;
            case KADABRA:
                break;
            case MEWTWO:
                break;
            case LAPRAS:
                break;
            case DRAGONITE:
                break;
            case PSYDUCK:
                break;
            case TORCHIC:
                break;
            case PIDGEOT:
                break;
            case BLAZIKEN:
                break;
            case METAGROSS:
                break;
            case PIDGEY:
                break;
            case PIDGEOTTO:
                break;
            case BULBASAUR:
                break;
            case BLASTOISE:
                break;
            case WARTORTLE:
                break;
            case ONIX:
                break;
            case SQUIRTLE:
                break;
            case PIKACHU:
                break;
            case SCEPTILE:
                break;
            case COMBUSKEN:
                break;
            case BELDUM:
                break;
            case CHARMANDER:
                break;
            case TREECKO:
                break;
            case GENGAR:
                break;
            case ALAKAZAM:
                break;
            case RAICHU:
                break;
            case ABRA:
                break;
            case DRAGONAIR:
                break;
            case GROVYLE:
                break;
            case GASTLY:
                break;
            case VENUSAUR:
                break;
            case IVYSAUR:
                break;
            case CHARIZARDSHINY:
                break;
            case MEW:
                break;
            case CHARIZARD:
                break;
            case CHARMELEON:
                break;
        }
        return null;
    }
}
