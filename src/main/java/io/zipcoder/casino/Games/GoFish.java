package io.zipcoder.casino.Games;

import io.zipcoder.casino.CardsAndDice.Card;
import io.zipcoder.casino.CardsAndDice.Deck;
import io.zipcoder.casino.CardsAndDice.Rank;
import io.zipcoder.casino.Casino.Casino;
import io.zipcoder.casino.Casino.Greeter;
import io.zipcoder.casino.Players.GoFishPlayer;
import io.zipcoder.casino.utilities.Console;


import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class GoFish implements Game {
    private GoFishPlayer dealer = new GoFishPlayer();
    private GoFishPlayer user = new GoFishPlayer(Casino.getProfile());
    private Deck deck = new Deck();
    private boolean isOver = false;
    private Console console;

    public boolean isOver() {
        return isOver;
    }

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

    public void play() {
        console.println(Greeter.getGoFishName());
        user.getProfile().setBalance(user.getProfile().getBalance() - 5);
        console.println("Rules: The object of this game is to get the most books (4 of a kind) down.\nHere's your staring hand:\n");
        dealStartingHands();
        while (!isOver) {
            displayStatus();
            dealerTurn();
            evaluate();
            displayStatus();
            userTurn();
            evaluate();
        }
    }

    public void dealerTurn() {
        if(dealer.getHandSize() != 0) {
            tryForUserCard();
        } else {
            console.println("I'm out of cards in my hand! I'll just draw");
            goFish(dealer);
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
            goFish(dealer);
        } else {
            goFish(dealer);
        }
    }

    private boolean askForCard(String askedFor) {
        String hasCard = console.getStandardInput(String.format("Do you have any %ss?", askedFor));
        return hasCard.equals("yes");
    }

    private void takeCards(String askedFor) {
        List<Card> takenCards = user.getCards(askedFor);
        console.println("I'll take these:");
        console.print(Card.printAllCards(takenCards));
        dealer.addToHand(takenCards);
    }

    private void dealStartingHands() {
        dealer.setHand(deck.drawMultipleCards(5));
        user.setHand(deck.drawMultipleCards(5));
    }

    public void userTurn() {
        String askedForCard = console.getStandardInputCaps("What card would you like to ask for?");
        if(!user.hasCard(askedForCard)) {
            console.println("You can only ask for cards you have");
            userTurn();
        } else {
            boolean hasCard = dealer.hasCard(askedForCard);
            dealerResponse(hasCard, askedForCard);
            if (user.hasBooks()) {
                bookTurn();
            }
        }
    }

    private void dealerResponse(boolean hasCard, String askedForCard) {
        if (hasCard) {
            List<Card> givenCards = dealer.getCards(askedForCard);
            user.addToHand(givenCards);
            console.println(String.format("You got me! Here's %d %ss", givenCards.size(), askedForCard));
            userTurn();
        } else {
            goFish(user, askedForCard);
        }
    }

    public void bookTurn() {
        boolean playingBook = playBook();
        if(playingBook) {
            displayStatus();
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
        user.increaseBookCount();
        String playBooks = console.getStandardInputCaps(String.format("What type of card do you want to play? (%s)", getAllBooks()));
        return user.getCards(playBooks);
    }

    private String getAllBooks() {
        HashMap<Rank, Integer> rankCount = new HashMap<>();
        for (Card card : user.getHand()) {
            Rank rank = card.getRank();
            if(rankCount.get(rank) == null) {
                rankCount.put(rank, 0);
            } else {
                rankCount.put(rank, rankCount.get(rank) + 1);
            }
        }
        return allBooksString(rankCount);
    }

    private String allBooksString(HashMap<Rank, Integer> rankCount) {
        StringBuilder allBooks = new StringBuilder();
        Set<Rank> allRanks = rankCount.keySet();
        for (Rank rank : allRanks) {
            if(rankCount.get(rank) > 2) {
                allBooks.append(rank + " ");
            }
        }
        return allBooks.toString();
    }

    private void goFish(GoFishPlayer player) {
        if(deck.cardsLeft() != 0) {
            Card card = deck.drawCard();
            player.addToHand(card);
        } else {
            console.println("There are no more cards in the deck");
        }
    }

    public void goFish(GoFishPlayer player, String askedFor) {
        if(deck.cardsLeft() != 0) {
            console.println("Nope! Go Fish!");
            Card card = deck.drawCard();
            player.addToHand(card);
            if(card.getRank().equals(GoFishPlayer.parseCardString(askedFor))) {
                console.println("Fish, Fish, you got your wish!");
            }
            console.println(String.format("YOU DREW:\n%s", card.printCard()));
        } else {
            console.println("There are no more cards in the deck");
        }
    }

    public void displayStatus() {
        console.print(Card.printAllCards(user.getHand()));
        console.println(String.format("YOU: %d DEALER: %d",
                user.getBookCount(), dealer.getBookCount()));
    }


    private boolean playBook() {
        String playbook = console.getStandardInput("Would you like to play a book?");
        if ("yes".equals(playbook) || "y".equals(playbook)) {
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
