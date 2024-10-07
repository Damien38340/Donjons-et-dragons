import java.util.Scanner;

public class Menu {

    private Scanner sc;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static int[] board;

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

    public String askingName(String mainMenu) {
        if (mainMenu.equals("1")) {
            System.out.println("What's your" + ANSI_CYAN + " name" + ANSI_RESET + "?");
        } else if (mainMenu.equals("2")) {
            System.out.println("See you around!");
            System.exit(0);
        } else {
            defaultMessage();
        }
        return sc.nextLine();  // Read user input
    }

    public String askingType() {
        System.out.println("What kind of" + ANSI_PURPLE + " character" + ANSI_RESET + " are you ?");
        return sc.nextLine();
    }

    public void showTypeAnswers(String type) {
        if (type.equals("Wizard")) {
            System.out.println("Oh I see... You want to be the new Harry Potter");
        } else if (type.equals("Warrior")) {
            System.out.println("a " + type + " ? You don't look that strong");
        } else {
            System.out.println("A whaaaat ?? I did not get your answer, you'll be what I decide you to be");
        }
    }

    public String showCharacterMenu() {
        System.out.println("1. Play");
        System.out.println("2. Character information");
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

    public void showEditionMenuChoice(String choice, Character newCharacter) {
        switch (choice) {
            case "1":
                String newName = showEditName();
                newCharacter.setName(newName);
                break;

            case "2":
                String newType = showEditType();
                newCharacter.setType(newType);
                if (newType.equals("Warrior")){
                    newCharacter = new Warrior(newCharacter.getName(), newType);
                }
                else {
                    newCharacter = new Wizard(newCharacter.getName(), newType);
                }
                break;

            case "3":
                showCharacterMenu();
                break;
            default:
                defaultMessage();
                break;
        }
    }

    public void exitMessage() {
        System.out.println("See you around!");
    }

    public void defaultMessage() {
        System.out.println("Invalid choice, please select a valid option.");

    }

    public String showEditName() {
        System.out.println("Can you say that name again ?");
        return sc.nextLine();
    }

    public String showEditType() {
        System.out.println("Can you say that type again ?");
        return sc.nextLine();
    }

}
