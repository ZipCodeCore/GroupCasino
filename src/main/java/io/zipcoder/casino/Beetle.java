package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;

import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Beetle extends DiceGame{
    Player player;
    Random random = new Random();
    Console console;
    private InputStream in;
    private PrintStream out;
    BeetleDisplay display = new BeetleDisplay();
    BeetleService service = new BeetleService();

    private Double purse = 0.00;

    public Beetle(Player player) {
        this.player = player;
        this.in = System.in;
        this.out = System.out;
        this.console = new Console(in, out);
    }
    
// FACILITATOR
    public void gameEngine() {
        Boolean userHasNotWon = true;
        Boolean opponentHasNotWon = true;
        Boolean playersHaveNotTied = true;

        display.displayWelcomeSequence(player, service.getCompleteBeetle());
        tableMinimumDeposit();
        display.currentPurse(getPurse());
        while (playersHaveNotTied && userHasNotWon && opponentHasNotWon) {

            //BET
            Double userBetAmount = (console.getDoubleInput("how much would you like to bet?"));
            acceptBetFromUser(userBetAmount);
            Double opponentBet = opponentBet(userBetAmount);
            setPurse(opponentBet);

            //PLAY
            Integer userRollValue = diceRollSum(1);
            analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), userRollValue);
            Integer opponentsRollValue = diceRollSum(1);
            analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), opponentsRollValue);

            //DISPLAY
            display.gameBoard(userRollValue, service.getUsersBeetle(), opponentsRollValue, service.getOpponentsBeetle(), getPurse(),userBetAmount,opponentBet);

            //ANALYZE
            playersHaveNotTied = tieStateDoesNotExist(service.getUsersBeetle(), service.getOpponentsBeetle());
            userHasNotWon = winningStateDoesNotExist(service.getUsersBeetle());
            opponentHasNotWon = losingStateDoesNotExist(service.getOpponentsBeetle());
        }
        display.printAccountBalance(player.getWallet());
    }

    //GAME STATE
    public Boolean tieStateDoesNotExist(String[][] usersBeetle, String[][] opponentsBeetle) {
        if (Arrays.deepEquals(service.getCompleteBeetle(), usersBeetle) && Arrays.deepEquals(service.getCompleteBeetle(), opponentsBeetle)) {
            display.bothBeetlesComplete();
            player.setWallet(player.getCurrentBet());
            System.out.println("Your bets were returned to your wallet.");
            return false;
        }
        return true;
    }

    public Boolean winningStateDoesNotExist(String[][] usersBeetle) {
        if (Arrays.deepEquals(service.getCompleteBeetle(), usersBeetle)) {
            display.userBugIsComplete();
            player.setWallet(purse);
            player.setCurrentBet(0.00);
            return false;
        }
        return true;
    }

    public Boolean losingStateDoesNotExist(String[][] opponentsBeetle) {
        if (Arrays.deepEquals(service.getCompleteBeetle(), opponentsBeetle)) {
            display.opponentsBugisComplete();
            player.setWallet(-player.getCurrentBet());
            player.setCurrentBet(0.00);
            return false;
        }
        return true;
    }

    public void analyzeRoll(Set<Integer> rollSet, String[][] playersBeetle, Integer diceRoll){
        if(!rollSet.contains(diceRoll)) {
            service.updateBeetleDrawing(playersBeetle,diceRoll);
            rollSet.add(diceRoll);
        }
    }

    //BETTING
    public void acceptBetFromUser(Double betAmount) {
        player.makeBet(betAmount);
        purse += betAmount;
    }


    public Double tableMinimumDeposit() {
        acceptBetFromUser(1.00);
        purse += 1;
        return purse;
    }

    public Double opponentBet(Double userBet) {
        Double opponentBet = 0.0;
        if (service.getOpponentsRolls().size() >= service.getUsersRolls().size()) {
            Double multiplier = random.nextDouble() + 0.5;
            opponentBet = userBet * Math.round(multiplier * 100) / 100;
        }
        BigDecimal formattedBet = new BigDecimal(opponentBet).setScale(2, RoundingMode.HALF_UP);
        opponentBet = formattedBet.doubleValue();
        return opponentBet;
    }

    public Double calculateReward() {
        double reward = purse - player.getCurrentBet();
        return reward;
    }

    //PURSE
    public Double calculateLoss() {
        return player.getCurrentBet();
    }

    public Double getPurse() {
        BigDecimal purseFormatted = new BigDecimal(purse).setScale(2, RoundingMode.HALF_UP);
        purse = purseFormatted.doubleValue();
        return purse;
    }

    public Double setPurse(Double betAmount) {
        purse += betAmount;
        return purse;
    }

    //UNUSED METHODS FROM ABSTRACT CLASS
    public String endGame() {
        return null;
    }

    public String startGame() {
        return null;
    }

}
