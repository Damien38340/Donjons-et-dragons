
public class Game {

    private int[] board;
    private Character player;
    private int positionPlayer;
    private Menu menu;

    public Game() {
        this.board = new int[64];
        this.positionPlayer = 1;
    }

    public void initGame() {
        menu = new Menu();

        String mainMenu = menu.showMainMenu();

        String userName = menu.askingName(mainMenu);

        menu.showMessageStrangeName(userName);

        String type = menu.askingType();

        if (type.equals("Warrior")){
            player = new Warrior(userName, type);
        }
        else {
            player = new Wizard(userName, type);
        }

        menu.showTypeAnswers(type);

        String characterMenuChoice = menu.showCharacterMenu();

        showCharacterMenuChoice(characterMenuChoice, player);

    }

    public void showCharacterMenuChoice(String choice, Character newCharacter) {
        boolean exit = false;
        while (!exit) {
            switch (choice) {
                case "1":
                    //start a new game
                    play();
                    break;
                case "2":
                    //show information
                    System.out.println(newCharacter);
                    break;

                case "3":
                    //edit information
                    String CharacterEditionMenuChoice = menu.showCharacterEditionMenu();
                    menu.showEditionMenuChoice(CharacterEditionMenuChoice, newCharacter);
                    break;

                case "4":
                    //exit
                    exit = true;
                    menu.exitMessage();
                    break;

                default:
                    menu.defaultMessage();
                    break;
            }
            if (!exit) {
                choice = menu.showCharacterMenu();

            }
        }
    }

    public int dice() {
        return (int) (Math.random() * 6 + 1);
    }

    public void play() {
        while (positionPlayer < board.length) {
            int roll = dice();
            positionPlayer += roll;
            if (positionPlayer > board.length) {
                positionPlayer = board.length;
            }
            System.out.println(positionPlayer);
        }
        System.out.println("Well done " + player.getName() + "! I did not believe in you but you're the proof that anything can happen");
    }
}
