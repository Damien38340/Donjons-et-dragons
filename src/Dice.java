public class Dice {

    private int dice;

    public Dice(){
        this.dice = (int) (Math.random() * 1 + 1);
    }

    public int getDice() {
        return dice;
    }

}
