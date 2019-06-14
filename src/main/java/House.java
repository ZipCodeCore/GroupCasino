public class House implements Dealer {

    private Integer moneyBet;

    public Integer payout(Integer payoutRatio, Integer originalBetAmount) {
        Integer payout = payoutRatio*originalBetAmount;
        moneyBet -= payout;
        return payout;
    }

    public void takeBets(Integer ...chips) {
        for (Integer chip : chips) moneyBet += chip;
    }

    public Integer moneyToChips(Double moneyAmount) {
        return (int)Math.floor(moneyAmount/5.0);
    }

}
