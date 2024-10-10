package Board;

import Characters.Hero;

public class Dragon extends CaseEnemy {
    public Dragon() {
        super(4,15);
    }

    @Override
    public void interact(Hero player){

        System.out.println("I'm a Dragon and you will burn!!\n Damage - " + attack);
        player.setHp(player.getHp() - this.attack);
        System.out.println("HP: " + player.getHp());
        System.out.println("You hit the Dragon !\n  + " + player.getAttack());
        hp -= player.getAttack();
        System.out.println("Dragon HP: " + hp);
    }
}
