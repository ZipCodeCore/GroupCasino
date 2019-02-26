package io.zipcoder.casino.Games;

import io.zipcoder.casino.Cards.Dice;
import io.zipcoder.casino.Casino.Casino;
import io.zipcoder.casino.Games.Game;
//import io.zipcoder.casino.Players.CrapsPlayer;
//import io.zipcoder.casino.Players.Profile;
import io.zipcoder.casino.Players.CrapsPlayer;
import io.zipcoder.casino.utilities.Console;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Craps implements Game {
    private CrapsPlayer user = new CrapsPlayer(Casino.getProfile());
    private int initialBalance = user.getProfile().getBalance();
    Console console = Console.getConsole();
    private int point = 0;
    private boolean toWinPassBet = false;
    private boolean toWinLayBet = false;
    private boolean isFirstRoll = true;
    private boolean isOver = false;
    private int placeBetChoice;
    private final int[] anyCraps = {2, 3, 12};
    private final int[] hornBetRolls = {2, 3, 11, 12};
    private final int[] hardwaysRolls = {4, 6, 8, 10};
    private final int[] placeNumberRolls = {4, 5, 6, 8, 9, 10};
    private final int[] fieldNumberRolls = {2, 3, 4, 9, 10, 11, 12};
    private int adjustedBalance;
    private int rollSum;
    private int hardwaysRoll;
    private boolean isAnyCrapsBet;
    private boolean isFieldBet;
    private boolean isHornBet;
    private boolean isPlaceBet;
    private boolean isLayBet;
    private int firstRollSum;
    Dice die1 = new Dice();
    Dice die2 = new Dice();
    private int betAmount = 0;
    private int hardwaysBet = 0;
    private boolean rollSumHardways = false;
    private GameStatus gameState;
    private boolean isHardwaysBet = false;
    private boolean isCrappedRolls = false;
    private boolean isNatural = false;
    private boolean isEleven = false;
    private boolean isPoint = false;
    private boolean isPlaying = true;

    private enum GameStatus {UNRESOLVED, WON, LOST}

    private enum BetList {
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
        betMap.put("Hop Bet", false);
    }

    private enum BetExplanations {
        PLACE("The Place bet wins if the chosen number is rolled before a 7. "),
        LAY("The Lay bet wins if a 7 is rolled before the point"),
        ANYCRAPS("Any Craps pays off on 2, 3 or 12 before rolling a 7"),
        FIELD("The Field wins if 4, 5, 6, 8, 9 or 10 hits before 7"),
        HORN("The Horn wins on 2, 3, 11 or 12 before rolling a 7"),
        HARDWAYS("Hardways involves two dice of the same face value, which must be hit before 7 or the corresponding sum thrown 'easy'");
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

    public static void main(String[] args) {
        Craps craps = new Craps();
        craps.play();
    }

    public void play() {
        System.out.println("Welcome to the craps table!");
        while (!isOver) {
            while (isFirstRoll) {
                promptBet();
                firstRoll();
            }
            while (isPlaying && gameState == GameStatus.UNRESOLVED) {
                promptBet();
                while (isPlaying) {
                    roll();
                    evaluate();
                }
            }
        }
    }

    public int firstRoll() {
        roll();
        if (Arrays.stream(anyCraps).anyMatch(i -> i == rollSum) && toWinPassBet) {
            System.out.println("Whomp, whomp, you crapped out.");
            adjustBalance(-betAmount);
            resetPointAndRoll();
        } else if (rollSum == 7 && toWinPassBet || rollSum == 11 && toWinPassBet) {
            System.out.println("You won the Pass bet, keep it up!");
            gameState = GameStatus.WON;
            adjustBalance(betAmount);
            resetPointAndRoll();
        } else if (rollSum == 7 && !toWinPassBet || rollSum == 11 && !toWinPassBet) {
            System.out.println("You lost the Pass bet!");
            gameState = GameStatus.UNRESOLVED;
            adjustBalance(-betAmount);
            resetPointAndRoll();
        } else if (Arrays.stream(anyCraps).anyMatch(i -> i == rollSum) && !toWinPassBet) {
            System.out.println("You won the Don't Pass bet, keep it up!");
            gameState = GameStatus.UNRESOLVED;
            adjustBalance(betAmount);
            resetPointAndRoll();
        } else {
            point = rollSum;
            System.out.println("The point is now " + point + ".\nKeep on rollin', shooter!");
            gameState = GameStatus.UNRESOLVED;
            isFirstRoll = false;
        }
        rollSum = point;
        return point;
    }

    public void resetPointAndRoll() {
        point = 0;
        isFirstRoll = true;
    }

    public void promptBet() {
        if (isFirstRoll) {
            int betAmount = console.getIntegerInput("How much would you like to bet?");
            String passChoice = console.getStringInput("Please choose 'Pass' or 'Don't Pass'");
            if (passChoice.equals("Pass")) {
                toWinPassBet = true;
                betMap.put("Pass Bet", true);
            } else if (passChoice.equals("Don't Pass")) {
                toWinPassBet = false;
                betMap.put("Pass Bet", false);
            }
        } else if (!isFirstRoll) {
            int betChoice = console.getIntegerInput("You have six choices:\n1) Explain Possible Bets\n2) List Current Bets\n3) List Available Bets\n4) Make a Bet\n5) Continue Rolling\n6) Quit");
            switch (betChoice) {
                case 1:
                    betRulesListed();
                    promptBet();
                case 2:
                    System.out.println("You have the current bets: " + currentBetList(true));
                    promptBet();
                case 3:
                    listBets();
                    promptBet();
                case 4:
                    makeBet();
                    break;
                case 5:
                    break;
                case 6:
                    cashOut();
            }
        }
    }

    public void makeBet() {
        String betName = console.getStringInput("What bet would you like to place?");
        switch (betName) {
            case "Place":
                isPlaceBet = true;
                placeBetChoice = console.getIntegerInput("What number do you want to make a Place Bet for?");
                if (Arrays.stream(placeNumberRolls).anyMatch(i -> i == placeBetChoice)) {
                    System.out.println("Excellent choice!");
                } else {
                    placeBetChoice = console.getIntegerInput("Stick to the Place numbers, buddy! Pick from 4, 5, 6, 8, 9 or 10.");
                }
                break;
            case "Lay":
                isLayBet = true;
                break;
            case "AnyCraps":
                isAnyCrapsBet = true;
                break;
            case "Field":
                isFieldBet = true;
                break;
            case "Horn":
                isHornBet = true;
                break;
            case "Hardways":
                isHardwaysBet = true;
                hardwaysRoll = console.getIntegerInput("What number do you want to place a Hardways Bet on?");
                if (Arrays.stream(hardwaysRolls).anyMatch(i -> i == hardwaysRoll)) {
                    System.out.println("Excellent choice!");
                } else {
                    hardwaysRoll = console.getIntegerInput("Stick to the Place numbers, buddy! Pick from 4, 6, 8, or 10.");
                }

            default:
                System.out.println("Please enter an actual bet, pal");
        }
    }

    public void betRulesListed() {
        for (BetExplanations bet : BetExplanations.values()) {
            System.out.println(bet.getExplanations());
        }
    }

    public void filteredBetList(String betOptions) {
        BetList.stream()
                .filter(e -> e.typeOfBet.equals(betOptions))
                .forEach(System.out::println);
    }

    private List<String> currentBetList(boolean value) {
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
        int roll1 = die1.roll();
        int roll2 = die2.roll();
        rollSum = roll1 + roll2;
        if (roll1 == roll2) {
            rollSumHardways = true;
        } else {
            rollSumHardways = false;
            switch (rollSum) {
                case 2:
                case 3:
                case 12:
                    isCrappedRolls = true;
                case 7:
                    isNatural = true;
                case 11:
                    isEleven = true;
                default:
                    isPoint = true;
            }
        }
        System.out.println(String.format("You rolled a %d and %d totaling %d", roll1, roll2, rollSum));
        isPlaying = true;
        return rollSum;
    }

    public void evaluate() {
        if (isNatural) {
            if (toWinLayBet) {
                gameState = GameStatus.WON;
                System.out.println("Your Lay bet paid off!");
                adjustBalance(betAmount);
            }
            if (!toWinPassBet) {
                gameState = GameStatus.WON;
                System.out.println("Your Don't Pass bet paid off!");
                adjustBalance(betAmount);
            } else if (!isOver) {
                System.out.println("Sorry shooter, it looks like your hot streak has come to an end!");
                gameState = GameStatus.LOST;
                adjustBalance(-betAmount);
                resetPointAndRoll();
                isPlaying = false;
            }
        }
        if (isCrappedRolls && !isFirstRoll) {
            if (isAnyCrapsBet && Arrays.stream(anyCraps).anyMatch(i -> i == rollSum)) {
                gameState = GameStatus.WON;
                System.out.println("Your Any Craps bet paid off!");
                adjustBalance(betAmount);
            }
            if (isAnyCrapsBet && Arrays.stream(anyCraps).noneMatch(i -> i == rollSum)) {
                gameState = GameStatus.LOST;
                System.out.println("You lost your Any Craps bet!");
                adjustBalance(-betAmount);
            }
        }
        if (isPoint) {
            /*if (point == rollSum){
                gameState = GameStatus.WON;
                System.out.println("You hit the point!");
                adjustBalance(betAmount);
            }*/
            if (isFieldBet && Arrays.stream(fieldNumberRolls).anyMatch(i -> i == rollSum)) {
                gameState = GameStatus.WON;
                System.out.println("You won your Field bet!");
                adjustBalance(betAmount);
            }
            if (isHornBet && Arrays.stream(hornBetRolls).anyMatch(i -> i == rollSum)) {
                gameState = GameStatus.WON;
                System.out.println("You won your Horn bet!");
                adjustBalance(betAmount);
            }
            if (isHardwaysBet && (die1 == die2) && hardwaysBet == rollSum) {
                gameState = GameStatus.WON;
                System.out.println("You won your Hardways bet!");
                adjustBalance(betAmount);
            }
            if (isLayBet && rollSum == 7) {
                gameState = GameStatus.WON;
                System.out.println("You won your Lay Bet!");
                adjustBalance(betAmount);
            }
            if (rollSum == point && toWinPassBet) {
                System.out.println("Lucky number " + point + "! You hit the point!");
                adjustBalance(betAmount);
            } else {
                gameState = GameStatus.UNRESOLVED;
            }
        }
        if (rollSum == placeBetChoice) {
            System.out.println("Your Place bet paid off!");
            adjustBalance(betAmount);
        }
    }

    private int adjustBalance(int profitOrLoss) {
        if (profitOrLoss > 0) {
            System.out.println(String.format("You're on a roll and %d NUCs richer!", profitOrLoss));
        } else if (profitOrLoss < 0) {
            System.out.println(String.format("You only lost %d NUCs. Play again to win that back and more!", profitOrLoss));
        }
        return (adjustedBalance + profitOrLoss);
    }

    public void compareBalance() {
        if (adjustedBalance > initialBalance) {
            System.out.println(String.format("You won %d NUCs!", (adjustedBalance - initialBalance)));
        } else if (adjustedBalance < initialBalance) {
            System.out.println(String.format("You lost %d NUCs!", (initialBalance - adjustedBalance)));
        } else if (adjustedBalance == initialBalance) {
            System.out.println("You broke even!");
        }
    }

    public void cashOut() {
        String continuePlaying = console.getStringInput("Would you like to continue playing?");
        if (continuePlaying.equals("No")) {
            compareBalance();
            user.getProfile().setBalance(adjustedBalance);
            isPlaying = false;
            isOver = true;
        } else if (continuePlaying.equals("Yes")) {
            roll();
        }
    }
}
