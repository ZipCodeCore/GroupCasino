package io.zipcoder.casino.GoFish;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardGame;
import io.zipcoder.casino.CardSet;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Menus.GoFishMenu;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Utilities.Console;

import java.util.ArrayList;

public class GoFishGame extends CardGame implements Game {


    private Console console = new Console(System.in,System.out);

    private String name = "Go Fish";
    private GoFishPlayer player;
    private GoFishNPC opponent;
    private CardSet shoe;
    private ArrayList <GoFishRound>hands;
    ArrayList <Card> playerSuites;
    ArrayList <Card> npcSuites;
    private int numDecks;



    public GoFishGame(Player player) {
        this.player = new GoFishPlayer(player);
        this.opponent = new GoFishNPC(new Player("Baity", "McSwitch", 55,0));
        this.numDecks = 1;
        this.hands = new ArrayList<GoFishRound>(0);
    }


    public String getName() {
        return name;
    }
    public CardSet getShoe(){
        return shoe;
    }



    //populates player deals hands
    public void startPlay(){
        new GoFishMenu(this).displayMenu();
        checkShoe();
        initialDeal();
    }
    public void initialDeal() {
        GoFishRound playerHand = new GoFishRound(this.player, this.shoe.removeFirstCard(), this.shoe.removeFirstCard(), this.shoe.removeFirstCard(), this.shoe.removeFirstCard(), this.shoe.removeFirstCard(), this.shoe.removeFirstCard(), this.shoe.removeFirstCard());
        this.hands.add(playerHand);
        this.player.addHand(playerHand);

        GoFishRound opponentHand = new GoFishRound(this.opponent,this.shoe.removeFirstCard(), this.shoe.removeFirstCard(), this.shoe.removeFirstCard(), this.shoe.removeFirstCard(), this.shoe.removeFirstCard(), this.shoe.removeFirstCard(), this.shoe.removeFirstCard());
        this.hands.add(opponentHand);
        this.opponent.addHand(opponentHand);

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

    public void roundOfPlay(){

    }


    //Option to quit game or play another round
    public void endChoice(){

    }

    public GoFishPlayer getPlayer() {
        return player;
    }

    public GoFishNPC getOpponent(){
        return opponent;
    }

    public Player checkForWin(){
        return null;
    }


    public void display(){

    }
}
