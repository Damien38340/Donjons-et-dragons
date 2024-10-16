package gear.spell;

import gear.OffensiveGear;

public class Spell extends OffensiveGear {

    public Spell(String name, int level) {
        super(name, level);
    }

    @Override
    public void display() {
        System.out.println("You found a spell " + this.name + " ! Attack + " + this.level);

    }
}
