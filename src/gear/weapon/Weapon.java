package gear.weapon;

import gear.OffensiveGear;

public abstract class Weapon extends OffensiveGear {

    protected Weapon(String name, int level) {
        super(name, level);
    }

    @Override
    public void display() {
        System.out.println("You found a " + this.name + " ! Attack + " + this.level);

    }
}
