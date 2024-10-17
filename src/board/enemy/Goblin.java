package board.enemy;

import characters.Hero;

/**
 * Represents a Goblin, a weak but aggressive enemy that the player can encounter.
 * The Goblin interacts with the hero, causing damage and receiving attacks in return.
 */
public class Goblin extends CaseEnemy {

    /**
     * Constructs a Goblin enemy with default values for name, attack, and level.
     * The Goblin has an attack strength of 1 and a level (HP) of 6.
     */
    public Goblin() {
        super("Goblin", 1, 10);
    }

    /**
     * Defines the interaction between the Goblin and the hero.
     * The Goblin attacks the hero, reducing the hero's HP based on the Goblin's attack value and the hero's defense.
     * The hero can counter-attack, reducing the Goblin's level (HP). If the hero's HP reaches zero or below, they die.
     *
     * @param player The hero interacting with the Goblin.
     */
    @Override
    public void interact(Hero player) {
    super.interact(player);
    }

    /**
     * Returns a personalized description for the Goblin.
     * This message is used to add flavor to the interaction between the Goblin and the hero.
     *
     * @return A string with a personalized description.
     */
    @Override
    public String getComplement() {
        return " and I'll rip you apart";
    }

    /**
     * Returns a personalized action when the enemy attacks.
     *
     * @return A string with a personalized attack message when the Goblin attacks.
     */
    @Override
    public String getPersonalizedAttack(){
        return " lunges at you!";
    }

    /**
     * Displays an ASCII art representation of a Goblin.
     */
    @Override
    public void display(){
        System.out.println("                                           .:.                                  .:.             \n" +
                "        ..                                 :.  .=-. ...                        ..:=+=:.             \n" +
                "        .=+-..                            .==..:+=-..-:.                    ..=+**+:..              \n" +
                "        ..=**+-..                     .:+**#####**###++=...             ..:=+*#*+-..                \n" +
                "         ..:+*#*+=:..             ..-*############***=*%%#*-.      .:=****+*#***:.                  \n" +
                "           ..=***#+++-..        ..*%%####**++++*****++*#%%#%%+.. .:+*++++*####=..                   \n" +
                "             .-#***#*+++*=.. .-=*%%##%##***++==++****#%%####%%%#%##*+#%%####*:.                     \n" +
                "              ...=#***##+++**#%%%##%%##****+++=+++***#**#%%#%%%%%##%%%#####=...                     \n" +
                "               ...=***#####*++*##%#%#####*****+++****####%%%%%%%%%#%#####=...                       \n" +
                "                 ..:=+**####%*+*###%#####*####****#######%%%%%%%%%####*:...                         \n" +
                "                   ..===+*###%#*#####***++++**#########%%%%%#**##%%%#*+..                           \n" +
                "                      ..:++*#%**#####****++==+*#########%%#*+*###%%%#:.                             \n" +
                "                      ..-**+*#%####***###*##+==*##**++**##**###%##%*:.                              \n" +
                "                       .:+=**##%####*+**##**###**+==+++**+*####*##*:.                               \n" +
                "                       .---=+##%####**++++***++==-===--=**+=+*+++*+.                                \n" +
                "                        .::...+######*+++++=====--+*######*+++++##=. ..+**+--+==--=--:..            \n" +
                "                        ..   .*####%+#%#**++++=++===++***+++*#%%*#=...+*#**+======+++**+-+=..       \n" +
                "                 .... ...    .:####%#+*%%%####**#*++*****##%%%**#%%#*+++++*======--==+*######+:.    \n" +
                "              ..-=+++.-++-:++*##%%#%##***%%#%*#*#**#*#**##%%%*##%%%++++****+==-----===+*****###*-.  \n" +
                ".-=++:......--+**####@%+++*+*###%#%%%%###**#%%%%%%%%#%%%%@##*####%%*********++++++*************##+..\n" +
                "-*+=+#***#%%#%%%%#%**+##*##**##%%#%##%%%###**##%*%##%###*%#*#%%##%%##*=-:.              ..:-=+***#*:\n" +
                "+*#####+######%%%%%#*****--+**+#+*%%#%%%%%%%#****########****#*-:-#=.                             ..\n" +
                "=*#####*=--:...+#%###=.....  .::-+#%#%@@%%%%%%##*+++***###*=:=+. :#*:.                              \n" +
                "              .:******.   ...:=**+*%%#%%%%%#%%%%%#######%#*++=-. .=#=..                             \n" +
                "               .*****#+:=+****++***#%##%%%#####%%%%%%%%%%#**++++=:.-+-..                            \n" +
                "               .+****+##*+=+=+*+**##%**%%%#+===+****#%%%%%#*+=+***+=...                             \n" +
                "               .*##*++***++=++####%%%**%%%%#++++*+**##%*##**++********-.                            \n" +
                "               .+%*****#%#*+**%%%#%%%%%%%%%#****#++####=:-*###%%#****##.                            \n" +
                "               .:#######%%#*+:....*%##%%%%##**########%#:.....-#**####=.                            \n" +
                "                ..=%%%#=-=....    .+%%%%%%%#######%##%%%%+.  :+#+*###*:                             \n" +
                "                 .......--.        .%%%%##**#####%%%%%%%%@: .-*#*=+##-.                             \n" +
                "                      ..-:.        .#%%%%%%%%%%#*##%##%%%%*=-+#==*#*:.                              \n" +
                "                      ..:..       ..%@%%%#%@@%%##%%%##%%%###%##*+**:.                               \n" +
                "                      ....       ..-#%%%%%%@%%%%#%%%%%@@@@###%%%#=...                               \n" +
                "                             ....:#%%%%%%%%%%###**%%@@@@@@%%##%#....                                \n" +
                "                            .+-:-*%%%%###%%%%#****%%%%@@@%%%%##-..                                  \n" +
                "                         .-+.=::*#%%%%%#####*****#%#%%@%@%%%%%@*.                                   \n" +
                "                      ..-=--*:*+**#%%%%##*#******#%#%%%%%%%%%%%@#:.                                 \n" +
                "                      ..=*+..*+###%%%#############%#%##%####%%%%@*:.                                \n" +
                "                      .=+==+=**#%%%%######**#%%#%%%%##########%%@%+.                                \n" +
                "                      .+:=*+**#%%%%##*#####%%%%#%%%%%#%%%%###%%%@%%+..                              \n" +
                "                      .+:**+*##%%%%%%#*###%%%%%#%%%%%%%%%%%%%#***%%%+..                             \n" +
                "                      .:*#*#####+**##%%##%%#####%%%%%%%%%%%#**+===*%%%*..                           \n" +
                "                      .*#*##*===+#*#%%##%%#*+*#%%%%%%%%%%%%#***++++##-*:.                           \n" +
                "                     .=+::*##*+*###%%+*%%%%###*#%%%%%%%%%%%#####***#%=..:.                          \n" +
                "                   ..+=..*##*###**%#..-#%%%###**###%%%%#+.:*%#*####%##:                             \n" +
                "                   .:...-###*###*#%%:.:+*-#%###*###%%#=.. :#####***###:                             \n" +
                "                      ..=#######%%%%:..-+:+=#########+.   .+%###****##=.                            \n" +
                "                      ..+##******#%#-. :-.-:*:=*###+:-.   :*##******#%+.                            \n" +
                "                      .:*#######%%%*.  ::.:.:.=*###=.:.   .-##*****##%=.                            \n" +
                "                      ..=##*****###-.  .......-+*%*=..    .-####***#%%*.                            \n" +
                "                       .=%#%%%%%%%%:          .=#%+...    .-##******###.                            \n" +
                "                      ..=%#****##%%:          .=#+..      .-%#######%%#.                            \n" +
                "                      .-##########%-          .=#-..      .:*%#%########+:                          \n" +
                "                  ..:=#######%%%%%%%.          -*.        .+%%%%###*####%#*:.                       \n" +
                "               ....*%%%%%%%####%%%%#...        .:.        :%%%%%%######%#######%#*-..               \n" +
                "             ..=*****#**####%###*-..                      .:+#*##%##%#########%%%%*..               \n" +
                "            .=%%%%%%#%###%##%%+...                              ..:-*#####%%%%%-==..                \n" +
                "           ..:-:+*+#%##%%%%=:...                                 ..   ...........                   \n" +
                "               ....-..=:....                                                       ");
    }
}
