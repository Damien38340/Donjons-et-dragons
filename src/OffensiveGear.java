public class OffensiveGear {
    private String type;
    private String name;
    private int attack;

    public OffensiveGear(String type, String name, int attack) {
        if (type.equals("Warrior")) {
            this.name = "weapon";
        } else {
            this.name = "spell";
        }
    }
}
