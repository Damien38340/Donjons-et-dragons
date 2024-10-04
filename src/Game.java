import javax.xml.namespace.QName;

public class Game {

    int[] board;
    Character player;
    int positionPlayer;
    String playerName;

    public Game(int[] board, Character player, String playerName) {
        this.board = board;
        this.player = player;
        this.playerName = player.getName();
    }

    public int dice() {
        return (int) (Math.random() * 6 + 1);
    }

    public void play() {
        positionPlayer = 1;

        while (positionPlayer < 64) {
            int roll = dice();
            positionPlayer += roll;
            System.out.println(positionPlayer);
           if(positionPlayer > 64){
               positionPlayer = positionPlayer - roll;
                positionPlayer += roll;
                System.out.println(positionPlayer);
            }

        }
        System.out.println("Well done " + playerName + "! I did not believe in you but you're the proof that anything can happen");
    }

}
