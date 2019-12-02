package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.BattleUseCase.TypeMap;
import csc207.phase2.UTFantasy.R;

class Kadabra extends Pokemon {
  /** Constructor of a Kadabra. */
  Kadabra(int level) {
    super(
        level,
        TypeMap.TypeEnum.PSYCHIC,
        null,
        R.drawable.kadabra,
        R.drawable.kadabra_back,
        "Kadabra",
        40,
        80,
        50,
        105,
        "quick");
    setLevelToEvolve(40, new Alakazam(40));
  }
  /**
   * Get the profile ID of Kadabra.
   *
   * @return an integer which is the profile ID of Kadabra.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.kadabra;
  }

  /**
   * Get the profile back ID of Kadabra.
   *
   * @return an integer which is the profile ID of the back of Kadabra.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.kadabra_back;
  }
}
