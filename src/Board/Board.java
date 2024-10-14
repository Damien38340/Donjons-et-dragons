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

        for (int i = 0; i < 10; i++) {
            board.add(new Witch());
        }
        for (int i = 0; i < 10; i++) {
            board.add(new Goblin());
        }
        for (int i = 0; i < 4; i++) {
            board.add(new Dragon());
        }
        for (int i = 0; i < 3; i++) {
            board.add(new WoodenSword());
        }
        for (int i = 0; i < 2; i++) {
            board.add(new BiggoronSword());
        }
        for (int i = 0; i < 4; i++) {
            board.add(new KokiriShield());
        }
        for (int i = 0; i < 1; i++) {
            board.add(new HylianShield());
        }
        for (int i = 0; i < 3; i++) {
            board.add(new WingardiumLeviosa());
        }
        for (int i = 0; i < 1; i++) {
            board.add(new AbraCadavra());
        }
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
