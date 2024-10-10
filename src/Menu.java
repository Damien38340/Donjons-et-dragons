import Characters.Hero;

import java.util.Scanner;

public class Menu {

    private final Scanner sc;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";

    public Menu() {
        sc = new Scanner(System.in);
    }

    public String showMainMenu() {

        System.out.println("1. New character");
        System.out.println("2. Exit");

        return sc.nextLine();
    }

    public void showMessageStrangeName(String name) {
        System.out.println("\n" + ANSI_CYAN + name + ANSI_RESET + "? What a strange" + ANSI_CYAN + " name" + ANSI_RESET);
    }

    public String askingName() {
        System.out.println("\n What's your" + ANSI_CYAN + " name" + ANSI_RESET + "?");

        return sc.nextLine();
    }

    public String askingType() {
        System.out.println("\n What kind of" + ANSI_PURPLE + " character" + ANSI_RESET + " are you ?");
        return sc.nextLine();
    }

    public void showTypeAnswers(String type) {
        if (type.equals("Wizard")) {
            System.out.println("\n Oh I see... You want to be the next Harry Potter");
        } else if (type.equals("Warrior")) {
            System.out.println("\n A " + type + " ? You don't look that strong");
        } else {
            System.out.println("\n A whaaaat ?? I did not get your answer, you'll be what I decide you to be");
        }
    }

    public String showCharacterMenu() {
        System.out.println("1. Play");
        System.out.println("2. Character information");
        System.out.println("3. Edit information");
        System.out.println("4. Exit");

        return sc.nextLine();
    }

    public String showCharacterEditionMenu() {
        System.out.println("\n What would you like to change ?\n");
        System.out.println("1. Name");
        System.out.println("2. Type");
        System.out.println("3. Cancel");

        return sc.nextLine();
    }

    public String rollTheDice(String name) {
        System.out.println("\r\n Press" + ANSI_BLUE + " enter" + ANSI_RESET + " to roll the dice dear " + ANSI_CYAN + name + ANSI_RESET + " (or press" + ANSI_RED + " 1" + ANSI_RESET + " if you wanna quit 'cause you're a coward, coward)");
        return sc.nextLine();
    }
        public void rollScore ( Dice roll){
            System.out.println("Dice: " + roll);
        }
    public void playerPosition(int playerPosition){
        System.out.println("Case: " + playerPosition);
    }

    public void exitMessage() {
        System.out.println("\n See you around!\uD83D\uDC4B\uD83C\uDFFC");
    }

    public void defaultMessage() {
        System.out.println("\n Invalid choice, please select a valid option.");

    }

    public String editName() {
        System.out.println("\n Can you say that name again ?");
        return sc.nextLine();
    }

    public String editType() {
        System.out.println("\n Can you say that type again ?");
        return sc.nextLine();
    }

    public void showPlayerInfo(Hero hero) {
        System.out.println(hero);
    }

    public void victoryMessage(Hero hero) {
        System.out.println("\n \uD83C\uDF89 Well done " + ANSI_CYAN + hero.getName() + ANSI_RESET + "! I did not believe in you but you're the proof that anything can happen \uD83C\uDF87");
    }

    public void defeatMessage() {
        System.out.println("\n \uD83D\uDC80 I knew you would not make it! \uD83D\uDC80");
    }

}
