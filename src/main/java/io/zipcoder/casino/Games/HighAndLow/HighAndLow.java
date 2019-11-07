package io.zipcoder.casino.Games.HighAndLow;

import io.zipcoder.casino.utilities.CasinoArt;
import io.zipcoder.casino.GamePieces.Dice;
import io.zipcoder.casino.Games.GamblingGame;
import io.zipcoder.casino.Games.Game;
import io.zipcoder.casino.PlayerCreation.Player;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.Sound;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


public class HighAndLow implements Game, GamblingGame {
    private Console console = new Console(System.in, System.out);
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private Dice dice = new Dice();
    private Integer totalBetValue = 0;
    private Player currentPlayer;
    private HighAndLowLanguage language = new HighAndLowLanguage();
    private CasinoArt art = new CasinoArt();
    private boolean running = true;
    private boolean didYouBet = true;
    private Sound spendSound;
    private Sound moneySound;
    private Sound loseSound;
    private Sound diceSound;
    private Sound winSound;


    public void runHighOrLow(Player currentPlayer) {
        spendSound = new Sound("spend_money.wav");
        moneySound = new Sound("win_money.wav");
        loseSound = new Sound("wahwah.wav");
        diceSound = new Sound("dice_roll.wav");
        winSound = new Sound("win_Sound.wav");
        this.currentPlayer = currentPlayer;
        approachTable(currentPlayer);
    }

    @Override
    public void approachTable(Player currentPlayer) {
        Console.clearScreen();
        console.println(art.getCasinoArt(CasinoArt.Art.HIGHANDLOW));
        console.println(language.getHighAndLowLanguage(HighAndLowLanguage.Language.APPROACHTABLE));
        while(running) {
            console.println(language.getHighAndLowLanguage(HighAndLowLanguage.Language.APPROACHTABLEMENU));
            Integer playerInput = console.getIntegerInput(":");

            switch (playerInput) {
                case 1:
                    runGame(currentPlayer);
                    running = false;
                    break;
                case 2:
                    showRules();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    console.println("Please enter a proper value");
                    break;
            }
        }
    }

    public void showRules(){
        console.println(language.getHighAndLowLanguage(HighAndLowLanguage.Language.RULES));
    }

    public void resetGame(){
        didYouBet = true;
        totalBetValue = 0;
    }

    @Override
    public void runGame(Player currentPlayer) {
        while(running) {
            if(!enoughBalance()){
                break;
            }
            resetGame();
            console.println("Welcome to High and Low, %s!\n", currentPlayer.getName());
            console.printSlow(language.getHighAndLowLanguage(HighAndLowLanguage.Language.BUYIN));
            totalBetValue += 10;
            spendSound.play();
            console.dotDotDot();
            console.newln();
            currentPlayer.placeBet(10);
            Integer firstRoll = firstRoll();

            console.println(language.getHighAndLowLanguage(HighAndLowLanguage.Language.PLACESECONDBET));
            placeBet(currentPlayer);
            if(!didYouBet){
                noBet();
                break;
            }
            String highOrLowBet = highOrLowBet();
            console.dotDotDot();
            console.newln();

            Integer secondRoll = secondRoll();


            winOrLose(firstRoll, secondRoll, highOrLowBet);
        exitGame(currentPlayer);
        }
    }

    public Integer firstRoll(){
        diceSound.play();
        Integer roll = dice.rollDice(1);
        console.println(dice.diceArt(roll));
        Integer roll2 = dice.rollDice(1);
        console.println(dice.diceArt(roll2));
        Integer sumOfRolls = roll + roll2;
        console.println("The first result of the first roll is %d", sumOfRolls);
        return sumOfRolls;
    }

    @Override
    public void placeBet(Player currentPlayer) {
        Integer playerInput = console.getIntegerInput(":");
        if(playerInput == 1){
            spendSound.play();
            currentPlayer.placeBet(10);
            totalBetValue += 10;
            didYouBet = true;
        } else {
            didYouBet = false;
        }

    }

    public String highOrLowBet(){
        console.println(language.getHighAndLowLanguage(HighAndLowLanguage.Language.HIGHORLOW));
        Integer playerBet = console.getIntegerInput(":");
        if(playerBet == 1){
            return "high";
        }
        return "low";
    }

    public Integer secondRoll(){
        diceSound.play();
        Integer roll = dice.rollDice(1);
        console.println(dice.diceArt(roll));
        Integer roll2 = dice.rollDice(1);
        console.println(dice.diceArt(roll2));
        Integer sumOfRolls = roll + roll2;
        console.println("The result of the second roll is %d", sumOfRolls);
        return sumOfRolls;
    }

    public void noBet(){
        console.println("Backing out? No problem!");
        LocalDateTime now = LocalDateTime.now();
        String addHistory = String.format("You lost $%d.00 at High and Low. ** ", totalBetValue);
        currentPlayer.addHistory(addHistory + dtf.format(now));
        exitGame(currentPlayer);
    }

    public void winOrLose(Integer firstRoll, Integer secondRoll, String highOrLowBet){
        if((firstRoll > secondRoll && highOrLowBet.equals("low")) || (firstRoll < secondRoll && highOrLowBet.equals("high"))){
            winSound.play();
            console.println("Congratulations! You've won $%d.00!", totalBetValue);
            LocalDateTime now = LocalDateTime.now();
            String addHistory = String.format("You won $%d.00 at High and Low! ** ", totalBetValue);
            currentPlayer.addHistory(addHistory + dtf.format(now));
            returnWinnings(currentPlayer);
        } else {
            loseSound.play();
            console.println((language.getHighAndLowLanguage(HighAndLowLanguage.Language.LOSE)));
            LocalDateTime now = LocalDateTime.now();
            String addHistory = String.format("You lost $%d.00 at High and Low. ** ", totalBetValue);
            currentPlayer.addHistory(addHistory + dtf.format(now));
        }
    }

    public boolean enoughBalance(){
        if(currentPlayer.getBalance() < 10) {
            console.printSlow(language.getHighAndLowLanguage(HighAndLowLanguage.Language.NOTENOUGHMONEY));
            console.println("Press Enter to return to the game menu... and hopefully the parking lot\n");
            console.newln();
            console.dotDotDot();
            console.getStringInput("Loser");
            return false;
        }
        return true;
    }

    @Override
    public void returnWinnings(Player currentPlayer) {
        currentPlayer.changeBalance(totalBetValue);

    }
    @Override
    public void exitGame(Player currentPlayer) {
    console.println(language.getHighAndLowLanguage(HighAndLowLanguage.Language.PLAYAGAIN));
        Integer playerInput = console.getIntegerInput(":");
        switch (playerInput){
            case 1:
                runGame(currentPlayer);
                break;
            case 2:
                running = false;
                break;
        }
    }
}