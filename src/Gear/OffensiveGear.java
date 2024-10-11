package Gear;

import Board.*;

public abstract class OffensiveGear extends CaseBonus {


    protected String name;
    protected int level;

    public OffensiveGear(String name, int level) {
       super(name, level);

      this.name = name;
      this.level = level;
    }

    @Override
    public String toString() {
        return name + " (\uD83D\uDC3B attack + " + level + ")";
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
