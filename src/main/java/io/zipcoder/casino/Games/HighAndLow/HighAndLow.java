package io.zipcoder.casino.Games.HighAndLow;

import io.zipcoder.casino.utilities.CasinoArt;
import io.zipcoder.casino.GamePieces.Dice;
import io.zipcoder.casino.Games.GamblingGame;
import io.zipcoder.casino.Games.Game;
import io.zipcoder.casino.PlayerCreation.Player;
import io.zipcoder.casino.utilities.Console;
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

    public void runHighOrLow(Player currentPlayer) {
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
            }
        }
    }

    public void showRules(){
        console.println(language.getHighAndLowLanguage(HighAndLowLanguage.Language.RULES));
    }

    @Override
    public void runGame(Player currentPlayer) {
        while(running) {
            totalBetValue = 0;
            Integer highOrLowBet = 0;
            console.println("Welcome to High and Low, %s!\n", currentPlayer.getName());
            console.println(language.getHighAndLowLanguage(HighAndLowLanguage.Language.BUYIN));
            currentPlayer.placeBet(10);
            Integer firstRoll = firstRoll();

            console.println(language.getHighAndLowLanguage(HighAndLowLanguage.Language.PLACESECONDBET));
            placeBet(currentPlayer);
            highOrLowBet();
            secondRoll();

            Integer secondRoll = secondRoll();


            winOrLose(firstRoll, secondRoll, highOrLowBet, didYouBet);
            exitGame(currentPlayer);
        }
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

    @Override
    public void placeBet(Player currentPlayer) {

        Integer playerInput = console.getIntegerInput(":");
        if(playerInput == 1){
            currentPlayer.placeBet(10);
            totalBetValue += 10;
            didYouBet = true;
        } else {
            didYouBet = false;
        }

    }

    public Integer highOrLowBet(){
        console.println(language.getHighAndLowLanguage(HighAndLowLanguage.Language.HIGHORLOW));
        Integer playerBet = console.getIntegerInput(":");
        return playerBet;
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

    public void winOrLose(Integer firstRoll, Integer secondRoll, Integer highOrLowBet, boolean didYouBet){
        if((firstRoll > secondRoll && highOrLowBet == 2) || (firstRoll < secondRoll && highOrLowBet == 1)){
            returnWinnings(currentPlayer);
        } else {
            console.println((language.getHighAndLowLanguage(HighAndLowLanguage.Language.LOSE)));
            LocalDateTime now = LocalDateTime.now();
            String addHistory = String.format("You lost $%d.00 at High and Low. ** ", totalBetValue);
            currentPlayer.addHistory(addHistory + dtf.format(now));
        }
    }

    @Override
    public void returnWinnings(Player currentPlayer) {
        console.println("Congratulations! You've won $%d.00!", totalBetValue);
        LocalDateTime now = LocalDateTime.now();
        String addHistory = String.format("You won $%d.00 at High and Low! ** ", totalBetValue);
        currentPlayer.addHistory(addHistory + dtf.format(now));
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