package Board;

import Characters.Hero;

public abstract class CaseBonus implements Case {

    String name;
    int level;

    protected CaseBonus(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
public void interact(Hero character){

}
}
