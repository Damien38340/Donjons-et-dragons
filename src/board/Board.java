package board;

import board.enemy.Dragon;
import board.enemy.Goblin;
import board.enemy.Witch;
import gear.arcaneDefenses.BarrierSpell;
import gear.arcaneDefenses.ElixirOfResilience;
import potion.Ale;
import potion.Water;
import gear.shield.HylianShield;
import gear.shield.KokiriShield;
import gear.spell.AbraCadavra;
import gear.spell.WingardiumLeviosa;
import gear.weapon.BiggoronSword;
import gear.weapon.WoodenSword;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Represents a game board that contains various cases including enemies and items.
 * The board is a collection of different types of cases that can be shuffled.
 */
public class Board {

    private ArrayList<Case> board = new ArrayList<>();
    private int boardSize;

    /**
     * Constructs a Board with a default size and initializes the game board with various cases.
     */
    public Board() {
        this.boardSize = 64;
        generateBoard(board);
    }

    /**
     * Generates the game board with a specified number of enemies, items, and empty cases.
     *
     * @param board The list of cases to populate the game board.
     */
    public void generateBoard(ArrayList<Case> board) {
        // Add 10 Witches to the board
        for (int i = 0; i < 10; i++) {
            board.add(new Witch());
        }
        // Add 10 Goblins to the board
        for (int i = 0; i < 10; i++) {
            board.add(new Goblin());
        }
        // Add 4 Dragons to the board
        for (int i = 0; i < 4; i++) {
            board.add(new Dragon());
        }
        // Add weapons to the board
        for (int i = 0; i < 3; i++) {
            board.add(new WoodenSword());
        }
        for (int i = 0; i < 2; i++) {
            board.add(new BiggoronSword());
        }
        // Add shields to the board
        for (int i = 0; i < 4; i++) {
            board.add(new KokiriShield());
        }
        for (int i = 0; i < 1; i++) {
            board.add(new HylianShield());
        }
        // Add spells to the board
        for (int i = 0; i < 3; i++) {
            board.add(new WingardiumLeviosa());
        }
        for (int i = 0; i < 1; i++) {
            board.add(new AbraCadavra());
        }
        // Add potions to the board
        for (int i = 0; i < 4; i++) {
            board.add(new ElixirOfResilience());
        }
        for (int i = 0; i < 1; i++) {
            board.add(new BarrierSpell());
        }
        for (int i = 0; i < 6; i++) {
            board.add(new Water());
        }
        for (int i = 0; i < 2; i++) {
            board.add(new Ale());
        }

        // Fill the remaining board size with empty cases
        while (board.size() < boardSize) {
            board.add(new CaseEmpty());
        }
        Collections.shuffle(board); // Shuffle the board to randomize case positions
        this.board = board;
    }

    /**
     * Moves an enemy to a random case on the board if it is still alive and eliminates the enemy if dead.
     *
     * @param enemyCase      The current case that contains the enemy.
     */
    public void moveEnemyToRandomCase(Case enemyCase) {

        if (enemyCase.getLevel() > 0) {
            Random random = new Random();
            int randomIndex = random.nextInt(boardSize);
            board.set(randomIndex, enemyCase); // Move the enemy to a random position
            System.out.println("The " + enemyCase.getName() + " fled!!");
        }
    }

    /**
     * Removes the enemy from the board and replaces its position with an empty case.
     *
     * @param enemyCase The case object that represents the enemy.
     * @param playerPosition The index on the board where the enemy was encountered.
     */
    public void handleEnemyDefeat(Case enemyCase, int playerPosition) {
        if (enemyCase.getLevel() <= 0){
            System.out.println("You slayed the " + enemyCase.getName() + "!!");
            board.add(playerPosition, new CaseEmpty());
        }
    }

    /**
     * Gets the size of the board.
     *
     * @return The size of the board.
     */
    public int getBoardSize() {
        return boardSize;
    }


    /**
     * Gets the list of cases on the board.
     *
     * @return The list of cases on the board.
     */
    public ArrayList<Case> getBoard() {
        return board;
    }

    /**
     * Sets the list of cases on the board.
     *
     * @param board The new list of cases to set on the board.
     */
    public void setBoard(ArrayList<Case> board) {
        this.board = board;
    }
}
