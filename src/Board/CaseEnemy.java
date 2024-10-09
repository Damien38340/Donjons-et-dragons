package Board;

public abstract class CaseEnemy implements Case {

    protected int attack;
    protected int hp;

    public CaseEnemy(int attack, int hp) {
    this.attack = attack;
    this.hp = hp;
    }
}
