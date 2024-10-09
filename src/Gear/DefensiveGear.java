package Gear;
import Board.*;

public abstract class DefensiveGear extends CaseBonus {

    protected String name;
    protected int defense;

    public DefensiveGear(String name, int defense) {
        super(name, defense);

        this.name = name;
        this.defense = defense;
    }

    public String toString() {
        if (name.isEmpty() && defense ==0) {
            return "Unequipped";
        }
            return name + " (\uD83E\uDD94 defense + " + defense + ")";
    }
}
