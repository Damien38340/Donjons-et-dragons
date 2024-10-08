public abstract class Character {

    protected String name;
    protected String type;
    private int hp;
    private int attack;
    private OffensiveGear offensiveGear;
    private DefensiveGear defensiveGear;

    public Character() {
        this("");
    }

    public Character(String name) {
        this(name, "");
    }

    public Character(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public OffensiveGear getOffensiveGear() {
        return offensiveGear;
    }

    public void setOffensiveGear(OffensiveGear offensiveGear) {
        this.offensiveGear = offensiveGear;
    }

    public DefensiveGear getDefensiveGear() {
        return defensiveGear;
    }

    public void setDefensiveGear(DefensiveGear defensiveGear) {
        this.defensiveGear = defensiveGear;
    }

    public String getName() {
        return this.name = name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void getType() {
        this.type = type;
    }

    public void setType(String newType) {
        this.type = newType;

    }

    public String toString() {
        return "name: " + name + "\ntype: " + type + "\nhp: " + hp + "\nattack: " + attack + "\n\n" + offensiveGear + "\n" + defensiveGear;
    }
}
