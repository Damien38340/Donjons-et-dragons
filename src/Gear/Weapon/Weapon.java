package Gear.Weapon;

import Gear.OffensiveGear;

public abstract class Weapon extends OffensiveGear {

    protected Weapon(String name, int attack) {
        super(name, attack);
    }
}
