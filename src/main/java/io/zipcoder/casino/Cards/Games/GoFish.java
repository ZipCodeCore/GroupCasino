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
    private Console console;

    public void setIsOver(boolean isOver) { this.isOver = isOver; }
    public Deck getDeck() { return deck; }

    public GoFishPlayer getDealer() {
        return dealer;
    }
    public GoFishPlayer getUser() {
        return user;
    }

    public GoFish(Console console) {
        this.console = console;
    }
    public GoFish() {
        console = Console.getConsole();
    }

    public int play() {
        console.println("Rules:\nThe object of this game is to get the most books (4 of a kind) down.\nHere's your staring hand!\n");
        dealStartingHands();
        while (!isOver) {
            displayStatus();
            dealerTurn();
            evaluate();
            displayStatus();
            userTurn();
            evaluate();
        }
        return -5;
    }

    public void dealerTurn() {
        if(dealer.getHandSize() != 0) {
            tryForUserCard();
        } else {
            console.println("I'm out of cards in my hand! I'll just draw");
            goFish(dealer, false);
        }
        playBooks();
    }

    public void playBooks() {
        if (dealer.hasBooks()) {
            List<Card> books = dealer.getBooks();
            console.println("Alright, I'm going to play these:");
            console.println(Card.printAllCards(books));
        }
    }

    public void tryForUserCard() {
        String askedFor = dealer.getRandomCard().getRank().toString();
        boolean saysHasCard = askForCard(askedFor);
        if (user.hasCard(askedFor)) {
            if (!saysHasCard) { console.println("J'accuse!");}
            takeCards(askedFor);
        } else if (saysHasCard) {
            console.println("Huh, it doesn't actually look like you do.");
            goFish(dealer, false);
        } else {
            goFish(dealer, false);
        }
    }

    public boolean askForCard(String askedFor) {
        String hasCard = console.getStandardInput(String.format("Do you have any %ss?", askedFor));
        return hasCard.equals("yes");
    }

    public void takeCards(String askedFor) {
        List<Card> takenCards = user.getCards(askedFor);
        console.println("I'll take these:");
        console.println(Card.printAllCards(takenCards));
        dealer.addToHand(takenCards);
    }

    public void dealStartingHands() {
        dealer.setHand(deck.drawMultipleCards(5));
        user.setHand(deck.drawMultipleCards(5));
    }

    public void userTurn() {
        String answer = console.getStandardInputCaps("What card would you like to ask for?");
        if(!user.hasCard(answer)) {
            console.println("You can only ask for cards you have");
            userTurn();
        } else {
            boolean hasCard = dealer.hasCard(answer);
            dealerResponse(hasCard, answer);
            if (user.hasBooks()) {
                bookTurn();
            }
        }
    }

    public void dealerResponse(boolean hasCard, String answer) {
        if (hasCard) {
            List<Card> givenCards = dealer.getCards(answer);
            user.addToHand(givenCards);
            console.println(String.format("You got me! Here's %d %ss", givenCards.size(), answer));
            userTurn();
        } else {
            goFish(user, true);
        }
    }

    public void bookTurn() {
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

    public List<Card> getPotentialBook() {
        user.increaseBookCount();
        String playBooks = console.getStandardInputCaps("What type of card do you want to play? (Ace, two, three, king, etc)");
        return user.getCards(playBooks);
    }

    public void goFish(GoFishPlayer player, boolean user) {
        if(deck.cardsLeft() != 0) {
            Card card = deck.drawCard();
            player.addToHand(card);
            if(user) {
                console.println(String.format("Nope! Go Fish!\nYOU DREW:\n%s", card.printCard()));
            }
        } else {
            console.println("There are no more cards in the deck");
        }
    }

    public void displayStatus() {
        console.print(Card.printAllCards(user.getHand()));
        console.println(String.format("YOU: %d DEALER: %d",
                user.getBookCount(), dealer.getBookCount()));
    }


    public boolean playBook() {
        String playbook = console.getStandardInput("Would you like to play a book?");
        if ("yes".equals(playbook)) {
            return true;
        } else {
            console.println("Okay, we'll keep going");
            return false;
        }
    }

    public void evaluate() {
        if(dealer.getBookCount() + user.getBookCount() == 13) {
            isOver = true;
            if (user.getBookCount() > dealer.getBookCount()) {
                console.println("You won! Great game.");
            } else if (user.getBookCount() < dealer.getBookCount()) {
                console.println("Looks like I beat you this time. Come back anytime!");
            }
        }
    }

}
