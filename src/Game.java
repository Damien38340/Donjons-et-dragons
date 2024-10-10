
import Board.Board;
import Characters.Hero;
import Characters.Warrior;
import Characters.Wizard;
import Board.Case;


public class Game {

    private Hero player;
    private int playerPosition = 1;
    private Menu menu;
    private Board board;
    private Dice dice;

    public Game() {

    }

    public void initGame() {
        menu = new Menu();

        mainMenu();
    }

    public void mainMenu() {
        String mainMenuChoice = menu.showMainMenu();

        if (mainMenuChoice.equals("1")) {
            createNewCharacter();
        } else if (mainMenuChoice.equals("2")) {
            exitGame();
        } else {
            menu.defaultMessage();
            mainMenu();
        }
    }

    public void exitGame() {
        menu.exitMessage();
        System.exit(0);
    }

    public void createNewCharacter() {

        String userName = menu.askingName();

        menu.showMessageStrangeName(userName);

        String type = menu.askingType();

        if (type.equals("Warrior")) {
            player = new Warrior(userName, type);
        } else {
            player = new Wizard(userName, type);
        }
        menu.showTypeAnswers(type);
        showCharacterMenu();
    }

    private Hero editCharacter(Hero player) {
        String choice = menu.showCharacterEditionMenu();

        switch (choice) {
            case "1":
                String newName = menu.editName();
                player.setName(newName);
                break;

            case "2":
                String newType = menu.editType();
                if (newType.equals("Warrior")) {
                    player = new Warrior(player.getName(), newType);
                } else {
                    player = new Wizard(player.getName(), newType);
                }
                break;
            case "3":
                showCharacterMenu();
                break;
            default:
                menu.defaultMessage();
                break;
        }
        return player;
    }

    public void showCharacterMenu() {
        String choice = menu.showCharacterMenu();

        switch (choice) {
            case "1":
                //start a new game
                play();
                break;
            case "2":
                //show information
                menu.showPlayerInfo(player);
                break;

            case "3":
                //edit information
                player = editCharacter(player);
                break;

            case "4":
                //exit
                exitGame();
                break;

            default:
                menu.defaultMessage();
                break;
        }
        showCharacterMenu();
    }

    public void movePlayer(Dice roll) {
        this.playerPosition += roll;
    }

    public void play() {
        board = new Board();
        dice = new Dice();

        try {
            while (playerPosition < board.getBoardSize()) {
                String rollTheDice = menu.rollTheDice(player.getName());

                if (rollTheDice.isEmpty()) { // when player presses enter
                    Dice roll = dice;
                    movePlayer(roll);
                    menu.rollScore(roll);
                    menu.playerPosition(playerPosition);

                    if (playerPosition >= board.getBoardSize()) {
                        int excess = playerPosition - board.getBoardSize();
                        playerPosition = board.getBoardSize();  // Prevent going beyond the board size
                        throw new PlayerOutOfBounds(excess);
                    }

                    Case currentCase = board.getBoard().get(playerPosition);
                    currentCase.fight(player);

                } else if (rollTheDice.equals("1")) {
                    menu.exitMessage();
                    System.exit(0);  // Exit the game
                } else {
                    menu.defaultMessage();  // Handle other input
                }
            }
        } catch (PlayerOutOfBounds e) {
            System.out.println(e.getMessage());
        }

        // This will only run once, after the loop finishes
        if (playerPosition == board.getBoardSize()) {
            menu.victoryMessage(player);
        }
    }

}