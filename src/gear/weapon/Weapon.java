package gear.weapon;

import gear.OffensiveGear;

public abstract class Weapon extends OffensiveGear {

    protected Weapon(String name, int level) {
        super(name, level);
    }
}
