package io.zipcoder.casino.utilities;

import io.zipcoder.casino.Cards.Card;
import io.zipcoder.casino.Players.GoFishPlayer;

import java.util.List;

public class Displayer {
    private Console console;
    public Displayer(){
        this.console = new Console();
    }
    public Displayer(Console console) {
        this.console = console;
    }



    public String goFishTurn() {
        return console.getStringInput("What card would you like to ask for?").trim().toUpperCase();
    }

    public void announceCardGiven(String answer, int size) {
        console.println(String.format("You got me! Here's %d %ss", size, answer));
    }

    public void announceGoFish(Card card) {
        console.println(String.format("Nope! Go Fish!"));
        //console.println(String.format("Don't tell that other guy, but you drew a %s", card.toString()));
    }


    public String getBookToPlay() {
        return console.getStringInput("Type of card do you want to play? (Ace, two, three, king, etc)").trim().toUpperCase();
    }

    public void notABook() {
        console.println("That's not a book.");
    }

    public void congradulate() {
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

    public void noMoreCards() {
        console.println("There are no more cards in the deck");
    }

    public void outOfCards() {
        console.println("I'm out of cards in my hand! I'll just draw");
    }
}
