import characters.*;
import board.*;
import menu.Menu;

/**
 * The Game class manages the main logic of the game, including initializing the game,
 * managing the player character, and controlling the game flow.
 */
public class Game {

    private Hero player; // The player's character
    private int playerPosition = 1; // The player's current position on the board
    private Menu menu; // The menu for user interactions
    private Board board; // The game board
    private Dice dice; // The dice used for rolling

    /**
     * Initializes a new Game instance, creating a new board and dice.
     */
    public Game() {
        this.board = new Board();
        this.dice = new Dice();
    }

    /**
     * Starts the game by initializing the menu and showing the main menu.
     */
    public void initGame() {
        menu = new Menu();
        mainMenu();
    }

    /**
     * Displays the main menu and processes the user's choice.
     */
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

    /**
     * Exits the game and displays an exit message.
     */
    public void exitGame() {
        menu.exitMessage();
        System.exit(0);
    }

    /**
     * Prompts the user to create a new character.
     */
    public void createNewCharacter() {
        String userName = menu.askingName();
        menu.showMessageStrangeName(userName);
        String type = menu.askingType();

        // Create the player character based on the chosen type
        if (type.equalsIgnoreCase("Warrior")) {
            player = new Warrior(userName, type);
        } else {
            player = new Wizard(userName, type);
        }
        menu.showTypeAnswers(type);
        showCharacterMenu();
    }

    /**
     * Edits the player's character based on user input.
     *
     * @param player the current hero character
     * @return the updated hero character
     */
    private Hero editCharacter(Hero player) {
        String choice = menu.showCharacterEditionMenu();

        switch (choice) {
            case "1":
                String newName = menu.editName();
                player.setName(newName);
                break;

            case "2":
                String newType = menu.editType();
                if (newType.equalsIgnoreCase("Warrior")) {
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

    /**
     * Displays the character menu and processes user choices related to the character.
     */
    public void showCharacterMenu() {
        String choice = menu.showCharacterMenu();

        switch (choice) {
            case "1":
                // Start a new game
                play();
                askReplay();
                break;
            case "2":
                // Show information
                menu.showPlayerInfo(player);
                break;

            case "3":
                // Edit information
                player = editCharacter(player);
                break;

            case "4":
                // Exit
                exitGame();
                break;

            default:
                menu.defaultMessage();
                break;
        }
        showCharacterMenu();
    }

    /**
     * Asks the player if they want to replay the game after finishing.
     */
    public void askReplay() {
        String replay = menu.replayMessage();
        if (replay.equalsIgnoreCase("Yes")) {
            playerPosition = 1;
            mainMenu();
        } else if (replay.equalsIgnoreCase("No")) {
            exitGame();
        } else {
            menu.defaultMessage();
            askReplay();
        }
    }

    /**
     * Moves the player based on the rolled dice value.
     *
     * @param roll the value rolled on the dice
     */
    public void movePlayer(int roll) {
        this.playerPosition += roll;
    }

    /**
     * Starts the gameplay loop, allowing the player to roll the dice and interact with the game board.
     */
    public void play() {
        try {
            while (playerPosition < board.getBoardSize()) {
                String rollTheDiceQuestion = menu.rollTheDiceQuestion(player.getName());

                switch (rollTheDiceQuestion) {
                    case "d" :
                        handleDiceRoll();

                    case "e" : menu.showPlayerInfo(player); // Show the player info
                    case "q" : {
                        menu.exitMessage();
                        System.exit(0); // Exit the game
                    }
                    default : menu.defaultMessage(); // Handle other input
                }
                if (player.getHp() <= 0) {
                    return;
                }
            }
        } catch (PlayerOutOfBounds e) {
            System.out.println(e.getMessage());
        }

        if (playerPosition == board.getBoardSize()) {
            playerPosition = 1;
            menu.victoryMessage(player);
        }
    }

    /**
     * Processes the dice roll and updates the player's position accordingly.
     *
     * @throws PlayerOutOfBounds if the player's position exceeds the board size
     */
    private void handleDiceRoll() throws PlayerOutOfBounds {
        int roll = dice.roll();
        movePlayer(roll);
        menu.rollScore(roll);
        menu.playerPosition(playerPosition);

        if (playerPosition >= board.getBoardSize()) {
            int excess = playerPosition - board.getBoardSize();
            playerPosition = board.getBoardSize();
            throw new PlayerOutOfBounds(excess);
        }

        Case currentCase = board.getBoard().get(playerPosition);
        currentCase.interact(player);
        if (player.getHp() <= 0) {
            menu.defeatMessage();
            return;
        }
        board.moveEnemyToRandomCase(currentCase); // When player presses d
    }
}
