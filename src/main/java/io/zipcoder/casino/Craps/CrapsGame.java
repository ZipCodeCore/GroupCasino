package io.zipcoder.casino.Craps;

import io.zipcoder.casino.DiceGame;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Menus.CrapsMenu;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Services.GameServices;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.Utility.Music;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CrapsGame extends DiceGame implements Game {

    public static void main(String[] args) throws InterruptedException {
        Player player = new Player ("Jeff","Smith", 28, 300.00);
        CrapsGame crapsGame = new CrapsGame(10.00,50.00,player);
        crapsGame.startPlay();
    }
    private String name = "Craps";
    private double minBet;
    private double maxBet;
    private CrapsPlayer player;
    private Integer setThePointRoll;    //saves your first roll to try to match with later rolls
    private Integer currentRoll;        //any roll after the first
    private Integer numRolls = 0;
    private Console console = new Console(System.in, System.out);
    private GameServices gameServices = new GameServices();
    Music crapsMusic = null;
    private Integer die1Point;
    private Integer die2Point;
    private Integer die1Current;
    private Integer die2Current;
    private Double winnings = 0D;
    private Double wager = 0D;



    //Craps Game Constructor
    public CrapsGame(double minBet, double maxBet, Player incomingPlayer) {
        this.minBet = minBet;
        this.maxBet = maxBet;
        this.player = new CrapsPlayer(incomingPlayer);
    }


    @Override
    //creates and runs a roundOfPlay
    public void startPlay() {
        try {
            Music.filePath = "src/music/(Craps) Amor maior - Higher Love.wav";
            crapsMusic = new Music();
            crapsMusic.play();
        } catch (Exception ex) {
            console.println("Error with playing sound.");
            ex.printStackTrace();
        }
        new CrapsMenu(this).displayMenu();

        roundOfPlay();

        endChoice();
    }

    @Override
    //runs a new game of craps
    public void roundOfPlay()  {
        Double betSize = betChoice();
        userRollsDiceSetPoint();
        console.println(displayPointRoll());
        if (winOnFirst(setThePointRoll) == true) {
            winnings = calculateWinnings(betSize, setThePointRoll, numRolls);
            console.println(winningMessageFirstRoll());

        } else if (loseOnFirst(setThePointRoll) == true) {
            console.println(losingMessageFirstRoll());
        }
        else {
            for (int i = 0; i < 3; i++) {
                numRolls = i + 1;
                userRollsDiceCurrentPoint();
                console.println(displayCurrentRoll(currentRoll));
                if (winOnSubsequent(currentRoll, setThePointRoll) == true) {
                    winnings = calculateWinnings(betSize, setThePointRoll, numRolls);
                    console.printWithDelays(winOnSubsequentMessage(), 50);
                    break;
                } else if (loseOnSubsequent(currentRoll) == true) {
                    console.println(loseOnSubsequentMessage());
                    break;
                }
                if (i == 2) {
                    console.println(losingMessageOutOfRolls());
                }
            }
        }
    }

    public Double betChoice(){
        console.println(String.format("\nCurrent bankroll: $%.2f", this.player.getPlayer().getBalance()));
        wager = console.getCurrency(String.format("\n[CROUPIER]: The limits here are %.2f and %.2f\n[CROUPIER]: What's your Bet? (Or press ENTER to leave the table)\n\n", this.minBet, this.maxBet));
         if (wager > this.player.getPlayer().getBalance()){
            console.println(String.format("\n[CROUPIER]: Your mouth is writing checks that your wallet can't cash, %s.\n", this.player.getPlayer().getLastName()));
            betChoice();
        }
        else if (wager < this.minBet || wager > this.maxBet) {
            console.println(String.format("\n[CROUPIER]: You're not playing within the table limits, %s.\n", this.player.getPlayer().getLastName()));
            betChoice();
        }
        else if (wager != null) {
             gameServices.wager(wager, this.player.getPlayer());
            return wager;
        }
        else if (wager == null) {
            return null;
        }
        return wager;
    }

    public Double calculateWinnings(Double wager, Integer setThePointRoll, Integer numRolls){
        // PUT THE PAY TABLE HERE
        if (setThePointRoll == 7 || setThePointRoll == 11){
            gameServices.payOut(2 * wager, this.player.getPlayer());
            return 2 * wager;
        }
        else if (setThePointRoll == 4 || setThePointRoll == 10){
            gameServices.payOut((7 - numRolls) * wager, this.player.getPlayer());
            return (7 - numRolls) * wager;
            }
        else if (setThePointRoll == 5 || setThePointRoll == 9){
            gameServices.payOut((6 - numRolls) * wager, this.player.getPlayer());
            return (6 - numRolls) * wager;
        }
        else if (setThePointRoll == 6 || setThePointRoll == 8){
            gameServices.payOut((5 - numRolls) * wager, this.player.getPlayer());
            return (5 - numRolls) * wager;
        }
        return 0.0;
    }

    @Override
    //implements menu whether you want to quit or go again
    public void endChoice() {
        String endChoiceInput = console.getInput("\n[CROUPIER]: You have finished this game of Craps.\n\nWould you like to play again? (Y/N)\n");
        if (endChoiceInput.toUpperCase().equals("N")) {
            try {
                crapsMusic.stop();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
            console.println("\n[CROUPIER]: Have a good rest of your day.\n");
            //also, return to the main menu
        } else if (endChoiceInput.toUpperCase().equals("Y")) {
            console.println("\n[CROUPIER]: That's great!!!\n");
            startPlay();
        } else {
            console.println("\n[CROUPIER]: That's not a valid selection. Please choose again.");
            endChoice();
        }
    }

    public boolean winOnFirst(Integer setThePointRoll) {
        if (setThePointRoll == 7 || setThePointRoll == 11) {
            return true;
        } else {
            return false;
        }
    }

    public boolean loseOnFirst(Integer setThePointRoll) {
        if (setThePointRoll == 2 || setThePointRoll == 3 || setThePointRoll == 12) {
            return true;
        } else {
            return false;
        }
    }


    public boolean winOnSubsequent(Integer currentRoll, Integer setThePointRoll) {
        if (currentRoll.equals(setThePointRoll)) {
            return true;
        }
        return false;
    }

    public boolean loseOnSubsequent(Integer currentRoll) {
        if (currentRoll == 7) {
            return true;
        }
        return false;
    }

    public void userRollsDiceSetPoint() {
        console.getInput("\nPress Enter to roll the dice\n");
        die1Point = roll();
        die2Point = roll();
        tossPointRoll(die1Point, die2Point);
    }

    public void userRollsDiceCurrentPoint() {
        console.getInput(String.format("-------------------------------------------------\nSet the Point Roll: %d\nPress Enter to roll the dice\n", setThePointRoll));
        die1Current = roll();
        die2Current = roll();
        tossCurrentRoll(die1Current, die2Current);

    }


    public Integer tossPointRoll(Integer die1Point, Integer die2Point) {
        setThePointRoll = die1Point + die2Point ;
        return setThePointRoll;
    }


    public String displayPointRoll() {
        return ("\n-------------------------------------------------") + ("SET THE POINT ROLL:\n" + DiceGame.diceToASCII(die1Point, die2Point) + "\n-------------------------------------------------");
        //console.println(String.format("\n(( You have rolled a %d for your set the point roll. ))\n", setThePointRoll));
    }

    public String displayCurrentRoll(Integer currentRoll) {
       return (DiceGame.diceToASCII(die1Current, die2Current)) + String.format("\n(( You have rolled a %d for this roll. ))\n", currentRoll);
    }

    public String winningMessageFirstRoll() {
        return String.format("\n(( You rolled a %d on the first roll! ))\n\nCongratulations!!\n\nYou won $%.2f!!!\n-------------------------------------------------\n\n", setThePointRoll, winnings-wager);
    }

    public String losingMessageFirstRoll() {
        return (String.format("\n(( You rolled a %d and have lost on the first roll! ))\n\nThis is unfortunate.....\n\n:(\n-------------------------------------------------\n\n", setThePointRoll));
    }

    public String losingMessageOutOfRolls() {
        return String.format("(( You are out of rolls. ))\nYou seem to have lost.\nThis is unfortunate.....\n:(\n-------------------------------------------------\n\n");

    }

    public Integer tossCurrentRoll(Integer die1Current, Integer die2Current) {
        currentRoll = die1Current + die2Current;
        return currentRoll;

    }


    public String winOnSubsequentMessage (){
        return (String.format("Hooray! You rolled a %d, and you have won $%.2f!!  It took you %d rolls to win.", currentRoll, winnings-wager, numRolls));
    }

    public String loseOnSubsequentMessage () {
        return (String.format("It appears that the odds were not in your favor today. Better luck next time.....\n-------------------------------------------------\n\n"));
    }

    public Integer getDie1Current() {
        return die1Current;
    }

    public Integer getDie2Current() {
        return die2Current;
    }

    public void setDie1Current (Integer die1Current1) {
        this.die1Current = die1Current1;
    }

    public void setDie2Current (Integer die2Current1) {
        this.die2Current = die2Current1;
    }

    public Integer getDie1Point() {
        return die1Point;
    }

    public void setDie1Point(Integer die1Point) {
        this.die1Point = die1Point;
    }

    public Integer getDie2Point() {
        return die2Point;

    }

    public void setDie2Point(Integer die2Point) {
        this.die2Point = die2Point;
    }

    public String getName() {
        return name;
    }
}


