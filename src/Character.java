public class Character {

    private String name;
    private String type;
    private int hp;
    private int attack;


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
        } else {
            this.hp = 6;
            this.attack = 15;
        }
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setType(String newType) {
        this.type = newType;
    }

    public String toString() {
        return "name: " + name + "\ntype: " + type + "\nhp: " + hp + "\nattack: " + attack;
    }

}
