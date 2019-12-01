package csc207.phase2.UTFantasy.Pet;

public class PokemonFactory {
  public Pokemon createPokemon(PokemonClass pokemonClass) {
    return createPokemon(pokemonClass, 1);
  }

  public Pokemon createPokemon(PokemonClass pokemonClass, int level) {
    switch (pokemonClass) {
      case METANG:
        return new Metang(level);
      case HAUNTER:
        return new Haunter(level);
      case GOLDUCK:
        return new Golduck(level);
      case DRATINI:
        return new Dratini(level);
      case KADABRA:
        return new Kadabra(level);
      case MEWTWO:
        return new Mewtwo(level);
      case LAPRAS:
        return new Lapras(level);
      case DRAGONITE:
        return new Dragonite(level);
      case PSYDUCK:
        return new Psyduck(level);
      case TORCHIC:
        return new Torchic(level);
      case PIDGEOT:
        return new Pidgeot(level);
      case BLAZIKEN:
        return new Blaziken(level);
      case METAGROSS:
        return new Metagross(level);
      case PIDGEY:
        return new Pidgey(level);
      case PIDGEOTTO:
        return new Pidgeotto(level);
      case BULBASAUR:
        return new Bulbasaur(level);
      case BLASTOISE:
        return new Blastoise(level);
      case WARTORTLE:
        return new Wartortle(level);
      case ONIX:
        return new Onix(level);
      case SQUIRTLE:
        return new Squirtle(level);
      case PIKACHU:
        return new Pikachu(level);
      case SCEPTILE:
        return new Sceptile(level);
      case COMBUSKEN:
        return new Combusken(level);
      case BELDUM:
        return new Beldum(level);
      case CHARMANDER:
        return new Charmander(level);
      case TREECKO:
        return new Treecko(level);
      case GENGAR:
        return new Gengar(level);
      case ALAKAZAM:
        return new Alakazam(level);
      case RAICHU:
        return new Raichu(level);
      case ABRA:
        return new Abra(level);
      case DRAGONAIR:
        return new Dragonair(level);
      case GROVYLE:
        return new Grovyle(level);
      case GASTLY:
        return new Gastly(level);
      case VENUSAUR:
        return new Venusaur(level);
      case IVYSAUR:
        return new Ivysaur(level);
      case CHARIZARDSHINY:
        return new CharizardShiny(level);
      case MEW:
        return new Mew(level);
      case CHARIZARD:
        return new Charizard(level);
      case CHARMELEON:
        return new Charmeleon(level);
      default:
        throw new IllegalStateException("Unexpected value: " + pokemonClass);
    }
  }

  public enum PokemonClass {
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
}
