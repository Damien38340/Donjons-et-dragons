public class PlayerOutOfBounds extends Exception {
    public PlayerOutOfBounds(int numberOfCasesExceeded) {
        super(numberOfCasesExceeded == 0
                ? "You are on the edge of the board"
                : (numberOfCasesExceeded == 1
                ? "You are " + numberOfCasesExceeded + " case off the board"
                : "You are " + numberOfCasesExceeded + " cases off the board"));
    }
}
