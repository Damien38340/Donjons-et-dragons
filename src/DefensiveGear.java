public class DefensiveGear {

    private String type;
    private String name;
    private int defense;

    public DefensiveGear(String type, String name, int defense) {
        this.type = type;
        this.name = name;
        this.defense = defense;
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
        return type + " : " + name + " (defense + " + defense + ")";
    }
}
