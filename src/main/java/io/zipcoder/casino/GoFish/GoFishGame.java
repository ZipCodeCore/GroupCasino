package io.zipcoder.casino.GoFish;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardGame;
import io.zipcoder.casino.CardSet;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Menus.GoFishMenu;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Utility.Music;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.Random;


public class GoFishGame extends CardGame implements Game {


    private Console console = new Console(System.in, System.out);

    private String name = "Go Fish";
    private GoFishPlayer player;
    private GoFishNPC opponent;
    private CardSet shoe;
    private CardSet playersCards;
    private CardSet opponentsCards;
    private CardSet playerSuites;
    private CardSet opponentSuites;
    private Music goFishMusic = null;

    public GoFishGame(Player player) {
        this.player = new GoFishPlayer(player);
        this.opponent = new GoFishNPC(new Player("Baity", "McSwitch", 55, 0));
        this.playersCards = new CardSet(0);
        this.opponentsCards = new CardSet(0);
        this.playerSuites = new CardSet(0);
        this.opponentSuites = new CardSet(0);
        this.shoe = new CardSet(1);

    }

    public static void main(String[] args) { // for testing
        Player player = new Player("Lem", "Jukes", 23, 300.00);
        GoFishGame goFishGame = new GoFishGame(player);
        goFishGame.startPlay();
    }

    //populates player deals hands
    public void startPlay() {
        new GoFishMenu(this).displayMenu();
        console.println("\n   >===>                         >=>                      \n" +
                " >>    >=>                     >>     >>          >=>      \n" +
                ">=>            >=>           >=>> >>       >===>  >=>      \n" +
                ">=>          >=>  >=>          >=>   >=>  >=>     >=>>=>   \n" +
                ">=>   >===> >=>    >=>         >=>   >=>   >==>   >=>  >=> \n" +
                " >=>    >>   >=>  >=>          >=>   >=>     >=>  >>   >=> \n" +
                "  >====>       >=>             >=>   >=>  >=>>=>  >=>  >=> \n" +
                "                                                          \n");
        initialDeal();
        turn(this.player, this.opponent, this.playersCards, this.opponentsCards, this.playerSuites, this.opponentSuites);
    }

    public void initialDeal() {
        shoe.shuffle();
        for (int i = 0; i < 7; i++) {
            this.playersCards.addCard(this.shoe.removeFirstCard());
            this.opponentsCards.addCard(this.shoe.removeFirstCard());
        }
    }

    public CardSet integrateStolenCards(ArrayList<Card> stolenCards, CardSet hand) {
        System.out.println("SUCCESSFULLY TOOK " + stolenCards.size() + stolenCards.get(0) + " CARDS");
        hand.addCards(stolenCards);
        return hand;
    }

    public Card drawCard(CardSet hand) {
        console.println("OoOoOoO  GO FISH!  OoOoOoO");
        Card fishedCard = shoe.removeFirstCard();
        hand.addCard(fishedCard);
        hand.sort();
        return fishedCard;
    }

    public void emptyHandDraw(CardSet hand) {
        if (hand.size() <= 0) {
            hand.addCard(shoe.removeFirstCard());
        }
    }

    public boolean scanForSuites(CardSet hand, CardSet currentPlayerSuites, String rankToCheck) {
        ArrayList<Card> suiteChecker = hand.removeRank(rankToCheck);
        if (suiteChecker.size() == 4) {
            console.println("NEW SUITE: " + suiteChecker.get(0));
            currentPlayerSuites.addCard(suiteChecker.get(0));
            return true;
        } else {
            hand.addCards(suiteChecker);
        }
        hand.sort();
        return false;
    }

    public void turn(GoFishPlayer playerUp, GoFishPlayer nextPlayer, CardSet playerUpCards, CardSet nextPlayerCards, CardSet playerUpSuites, CardSet nextPlayerSuites) {
        // TODO: check for win, cause it to drop through the end of the method
        GoFishPlayer winStatus = checkForWin(playerUp, nextPlayer, playerUpCards, nextPlayerCards);
        //announceWinner(winStatus);
        emptyHandDraw(playerUpCards);


        console.clearScreen();
        displayStatus();
        String cardChoice = playerUp.chooseCard(playerUpCards);
        ArrayList<Card> stolenCards = nextPlayerCards.removeRank(cardChoice);

        if (stolenCards.size() > 0) { // successfully took from opponent
            integrateStolenCards(stolenCards, playerUpCards);
            // scan and get another turn
            scanForSuites(playerUpCards, playerUpSuites, cardChoice);
            turn(playerUp, nextPlayer, playerUpCards, nextPlayerCards, playerUpSuites, nextPlayerSuites);
        } else { // didn't guess correctly
            Card fishedCard = drawCard(playerUpCards);
            if (fishedCard.getRank().equals(cardChoice)) { // drew a helpful card
                //scan and get another turn
                scanForSuites(playerUpCards, playerUpSuites, cardChoice);
                turn(playerUp, nextPlayer, playerUpCards, nextPlayerCards, playerUpSuites, nextPlayerSuites);
            } else { // did not draw
                if (scanForSuites(playerUpCards, playerUpSuites, fishedCard.getRank())) { // ...got a suite from it, though
                    // go again
                    turn(playerUp, nextPlayer, playerUpCards, nextPlayerCards, playerUpSuites, nextPlayerSuites);
                } else { // everything failed
                    // opponent's turn
                    turn(nextPlayer, playerUp, nextPlayerCards, playerUpCards, nextPlayerSuites, playerUpSuites);
                }
            }
        }


    }

    public GoFishPlayer checkForWin(GoFishPlayer playerUp, GoFishPlayer nextPlayer, CardSet playerUpSuites, CardSet nextPlayerSuites) {

        if (playerUpSuites.size() == 7) {
            return playerUp;
        } else if (nextPlayerSuites.size() == 7) {
            return nextPlayer;
        } else {
            return null;
        }
    }

    public void announceWinner(GoFishPlayer winner) {
        if (winner != null) {
            console.printWithDelays(winner.getPlayer().getFirstName() + " IS THE WINNER!!!!!!!!! \n");
        }
    }


    //Option to quit game or play another round
    public void endChoice() {
    }

    public String getName() {
        return name;
    }

    public GoFishPlayer getPlayer() {
        return player;
    }

    public GoFishNPC getOpponent() {
        return opponent;
    }

    public void displayStatus() {
        goTitleScreen();
        playersCards.sort();
        playerSuites.sort();
        displayOpponentHands();
        displayOpponentSuite();
        displayPlayerSuite();
        displayPlayerHands();
    }

    public void displayPlayerSuite() {
        console.println("************************* PLAYER'S SUITES *************************\n" + playerSuites.toASCIISuite() + "\n");
    }

    public void displayPlayerHands() {
        console.println("************************** PLAYER'S HAND **************************\n" + playersCards.toASCII() + "\n");
    }

    public void displayOpponentHands() {
        console.println("************************* OPPONENT'S HAND *************************\n" + opponentsCards.toASCIIBlank() + "\n");
    }

    public void displayOpponentSuite() {
        console.println("************************ OPPONENT'S SUITES ************************\n" + opponentSuites.toASCIISuite() + "\n");
    }

    public void goTitleScreen() {
        console.println("\n   >===>                         >=>                      \n" +
                " >>    >=>                     >>     >>          >=>      \n" +
                ">=>            >=>           >=>> >>       >===>  >=>      \n" +
                ">=>          >=>  >=>          >=>   >=>  >=>     >=>>=>   \n" +
                ">=>   >===> >=>    >=>         >=>   >=>   >==>   >=>  >=> \n" +
                " >=>    >>   >=>  >=>          >=>   >=>     >=>  >>   >=> \n" +
                "  >====>       >=>             >=>   >=>  >=>>=>  >=>  >=> \n" +
                "                                                          \n");
    }
}