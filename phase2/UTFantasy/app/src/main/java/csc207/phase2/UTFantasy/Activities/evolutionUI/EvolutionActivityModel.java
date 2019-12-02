package csc207.phase2.UTFantasy.Activities.evolutionUI;

public interface EvolutionActivityModel {
  /**
   * start the animation of evlution
   *
   * @param preEvolve the image of the pokemon before evolution
   * @param postEvolve the image of the pokemon after evolution
   */
  void runAnimation(int preEvolve, int postEvolve);

  void showImg(int preEvolve);

  void showText(String text);

  void end();
}
