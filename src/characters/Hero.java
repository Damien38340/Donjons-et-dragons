package characters;

import gear.DefensiveGear;
import gear.OffensiveGear;

/**
 * Represents a hero in the game. The Hero class serves as an abstract base class
 * that defines common attributes and behaviors for all hero types, including
 * their offensive and defensive gear, health points, attack, and defense statistics.
 */
public abstract class Hero {

    protected String name;          // The name of the hero
    protected String type;          // The type or class of the hero
    private int hp;                 // The health points of the hero
    private int attack;             // The attack power of the hero
    private int defense;            // The defense power of the hero
    private OffensiveGear offensiveGear; // The offensive gear equipped by the hero
    private DefensiveGear defensiveGear; // The defensive gear equipped by the hero

    /**
     * Default constructor that initializes the hero with an empty name.
     */
    protected Hero() {
        this("");
    }

    /**
     * Constructs a Hero with a specified name.
     *
     * @param name The name of the hero
     */
    protected Hero(String name) {
        this(name, "");
    }

    /**
     * Constructs a Hero with a specified name and type.
     *
     * @param name The name of the hero
     * @param type The type or class of the hero
     */
    protected Hero(String name, String type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Constructs a Hero with a specified name, type, and defense value.
     *
     * @param name The name of the hero
     * @param type The type or class of the hero
     * @param defense The defense value of the hero
     */
    protected Hero(String name, String type, int defense) {
        this.name = name;
        this.type = type;
        this.defense = defense;
    }

    /**
     * Gets the health points of the hero.
     *
     * @return The health points of the hero
     */
    public int getHp() {
        return hp;
    }

    /**
     * Sets the health points of the hero.
     *
     * @param hp The new health points of the hero
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Gets the attack value of the hero.
     *
     * @return The attack value of the hero
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Sets the attack value of the hero.
     *
     * @param attack The new attack value of the hero
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * Gets the offensive gear of the hero.
     *
     * @return The offensive gear of the hero
     */
    public OffensiveGear getOffensiveGear() {
        return offensiveGear;
    }

    /**
     * Sets the offensive gear of the hero.
     *
     * @param offensiveGear The new offensive gear for the hero
     */
    public void setOffensiveGear(OffensiveGear offensiveGear) {
        this.offensiveGear = offensiveGear;
    }

    /**
     * Gets the defensive gear of the hero.
     *
     * @return The defensive gear of the hero
     */
    public DefensiveGear getDefensiveGear() {
        return defensiveGear;
    }

    /**
     * Sets the defensive gear of the hero.
     *
     * @param defensiveGear The new defensive gear for the hero
     */
    public void setDefensiveGear(DefensiveGear defensiveGear) {
        this.defensiveGear = defensiveGear;
    }

    /**
     * Gets the name of the hero.
     *
     * @return The name of the hero
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the hero.
     *
     * @param newName The new name for the hero
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Gets the type of the hero.
     *
     * @return The type of the hero
     */
    public String getType() {
        return this.type;
    }

    /**
     * Sets the type of the hero.
     *
     * @param newType The new type for the hero
     */
    public void setType(String newType) {
        this.type = newType;
    }

    /**
     * Gets the defense value of the hero.
     *
     * @return The defense value of the hero
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Sets the defense value of the hero.
     *
     * @param defense The new defense value for the hero
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * Returns a string representation of the hero's attributes.
     *
     * @return A string detailing the hero's name, type, health points,
     *         attack value, offensive gear, and defensive gear
     */
    @Override
    public String toString() {
        return "name: " + name +
                "\ntype: " + type +
                "\nhp: " + hp +
                "\nattack: " + attack +
                "\n\n" + offensiveGear +
                "\n" + defensiveGear;
    }
}
