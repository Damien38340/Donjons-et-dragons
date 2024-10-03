import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        Menu menu = new Menu();

        String mainMenu = menu.showMainMenu();

        Character newCharacter = null;
        if (mainMenu.equals("1")) {
            newCharacter = new Character();
        } else if (mainMenu.equals("2")) {
            System.out.println("See you around!");
            System.exit(0);
        }

        System.out.println("What's your name?");

        String userName = myObj.nextLine();  // Read user input
        newCharacter.setName(userName);
        System.out.println(userName + "? What a strange name");  // Output user input

        System.out.println("What kind of character are you ?");
        String type = myObj.nextLine();
        newCharacter.setType(type);

        if (type.equals("Wizard")) {
            System.out.println("Oh I see... You want to be the new Harry Potter");
        } else if (type.equals("Warrior")) {
            System.out.println("a " + type + " ? You did not look that strong");
        } else {
            System.out.println("I did not get your answer");
        }

        String characterMenu = menu.showCharacterMenu();

        switch (characterMenu) {
            case "1" -> {
                //show information
                System.out.println(newCharacter.toString());
            }
            case "2" -> {
                //edit information
            }
            case "3" -> {
                System.out.println("See you around!");
                System.exit(0);
            }
        }
    }
}