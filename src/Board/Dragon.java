package Board;

import Characters.Hero;

public class Dragon extends CaseEnemy {
    public Dragon() {
        super(4,15);
    }

    @Override
    public void interact(Hero player){
        System.out.println("I'm a Dragon and you will burn!!");
        System.out.println("damage - " + attack);
        System.out.println("HP: " + player.getHp());
    }
}
