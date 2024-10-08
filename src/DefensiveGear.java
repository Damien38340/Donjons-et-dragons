public abstract class DefensiveGear {

    protected String type;
    protected String name;
    protected int defense;

    public DefensiveGear(String type, String name, int defense) {
        this.type = type;
        this.name = name;
        this.defense = defense;
    }

    public String toString() {
        return type + " : " + name + " (\uD83E\uDD94 defense + " + defense + ")";
    }
}
