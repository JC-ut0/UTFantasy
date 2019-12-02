package csc207.phase2.UTFantasy.Pet;

public interface ObservablePokemon {
    void setObserver(BattleObserver o);

    void setHp(int Hp);

    void addExp(int exp);

    void notifyObserverHpChange();
}
