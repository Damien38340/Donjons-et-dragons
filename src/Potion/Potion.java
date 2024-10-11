package Potion;

import Board.CaseBonus;

public class Potion extends CaseBonus {

    protected String name;
    protected int level;

    public Potion(String name, int level) {
        super(name, level);

        this.name = name;
        this.level = level;
    }

    @Override
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
