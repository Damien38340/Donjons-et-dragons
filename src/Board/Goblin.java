package Board;

import Characters.Hero;

public class Goblin extends CaseEnemy {
    public Goblin() {
        super(1,6);
    }

    @Override
    public void interact(Hero player){

        System.out.println("I'm a Goblin !!\n Damage - " + attack);
        player.setHp(player.getHp() - this.attack);
        System.out.println("HP: " + player.getHp());
        System.out.println("You hit the Goblin !\n + " + player.getHp());
        hp -= player.getAttack();
        System.out.println("Goblin HP: " + hp);
    }

}
