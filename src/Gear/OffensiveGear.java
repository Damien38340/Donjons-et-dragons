package Gear;

import org.w3c.dom.ls.LSOutput;

public abstract class OffensiveGear {

    protected String name;
    protected int attack;

    public OffensiveGear(String name, int attack) {
        this.name = name;
        this.attack = attack;
    }

    public String toString() {
        if (name.isEmpty() && attack==0) {
            return "Unequipped";
        }
        return name + " (\uD83D\uDC3B attack + " + attack + ")";
    }
}
