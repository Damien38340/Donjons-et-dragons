package Gear.Weapon;
import Characters.Hero;


public class WoodenSword extends Weapon {
    public WoodenSword() {
        super("Wooden Sword", 1);
    }

    @Override public void interact(Hero player){

        player.setOffensiveGear(this);
        player.setAttack(player.getAttack()+ this.level);
        System.out.println("You found a Wooden Sword !");
        System.out.println("attack + " + this.level);

    }

}
