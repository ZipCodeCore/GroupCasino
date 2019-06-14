public class Dice {
    private Integer[] dice;
    public Dice(Integer numberOfDice) {
        this.dice = new Integer[numberOfDice];
    }

    public Integer tossAndSum() {return 2; }
    public void toss() {}
    public Integer[] getDice() { return dice; }

}
