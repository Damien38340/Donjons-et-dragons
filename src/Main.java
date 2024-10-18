import java.sql.SQLException;

/**
 * The Main class serves as the entry point for the game application.
 * It initializes the Game and starts the gameplay process.
 */
public class Main {

    /**
     * The main method is the entry point for the Java application.
     * It creates an instance of the Game class and starts the game.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {

        Game game = new Game();

        // Initialize and start the game
        game.initGame();
    }
}
