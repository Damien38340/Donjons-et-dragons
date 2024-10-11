package Board.Enemy;

import Characters.Hero;

public class Dragon extends CaseEnemy {

    String name = "Dragon";

    public Dragon() {
        super(4, 15);
    }

    @Override
    public void interact(Hero player) {

        System.out.println("          ___====-_  _-====___\n" +
                "           _--^^^#####//      \\\\#####^^^--_\n" +
                "        _-^##########// (    ) \\\\##########^-_\n" +
                "       -############//  |\\^^/|  \\\\############-\n" +
                "     _/############//   (@::@)   \\\\############\\_\n" +
                "    /#############((     \\\\//     ))#############\\\n" +
                "   -###############\\\\    (oo)    //###############-\n" +
                "  -#################\\\\  / VV \\  //#################-\n" +
                " -###################\\\\/      \\//###################-\n" +
                "_#/|##########/\\######(   /\\   )######/\\##########|\\#_\n" +
                "|/ |#/\\#/\\#/\\/  \\#/\\##\\  |  |  /##/\\#/  \\/\\#/\\#/\\#| \\|\n" +
                "`  |/  V  V  `   V  \\#\\| |  | |/#/  V   '  V  V  \\|  '\n" +
                "   `   `  `      `   / | |  | | \\   '      '  '   '\n" +
                "                    (  | |  | |  )\n" +
                "                   __\\ | |  | | /__\n" +
                "                  (vvv(VVV)(VVV)vvv)");
        int defenseValue = isEquipmentNull(player) ? 0 : player.getDefensiveGear().getLevel();
        System.out.println("\r\nI'm a Dragon and you will burn!!\n Damage - " + attack);
        player.setHp(player.getHp() - this.attack + defenseValue);
        System.out.println(player.getName() + " HP: " + player.getHp());
        if (player.getHp() <= 0) {
            System.out.println("You died.");
        } else {
            int attackValue = isEquipmentNull(player) ? player.getAttack() : player.getAttack() + player.getOffensiveGear().getLevel();
            System.out.println("You hit the Dragon !\n  + " + attackValue);
            level -= attackValue;
            System.out.println("Dragon HP: " + level);
        }
    }

    public boolean isEquipmentNull(Hero player) {
        return player.getOffensiveGear() == null;
    }

    @Override
    public String getName() {
        return name;
    }
}
