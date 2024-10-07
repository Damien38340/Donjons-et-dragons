public class Wizard  extends Character{

    private int hp;
    private int attack;
    private Spell spell;
    private Potion potion;

    public Wizard(String name, String type) {
        super(name, type);
        this.setHp(6);
        this.setAttack(15);
        this.setOffensiveGear(spell);
        this.setDefensiveGear(potion);
    }

}
