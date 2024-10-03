import java.util.Scanner;

public class Menu {
    private Scanner sc;

    public Menu() {
        sc = new Scanner(System.in);
    }

    public String showMainMenu() {

        System.out.println("1. New character");
        System.out.println("2. Exit");

        return sc.nextLine();
    }

    public String showCharacterMenu() {
        System.out.println("1. Character information");
        System.out.println("2. Edit information");
        System.out.println("3. Exit");

        return sc.nextLine();
    }

}
