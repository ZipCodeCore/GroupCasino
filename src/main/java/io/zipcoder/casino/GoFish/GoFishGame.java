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
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

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
    Music goFishMusic = null;


    public GoFishGame(Player player) {
        this.player = new GoFishPlayer(player);
        this.opponent = new GoFishNPC(new Player("Baity", "McSwitch", 55, 0));
        //this.numDecks = 1;
        this.playersCards = new CardSet(0);
        this.opponentsCards = new CardSet(0);
        this.shoe = new CardSet(1);
    }

 /*   public static void main(String[] args) { // for testing
        Player player = new Player("Lem", "Jukes", 23, 300.00);
        CardSet shoe = new CardSet(1);
        CardSet playersCards = new CardSet(0);
        CardSet opponentCards = new CardSet(0);
        GoFishGame goFishGame = new GoFishGame(player);
        goFishGame.startPlay();
    }
*/
    //populates player deals hands
    public void startPlay() {
        new GoFishMenu(this).displayMenu();
        initialDeal();
    }
    public void initialDeal() {
        for (int i = 0; i < 7; i++) {
            this.playersCards.addCard(this.shoe.removeFirstCard());
            this.opponentsCards.addCard(this.shoe.removeFirstCard());
        }
        playerTurn(player);
    }

    public String playerTurn(GoFishPlayer player) {
        displayStatus();
        String cardChoice = console.getCardRankInput("");
        ArrayList<Card> stolenCards = opponentsCards.removeRank(cardChoice);

        if (stolenCards.size() > 0) {
            String cardCheck = cardChoice;
            System.out.println("YOU HAVE SUCCESSFULLY TAKEN " + stolenCards.size() + stolenCards.get(0) + " FROM THE OPPONENT");
            playersCards.addCards(stolenCards);
            scanForPlayerSuites(cardCheck);
            playerTurn(player);

        } else {
            console.println("OoOoOoO  GO FISH!  OoOoOoO");
            Card fishedCard = this.shoe.removeFirstCard();
            playersCards.addCard(fishedCard);
            if (fishedCard.toString().equals(cardChoice)){
            scanForPlayerSuites(fishedCard.toString());
            playerTurn(player);
            } else {
                int suiteSuccess = playerSuites.size();
                scanForPlayerSuites(fishedCard.toString());
                if (suiteSuccess < playerSuites.size()){
                    playerTurn(player);
                } else {
                    opponentTurn();
                }
            }
        }

        return null;
    }
    public void opponentTurn() {

        console.clearScreen();
        displayStatus();
        console.println("**** IT'S YOUR OPPONENTS TURN! ****"+ "\n" +"\n" +this.opponent.getPlayer()+" IS MAKING THEIR SELECTION..."+"\n "+"\n "+"\n");
        String npcChoice = npcPickACard();
        ArrayList<Card> npcStolenCards = playersCards.removeRank(npcChoice);
        if (npcStolenCards.size()>0){
            String npcCardCheck = npcChoice;
            System.out.println("YOU HAVE SUCCESSFULLY TAKEN " + npcStolenCards.size() + npcStolenCards.get(0) + " FROM THE OPPONENT");
            opponentsCards.addCards(npcStolenCards);
            scanForPlayerSuites(npcCardCheck);
            opponentTurn();

        } else {
            console.println("OoOoOoO  GO FISH!  OoOoOoO");
            Card npcFishedCard = this.shoe.removeFirstCard();
            opponentsCards.addCard(npcFishedCard);
            if (npcFishedCard.toString().equals(npcChoice)){
                scanForPlayerSuites(npcFishedCard.toString());
                opponentTurn();
            } else {
                int npcSuiteSuccess = opponentSuites.size();
                scanForPlayerSuites(npcFishedCard.toString());
                if (npcSuiteSuccess < opponentSuites.size()){
                    opponentTurn();
                } else {
                    playerTurn(player);
                }
            }
        }




    }

    public String npcPickACard() {
        Random rng = new Random();
        ArrayList<Card> cardPicker = new ArrayList<>();
        Set<Card> cardFilter = new TreeSet<>();
        for (Card i : opponentsCards.getCards())
            cardFilter.add(i);
        cardPicker.addAll(cardFilter);
        String pickedCard = cardPicker.get(rng.nextInt(cardPicker.size())).toString();
        return pickedCard;
    }

    public void roundOfPlay() {
    }

    public String checkForPlayerWin() {
        if (playerSuites.size() >= 7) {
            console.println("YOU WIN!");
        }
        return playerTurn(player);
    }
    public String checkForOpponentWin() {
        if (opponentSuites.size() >= 7) {
            console.println("YOU LOOOOOOOOOOOSE!");
        }
        return playerTurn(player);
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
    public void scanForPlayerSuites(String selectCard) {
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
/*    public void checkShoe() {
        if (this.shoe == null || this.shoe.size() < this.numDecks * 26) {
            this.shoe = getNewShoe();
        }
    }
    public CardSet getNewShoe() {
        CardSet newShoe = new CardSet(this.numDecks);
        newShoe.shuffle();
        return newShoe;
    }*/



