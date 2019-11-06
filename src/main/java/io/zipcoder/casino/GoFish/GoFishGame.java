package io.zipcoder.casino.GoFish;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardGame;
import io.zipcoder.casino.CardSet;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Menus.GoFishMenu;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Utilities.Console;
import io.zipcoder.casino.Utilities.Music;
import sun.management.snmp.jvmmib.JVM_MANAGEMENT_MIBOidTable;

import java.util.ArrayList;

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
    private int numDecks;
    Music goFishMusic = null;


    public GoFishGame(Player player, CardSet shoe, CardSet playerCards, CardSet opponentCards) {
        this.player = new GoFishPlayer(player);
        this.opponent = new GoFishNPC(new Player("Baity", "McSwitch", 55, 0));
        //this.numDecks = 1;
        this.playersCards = new CardSet(0);
        this.opponentsCards = new CardSet(0);
        this.shoe = new CardSet(1);
    }

    public static void main(String[] args) { // for testing
        Player player = new Player("Lem", "Jukes", 23, 300.00);
        CardSet shoe = new CardSet(1);
        CardSet playersCards = new CardSet(0);
        CardSet opponentCards = new CardSet(0);
        GoFishGame goFishGame = new GoFishGame(player, shoe, playersCards, opponentCards);
        goFishGame.startPlay();
    }


    //populates player deals hands
    public void startPlay() {
        new GoFishMenu(this).displayMenu();
        checkShoe();
        initialDeal();
    }

    public void initialDeal() {
        CardSet playerCards = new CardSet(0);
        CardSet opponentCards = new CardSet(0);
        for (int i = 0; i < 7; i++) {
            playerCards.addCard(this.shoe.removeFirstCard());
            opponentCards.addCard(this.shoe.removeFirstCard());
        }
        prompt(player);
        // GoFishRound goFishRound = new GoFishRound(this.player, this.opponent, this.shoe, playerCards)

    }

    public String prompt(GoFishPlayer player) {
        displayStatus();

        String cardChoice = console.getCardRankInput("");

        ArrayList<Card> stolenCards = opponentsCards.removeRank(cardChoice);

        if (stolenCards.size() > 0) {
            String cardCheck = cardChoice;
            System.out.println("YOU HAVE SUCCESSFULLY TAKEN " + stolenCards.size() + stolenCards.get(0) + " FROM THE OPPONENT");

            playersCards.addCards(stolenCards);

            scanForSuites(cardCheck);

            prompt(player);

        } else {
            prompt(player);
        }
        //if(cardChoice ==
        return null;
    }

    public void roundOfPlay() {
    }

    public void checkShoe() {
        if (this.shoe == null || this.shoe.size() < this.numDecks * 26) {
            this.shoe = getNewShoe();
        }
    }



    public CardSet getNewShoe() {
        CardSet newShoe = new CardSet(this.numDecks);
        newShoe.shuffle();
        return newShoe;
    }


    public String checkForWin() {
        if (playerSuites.size() >= 7) {
            console.println("YOU WIN!");
        }
        if (opponentSuites.size() >= 7) {
            console.println("YOU LOOOOOOOOOOOSE!");
        }
        return prompt(player);
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
        playersCards.sort();
        playerSuites.sort();
        displaySuite();
        displayPlayerHands();
    }

    public void scanForSuites(String selectCard) {
        ArrayList<Card>suiteChecker = playersCards.removeRank(selectCard);
        if (suiteChecker.size() == 4) {
            console.println("YOU SUCCESSFULLY MADE A SUITE OF " + suiteChecker.get(0));
            playerSuites.addCard(suiteChecker.get(0));
            ;
        } else {
            playersCards.addCards(suiteChecker);
        }
        playersCards.sort();
    }

    public void displaySuite() {
        console.println("************************ PLAYER'S SUITES ************************\n" + playerSuites.toASCIISuite() + "\n" + "*****************************************************************");
    }
    public void displayPlayerHands(){
        console.println("************************* PLAYER'S HAND *************************\n" + playerSuites.toASCII() + "\n" + "*****************************************************************");
    }
}


