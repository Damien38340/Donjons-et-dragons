package Potion;

import Board.CaseBonus;

/**
 * The Potion class represents a type of bonus case that provides health benefits to a hero.
 */
public class Potion extends CaseBonus {

    protected String name;
    protected int level;

    /**
     * Constructs a Potion with a specified name and healing level.
     *
     * @param name  the name of the potion
     * @param level the amount of health points the potion restores
     */
    public Potion(String name, int level) {
        super(name, level);
        this.name = name;
        this.level = level;
    }

    /**
     * Returns the level of health restoration provided by the potion.
     *
     * @return the level of the potion
     */
    @Override
    public int getLevel() {
        return level;
    }

    /**
     * Sets the level of health restoration for the potion.
     *
     * @param level the new level of the potion
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Returns the name of the potion.
     *
     * @return the name of the potion
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the potion.
     *
     * @param name the new name of the potion
     */
    public void setName(String name) {
        this.name = name;
    }
}
