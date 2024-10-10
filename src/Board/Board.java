package Board;

import Characters.Hero;
import Gear.*;

import java.util.ArrayList;
import java.util.Collections;

public class Board {


    private ArrayList<Case> board = new ArrayList<Case>();
    private CaseEmpty emptyCase;
    private int boardSize;
    private CaseEnemy enemy;
    private CaseBonus bonus;
    private DefensiveGear defensiveGear;
    private OffensiveGear offensiveGear;
    private Weapon weapon;
    private Spell spell;
    private Shield shield;
    private Potion potion;

    public Board() {
        this.emptyCase = new CaseEmpty();
        this.boardSize = 8;
        generateBoard(board);
    }

    public void generateBoard(ArrayList<Case> board) {
        board.add(new Witch());
        board.add(new Goblin());
        board.add(new Dragon());
        board.add(new KokiriShield());
        while (board.size() < boardSize) {
            board.add(emptyCase);
        }
        Collections.shuffle(board);
        this.board = board;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }
    public ArrayList<Case> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<Case> board) {
        this.board = board;
    }
}
