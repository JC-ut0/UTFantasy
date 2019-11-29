package csc207.phase2.UTFantasy.Products;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.R;

public class MasterBall extends PokemonBall{
    /** constructor of MasterBall */
    MasterBall(){
    super("Master Ball", 500, R.drawable.master_ball,1);
    }

    @NonNull
    @Override
    public String toString(){
        return "This is a Master Ball which can catch a pokemon with 100%";
    }
}
