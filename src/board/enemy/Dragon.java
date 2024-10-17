package board.enemy;

import characters.Hero;

/**
 * Represents a Dragon, a specific type of enemy encountered by the player.
 * The Dragon interacts with the hero, causing damage and receiving attacks in return.
 */
public class Dragon extends CaseEnemy {

    /**
     * Constructs a Dragon enemy with default values for name, attack, and level.
     * The Dragon has an attack strength of 4 and a level (HP) of 15.
     */
    public Dragon() {
        super("Dragon", 4, 20);
    }

    /**
     * Overrides the visualizer display.
     */
    @Override
    public void interact(Hero player) {
        super.interact(player);
    }

    /**
     * Returns a complementary description for the Dragon.
     * This message is used to add flavor to the interaction between the Dragon and the hero.
     *
     * @return A string with a personalized description.
     */
    @Override
    public String getComplement() {
        return " and you will burn";
    }

    /**
     * Returns a personalized action when the enemy attacks.
     *
     * @return A string with a personalized attack message when the Dragon attacks.
     */
    @Override
    public String getPersonalizedAttack(){
        return " breathes fire!";
}

    /**
     * Displays an ASCII art representation of a Dragon.
     */
    @Override
    public void display() {

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

    }
}
