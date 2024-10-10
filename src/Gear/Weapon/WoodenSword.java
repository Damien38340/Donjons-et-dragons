package Gear.Weapon;
import Characters.Hero;


public class WoodenSword extends Weapon {
    public WoodenSword() {
        super("Wooden Sword", 1);
    }

    @Override public void interact(Hero player){
        System.out.println("You found a Wooden Sword !");
        System.out.println("attack + " + attack);
        player.setAttack(player.getAttack()+attack);

    }

}
