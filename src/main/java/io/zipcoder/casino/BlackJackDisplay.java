package io.zipcoder.casino;

public class BlackJackDisplay extends Display {

    public void rules() {
        setPrintCurrentDisplay("Your goal is to draw cards that total 21, or come closer to 21 than the dealer without going over"+

                "\nMake a bet from $1 to all-in, receive your cards" +

                "\nThe dealer will give you two blackjack cards and show one of his cards, decide if you want to double your bet" +

                "\nYou can double your bet any time before you hit OR stand and split your bet if you get two cards of the same value." +

                "\nConsider if you want to ‘hit’" +

                "\nYou have an option to add more blackjack cards by choosing 'hit', but you lose automatically if your value of cards exceeds 21." +

                "\nChoose 'stand' when you are ready to play your hand. learn the dealer’s hand" +

                "\nThe dealer will reveal his hidden blackjack card and must always hit if they have 16 or lower. They will stop hitting if they have 17 or more." +

                "\nYou win when the combined value of your cards is greater than that of the dealer."+

                "\nYou lose if you have a lower score than the dealer, or if the total of your cards exceeds 21.");

                //TIPS
                /*"\nThe dealer and each player start with two cards. The dealer’s first card faces up, the second faces down."+

                "\nFace cards each count as 10, Aces count as 1 or 11, all others count at face value."+

                "\nAn Ace with any 10, Jack, Queen, or King is a “Blackjack.”:");*/
    }

    public void dealtHand(){

        setPrintCurrentDisplay("You were dealt ");
    }

    public void hitOrStand(){

        setCurrentDisplay("Do you want to hit or stand?");
    }

    public void dealerHit() {

        setPrintCurrentDisplay("Your hand total is ");
    }

    public void playerHit(){

        setPrintCurrentDisplay("You hit 21!");

    }

    public void dealerStand() {

        setPrintCurrentDisplay("Do you want to hit or stand?");

    }

    public void bust(){

        setPrintCurrentDisplay("You passed 21! Bust...");
    }

    public void dealerBust(){

        setPrintCurrentDisplay("The dealer busted.");
    }

    public void wonGame(){

        setPrintCurrentDisplay("You win");

    }

    public void lostGame(){

        setPrintCurrentDisplay("You lost");
    }

    public void blackJack(){

        setPrintCurrentDisplay("You got Black Jack!");

    }

    public void splitPairs() {

        setPrintCurrentDisplay("Would you like to split pairs?");

    }

    public void doubleDown() {

        setPrintCurrentDisplay("");

    }

}