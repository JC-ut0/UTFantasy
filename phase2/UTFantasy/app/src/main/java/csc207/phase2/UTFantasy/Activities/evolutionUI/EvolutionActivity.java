package csc207.phase2.UTFantasy.Activities.evolutionUI;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.IO.UserIO;
import csc207.phase2.UTFantasy.R;

public class EvolutionActivity extends Activity implements EvolutionActivityModel {
  private ImageView evolutionImage;
  private TextView evolutionText;
  private EvolutionPresenter presenter;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_evolution);

    // find instances of widgets
    evolutionImage = findViewById(R.id.evolutionImage);
    evolutionText = findViewById(R.id.evolutionText);
    Button aButton = findViewById(R.id.evolution_A_Button);
    Button bButton = findViewById(R.id.evolution_B_Button);

    // initialize presenter
    Intent intent = getIntent();
    String username = intent.getStringExtra("username");
    Player player = UserIO.getSingletonUserIo().getUserData().getUser(username).getPlayer();
    int pokemonIndex = intent.getIntExtra("pokemonIndex", 0);
    this.presenter = new EvolutionPresenter(this, player);
    presenter.setPokemon(pokemonIndex);

    // set buttons' onClickListeners
    aButton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            presenter.confirm();
          }
        });

    bButton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            presenter.cancel();
          }
        });
  }

  // ================================================================================================
  // implementation of methods of EvolutionActivityModel
  @Override
  public void runAnimation(int preEvolve, int postEvolve) {
    // create animation with 30 frames;
    AnimationDrawable animation = new AnimationDrawable();
    Drawable preImg = getResources().getDrawable(preEvolve, null);
    Drawable postImg = getResources().getDrawable(postEvolve, null);
    for (int i = 0; i < 30; i++) {
      int duration = 300 - i * i * i / 10;
      if (i % 2 == 0) animation.addFrame(preImg, duration);
      else animation.addFrame(postImg, duration);
    }
    animation.setOneShot(true);
    evolutionImage.setBackground(animation);
    ((AnimationDrawable) evolutionImage.getBackground()).start();
  }

  @Override
  public void showImg(int img) {
    evolutionImage.setBackground(getResources().getDrawable(img, null));
  }

  @Override
  public void showText(String text) {
    evolutionText.setText(text);
  }

  @Override
  public void end() {
    onBackPressed();
  }
}
