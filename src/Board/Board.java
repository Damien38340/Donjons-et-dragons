package Board;

import Gear.Potion.Ale;
import Gear.Potion.Water;
import Gear.Shield.HylianShield;
import Gear.Shield.KokiriShield;
import Gear.Shield.Shield;
import Gear.Spell.AbraCadavra;
import Gear.Spell.Spell;
import Gear.Spell.WingardiumLeviosa;
import Gear.Weapon.BiggoronSword;
import Gear.Weapon.WoodenSword;

import java.util.ArrayList;
import java.util.Collections;

public class Board {


    private ArrayList<Case> board = new ArrayList<Case>();
    private int boardSize;

    public Board() {
        this.boardSize = 64;
        generateBoard(board);
    }

    public void generateBoard(ArrayList<Case> board) {
        board.add(new Witch());
        board.add(new Goblin());
        board.add(new Dragon());
        board.add(new KokiriShield());
        board.add(new HylianShield());
        board.add(new Water());
        board.add(new Ale());
        board.add(new AbraCadavra());
        board.add(new WingardiumLeviosa());
        board.add(new WoodenSword());
        board.add(new BiggoronSword());

        while (board.size() < boardSize) {
            board.add(new CaseEmpty());
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
