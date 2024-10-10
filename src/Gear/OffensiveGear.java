package Gear;

import Board.CaseBonus;
import org.w3c.dom.ls.LSOutput;

public abstract class OffensiveGear extends CaseBonus {

    protected String name;
    protected int attack;

    public OffensiveGear(String name, int attack) {
       super(name, attack);
    }

    public String toString() {
        if (name.isEmpty() && attack==0) {
            return "Unequipped";
        }
        return name + " (\uD83D\uDC3B attack + " + attack + ")";
    }
}
