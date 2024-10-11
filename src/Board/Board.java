package Board;

import Gear.Potion.Ale;
import Gear.Potion.Water;
import Gear.Shield.HylianShield;
import Gear.Shield.KokiriShield;
import Gear.Shield.Shield;
import Gear.Spell.AbraCadavra;
import Gear.Spell.WingardiumLeviosa;
import Gear.Weapon.BiggoronSword;
import Gear.Weapon.WoodenSword;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Board {


    private ArrayList<Case> board = new ArrayList<Case>();
    private int boardSize;

    public Board() {
        this.boardSize = 64;
        generateBoard(board);
    }

    public void generateBoard(ArrayList<Case> board) {

        addMultipleCases(board, new Witch(), 10);
        addMultipleCases(board, new Goblin(), 10);
        addMultipleCases(board, new Dragon(), 4);

        addMultipleCases(board, new WoodenSword(), 3);
        addMultipleCases(board, new BiggoronSword(), 1);

        addMultipleCases(board, new KokiriShield(), 3);
        addMultipleCases(board, new HylianShield(), 1);

        addMultipleCases(board, new AbraCadavra(),2);
        addMultipleCases(board, new WingardiumLeviosa(), 2);

        addMultipleCases(board, new Ale(), 2);
        addMultipleCases(board, new Water(), 2);

        while (board.size() < boardSize) {
            board.add(new CaseEmpty());
        }
        Collections.shuffle(board);
        this.board = board;
    }

    public void moveEnemyToRandomCase(Case currentCase) {
        if (currentCase instanceof CaseEnemy enemyCase) {

            if (enemyCase.getLevel() > 0) {

                Random random = new Random();
                int randomIndex = random.nextInt(boardSize);
                board.set(randomIndex, enemyCase);
                System.out.println("The " + enemyCase.getName() + " fled!!");
            } else {
                System.out.println("You slayed the " + enemyCase.getName() + "!!");
            }
        }
    }

    public void addMultipleCases(ArrayList<Case> board, Case caseType, int count) {
        for (int i = 0; i < count; i++) {
            board.add(caseType);
        }
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
