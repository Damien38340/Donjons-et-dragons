public class Wizard  extends Character{


    public Wizard(String name, String type) {
        super(name, type);
        this.setHp(6);
        this.setAttack(15);
        this.setOffensiveGear(new Spell());
        this.setDefensiveGear(new Potion());
    }
}