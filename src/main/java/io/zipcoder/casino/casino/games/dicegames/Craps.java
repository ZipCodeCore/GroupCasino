package io.zipcoder.casino.casino.games.dicegames;

import io.zipcoder.casino.casino.games.dicegames.diceutilities.Dice;
import io.zipcoder.casino.casino.games.Game;
import io.zipcoder.casino.casino.Casino;
import io.zipcoder.casino.casino.Greeter;
import io.zipcoder.casino.casino.utilities.Console;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Craps implements Game {
    Console console = Console.getConsole();
    private CrapsPlayer user = new CrapsPlayer(Casino.getProfile());
    private int initialBalance = getUser().getProfile().getBalance();
    private int adjustedBalance = initialBalance;
    private int betAmount = 0;
    private final int[] anyCraps = {2, 3, 12};
    private final int[] hornBetRolls = {2, 3, 11, 12};
    private final int[] hardwaysRolls = {4, 6, 8, 10};
    private final int[] placeNumberRolls = {4, 5, 6, 8, 9, 10};
    private final int[] fieldNumberRolls = {2, 3, 4, 9, 10, 11, 12};
    private int point = 0;
    private boolean isFirstRoll = true;
    private int hardwaysRoll;
    private boolean rollSumHardways = false;
    private int placeBetChoice;
    private int roll1;
    private int roll2;
    private int rollSum;
    Dice die1 = new Dice();
    Dice die2 = new Dice();
    private GameStatus gameState;

    public void setIsFirstRoll(boolean isFirstRoll) {
        this.isFirstRoll = isFirstRoll;
    }

    public void setRollSum(int rollSum) {
        this.rollSum = rollSum;
    }

    public Map<String, Boolean> getBetMap() {
        return betMap;
    }

    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }

    public int getAdjustedBalance() {
        return adjustedBalance;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public boolean getIsFirstRoll() {
        return isFirstRoll;
    }

    public void setBetInBetMap(String bet, boolean value) {
        betMap.put(bet, value);
    }

    public boolean getBetInBetMap(String bet) {
        return betMap.get(bet);
    }

    public void clearBets() {
        betMap.put("Pass Bet", false);
        betMap.put("Place Bet", false);
        betMap.put("Lay Bet", false);
        betMap.put("Any Craps", false);
        betMap.put("The Field", false);
        betMap.put("The Horn", false);
        betMap.put("Hardways", false);
    }

    public void setDie1(Dice dice) {
        die1 = dice;
    }

    public void setDie2(Dice dice) {
        die2 = dice;
    }

    public int getRollSum() {
        return rollSum;
    }

    public void setRollSumHardways(boolean rollSumHardways) {
        this.rollSumHardways = rollSumHardways;
    }

    public boolean getRollSumHardways() {
        return rollSumHardways;
    }

    public int getBetAmount() {
        return betAmount;
    }

    public void setAdjustedBalance(int adjustedBalance) {
        this.adjustedBalance = adjustedBalance;
    }

    public void setHardwaysRoll(int hardwaysRoll) {
        this.hardwaysRoll = hardwaysRoll;
    }

    public int getHardwaysRoll(){return hardwaysRoll;}

    public int getPlaceBetChoice() {return placeBetChoice;}

    public void setPlaceBetChoice(int placeBetChoice) {
        this.placeBetChoice = placeBetChoice;
    }

    public void setInitialBalance(int initialBalance) {
        this.initialBalance = initialBalance;
    }

    public CrapsPlayer getUser() {
        return user;
    }

    private enum GameStatus {UNRESOLVED, WON, LOST}

    public enum BetList {
        PLACE("always"),
        LAY("always"),
        ANYCRAPS("oneOff"),
        FIELD("oneOff"),
        HORN("oneOff"),
        HARDWAYS("always");
        private String typeOfBet;

        BetList(String typeOfBet) {
            this.typeOfBet = typeOfBet;
        }

        public static Stream<BetList> stream() {
            return Stream.of(BetList.values());
        }
    }

    private static Map<String, Boolean> betMap = new HashMap<>();

    static {
        betMap.put("Pass Bet", false);
        betMap.put("Place Bet", false);
        betMap.put("Lay Bet", false);
        betMap.put("Any Craps", false);
        betMap.put("The Field", false);
        betMap.put("The Horn", false);
        betMap.put("Hardways", false);
    }

    private enum BetExplanations {
        PLACE("The Place bet wins if the chosen number is rolled before a 7"),
        LAY("The Lay bet wins if a 7 is rolled before the point"),
        ANYCRAPS("Any Craps pays off on 2, 3 or 12 before rolling a 7"),
        FIELD("The Field wins if 4, 5, 6, 8, 9 or 10 hits before 7"),
        HORN("The Horn wins on 2, 3, 11 or 12 before rolling a 7"),
        HARDWAYS("Hardways involves two dice of the same face value, which must be hit before 7 or the corresponding sum thrown 'easy'\n");
        private String betRules;

        BetExplanations(String betRules) {
            this.betRules = betRules;
        }

        public String getExplanations() {
            return betRules;
        }

        public static Stream<BetExplanations> stream() {
            return Stream.of(BetExplanations.values());
        }
    }

    public Craps() {
    }

    // Purely for testing
    public Craps(Console console) {
        this.console = console;
    }

    public void play() {
        console.println(Greeter.getCrapsName());
        console.println("Welcome to the craps table!");
        while (getIsFirstRoll()) {
            promptFirstBet();
            roll();
            evaluateFirstRoll();
            evaluateGameState(gameState);
        }
        while (gameState == GameStatus.UNRESOLVED) {
            promptBet();
            roll();
            evaluate();
            evaluateGameState(gameState);
        }
    }

    public void evaluateFirstRoll() {
        {
            if (getBetInBetMap("Pass Bet")) {
                if (Arrays.stream(anyCraps).anyMatch(i -> i == getRollSum())) {
                    gameState = GameStatus.LOST;
                } else if (getRollSum() == 7 || getRollSum() == 11) {
                    gameState = GameStatus.WON;
                } else {
                    setupGameplayLoop();
                }
            } else if (!getBetInBetMap("Pass Bet")) {
                if (getRollSum() == 7 || getRollSum() == 11) {
                    gameState = GameStatus.LOST;
                } else if (Arrays.stream(anyCraps).anyMatch(i -> i == getRollSum())) {
                    gameState = GameStatus.UNRESOLVED;
                } else {
                    setupGameplayLoop();
                }
            }
        }
    }

    public void setupGameplayLoop() {
        gameState = GameStatus.UNRESOLVED;
        setPoint(rollSum);
        setIsFirstRoll(false);
        console.println("The point is now " + point + ".\n");
    }

    public void evaluateGameState(GameStatus gameState) {
        if (gameState == GameStatus.WON) {
            console.println("Your bet paid off!");
            adjustBalance(betAmount);
            resetPointAndRoll();
            clearBets();
            promptQuit();
        } else if (gameState == GameStatus.LOST) {
            console.println("You lost your bet!");
            adjustBalance(-betAmount);
            resetPointAndRoll();
            clearBets();
            promptQuit();
        } else {
            gameState = GameStatus.UNRESOLVED;
            setIsFirstRoll(false);
        }
    }

    public void resetPointAndRoll() {
        setPoint(0);
        setIsFirstRoll(true);
    }

    public void promptFirstBet() {
        int betReturn = console.getIntegerInput("How much would you like to bet?");
        if (betReturn > adjustedBalance) {
            console.println("You don't have that much, pal");
            promptFirstBet();
        } else {
            betAmount = betReturn;
        }
        String passChoice = console.getStandardInput("Please choose 'Pass' or 'Don't Pass'");
        if (passChoice.equals("pass")) {
            setBetInBetMap("Pass Bet", true);
        } else if (passChoice.equals("don't pass")) {
            setBetInBetMap("Pass Bet", false);
        } else {
            console.println("I don't know that one, ace. Try again.");
            promptFirstBet();
        }
    }

    public void promptBet() {
        int betChoice = console.getIntegerInput("You have five choices:\n1) Explain Possible Bets\n2) List Current Bets\n3) List Available Bets\n4) Make a Bet\n5) Continue Rolling");
        switch (betChoice) {
            case 1:
                betRulesListed();
                promptBet();
                break;
            case 2:
                console.println("You have the current bets: " + currentBetList(true) + "\n");
                promptBet();
                break;
            case 3:
                listBets();
                promptBet();
                break;
            case 4:
                makeBet();
                break;
            case 5:
                break;
        }
    }

    public void makeBet() {
        String betName = console.getStandardInput("What bet would you like to place?");
        switch (betName) {
            case "place":
                setBetInBetMap("Place Bet", true);
                setPlaceBetChoice(console.getIntegerInput("What number do you want to make a Place Bet for?"));
                if (Arrays.stream(placeNumberRolls).anyMatch(i -> i == getPlaceBetChoice())) {
                    console.println("Excellent choice!");
                } else {
                    setPlaceBetChoice(console.getIntegerInput("Stick to the Place numbers, buddy! Pick from 4, 5, 6, 8, 9 or 10"));
                }
                break;
            case "lay":
                setBetInBetMap("Lay Bet", true);
                break;
            case "anycraps":
                setBetInBetMap("Any Craps", true);
                break;
            case "field":
                setBetInBetMap("The Field", true);
                break;
            case "horn":
                setBetInBetMap("The Horn", true);
                break;
            case "hardways":
                setBetInBetMap("Hardways", true);
                setHardwaysRoll(console.getIntegerInput("What number do you want to place a Hardways Bet on?"));
                if (Arrays.stream(hardwaysRolls).anyMatch(i -> i == getHardwaysRoll())) {
                    console.println("Excellent choice!\n");
                } else {
                    setHardwaysRoll(console.getIntegerInput("Stick to the Place numbers, buddy! Pick from 4, 6, 8, or 10"));
                }
                break;
            default:
                console.println("Please enter an actual bet, pal");
                makeBet();
        }
    }

    public void betRulesListed() {
        for (BetExplanations bet : BetExplanations.values()) {
            console.println(bet.getExplanations());
        }
    }

    public void filteredBetList(String betOptions) {
        BetList.stream()
                .filter(e -> e.typeOfBet.equals(betOptions))
                .forEach(console::println);
    }

    public List<String> currentBetList(boolean value) {
        return betMap
                .entrySet()
                .stream()
                .filter(e -> Objects.equals(e.getValue(), value))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public void listBets() {
        int betList = console.getIntegerInput("Choose one of the follow:\n1) List Bets always available\n2) List one-off Bets\n3) Go to previous Menu");
        switch (betList) {
            case 1:
                filteredBetList("always");
                break;
            case 2:
                filteredBetList("oneOff");
                break;
            case 3:
                promptBet();
                break;
        }
    }

    public int roll() {
        roll1 = die1.roll();
        roll2 = die2.roll();
        setRollSum(roll1 + roll2);
        if (roll1 == roll2) {
            rollSumHardways = true;
        } else {
            rollSumHardways = false;
        }
        console.println("\nHERE ARE YOUR DIE:\n" + Dice.getDiceString(roll1, roll2));
        return getRollSum();
    }

    public void evaluate() {
        if (rollSum == 7) {
            evaluate7s();
        } else if (Arrays.stream(anyCraps).anyMatch(i -> i == getRollSum())) {
            evaluateCrappedRolls();
        } else evaluatePointRolls();
    }

    public void evaluate7s() {
        if (getBetInBetMap("Lay Bet")) {
            gameState = GameStatus.WON;
        } else if (!getBetInBetMap("Pass Bet")) {
            gameState = GameStatus.WON;
        } else {
            gameState = GameStatus.LOST;
        }
    }

    public void evaluateCrappedRolls() {
        if (!getIsFirstRoll() && gameState == GameStatus.UNRESOLVED) {
            if (getBetInBetMap("Any Craps") && Arrays.stream(anyCraps).anyMatch(i -> i == getRollSum())) {
                gameState = GameStatus.WON;
            }
            if (getBetInBetMap("Any Craps") && Arrays.stream(anyCraps).noneMatch(i -> i == getRollSum())) {
                gameState = GameStatus.LOST;
            }
        }
    }

    public void evaluatePointRolls() {
        {
            if (getBetInBetMap("The Field") && Arrays.stream(fieldNumberRolls).anyMatch(i -> i == getRollSum())) {
                gameState = GameStatus.WON;
            }
            if (getBetInBetMap("The Horn") && Arrays.stream(hornBetRolls).anyMatch(i -> i == getRollSum())) {
                gameState = GameStatus.WON;
            }
            if (getBetInBetMap("Hardways") && (roll1 == roll2) && hardwaysRoll == getRollSum()) {
                gameState = GameStatus.WON;
            }
            if (getBetInBetMap("Lay Bet") && getRollSum() == 7) {
                gameState = GameStatus.WON;
            }
            if (getPoint() == getRollSum() && getBetInBetMap("Pass Bet")) {
                console.println("Lucky number " + point + "! You hit the point!\n");
                gameState = GameStatus.WON;
            }
            if (getRollSum() == placeBetChoice) {
                gameState = GameStatus.WON;
                promptQuit();
            } else {
                console.println("Nothing won yet...\n");
            }
        }
    }

    public void promptQuit() {
        String quitPrompt = console.getStandardInput("Would you like to quit while you're ahead?");
        if (quitPrompt.equals("yes")) {
            cashOut();
        } else {
            console.println("Okay, you're a responsible adult, and you know your limits\n");
            gameState = GameStatus.UNRESOLVED;
            resetPointAndRoll();
        }
    }

    public void adjustBalance(int profitOrLoss) {
        if (profitOrLoss > 0) {
            console.println(String.format("You're on a roll and %d NUCs richer!\n", profitOrLoss));
        } else if (profitOrLoss < 0) {
            console.println(String.format("%d NUCs gone already? Play again to win that back and more!\n", profitOrLoss));
        }
        adjustedBalance += profitOrLoss;
    }

    public void compareBalance() {
        if (adjustedBalance > initialBalance) {
            console.println(String.format("You won %d NUCs!\n", (adjustedBalance - initialBalance)));
        } else if (adjustedBalance < initialBalance) {
            console.println(String.format("You're %d NUCs poorer!\n", (initialBalance - adjustedBalance)));
        } else {
            console.println("You broke even!\n");
        }
    }

    public void cashOut() {
        String continuePlaying = console.getStandardInput("Wouldn't you rather continue playing?");
        if (continuePlaying.equals("no")) {
            compareBalance();
            user.getProfile().setBalance(adjustedBalance);
        }
    }
}