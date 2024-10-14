package Board.Enemy;

import Characters.Hero;

public class Dragon extends CaseEnemy {


    public Dragon() {
        super("Dragon", 4, 15);

    }

    @Override
    public void interact(Hero player) {

        visualizer.displayDragon();
        int defenseValue = getDefenseValue(player);
        player.setHp(player.getHp() - this.attack + defenseValue);
        String attackMessage = getAttackMessage();
        System.out.println(attackMessage);
        System.out.println(player.getName() + " HP: " + player.getHp());
        if (player.getHp() <= 0) {
            System.out.println("You died.");
        } else {
            int attackValue = getAttackValue(player);
            System.out.println("You hit the " + name + "!\n  + " + attackValue);
            level -= attackValue;
            System.out.println(name + " HP: " + level);
        }

    }

    private int getAttackValue(Hero player) {
        return isOffensiveEquipmentNull(player) ? player.getAttack() : player.getAttack() + player.getOffensiveGear().getLevel();
    }

    private int getDefenseValue(Hero player) {
        return isDefensiveEquipmentNull(player) ? 0 : player.getDefensiveGear().getLevel();
    }

    public boolean isOffensiveEquipmentNull(Hero player) {
        return player.getOffensiveGear() == null;
    }
    public boolean isDefensiveEquipmentNull(Hero player) {
        return player.getDefensiveGear() == null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getComplement() {
        return  " and you will burn!!\n";
    }
}
