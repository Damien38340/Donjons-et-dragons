package gear.shield;

import gear.DefensiveGear;

public class Shield extends DefensiveGear {

    public Shield(String name, int defense) {
        super(name, defense);
    }

    @Override
    public void display() {
        System.out.println("You found a " + this.name + " ! Defense + " + this.level);
    }
}
