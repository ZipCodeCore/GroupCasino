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
    private DateTimeFormatter dateTimeReformatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
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
                    console.println(showRules());
                    break;
                case 3:
                    running = false;
                    break;
            }
        }
    }

    public String showRules(){
        return language.getHighAndLowLanguage(HighAndLowLanguage.Language.RULES);
    }

    public Boolean resetGame(){
        didYouBet = true;
        totalBetValue = 0;
        return didYouBet;
    }

    @Override
    public void placeBet(Player currentPlayer) {
        currentPlayer.placeBet(10);
        totalBetValue += 10;
    }

    public Integer firstRoll(){
        Integer roll = dice.rollDice(1);
        console.println(dice.diceArt(roll));
        Integer roll2 = dice.rollDice(1);
        console.println(dice.diceArt(roll2));
        Integer sumOfRolls = roll + roll2;
        console.println("The first result of the first roll is %d", sumOfRolls);
        return sumOfRolls;
    }

    public Boolean secondBet(Integer playerInput){
        return playerInput == 1;
    }

    public String highOrLowBet(Integer highOrLow){
        if(highOrLow == 1){
            return "high";
        }
        return "low";
    }

    public Integer secondRoll(){
        Integer roll = dice.rollDice(1);
        console.println(dice.diceArt(roll));
        Integer roll2 = dice.rollDice(1);
        console.println(dice.diceArt(roll2));
        Integer sumOfRolls = roll + roll2;
        console.println("The result of the second roll is %d", sumOfRolls);
        return sumOfRolls;
    }

    public String noBet(Integer totalBetValue){
        console.println("Backing out? No problem! You've lost $%d.00", totalBetValue);
        return String.format("You lost $%d.00 at High and Low. ** ", totalBetValue);
    }

    public void playWinOrLoseSound(Integer firstRoll, Integer secondRoll, String highOrLowBet){
        if((firstRoll > secondRoll && highOrLowBet.equals("low")) || (firstRoll < secondRoll && highOrLowBet.equals("high"))){
            winSound.play();
        } else {
            loseSound.play();
        }
    }

    public boolean winOrLose(Integer firstRoll, Integer secondRoll, String highOrLowBet){
        if((firstRoll > secondRoll && highOrLowBet.equals("low")) || (firstRoll < secondRoll && highOrLowBet.equals("high"))){
            console.println("Congratulations! You've won $%d.00!", totalBetValue);
            return true;
        } else {
            console.println("Sorry, you've lost $%d.00. Please try again soon!", totalBetValue);
            return false;
        }
    }

    public boolean enoughBalance(Integer currentBalance){
        return currentBalance >= 10;
    }

    public void addHistory(Boolean result, Integer totalBetValue, Player currentPlayer){
        LocalDateTime now = LocalDateTime.now();
        if(result){
            String addHistory = String.format("You won $%d.00 at High and Low! ** ", totalBetValue);
            currentPlayer.addHistory(addHistory + dateTimeReformatter.format(now));
        } else {
            String addHistory = String.format("You lost $%d.00 at High and Low. ** ", totalBetValue);
            currentPlayer.addHistory(addHistory + dateTimeReformatter.format(now));
        }
    }

    public void notEnoughMoney() {
        console.printSlow(language.getHighAndLowLanguage(HighAndLowLanguage.Language.NOTENOUGHMONEY));
        console.println("Press Enter to return to the game menu... and hopefully the parking lot\n");
        console.newln();
        console.dotDotDot();
        console.getStringInput("Loser");
    }

    @Override
    public void returnWinnings(Player currentPlayer, Integer totalBetValue) {
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

    @Override
    public void runGame(Player currentPlayer) {
        while(running) {
            if(!enoughBalance(currentPlayer.getBalance())){
                notEnoughMoney();
                break;
            }
            resetGame();
            console.println("Welcome to High and Low, %s!\n", currentPlayer.getName());
            console.printSlow(language.getHighAndLowLanguage(HighAndLowLanguage.Language.BUYIN));
            //
            spendSound.play();
            console.dotDotDot();
            console.newln();
            //
            placeBet(currentPlayer);
            diceSound.play();
            Integer firstRoll = firstRoll();

            console.println("Your current balance is $%d.00", currentPlayer.getBalance());
            console.println(language.getHighAndLowLanguage(HighAndLowLanguage.Language.PLACESECONDBET));

            Integer playerInput = console.getIntegerInput(":");
            didYouBet = secondBet(playerInput);
            if(didYouBet){
                spendSound.play();
                placeBet(currentPlayer);
            }else {
                String noBetHistory = noBet(totalBetValue);
                LocalDateTime now = LocalDateTime.now();
                currentPlayer.addHistory(noBetHistory + dateTimeReformatter.format(now));
                exitGame(currentPlayer);
                break;
            }
            console.println(language.getHighAndLowLanguage(HighAndLowLanguage.Language.HIGHORLOW));
            Integer playerBet = console.getIntegerInput(":");
            String highOrLowBet = highOrLowBet(playerBet);
            console.dotDotDot();
            console.newln();

            diceSound.play();
            Integer secondRoll = secondRoll();

            playWinOrLoseSound(firstRoll, secondRoll, highOrLowBet);
            Boolean result = winOrLose(firstRoll, secondRoll, highOrLowBet);
            if(result){
                returnWinnings(currentPlayer, totalBetValue * 2);
            }
            addHistory(result, totalBetValue, currentPlayer);

            console.println("Your current balance is $%d.00", currentPlayer.getBalance());
            exitGame(currentPlayer);
        }
    }
}