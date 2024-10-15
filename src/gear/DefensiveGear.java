package gear;

import board.*;
import characters.Hero;

/**
 * Represents an abstract class for defensive gear that can be equipped by heroes.
 * This class extends CaseBonus and provides common attributes and methods for all types of defensive gear.
 */
public abstract class DefensiveGear extends CaseBonus {

    /** The name of the defensive gear. */
    protected String name;

    /** The defense level provided by the defensive gear. */
    protected int level;

    /**
     * Constructs a DefensiveGear with a specified name and defense level.
     *
     * @param name  The name of the defensive gear.
     * @param level The defense level provided by the gear.
     */
    public DefensiveGear(String name, int level) {
        super(name, level);
        this.name = name;
        this.level = level;
    }

    /**
     * Returns a string representation of the defensive gear, including its name and defense level.
     *
     * @return A string representation of the defensive gear.
     */
    @Override
    public String toString() {
        return name + " (\uD83E\uDD94 defense + " + level + ")";
    }

    /**
     * Returns the name of the defensive gear.
     *
     * @return The name of the defensive gear.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns the defense level of the defensive gear.
     *
     * @return The defense level of the defensive gear.
     */
    @Override
    public int getLevel() {
        return level;
    }

    /**
     * Checks if the hero has any defensive gear equipped.
     *
     * @param player The hero whose defensive gear is being checked.
     * @return {@code true} if the hero does not have defensive gear equipped, otherwise {@code false}.
     */
    public boolean isEquipmentNull(Hero player) {
        return player.getDefensiveGear() == null;
    }
}
