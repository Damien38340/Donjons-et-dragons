package Board;

import Characters.Hero;

public class CaseEmpty implements Case {
    public CaseEmpty() {

    }
    @Override
    public void fight(Hero player) {
        System.out.println("Nothing here");
    }
}
