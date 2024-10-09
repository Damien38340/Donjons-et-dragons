package Characters;

public class Wizard  extends Hero {


    public Wizard(String name, String type) {
        super(name, type);
        this.setHp(6);
        this.setAttack(15);
    }
}