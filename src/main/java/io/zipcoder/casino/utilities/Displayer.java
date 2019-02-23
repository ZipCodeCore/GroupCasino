package io.zipcoder.casino.utilities;

import io.zipcoder.casino.Cards.Card;

import java.util.List;

public class Displayer {
    private Console console;
    public Displayer(){
        this.console = new Console();
    }
    public Displayer(Console console) {
        this.console = console;
    }


    public void displayHand(List<Card> cards) {
        console.println("Your current hand is: ");
        displayCards(cards);
    }

    public void displayCards(List<Card> cards) {
        console.println("DISPLAYED CARDS: ----------");
        for (Card card: cards) {
            console.println(card.toString());
        }
        console.println("--------------------");
    }

    public String goFishTurn() {
        return console.getStringInput("What card would you like to ask for?");
    }

    public void announceCardGiven(String answer, int size) {
        console.println(String.format("You got me! Here's %d %ss", size, answer));
    }

    public void announceGoFish(String answer, Card card) {
        console.println(String.format("Nope! I don't have any %ss. Go Fish!", answer));
        console.println(String.format("Don't tell that other guy, but you drew a %s", card.toString()));
    }

    public boolean playPair() {
        String playPair = console.getStringInput("Would you like to play a pair?");
        if ("yes".equals(playPair.toLowerCase().trim())) {
            return true;
        } else {
            console.println("Okay, we'll keep going");
            return false;
        }
    }

    public String getPairToPlay() {
        return console.getStringInput("Type of card do you want to play? (Ace, two, three, king, etc)").trim().toUpperCase();
    }

    public void notAPair() {
        console.println("That's not a pair.");
    }

    public void congradulate() {
        console.println("You won! Great game.");
    }

    public void goodGame() {
        console.println("Looks like I beat you this time. Come back anytime!");
    }

    public boolean askForCard(String askedFor) {
        String hasCard = console.getStringInput(String.format("Do you have any %ss", askedFor));
        if(hasCard.trim().toLowerCase().equals("yes")) {
            return true;
        } else {
            return false;
        }
    }

    public void takeUserCard() {
        console.println("It seems that you do. I'll take these:");
    }

    public void announcePlayingCards() {
        console.println("Alright, I'm going to play these:");
    }

    public void accuse() {
        console.println("I don't think that's right -.-");
    }
}
