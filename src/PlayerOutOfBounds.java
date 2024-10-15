/**
 * The PlayerOutOfBounds exception is thrown when a player attempts to move beyond the boundaries of the game board.
 * This exception provides a message indicating how many cases the player has exceeded.
 */
public class PlayerOutOfBounds extends Exception {

    /**
     * Constructs a new PlayerOutOfBounds exception with a detailed message.
     *
     * @param numberOfCasesExceeded The number of cases the player has exceeded beyond the board.
     *                               A value of 0 indicates the player is at the edge of the board.
     *                               A positive value indicates how many cases off the board the player is.
     */
    public PlayerOutOfBounds(int numberOfCasesExceeded) {
        super(numberOfCasesExceeded == 0
                ? "You are on the edge of the board"
                : (numberOfCasesExceeded == 1
                ? "You are " + numberOfCasesExceeded + " case off the board"
                : "You are " + numberOfCasesExceeded + " cases off the board"));
    }
}
