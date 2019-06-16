public class PokerNPC extends PokerPlayer{

    public PokerNPC(Person p) {
        super(p);
    }

    @Override
    public Integer getBetFromAction(Console console, Integer lastBet) {
        return 0;
    }
}
