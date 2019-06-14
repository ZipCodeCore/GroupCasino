import exceptions.NegativeBetException;
import exceptions.NotEnoughChipException;

public class PokerPlayer extends Player implements Gambling {
    private Hand hand = new PokerHand();
    private Boolean folded = false;
<<<<<<< HEAD
=======



    private Integer chips;
>>>>>>> 8e61c5f62b0f715ab55530f1341a4d94f375bb19

    public PokerPlayer(Person p) {
        super(p);
    }



    public void leaveGame(){}

    public Integer call(Integer lastPlayerBet) {
        return bet(lastPlayerBet);
    }

    public Integer check() {return call(0);}

    public void fold() {
        folded = true;
    }

    public Integer raise(Integer lastPlayerBet, Integer amountToRaise) {
        return bet(lastPlayerBet + amountToRaise);
    }

    public Integer smallBlind() {
        return bet(1);
    }

    public Integer bigBlind() {
        return bet(2);
    }

    public Boolean isFolded() {
        return folded;
    }

    public Integer getChip() {
        return chips;
    }

    public void setChips(Integer chips) {
        this.chips = chips;
    }


    public Integer bet(Integer numOfChipsToBet) throws NegativeBetException, NotEnoughChipException {
        if (numOfChipsToBet < 0)
            throw new NegativeBetException("Invalid number of Chips");
        if(numOfChipsToBet > chips)
            throw new NotEnoughChipException("Not enough Chips");
        chips -= numOfChipsToBet;
        return numOfChipsToBet;
    }
<<<<<<< HEAD

=======
>>>>>>> 8e61c5f62b0f715ab55530f1341a4d94f375bb19
}
