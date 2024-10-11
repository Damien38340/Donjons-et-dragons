package Characters;

import java.util.Random;

public class Wizard extends Hero {


    public Wizard(String name, String type) {
        super(name, type);
        this.setHp(randomHP());
        this.setAttack(randomAttack());
        if (getDefensiveGear() != null) {
            this.setDefense(getDefensiveGear().getLevel());
        }
    }

    public int randomHP() {
        Random random = new Random();
        return random.nextInt(3, 6);
    }

    public int randomAttack() {
        Random random = new Random();
        return random.nextInt(8, 15);
    }
}