// Using Card.java by Rob-bie
// https://gist.github.com/Rob-bie/b490814b4b7cbb070d58

package io.zipcoder.casino;

public class Card implements Comparable<Card>
{
    public enum Rank
    {
        DEUCE(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9),
        TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);
        private Integer rankValue;
        public final Integer getRankValue()
        {
            return rankValue;
        }
        Rank(final int rv) {
            rankValue = rv;
        }
        public Integer cardValue() {
            return rankValue;
        }
    }

    public enum Suit
    {
        CLUBS(2), DIAMONDS(3), HEARTS(4), SPADES(1);
        private Integer suitValue;
        public final Integer getSuitValue()
        {
            return suitValue;
        }
        Suit(final int sv)
        {
            suitValue = sv;
        }
        public Integer SuitValue()
        {
            return suitValue;
        }
    }

    private final Rank rank;
    private final Suit suit;
    protected Card(final Rank rank, final Suit suit)
    {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank rank()
    {
        return rank;
    }

    public Suit suit()
    {
        return suit;
    }

    @Override
    public String toString()
    {
        return rank + " of " + suit + "(" + cardValue() + ")";
    }

    public Integer cardValue()
    {
        return rank.getRankValue() * suit.getSuitValue();
    }

    public int compareTo(Card o)
    {
        return -this.cardValue().compareTo(o.cardValue());
    }
}