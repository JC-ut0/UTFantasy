package csc207.phase2.UTFantasy.Pet;

public interface ObservablePokemon {
    public void setObserver(BattleObserver o);

    public void setHp(int Hp);

    public void addExp(int exp);

    public void notifyObserverHpChange();

    public void notifyObserverExpChange();

    //    public void addExp();
    //
    //    public boolean hasExpChange();
    //
    //    public void addLevel();
    //
    //    public boolean hasLevelChanged();
}
