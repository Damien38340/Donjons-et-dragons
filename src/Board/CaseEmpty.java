package Board;

import Characters.Hero;

/**
 * Represents an empty case on the game board. This class implements the
 * {@link Case} interface, signifying that it does not contain any items
 * or enemies and has a level of 0.
 */
public class CaseEmpty implements Case {

    /**
     * Returns the level of this case, which is 0 for an empty case.
     *
     * @return the level of the empty case
     */
    public int getLevel() {
        return 0;
    }

    /**
     * Returns the name of this case, which is "Empty".
     *
     * @return the name of the case
     */
    public String getName() {
        return "Empty";
    }

    /**
     * Constructs an instance of CaseEmpty.
     */
    public CaseEmpty() {
        // Default constructor
    }

    /**
     * Interacts with the specified hero. Since this case is empty, it
     * notifies the player that there is nothing here.
     *
     * @param player the hero interacting with the empty case
     */
    @Override
    public void interact(Hero player) {
        System.out.println("Nothing here");
    }
}
