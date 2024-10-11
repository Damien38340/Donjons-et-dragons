package Board;

import Board.Enemy.CaseEnemy;
import Board.Enemy.Dragon;
import Board.Enemy.Goblin;
import Board.Enemy.Witch;
import Gear.ArcaneDefenses.BarrierSpell;
import Gear.ArcaneDefenses.ElixirOfResilience;
import Potion.Ale;
import Potion.Water;
import Gear.Shield.HylianShield;
import Gear.Shield.KokiriShield;
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
        addMultipleCases(board, new BiggoronSword(), 2);

        addMultipleCases(board, new KokiriShield(), 4);
        addMultipleCases(board, new HylianShield(), 1);

        addMultipleCases(board, new WingardiumLeviosa(), 3);
        addMultipleCases(board, new AbraCadavra(),1);

        addMultipleCases(board, new ElixirOfResilience(), 4);
        addMultipleCases(board, new BarrierSpell(),1);

        addMultipleCases(board, new Water(), 6);
        addMultipleCases(board, new Ale(), 2);

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
