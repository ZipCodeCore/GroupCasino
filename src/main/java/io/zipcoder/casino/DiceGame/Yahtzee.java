package io.zipcoder.casino.DiceGame;

import io.zipcoder.casino.Player;

import java.util.ArrayList;
import java.util.TreeMap;

public class Yahtzee extends DiceGame {
    private YahtzeePlayer yahtzeePlayer;
    private int score;
    private TreeMap<String, Integer> scoreCard;
    private int rollNumber;
    private ArrayList<Dice> savedDice;
    private ArrayList<Dice> rolledDice;


    public Yahtzee(Player player) {
        this.yahtzeePlayer = new YahtzeePlayer(player);
        this.score = 0;
        this.scoreCard = new TreeMap<>();
        this.rollNumber = 1;
        this.savedDice = new ArrayList<>();
        this.rolledDice = new ArrayList<>();
    }

    public void play() {
    }

    public void walkAway() {
    }


    // this method will merge ale rolledDice and savedDice into one ArrayList
    public ArrayList<Dice> getAllDice(ArrayList<Dice> rolledDice, ArrayList<Dice> savedDice) {
        ArrayList<Dice> allDice = rolledDice;
        for (Dice die : savedDice) {
            allDice.add(die);
        }
        return allDice;
    }

    // this method will get the score for the entered category based on the dice
    public int getScoreForCategory(String category, ArrayList<Dice> allDice) {
        int score = 0;
        String categoryToScore = category.toLowerCase();

        switch (categoryToScore) {
            case "aces":
                score = scoreAces(allDice);
                break;

            case "twos":
                score = scoreTwos(allDice);
                break;

            case "threes":
                score = scoreThrees(allDice);
                break;

            case "fours":
                score = scoreFours(allDice);
                break;

            case "fives":
                score = scoreFives(allDice);
                break;

            case "sixes":
                score = scoreSixes(allDice);
                break;

            case "3 of a kind":
                score = scoreThreeOfAKind(allDice);
                break;

            case "4 of a kind":
                score = scoreFourOfAKind(allDice);
                break;

            case "full house":
                score = scoreFullHouse(allDice);
                break;

            case "small straight":
                score = scoreSmallStraight(allDice);
                break;

            case "large straight":
                score = scoreLargeStraight(allDice);
                break;

            case "yahtzee":
                score = scoreYahtzee(allDice);
                break;

            case "chance":
                score = scoreChance(allDice);
                break;

            default:
                System.out.println("invalid category");
        }
        return score;
    }

    public int scoreAces(ArrayList<Dice> allDice) {
        int score = 0;
        for (Dice die : allDice) {
            if (die.getValue() == 1) {
                score += 1;
            }
        }
        return score;
    }

    public int scoreTwos(ArrayList<Dice> allDice) {
        int score = 0;
        for (Dice die : allDice) {
            if (die.getValue() == 2) {
                score += 2;
            }
        }
        return score;
    }

    public int scoreThrees(ArrayList<Dice> allDice) {
        int score = 0;
        for (Dice die : allDice) {
            if (die.getValue() == 3) {
                score += 3;
            }
        }
        return score;
    }

    public int scoreFours(ArrayList<Dice> allDice) {
        int score = 0;
        for (Dice die : allDice) {
            if (die.getValue() == 4) {
                score += 4;
            }
        }
        return score;
    }

    public int scoreFives(ArrayList<Dice> allDice) {
        int score = 0;
        for (Dice die : allDice) {
            if (die.getValue() == 5) {
                score += 5;
            }
        }
        return score;
    }

    public int scoreSixes(ArrayList<Dice> allDice) {
        int score = 0;
        for (Dice die : allDice) {
            if (die.getValue() == 6) {
                score += 6;
            }
        }
        return score;
    }

    public int upperSectionBonus(TreeMap<String, Integer> scoreCard) {
        // if score for Aces to Sixes is >= 63, return 35.  Else return 0.
        return 0;
    }

    public int getUpperSectionTotal(TreeMap<String, Integer> scoreCard) {
        return 0;
    }

    public boolean hasThreeOfAKind(ArrayList<Dice> allDice) {
        Integer[] diceCount = countDice(allDice);
        for (Integer dieCount : diceCount) {
            if (dieCount >= 3) {
                return true;
            }
        }
        return false;
    }

    public int scoreThreeOfAKind(ArrayList<Dice> allDice) {
        if (hasThreeOfAKind(allDice)) {
            return getSumOfDice(allDice);
        }
        return 0;
    }


    public boolean hasFourOfAKind(ArrayList<Dice> allDice) {
        Integer[] diceCount = countDice(allDice);
        for (Integer dieCount : diceCount) {
            if (dieCount >= 4) {
                return true;
            }
        }
        return false;
    }


    public int scoreFourOfAKind(ArrayList<Dice> allDice) {
        if (hasFourOfAKind(allDice)) {
            return getSumOfDice(allDice);
        }
        return 0;
    }


    public boolean hasFullHouse(ArrayList<Dice> allDice) {
        Integer[] diceCount = countDice(allDice);
        boolean hasTwoCount = false;
        boolean hasThreeCount = false;

        for (Integer dieCount : diceCount) {
            if (dieCount == 2) {
                hasTwoCount = true;
            }
            if (dieCount == 3) {
                hasThreeCount = true;
            }
        }
        if (hasTwoCount && hasThreeCount) {
            return true;
        } else {
            return false;
        }
    }


    public int scoreFullHouse(ArrayList<Dice> allDice) {
        if (hasFullHouse(allDice)) {
            return 25;
        } else {
            return 0;
        }
    }


    public boolean hasSmallStraight(ArrayList<Dice> allDice) {
        Integer[] diceCount = countDice(allDice);

        if ((diceCount[0] >= 1) && (diceCount[1] >= 1) && (diceCount[2] >= 1) && (diceCount[3] >= 1)) {
            return true;
        }
        if ((diceCount[1] >= 1) && (diceCount[2] >= 1) && (diceCount[3] >= 1) && (diceCount[4] >= 1)) {
            return true;
        }
        if ((diceCount[2] >= 1) && (diceCount[3] >= 1) && (diceCount[4] >= 1) && (diceCount[5] >= 1)) {
            return true;
        } else {
            return false;
        }
    }


    public int scoreSmallStraight(ArrayList<Dice> allDice) {
        if (hasSmallStraight(allDice)) {
            return 30;
        } else {
            return 0;
        }
    }


    public boolean hasLargeStraight(ArrayList<Dice> allDice) {
        Integer[] diceCount = countDice(allDice);

        if ((diceCount[0] == 1) && (diceCount[1] == 1) && (diceCount[2] == 1) && (diceCount[3] == 1) && (diceCount[4] == 1)) {
            return true;
        }
        if ((diceCount[1] == 1) && (diceCount[2] == 1) && (diceCount[3] == 1) && (diceCount[4] == 1) && (diceCount[5] == 1)) {
            return true;
        } else {
            return false;
        }
    }


    public int scoreLargeStraight(ArrayList<Dice> allDice) {
        if (hasLargeStraight(allDice)) {
            return 40;
        } else {
            return 0;
        }
    }


    public boolean hasYahtzee(ArrayList<Dice> allDice) {
        Integer[] diceCount = countDice(allDice);

        for (Integer dieCount : diceCount) {
            if (dieCount == 5) {
                return true;
            }
        }
        return false;
    }


    public int scoreYahtzee(ArrayList<Dice> allDice) {
        if(hasYahtzee(allDice)){
            return 50;
        }
        else {
            return 0;
        }
    }


    public int scoreChance(ArrayList<Dice> allDice) {
        return getSumOfDice(allDice);
    }

    public int getLowerSectionTotal(TreeMap<String, Integer> scoreCard) {
        // return sum of all lower section values
        return 0;
    }

    public int getTotalScore(TreeMap<String, Integer> scoreCard) {
        // return the sum of getLowerSectionTotal and getUpperSectionTotal
        return 0;
    }

    public YahtzeePlayer getYahtzeePlayer() {
        return this.yahtzeePlayer;
    }

    public TreeMap<String, Integer> getScoreCard() {
        return this.scoreCard;
    }

    public ArrayList<Dice> getSavedDice() {
        return this.savedDice;
    }

    public void setYahtzeePlayer(YahtzeePlayer yahtzeePlayer) {
        this.yahtzeePlayer = yahtzeePlayer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setScoreCard(TreeMap<String, Integer> scoreCard) {
        this.scoreCard = scoreCard;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setSavedDice(ArrayList<Dice> savedDice) {
        this.savedDice = savedDice;
    }

    public ArrayList<Dice> getRolledDice() {
        return rolledDice;
    }

    public void setRolledDice(ArrayList<Dice> rolledDice) {
        this.rolledDice = rolledDice;
    }

    public Integer[] countDice(ArrayList<Dice> dice) {
        Integer[] diceCounter = {0, 0, 0, 0, 0, 0};
        for (Dice die : dice) {
            if (die.getValue() == 1) {
                diceCounter[0]++;
            } else if (die.getValue() == 2) {
                diceCounter[1]++;
            } else if (die.getValue() == 3) {
                diceCounter[2]++;
            } else if (die.getValue() == 4) {
                diceCounter[3]++;
            } else if (die.getValue() == 5) {
                diceCounter[4]++;
            } else if (die.getValue() == 6) {
                diceCounter[5]++;
            }
        }
        return diceCounter;
    }


    public int getSumOfDice(ArrayList<Dice> dice) {
        int sum = 0;

        for (Dice die : dice) {
            sum += die.getValue();
        }
        return sum;
    }

}
