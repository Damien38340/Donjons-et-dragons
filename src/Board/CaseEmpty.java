package Board;

import Characters.Hero;

public class CaseEmpty implements Case {

    public int getLevel(){
        return 0;
    };

    public String getName(){
        return "Empty";
    };

    public CaseEmpty() {

    }
    @Override
    public void interact(Hero player) {
        System.out.println("Nothing here");
    }
}
