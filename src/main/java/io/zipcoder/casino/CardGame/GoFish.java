package io.zipcoder.casino.CardGame;

import io.zipcoder.casino.CardGame.Cards.Card;
import io.zipcoder.casino.CardGame.Cards.Deck;
import io.zipcoder.casino.CardGame.Cards.Face;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GoFish extends CardGame {
    private GoFishPlayer goFishPlayer;
    private GoFishPlayer dealer;
    private int playersScoreCounter;
    private int dealersScoreCounter;
    private Deck deck;
    Console console = Console.getInstance();
    private boolean playing = false;
    private String input;
    private boolean playerAskingForCard = false;
    boolean playerDrawing = false;
    boolean playersTurn = true;
    boolean newTurn = true;
    boolean dealersTurn = false;
    boolean dealerAskingForCard = false;
    boolean givingDealerCard = false;
    boolean dealerDrawing = false;
    Face requestedCard = null;

    boolean deckNotEmpty;



    public GoFish(Player player) {

        this.goFishPlayer = new GoFishPlayer(player);
        this.dealer = new GoFishPlayer(new Player("dealer", 0.0));
        this.deck = new Deck(1);
        this.deck.shuffle();
    }


    public void play() {

        startGame();

        while (playing) {

            // players turn
            while (playersTurn) {
                checkAskInput();

                // player asking dealer for card
                while (playerAskingForCard) {
                    askDealerForCard();
                }

                // if dealer has card requested by player
                if ((requestedCard != null) && input.toLowerCase().equals("ask")) {
                    dealerResponse();

                    // if player has to draw
                    checkDrawInput();
                    while (playerDrawing) {
                        playerDraw();
                    }
                }
            }

            // dealers turn
            while (dealersTurn) {

                // card dealer is asking player for
                Face dealersRequestedCard = getDealersRequestedCard();

                // dealer requests card
                while (dealerAskingForCard) {
                    console.println("\nThe dealer requested the card " + dealersRequestedCard + ".\n\n" + goFishPlayer.getHand().toString());
                    respondToDealer(dealersRequestedCard);
                }

                // player has card to give to dealer
                if (givingDealerCard) {
                    giveDealerCard(dealersRequestedCard);
                }

                // dealer drawing
                if (dealerDrawing) {
                    dealerDraw(dealersRequestedCard);

                    // dealer did not draw the requested card -- switch to players turn
                    if (dealerDrawing) {
                        dealersTurn = false;
                        dealerDrawing = false;
                        playersTurn = true;
                    }
                }
            }
/*
            if (dealersScoreCounter > playersScoreCounter) {

                console.println("You Lose, Better Luck Next Time");
            } else {

                console.println("Congratulations! You Win");
            }

*/
        }
    }


    public Card getLastCard(GoFishPlayer player) {

        ArrayList<Card> cards = player.getHand().showMyCards();

        Card lastCard = player.getHand().showMyCards().get(cards.size() - 1);

        return lastCard;
    }


    public void walkAway() {

    }


    public String getCardOptions() {
        return "\n" + Arrays.toString(Face.values()) + "\n" ;
    }

    public void updatePlayerScore() {
        playersScoreCounter = goFishPlayer.getCounter4();
    }

    public void updateDealerScore() {
        dealersScoreCounter = dealer.getCounter4();
    }


    public GoFishPlayer getGoFishPlayer() {
        return goFishPlayer;
    }

    public GoFishPlayer getDealer() {
        return dealer;
    }

    public int getPlayersScoreCounter() {
        return playersScoreCounter;
    }

    public int getDealersScoreCounter() {
        return dealersScoreCounter;
    }


    // Starting the game asking for the initial deal of 7 cards for each of the players.
    // cHeck if the initial dealt cards already contains any 4 of a kind  if yes updates the player's scores.

    public void startGame() {

        input = console.getStringInput("Welcome to Go Fish!  Type 'deal' to play!");

        if (input.equals("deal")) {
            goFishPlayer.getHand().addCardsToHand(deck.deal(7));
            dealer.getHand().addCardsToHand(deck.deal(7));
            playing = true;

            console.println(goFishPlayer.getHand().toString());

            if (goFishPlayer.fourOfAKindFinder()) {
                updatePlayerScore();
                console.println("Wow! You were dealt four of a kind!  Your new score is %d.", playersScoreCounter);
            }

            if (dealer.fourOfAKindFinder()) {
                updateDealerScore();
                console.println("The dealer was dealt four of a kind!  The dealers score is %d.", dealersScoreCounter);
            }
        }
    }


    public void checkAskInput() {
        if (newTurn) {
            input = console.getStringInput("\nType 'ASK' to ask for a card.");
        }
        if (input.toLowerCase().equals("ask")) {
            playerAskingForCard = true;
        }
    }


    public void askDealerForCard() {
        console.println("\n" + goFishPlayer.getHand().toString());
        String cardInput = console.getStringInput("Enter the card you want to ask the dealer for!\n" + getCardOptions());
        try {
            requestedCard = Face.valueOf(cardInput.toUpperCase());
            playerAskingForCard = false;
        } catch (IllegalArgumentException iae) {
            console.println("Invalid card requested.\n");
        }
    }


    public void dealerResponse() {
        if (dealer.hasRequestedCard(requestedCard)) {
            goFishPlayer.requestCard(dealer, requestedCard);
            console.println("\n" + goFishPlayer.getHand().toString());
            console.println("The dealer gave you all their " + requestedCard.name() + " cards!  Go again!\n");

            if (goFishPlayer.fourOfAKindFinder()) {
                updatePlayerScore();
                console.println("\nYou got four of a kind!  Your new score is %d.", playersScoreCounter);
                playerAskingForCard = true;
            }
        } else {
            input = console.getStringInput("\nThe dealer does not have any " + requestedCard.name() + " cards.  Enter 'DRAW' to Go Fish!");
        }
    }

    public void checkDrawInput() {
        if (input.toLowerCase().equals("draw")) {
            playerDrawing = true;
            newTurn = true;
        } else if (input.toLowerCase().equals("ask")) {
            newTurn = true;
        } else {
            console.println("Invalid input.");
            newTurn = false;
        }
    }

    public void playerDraw() {
        goFishPlayer.getHand().drawCard(deck);
        printPlayersDraw();
        if (goFishPlayer.fourOfAKindFinder()) {
            updatePlayerScore();
            console.println("You got 4 of a kind!  Your new score is %d!\n", playersScoreCounter);
        }
    }

    public void printPlayersDraw() {
        if (getLastCard(goFishPlayer).getFace().equals(requestedCard)) {

            console.println("You drew a %s!  Go again!", requestedCard.name());
            playerDrawing = false;
            playerAskingForCard = true;
        } else {
            console.println("\n" + goFishPlayer.getHand().toString());
            console.println("You drew a %s.  It's the dealer's turn.", getLastCard(goFishPlayer).getFace().name());
            playerDrawing = false;
            playersTurn = false;
            dealersTurn = true;
            dealerAskingForCard = true;
        }
    }

    public Face getDealersRequestedCard() {
        int sizeOfDealersHand = dealer.getHand().getSize();
        Random random = new Random();
        Integer indexOfCard = random.nextInt(sizeOfDealersHand - 1);
        Face dealersRequestedCard = dealer.getHand().showMyCards().get(indexOfCard).getFace();

        return dealersRequestedCard;
    }


    public void respondToDealer(Face dealersRequestedCard) {
        if (goFishPlayer.hasRequestedCard(dealersRequestedCard)) {
            input = console.getStringInput("You have the card the dealer requested. Type 'GIVE' to it to the dealer.");
            if (!input.toLowerCase().equals("give")) {
                console.println("Invalid input.");
            } else {
                dealerAskingForCard = false;
                givingDealerCard = true;
            }
        } else {
            input = console.getStringInput("You don't have the requested card!  Tell the dealer to 'GO FISH'.");
            if (input.toLowerCase().equals("go fish")) {
                dealerAskingForCard = false;
                dealerDrawing = true;
            } else {
                console.println("Invalid input.");
            }
        }
    }


    public void dealerDraw(Face dealersRequestedCard) {
        dealer.getHand().drawCard(deck);

        if (getLastCard(dealer).getFace().equals(dealersRequestedCard)) {
            console.println("The dealer drew the card they requested.  It's their turn again!");
            dealerDrawing = false;
            dealerAskingForCard = true;
        }
        if (dealer.fourOfAKindFinder()) {
            updateDealerScore();
            console.println("The dealer got 4 of a kind.  Their score is %d", dealersScoreCounter);
        }
    }


    public void giveDealerCard(Face dealersRequestedCard) {
        dealer.requestCard(goFishPlayer, dealersRequestedCard);

        if (dealer.fourOfAKindFinder()) {
            updateDealerScore();
            console.println("The dealer got 4 of a kind.  Their score is %d", dealersScoreCounter);
        }
        givingDealerCard = false;
        dealerAskingForCard = true;
    }


    public boolean isDeckNotEmpty (Deck deck){

        if(deck.deckSize() > 0){

            deckNotEmpty = true;
        }

        else {

            deckNotEmpty = false;
        }


        return deckNotEmpty;
    }


    public void setGoFishPlayer(GoFishPlayer goFishPlayer) {
        this.goFishPlayer = goFishPlayer;
    }

    public void setDealer(GoFishPlayer dealer) {
        this.dealer = dealer;
    }

    public void setPlayersScoreCounter(int playersScoreCounter) {
        this.playersScoreCounter = playersScoreCounter;
    }

    public void setDealersScoreCounter(int dealersScoreCounter) {
        this.dealersScoreCounter = dealersScoreCounter;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public boolean isPlayerAskingForCard() {
        return playerAskingForCard;
    }

    public void setPlayerAskingForCard(boolean playerAskingForCard) {
        this.playerAskingForCard = playerAskingForCard;
    }

    public boolean isPlayerDrawing() {
        return playerDrawing;
    }

    public void setPlayerDrawing(boolean playerDrawing) {
        this.playerDrawing = playerDrawing;
    }

    public boolean isPlayersTurn() {
        return playersTurn;
    }

    public void setPlayersTurn(boolean playersTurn) {
        this.playersTurn = playersTurn;
    }

    public boolean isNewTurn() {
        return newTurn;
    }

    public void setNewTurn(boolean newTurn) {
        this.newTurn = newTurn;
    }

    public boolean isDealersTurn() {
        return dealersTurn;
    }

    public void setDealersTurn(boolean dealersTurn) {
        this.dealersTurn = dealersTurn;
    }

    public boolean isDealerAskingForCard() {
        return dealerAskingForCard;
    }

    public void setDealerAskingForCard(boolean dealerAskingForCard) {
        this.dealerAskingForCard = dealerAskingForCard;
    }

    public boolean isGivingDealerCard() {
        return givingDealerCard;
    }

    public void setGivingDealerCard(boolean givingDealerCard) {
        this.givingDealerCard = givingDealerCard;
    }

    public boolean isDealerDrawing() {
        return dealerDrawing;
    }

    public void setDealerDrawing(boolean dealerDrawing) {
        this.dealerDrawing = dealerDrawing;
    }

    public Face getRequestedCard() {
        return requestedCard;
    }

    public void setRequestedCard(Face requestedCard) {
        this.requestedCard = requestedCard;
    }
}
