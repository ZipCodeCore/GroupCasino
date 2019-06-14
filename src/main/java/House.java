public class House implements Dealer {

    private Integer houseWallet;
    private Integer payoutRatio;



    public House(Integer payoutRatio) {
        this.houseWallet = 0;
        this.payoutRatio = payoutRatio;
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

    @Override
    public Hand dealRound(Integer numberOfCards, Boolean faceDown) {
        return null;
    }

    @Override
    public Hand dealHand(Integer numberOfC) {
        return null;
    }

    @Override
    public Hand dealBlackJackHand(BlackJack_Player player) {
        return null;
    }

    @Override
    public Card dealCard(Integer numberOfCards) {
        return null;
    }

    @Override
    public void shuffle() {

    }
}
