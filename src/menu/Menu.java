package menu;

import characters.Hero;
import database.DataBase;

import java.util.Scanner;

/**
 * This class represents the menu system for the game, providing various
 * methods for displaying options and interacting with the player.
 */
public class Menu {

    private final Scanner sc;
    private DataBase dataBase;

    // ANSI escape codes for colored text output in the console
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";

    /**
     * Constructs a Menu object and initializes the Scanner for user input.
     */
    public Menu() {
        sc = new Scanner(System.in);
    }

    /**
     * Displays the main menu options and returns the user's choice.
     *
     * @return the selected option as a String
     */
    public String showMainMenu() {
        System.out.println("1. New hero");
        System.out.println("2. Choose a hero");
        System.out.println("3. Exit");

        return sc.nextLine();
    }

    /**
     * Prompts the user for their name and returns the input.
     *
     * @return the player's name as a String
     */
    public String askingName() {
        System.out.println("\n What's your" + ANSI_CYAN + " name" + ANSI_RESET + "?");
        return sc.nextLine();
    }

    /**
     * Displays a message indicating a name chosen by the player.
     *
     * @param name the name chosen by the player
     */
    public void showMessageStrangeName(String name) {
        System.out.println("\n" + ANSI_CYAN + name + ANSI_RESET + "? What a strange" + ANSI_CYAN + " name" + ANSI_RESET);
    }

    /**
     * Prompts the user for the type of character they wish to create and returns the input.
     *
     * @return the character type as a String
     */
    public String askingType() {
        System.out.println("\n What kind of" + ANSI_PURPLE + " character" + ANSI_RESET + " are you ?");
        return sc.nextLine();
    }

    /**
     * Displays a response based on the character type selected by the player.
     *
     * @param type the type of character chosen by the player
     */
    public void showTypeAnswers(String type) {
        if (type.equals("Wizard")) {
            System.out.println("\n Oh I see... You want to be the next Harry Potter\n");
        } else if (type.equals("Warrior")) {
            System.out.println("\n A " + type + " ? You don't look that strong\n");
        } else {
            System.out.println("\n A whaaaat ?? I did not get your answer, you'll be what I decide you to be\n");
        }
    }

    /**
     * Displays the character menu options and returns the user's choice.
     *
     * @return the selected option as a String
     */
    public String showCharacterMenu() {
        System.out.println("1. Play");
        System.out.println("2. Character information");
        System.out.println("3. Edit information");
        System.out.println("4. Exit");
        return sc.nextLine();
    }

    /**
     * Displays the character edition menu options and returns the user's choice.
     *
     * @return the selected option as a String
     */
    public String showCharacterEditionMenu() {
        System.out.println("\n What would you like to change ?\n");
        System.out.println("1. Name");
        System.out.println("2. Type");
        System.out.println("3. Cancel");
        return sc.nextLine();
    }

    /**
     * Prompts the user to roll the dice and returns their input.
     *
     * @param name the name of the player for personalized messaging
     * @return the user's choice as a String
     */
    public String rollTheDiceQuestion(String name) {
        System.out.println("\r\n Press" + ANSI_BLUE + " d" + ANSI_RESET + " to roll the dice dear " + ANSI_CYAN + name + ANSI_RESET + " (press" + ANSI_PURPLE + " e" + ANSI_RESET + " to see your info or press" + ANSI_RED + " q" + ANSI_RESET + " if you wanna quit 'cause you're a coward, coward)");
        return sc.nextLine();
    }

    /**
     * Displays the result of dice roll.
     *
     * @param roll the result of the dice roll
     */
    public void rollScore(int roll) {
        System.out.println("Dice: " + roll);
    }

    /**
     * Displays the player's position on the board.
     *
     * @param playerPosition the current position of the player
     */
    public void playerPosition(int playerPosition) {
        System.out.println("Case: " + playerPosition);
    }

    /**
     * Displays an exit message when the player chooses to quit.
     */
    public void exitMessage() {
        System.out.println("\n See you around!\uD83D\uDC4B\uD83C\uDFFC");
    }

    /**
     * Displays a default message for invalid menu selections.
     */
    public void defaultMessage() {
        System.out.println("\n Invalid choice, please select a valid option.");
    }

    /**
     * Prompts the user to re-enter their name when editing.
     *
     * @return the new name as a String
     */
    public String editName() {
        System.out.println("\n Can you say that name again ?");
        return sc.nextLine();
    }

    /**
     * Prompts the user to re-enter their character type when editing.
     *
     * @return the new type as a String
     */
    public String editType() {
        System.out.println("\n Can you say that type again ?");
        return sc.nextLine();
    }

    /**
     * Displays the player's information using the Hero object.
     *
     * @param hero the Hero object containing player information
     */
    public void showPlayerInfo(Hero hero) {
        System.out.println(hero);
    }

    /**
     * Displays a victory message when the player wins.
     *
     * @param hero the Hero object representing the player
     */
    public void victoryMessage(Hero hero) {
        System.out.println("\n \uD83C\uDF89 Well done " + ANSI_CYAN + hero.getName() + ANSI_RESET + "! I did not believe in you but you're the proof that anything can happen \uD83C\uDF87");
    }

    /**
     * Displays multiple choices when the player is on a case of the board
     *
     * @return the selected option as a String
     */
    public String enemyInteraction() {
        System.out.println("1. Fight");
        System.out.println("2. View inventory");
        System.out.println("3. Flee");

        return sc.nextLine();
    }

    public String bonusInteraction(){
        System.out.println("1. Retrieve equipment");
        System.out.println("2. View inventory");
        System.out.println("3. Thanks... but no thanks!");

        return sc.nextLine();
    }

    public void retreatPlayer(int roll) {
        if (roll == 1) {
            System.out.println("You have retreated " + roll + " case");
        } else {
            System.out.println("You have retreated " + roll + " cases");
        }
    }

    public void updatePlayerPosition(int newPosition) {

        System.out.println("You are now on case: " + newPosition);
    }

    /**
     * Displays a defeat message when the player loses.
     */
    public void defeatMessage() {
        System.out.println("\n \uD83D\uDC80 I knew you would not make it! \uD83D\uDC80");
    }

    /**
     * Prompts the user to replay the game and returns their choice.
     *
     * @return the user's choice as a String
     */
    public String replayMessage() {
        System.out.println("\r\nWould you like to give it another try ? ");
        System.out.println("\r\nPress " + ANSI_CYAN + "Yes " + ANSI_RESET + "to continue");
        System.out.println("Press " + ANSI_RED + "No " + ANSI_RESET + "to hit the road");
        return sc.nextLine();
    }

    public String askingToSaveCharacter(){
        System.out.println("Do you wish to save your character ?");
        System.out.println("Yes");
        System.out.println("No");

        return sc.nextLine();
    }

    public String askingToSaveChanges(){
        System.out.println("Do you wish to save your changes ?");
        System.out.println("Yes");
        System.out.println("No");

        return sc.nextLine();
    }


    public String listOfHeroes(DataBase dataBase){
        dataBase.getHeroes();
        System.out.println("\n\n Type the ID to choose your character");

        return sc.nextLine();
    }
}
