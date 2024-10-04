public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();

        String mainMenu = menu.showMainMenu();

        String userName = menu.askingName(mainMenu);

        menu.showMessageStrangeName(userName);

        String type = menu.askingType();

        Character newCharacter = new Character(userName, type);

        menu.showTypeAnswers(type);

        String characterMenuChoice = menu.showCharacterMenu();

        menu.showCharacterMenuChoice(characterMenuChoice, newCharacter);


    }
}