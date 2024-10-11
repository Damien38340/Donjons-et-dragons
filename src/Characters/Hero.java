package Characters;

import Gear.DefensiveGear;
import Gear.OffensiveGear;


public abstract class Hero {

    protected String name;
    protected String type;
    private int hp;
    private int attack;
    private int defense;
    private OffensiveGear offensiveGear;
    private DefensiveGear defensiveGear;

    public Hero() {
        this("");
    }

    public Hero(String name) {
        this(name, "");
    }

    public Hero(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Hero(String name, String type, int defense) {
        this.name = name;
        this.type = type;
        this.defense = defense;
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

    public String getType() {
        return this.type = type;
    }

    public void setType(String newType) {
        this.type = newType;

    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public String toString() {
        return "name: " + name + "\ntype: " + type + "\nhp: " + hp + "\nattack: " + attack + "\n\n" + offensiveGear + "\n" + defensiveGear;
    }
}
