public class OffensiveGear {

    private String type;
    private String name;
    private int attack;

    public OffensiveGear(String type, String name, int attack) {
        this.type = type;
        this.name = name;
        this.attack = attack;
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

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
    public String toString() {
        return type + " : " + name + " (attack + " + attack + ")";
    }
}
