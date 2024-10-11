
import Characters.*;
import Board.*;


public class Game {

    private Hero player;
    private int playerPosition = 1;
    private Menu menu;
    private Board board;
    private Dice dice;

    public Game() {
        this.board = new Board();
        this.dice = new Dice();
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

    public void movePlayer(int roll) {
        this.playerPosition += roll;
    }

    public void play() {

        try {
            while (playerPosition < board.getBoardSize()) {
                String rollTheDiceQuestion = menu.rollTheDiceQuestion(player.getName());

                if (rollTheDiceQuestion.equals("d")) { // when player presses enter
                    int roll = dice.roll();
                    movePlayer(roll);
                    menu.rollScore(roll);
                    menu.playerPosition(playerPosition);

                    if (playerPosition >= board.getBoardSize()) {
                        int excess = playerPosition - board.getBoardSize();
                        playerPosition = board.getBoardSize();                        throw new PlayerOutOfBounds(excess);
                    }

                    Case currentCase = board.getBoard().get(playerPosition);
                    currentCase.interact(player);
                    if (player.getHp() <= 0){
                        menu.defeatMessage();
                        break;
                    }
                    board.moveEnemyToRandomCase(currentCase);
                }
                else if (rollTheDiceQuestion.equals("e")) {
                    menu.showPlayerInfo(player); // Show the player info
                }

                else if (rollTheDiceQuestion.equals("q")) {
                    menu.exitMessage();
                    System.exit(0);  // Exit the game
                }

                else {
                    menu.defaultMessage();  // Handle other input
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

}