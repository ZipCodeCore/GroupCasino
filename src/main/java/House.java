
import java.util.Collections;
import java.util.Random;

public class House implements Dealer {


    public void payout() {}
    public void takeBets() {}


    private Integer houseWallet;
    private Integer payoutRatio;
    private Decks decks;


    public House(Integer payoutRatio, Decks decks) {
        this.houseWallet = 0;
        this.payoutRatio = payoutRatio;
        this.decks = decks;

    }

    public Integer payout(Integer originalBetAmount) {
        Integer payout = payoutRatio*originalBetAmount;
        houseWallet -= payout;
        return payout;
    }

    public void takeBets(Integer ...chips) {
        for (Integer chip : chips) houseWallet += payoutRatio*chip;
    }

    public Integer moneyToChips(Double moneyAmount) {
        return (int)Math.floor(moneyAmount/5.0);
    }
    public Integer getHouseWallet() {
        return houseWallet;
    }

    public void setHouseWallet(Integer houseWallet) {
        this.houseWallet = houseWallet;
    }

    public Integer getPayoutRatio() {
        return payoutRatio;
    }
    public Decks getDecks() {
        return decks;
    }

    @Override
    public Card dealCard() {
        return decks.getCards().remove(0);
    }

    @Override
    public void shuffle() {
        Collections.shuffle(decks.getCards());
    }
}
