abstract class OffensiveGear {

    private String type;
    private String name;
    private int attack;

    public OffensiveGear() {

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
        return type + " : " + name + " (\uD83D\uDC3B attack + " + attack + ")";
    }
}
