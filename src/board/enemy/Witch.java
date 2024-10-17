package board.enemy;

import characters.Hero;

/**
 * Represents a Witch, a mystical enemy that the player can encounter.
 * The Witch interacts with the hero, causing damage and receiving attacks in return.
 */
public class Witch extends CaseEnemy {

    /**
     * Constructs a Witch enemy with default values for name, attack, and level.
     * The Witch has an attack strength of 2 and a level (HP) of 9.
     */
    public Witch() {
        super("Witch", 2, 14);
    }

    /**
     * Defines the interaction between the Witch and the hero.
     * The Witch attacks the hero, reducing the hero's HP based on the Witch's attack value and the hero's defense.
     * The hero can counter-attack, reducing the Witch's level (HP). If the hero's HP reaches zero or below, they die.
     *
     * @param player The hero interacting with the Witch.
     */
    @Override
    public void interact(Hero player) {
    super.interact(player);
    }

    /**
     * Returns a personalized description for the Witch.
     * This message is used to add flavor to the interaction between the Witch and the hero.
     *
     * @return A string with a personalized description.
     */
    @Override
    public String getComplement() {
        return " and I curse you";
    }


    /**
     * Returns a personalized action when the enemy attacks.
     *
     * @return A string with a personalized attack message when the Witch attacks.
     */
@Override
    public String getPersonalizedAttack(){
    return " casts a hex!";
}
    /**
     * Displays an ASCII art representation of a Witch.
     */
    @Override
    public void display(){

        System.out.println("                                               .:+#-.                                               \n" +
                "                                             ..*@@@@%-.                                             \n" +
                "                                            ..@**@@@@@%-.                                           \n" +
                "                                            .*=..:@@@@@@@-.                                         \n" +
                "                                            -+   .=@@@@@@@@+....::.                                 \n" +
                "                                           ...   .:@@@@@@@@@@@@*...                                 \n" +
                "                                                 ..#@@@@@@@@@@..                                    \n" +
                "                                                  .*@@@@@@@@@@@%..                                  \n" +
                "                                               .:#@@@@@@@@@@@@*-+.                                  \n" +
                "                                          ..::=@@@@@@@@@@@@@@@=.                                    \n" +
                "                                ....::.:-*@@@@@@@@@@@@@@@@@@@%#-                                    \n" +
                "                                  .==*##%@@@@@@@@@@@@@@@@@@%..                                      \n" +
                "                              ...:+-**-+#+@@@@@@@@@@@@@@@@@@@@:.                                    \n" +
                "                              ....-...#@@@@@@@@@@@@@@@@@@@@@@@@@#:.                                 \n" +
                "                               .:*#%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%:                                \n" +
                "                       ......-#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#@@@@#-..                     ...-+:.\n" +
                "                      .+@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#. .*@@@@@*-:....          ..-+@@@%+..\n" +
                "                 ..:-+#.-@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=.     .:#%@@@@@@@@@@@@-=+-%@@@%-..    \n" +
                "               ..*-...+@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*....-=+**+:.....%@@@@@@@@@@@@+...       \n" +
                "               .-%@@@@@@@@+@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#:.+@@@@@@@@@@*:..         \n" +
                "              .*@@@#++==-%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%:.                \n" +
                "             .+@@*..#@@@@@@@@@@@@@@@#%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@+ #@@@:.                 \n" +
                "         .:=%@@@+.:%@@@##+#@@@@@%-*@%*:.#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=. =@@@                   \n" +
                "        .@@@@%=.+@@@@*..%@@@@@%:+@+.   .%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:.  -@@:                   \n" +
                "        %=..  .%@%:.. .#@@@...+@@-     .*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#.  :@@.                    \n" +
                "      .*.  ...+@@....*@@#..-%@@*..     ..#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%.. +@+.                    \n" +
                "      ..   .*%=.. .#+:.   .@@-.           .-*@@@@@@@@@@@@@@@@@@@@@@@@@@@@+..#..                     \n" +
                "          .+.    -@:.     .*.         ..-+%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-*.                       \n" +
                "           .     #-.      :..:..  .:-#@@@@%*-#@@@@@@@@@@@@@@@@%@@@@*.:%@@@#.                        \n" +
                "               .:..    ..=:*@+-:*@@@@@%-...=@@@@@@@@@@@@@@@+.=@@@@:.  .-@@@@*:..                    \n" +
                "                      ..##@@@@@@@@#......=@@#-@@@@@@@@@@@*..-@@@#..     =@@@@@@+....                \n" +
                "     :.   .:...=+**=::+@@@@@@@@*=...  .+*:+%@@@@@@@@@@@%:..@@@@@+.      -@@@@@@@@@@#.               \n" +
                " ...-*#%@@@@@@@@@@@@@@@@@@@@@@@*:. ..-*:+@##@@@@@@@@*-...:%@@@@@+.      .#@%..--:...                \n" +
                ".-+#@@@@@@@@@@@@@@@@@@#+......::.  ..-#@**@@@@@@#:...   ..=#.%@@%..      ....                       \n" +
                "..:=#@@@@@@@@@@@@@@@@=.            .-:.+@%-*@@@%.           .-%@@@%:                                \n" +
                "..:*@@@@@@@@@@@@@@@#...            .:=%@*%@@%#:..            ....-+:                                \n" +
                " .#=*#%@@@@@@@@@@%-.              :%-.:@@@*..                                                       \n" +
                " .:**#%@@@@@@@@#=..             ......%@*..                                                         \n" +
                "  ..:-#%%@@@@%:..                  .#%=...                                                          \n" +
                "    .-:-+@@#+..                 ..:@+.                                                              \n" +
                "    ....=+-=.                   .+@+.                                                               \n" +
                "          ..                    :*..                                                                \n" +
                "                                ..                                                                  ");
    }
}

