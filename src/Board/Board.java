package Board;

import Gear.*;

import java.util.ArrayList;

public class Board {

    private ArrayList<Case> board;
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
        this.board = new ArrayList<Case>();
        this.emptyCase = new CaseEmpty();
        this.boardSize = 4;
    }

    public void generateBoard() {
        board = new ArrayList<Case>();

        for (int i = 1; i < boardSize; i++) {
            board.add(i, emptyCase);
        }
        board.add(1, new Witch());
        board.add(2, new Goblin());
        board.add(2, new Dragon());
        board.add(3, new KokiriShield());


    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }
}
