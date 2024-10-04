import java.util.Scanner;


public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        Menu menu = new Menu();

        String mainMenu = menu.showMainMenu();

        if (mainMenu.equals("1")) {
        } else if (mainMenu.equals("2")) {
            System.out.println("See you around!");
            System.exit(0);
        }

        System.out.println("What's your" + ANSI_CYAN + " name" + ANSI_RESET + "?");

        String userName = myObj.nextLine();  // Read user input
        System.out.println(userName + "? What a strange" + ANSI_CYAN + " name" + ANSI_RESET);  // Output user input

        System.out.println("What kind of" + ANSI_PURPLE + " character" + ANSI_RESET + " are you ?");
        String type = myObj.nextLine();

        Character newCharacter = new Character(userName, type);

        if (type.equals("Wizard")) {
            System.out.println("Oh I see... You want to be the new Harry Potter");
        } else if (type.equals("Warrior")) {
            System.out.println("a " + type + " ? You don't look that strong");
        } else {
            System.out.println("I did not get your answer");
        }

        String characterMenu = menu.showCharacterMenu();

        switch (characterMenu) {
            case "1" -> {
                //start a new game

            }
            case "2" -> {
                //show information
                System.out.println(newCharacter);
            }
            case "3" -> {
                //edit information

            }
            case "4" -> {
                System.out.println("See you around!");
                System.exit(0);
            }
        }
    }
}