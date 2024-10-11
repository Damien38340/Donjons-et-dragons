package Board;

public abstract class CaseEnemy implements Case {

    protected int attack;
    protected int level;

    public CaseEnemy(int attack, int level) {
    this.attack = attack;
    this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
