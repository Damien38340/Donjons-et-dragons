package Characters;

public class Warrior extends Character {


    public Warrior(String name, String type) {
        super(name, type);
        this.setHp(10);
        this.setAttack(10);
        this.setOffensiveGear(new Weapon());
        this.setDefensiveGear(new Shield());
    }
}
