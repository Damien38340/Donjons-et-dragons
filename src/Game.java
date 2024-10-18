import board.enemy.CaseEnemy;
import characters.*;
import board.*;
import database.DataBase;
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
    private DataBase dataBase;

    /**
     * Initializes a new Game instance, creating a new board and dice.
     */
    public Game() {
        this.board = new Board();
        this.dice = new Dice();
        this.dataBase = new DataBase();
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

        switch (mainMenuChoice) {

            case "1":
                createNewCharacter();
                break;
            case "2": {
                chooseYourHero();
                showCharacterMenu();
                break;
            }
            case "3":
                exitGame();
                break;
            default: {
                menu.defaultMessage();
                mainMenu();
                break;
            }
        }
    }

    public void chooseYourHero() {

        boolean validSelection = false; // Track if the selection is valid

        while (!validSelection) {
            String heroChoice = menu.listOfHeroes(dataBase);

            int chosenHeroId;
            try {
                chosenHeroId = Integer.parseInt(heroChoice);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;  // Exit or allow re-entry in case of invalid input
            }

            Hero chosenHero = dataBase.getHeroById(chosenHeroId, player);

            if (chosenHero != null) {
                player = chosenHero;
                System.out.println("You have selected: " + chosenHero.getName() +"\n");
                validSelection = true;
                // Proceed with the game logic for the selected hero
            } else {
                System.out.println("\nHero with ID " + chosenHeroId + " not found. Please try again.\n");
                // Optionally, loop back to let the player choose again
            }
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
        saveCharacter();
        showCharacterMenu();
    }

    public void saveCharacter() {
        String choice = menu.askingToSaveCharacter();

        if (choice.equalsIgnoreCase("Yes")) {
            dataBase.createHero(player);  // Save the player's character in the database
        } else if (choice.equalsIgnoreCase("No")) {
            System.out.println("Character not saved.");
        } else {
            menu.defaultMessage();
            saveCharacter();
        }
    }

    /**
     * Edits the player's character based on user input.
     *
     * @param player the current hero character
     * @return the updated hero character
     */
    private Hero editCharacter(Hero player) {
        String choice = menu.showCharacterEditionMenu();
        Hero chosenHero = dataBase.getHeroByName(player.getName(), player);

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
        if (chosenHero != null){
            saveChanges();
        }
        return player;
    }

    public void saveChanges() {
        String choice = menu.askingToSaveChanges();

        if (choice.equalsIgnoreCase("Yes")) {
            dataBase.editHero(player);
        } else if (choice.equalsIgnoreCase("No")) {
            System.out.println("Changes not saved.");
        } else {
            menu.defaultMessage();
            saveCharacter();
        }
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
                    case "d":
                        handleDiceRoll();
                        break;
                    case "e":
                        menu.showPlayerInfo(player);  // Show the player info
                        break;
                    case "q": {
                        menu.exitMessage();
                        System.exit(0); // Exit the game
                        break;
                    }
                    default:
                        menu.defaultMessage(); // Handle other input
                }
                if (player.getHp() <= 0) {
                    return;
                }
            }
        } catch (PlayerOutOfBounds e) {
            System.out.println(e.getMessage());
        }

        if (playerPosition == board.getBoardSize()) {
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

        currentCase.display();

        if (currentCase instanceof CaseEnemy) {
            ((CaseEnemy) currentCase).enemyArrival();
            handleEnemyInteraction(currentCase);
            if (player.getHp() <= 0) {
                menu.defeatMessage();
            } else if (player.getHp() > 0) {//check if neither the player nor the enemy died
                if (currentCase.getLevel() < 5) {
                    board.moveEnemyToRandomCase(currentCase);
                    board.handleEnemyDefeat(currentCase, playerPosition);
                } else {
                    handleEnemyInteraction(currentCase);
                    board.handleEnemyDefeat(currentCase, playerPosition);
                }
            }
        } else if (currentCase instanceof CaseBonus) {
            handleBonusInteraction(currentCase);
        }
    }

    private void handleEnemyInteraction(Case currentCase) {
        String choice = menu.enemyInteraction();
        switch (choice) {
            case "1":
                currentCase.interact(player);
                break;
            case "2":
                menu.showPlayerInfo(player);
                handleEnemyInteraction(currentCase);
                break;
            case "3":
                movePlayerBackRandomly(dice.roll());
                menu.updatePlayerPosition(playerPosition);
                play();
                break;
            default:
                menu.defaultMessage();
                handleEnemyInteraction(currentCase);
                break;
        }
    }

    public void handleBonusInteraction(Case currentCase) {
        String choice = menu.bonusInteraction();
        switch (choice) {
            case "1":
                currentCase.interact(player);
                break;
            case "2":
                menu.showPlayerInfo(player);
                handleBonusInteraction(currentCase);
                break;
            case "3":
                break;
            default:
                menu.defaultMessage();
                handleBonusInteraction(currentCase);
                break;
        }
    }

    public void movePlayerBackRandomly(int roll) {
        this.playerPosition -= roll;
        if (playerPosition <= 0) {
            playerPosition = 1;
        }
        menu.retreatPlayer(roll);
    }
}
