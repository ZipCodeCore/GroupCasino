public class Dice {
    private Integer[] dice;
    public Dice(Integer numberOfDice) {
        this.dice = new Integer[numberOfDice];
    }
    Integer roll;
    Integer toss=0;
    public Integer toss() {
    roll=((int)(Math.random()*6) + 1);
    return roll;
    }
    public Integer tossAndSum() {
        for(int i=1;i<dice.length;i++) {
            toss = toss + ((int) (Math.random() * 6) + 1);
        }
            return toss;
    }


}
