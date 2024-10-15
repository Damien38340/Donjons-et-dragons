package gear.arcaneDefenses;

import gear.DefensiveGear;

/**
 * Represents a defensive gear item that provides arcane protections.
 * It will only be effective for Wizard or unknown type
 * This class extends the DefensiveGear class, inheriting its attributes and methods.
 */
public class ArcaneDefenses extends DefensiveGear {

    /**
     * Constructs an ArcaneDefenses object with the specified name and defense value.
     *
     * @param name    The name of the arcane defense item
     * @param defense The defense value provided by this item
     */
    public ArcaneDefenses(String name, int defense) {
        super(name, defense);
    }
}
