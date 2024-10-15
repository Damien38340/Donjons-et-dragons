package gear;

import board.*;
import characters.Hero;

/**
 * Represents an abstract class for offensive gear that can be equipped by heroes.
 * This class extends CaseBonus and provides common attributes and methods for all types of offensive gear.
 */
public abstract class OffensiveGear extends CaseBonus {

    /** The name of the offensive gear. */
    protected String name;

    /** The attack level provided by the offensive gear. */
    protected int level;

    /**
     * Constructs an OffensiveGear with a specified name and attack level.
     *
     * @param name  The name of the offensive gear.
     * @param level The attack level provided by the gear.
     */
    public OffensiveGear(String name, int level) {
        super(name, level);
        this.name = name;
        this.level = level;
    }

    /**
     * Returns a string representation of the offensive gear, including its name and attack level.
     *
     * @return A string representation of the offensive gear.
     */
    @Override
    public String toString() {
        return name + " (\uD83D\uDC3B attack + " + level + ")";
    }

    /**
     * Returns the name of the offensive gear.
     *
     * @return The name of the offensive gear.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns the attack level of the offensive gear.
     *
     * @return The attack level of the offensive gear.
     */
    @Override
    public int getLevel() {
        return level;
    }

    /**
     * Checks if the hero has any offensive gear equipped.
     *
     * @param player The hero whose offensive gear is being checked.
     * @return {@code true} if the hero does not have offensive gear equipped, otherwise {@code false}.
     */
    public boolean isEquipmentNull(Hero player) {
        return player.getOffensiveGear() == null;
    }
}
