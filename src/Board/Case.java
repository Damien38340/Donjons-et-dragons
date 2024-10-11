package Board;

import Characters.Hero;

public interface Case {

    void interact(Hero player);

    int getLevel();
    String getName();

}

