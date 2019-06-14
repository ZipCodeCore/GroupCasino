import java.util.ArrayList;

abstract class CardGame extends Game{

    private Decks decks;

    public CardGame(Player[] players, Integer numberOfDecks) {
        super(players);
        this.decks = new Decks(numberOfDecks);

    }

<<<<<<< HEAD
=======
>>>>>>> 2f08e58f3d0c1a158f01e853a8293a5edb154dc6
}
