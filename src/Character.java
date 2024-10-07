public class Character {

    private String name;
    private String type;
    private int hp;
    private int attack;
    private OffensiveGear offensiveGear;
    private DefensiveGear defensiveGear;

    public Character() {
        this("");
    }

    public Character(String name) {
        this(name, "");
    }

    public Character(String name, String type) {
        this.name = name;
        this.type = type;
        if (type.equals("Warrior")) {
            this.hp = 10;
            this.attack = 10;
            this.offensiveGear = new OffensiveGear("Weapon", "Wooden Sword", 1);
            this.defensiveGear = new DefensiveGear("Shield", "Kokiri Shield", 1);
        } else {
            this.hp = 6;
            this.attack = 15;
            this.offensiveGear = new OffensiveGear("Spell", "Taylor Swift", 1);
            this.defensiveGear = new DefensiveGear("Potion", "Water", 1);
        }
    }

    public String getName() {
        return this.name = name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void getType() {
        this.type = type;
    }

    public void setType(String newType) {
        this.type = newType;
        updateGear();
    }

    private void updateGear() {
        if (type.equals("Warrior")) {
            this.hp = 10;
            this.attack = 10;
            this.offensiveGear = new OffensiveGear("Weapon", "Wooden Sword", 1);
            this.defensiveGear = new DefensiveGear("Shield", "Kokiri Shield", 1);
        } else {
            this.hp = 6;
            this.attack = 15;
            this.offensiveGear = new OffensiveGear("Spell", "Taylor Swift", 1);
            this.defensiveGear = new DefensiveGear("Potion", "Water", 1);
        }
    }

    public String toString() {
        return "name: " + name + "\ntype: " + type + "\nhp: " + hp + "\nattack: " + attack + "\n\n" + offensiveGear + "\n" + defensiveGear;
    }
}
