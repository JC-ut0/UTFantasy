package csc207.phase2.UTFantasy.Products;


public abstract class PokemonBall extends Product {
    private double getCaught;
    PokemonBall(String name, int price, int imageRes, double getCaught){
        super(name, price,imageRes);
        this.getCaught = getCaught;
    }

    double getGetCaught(){
        return getCaught;
    }
}
