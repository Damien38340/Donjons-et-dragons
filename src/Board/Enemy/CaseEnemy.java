package Board.Enemy;

import Board.Case;
import Menu.Menu;

public abstract class CaseEnemy implements Case {

    protected String name;
    protected int attack;
    protected int level;
    protected Menu menu = new Menu();
    protected EnemyVisualizer visualizer;


    public CaseEnemy(String name, int attack, int level) {
        this.name = name;
        this.attack = attack;
        this.level = level;
        this.visualizer = new EnemyVisualizer();
    }

    public int getLevel() {
        return level;
    }

    public String getAttackMessage(){
       return "\r\nI'm a " + name + getComplement() + "!!\n Damage - " + attack;
    }

    public abstract String getComplement();
}
