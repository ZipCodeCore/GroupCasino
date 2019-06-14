public class Dice {
    private Integer[] dice;
    public Dice(Integer numberOfDice) {
        this.dice = new Integer[numberOfDice];
    }
    public Integer toss() {
    return ((int)(Math.random()*6) + 1);


    }
    public Integer tossAndSum() {
        Integer sum=0;
        int j=0;
        for(int i=0;i<dice.length;i++) {
            dice[i]=toss();
            sum = sum + dice[i];
        }
            return sum;
    }

    public Integer[] getDice() {
        return dice;
    }

    public Integer sum() {
        Integer sum=0;
        for(int i=0;i<dice.length;i++) {
            sum = sum + dice[i];
        }
        return sum;
    }
}
