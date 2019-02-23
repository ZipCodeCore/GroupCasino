package io.zipcoder.casino.Cards.Games;

import io.zipcoder.casino.Cards.Card;
import io.zipcoder.casino.Cards.Deck;
import io.zipcoder.casino.Players.GoFishPlayer;
import io.zipcoder.casino.utilities.Console;


import java.util.List;

public class GoFish extends Game {
    private GoFishPlayer dealer = new GoFishPlayer();
    private GoFishPlayer user = new GoFishPlayer();
    private Deck deck = new Deck();
    private boolean isOver = false;
    private Console console = new Console();

    public int play() {
        dealStartingHands();
        while (!isOver) {
            dealerTurn();
            evaluate();
            userTurn();
            evaluate();
        }
        return -5;
    }

    private void dealerTurn() {
        displayStatus();
        if(dealer.handSize() != 0) {
            tryForUserCard();
        } else {
            console.println("I'm out of cards in my hand! I'll just draw");
            goFish(dealer, false);
        }
        playBooks();
    }

    private void playBooks() {
        if (dealer.hasBooks()) {
            List<Card> books = dealer.getBooks();
            console.println("Alright, I'm going to play these:");
            displayCards(books);
        }
    }

    private void tryForUserCard() {
        String askedFor = dealer.getRandomCard().getRank().toString();
        boolean hasCard = askForCard(askedFor);
        if (user.hasCard(askedFor)) {
            if (!hasCard) { console.println("J'accuse!");}
            takeCards(askedFor);
        } else if (!user.hasCard(askedFor) && hasCard) {
            console.println("Huh, it doesn't actually look like you do.");
            goFish(dealer, false);
        } else {
            goFish(dealer, false);
        }
    }

    private void takeCards(String askedFor) {
        List<Card> takenCards = user.getCards(askedFor);
        console.println("I'll take these:");
        displayCards(takenCards);
        dealer.addToHand(takenCards);
    }

    private void dealStartingHands() {
        dealer.setHand(deck.drawMultipleCards(5));
        user.setHand(deck.drawMultipleCards(5));
    }

    private void userTurn() {
        String answer = console.getStandardInput("What card would you like to ask for?");
        boolean hasCard = dealer.hasCard(answer);
        dealerResponse(hasCard, answer);
        if(user.hasBooks()) {
            bookTurn();
        }
    }

    private void dealerResponse(boolean hasCard, String answer) {
        if (hasCard) {
            List<Card> givenCards = dealer.getCards(answer);
            user.addToHand(givenCards);
            console.println(String.format("You got me! Here's %d %ss", givenCards.size(), answer));
            userTurn();
        } else {
            goFish(user, true);
        }
    }

    private void bookTurn() {
        boolean playingBook = playBook();
        if(playingBook) {
            List<Card> playedBooks = getPotentialBook();
            if(playedBooks.size() != 4) {
                console.println("That's not a book.");
                user.addToHand(playedBooks);
                bookTurn();
            } else if (user.hasBooks()) {
                bookTurn();
            }
        }
    }

    private List<Card> getPotentialBook() {
        displayCards(user.getHand());
        user.increaseBookCount();
        String playBooks = console.getStandardInput("Type of card do you want to play? (Ace, two, three, king, etc)");
        return user.getCards(playBooks);
    }

    public void goFish(GoFishPlayer player, boolean user) {
        if(deck.cardsLeft() != 0) {
            Card card = deck.drawCard();
            player.addToHand(card);
            if(user) {
                console.println(String.format("Nope! Go Fish!"));
            }
        } else {
            console.println("There are no more cards in the deck");
        }
    }

    private void evaluate() {
        if(dealer.getBookCount() + user.getBookCount() == 13) {
            isOver = true;
            if (user.getBookCount() > dealer.getBookCount()) {
                console.println("You won! Great game.");
            } else if (user.getBookCount() < dealer.getBookCount()) {
                console.println("Looks like I beat you this time. Come back anytime!");
            }
        }
    }


    public void displayStatus() {
        console.clear();
        console.println("Your current hand is: ");
        displayCards(user.getHand());
        console.println(String.format("You currently have %d books and the dealer has %d books",
                user.getBookCount(), dealer.getBookCount()));
    }

    public void displayCards(List<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            console.print(cards.get(i).toString());
            if((i + 1) % 8 == 0) {
                console.print("\n");
            }
        }
        console.print("\n");
    }

    public boolean playBook() {
        String playbook = console.getStringInput("Would you like to play a book?");
        if ("yes".equals(playbook.toLowerCase().trim())) {
            return true;
        } else {
            console.println("Okay, we'll keep going");
            return false;
        }
    }

    public boolean askForCard(String askedFor) {
        String hasCard = console.getStandardInput(String.format("Do you have any %ss", askedFor));
        return hasCard.equals("yes");
    }
}
