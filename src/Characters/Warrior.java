package Characters;

import java.util.Random;

public class Warrior extends Hero {


    public Warrior(String name, String type) {
        super(name, type);
        this.setHp(randomLevel());
        this.setAttack(randomLevel());
        if (getDefensiveGear() != null){
        this.setDefense(getDefensiveGear().getLevel());}
    }

    public int randomLevel(){
        Random random = new Random();
        return random.nextInt(5,10 );
    }
}
