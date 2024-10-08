package Gear;

public abstract class OffensiveGear {

    protected String type;
    protected String name;
    protected int attack;

    public OffensiveGear(String type, String name, int attack) {
        this.type = type;
        this.name = name;
        this.attack = attack;
    }

    public String toString() {
        return type + " : " + name + " (\uD83D\uDC3B attack + " + attack + ")";
    }
}
