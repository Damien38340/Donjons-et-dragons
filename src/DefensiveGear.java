abstract class DefensiveGear {

    private String type;
    private String name;
    private int defense;

    public DefensiveGear() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
    public String toString() {
        return type + " : " + name + " (\uD83E\uDD94 defense + " + defense + ")";
    }
}
