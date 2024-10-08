import Characters.Character;

import java.util.Scanner;

public class Menu {

    private Scanner sc;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public Menu() {
        sc = new Scanner(System.in);
    }

    public String showMainMenu() {

        System.out.println("1. New character");
        System.out.println("2. Exit");

        return sc.nextLine();
    }

    public void showMessageStrangeName(String name) {
        System.out.println(name + "? What a strange" + ANSI_CYAN + " name" + ANSI_RESET);  // Output user input
    }

    public String askingName() {
        System.out.println("What's your" + ANSI_CYAN + " name" + ANSI_RESET + "?");

        return sc.nextLine();  // Read user input
    }

    public String askingType() {
        System.out.println("What kind of" + ANSI_PURPLE + " character" + ANSI_RESET + " are you ?");
        return sc.nextLine();
    }

    public void showTypeAnswers(String type) {
        if (type.equals("Characters.Wizard")) {
            System.out.println("Oh I see... You want to be the new Harry Potter");
        } else if (type.equals("Characters.Warrior")) {
            System.out.println("a " + type + " ? You don't look that strong");
        } else {
            System.out.println("A whaaaat ?? I did not get your answer, you'll be what I decide you to be");
        }
    }

    public String showCharacterMenu() {
        System.out.println("1. Play");
        System.out.println("2. Characters.Character information");
        System.out.println("3. Edit information");
        System.out.println("4. Exit");

        sc = new Scanner(System.in);
        return sc.nextLine();
    }


    public String showCharacterEditionMenu() {
        System.out.println("What would you like to change ?\n");
        System.out.println("1. Name");
        System.out.println("2. Type");
        System.out.println("3. Cancel");

        return sc.nextLine();
    }

    public void exitMessage() {
        System.out.println("See you around!");
    }

    public void defaultMessage() {
        System.out.println("Invalid choice, please select a valid option.");

    }

    public String editName() {
        System.out.println("Can you say that name again ?");
        return sc.nextLine();
    }

    public String editType() {
        System.out.println("Can you say that type again ?");
        return sc.nextLine();
    }

    public void showPlayerInfo(Character character) {
        System.out.println(character);
    }

    public void victoryMessage(Character character) {
        System.out.println("Well done " + character.getName() + "! I did not believe in you but you're the proof that anything can happen");
    }

    public void defeatMessage() {
        System.out.println("I knew you would not make it!");
    }

}
