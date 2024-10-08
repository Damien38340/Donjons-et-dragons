
import Characters.Character;
import Characters.Warrior;
import Characters.Wizard;

import java.util.ArrayList;

public class Game {

    private ArrayList<Case> board;
    private Character player;
    private int positionPlayer;
    private Menu menu;

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

        if (type.equals("Characters.Warrior")) {
            player = new Warrior(userName, type);
        } else {
            player = new Wizard(userName, type);
        }
        menu.showTypeAnswers(type);
        showCharacterMenu();
    }

    private Character editCharacter(Character character) {
        String choice = menu.showCharacterEditionMenu();

        switch (choice) {
            case "1":
                String newName = menu.editName();
                character.setName(newName);
                break;

            case "2":
                String newType = menu.editType();
                if (newType.equals("Characters.Warrior")) {
                    character = new Warrior(character.getName(), newType);
                } else {
                    character = new Wizard(character.getName(), newType);
                }
                break;
            case "3":
                showCharacterMenu();
                break;
            default:
                menu.defaultMessage();
                break;
        }
        return character;
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

    public int dice() {
        return (int) (Math.random() * 6 + 1);
    }

    public void play() {
        positionPlayer = 1;
        board = new ArrayList<Case>(65);

        for (Case c : board) {
            board.add(c);
        }

        try {
            while (positionPlayer < board.size() - 1) {
                int roll = dice();
                positionPlayer += roll;
                System.out.println(positionPlayer);
            }
        } catch (Exception e) {
            System.out.println("Player out of bounds !!");
        }
        if (positionPlayer == board.size() - 1) {
            menu.victoryMessage(player);
        } else {
            menu.defeatMessage();
        }
    }
}