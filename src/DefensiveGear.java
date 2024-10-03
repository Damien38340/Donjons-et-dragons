public class DefensiveGear {

    private String type;
    private String name;
    private int defense;

    public DefensiveGear(String type, String name, int defense) {
        if (type.equals("Warrior")) {
            this.name = "Shield";
        } else {
            this.name = "Philter";
        }
    }
}
