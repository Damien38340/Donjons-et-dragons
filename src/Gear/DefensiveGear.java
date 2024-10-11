package Gear;
import Board.*;

public abstract class DefensiveGear extends CaseBonus {


    protected String name;
    protected int level;

    public DefensiveGear(String name, int level) {
        super(name, level);

        this.name = name;
        this.level = level;
    }

    @Override
    public String toString() {
            return name + " (\uD83E\uDD94 defense + " + level + ")";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLevel() {
        return level;
    }

}
