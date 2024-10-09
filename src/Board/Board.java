package Board;

import java.util.ArrayList;

public class Board {

    private ArrayList<Case> board;
    private CaseEmpty emptyCase;
    private int boardSize;
    private CaseEnemy enemy;
    private CaseBonus bonus;

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
        board.add(1, enemy);
        board.add(2, bonus);
        board.add(3, bonus);
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }
}
