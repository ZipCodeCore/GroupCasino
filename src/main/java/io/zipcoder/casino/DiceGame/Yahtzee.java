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


    public Yahtzee(Player player){
        this.yahtzeePlayer = new YahtzeePlayer(player);
        this.score = 0;
        this.scoreCard = new TreeMap<String, Integer>();
        this.rollNumber = 1;
        this.savedDice = new ArrayList<Dice>();
        this.rolledDice = new ArrayList<Dice>();
    }

    public void play() {
    }

    public void walkAway(){}


    // this method will merge ale rolledDice and savedDice into one ArrayList
    public ArrayList<Dice> getAllDice(ArrayList<Dice> rolledDice, ArrayList<Dice> savedDice){
        ArrayList<Dice> allDice = rolledDice;
        for(Dice die : savedDice){
            allDice.add(die);
        }
        return allDice;
    }

    // this method will get the score for the entered category based on the dice
    public int getScoreForCategory(String category, ArrayList<Dice> allDice){
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

            case "three of a kind":
                score = scoreThreeOfAKind(allDice);
                break;

            case "four of a kind":
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

            case "chance":
                score = scoreChance(allDice);

            default :
                System.out.println("invalid category");
        }
        return score;
    }

    public int scoreAces(ArrayList<Dice> allDice){
        int score = 0;
        for(Dice die : allDice){
            if (die.getValue() == 1){
                score += 1;
            }
        }
        return score;
    }

    public int scoreTwos(ArrayList<Dice> allDice){
        int score = 0;
        for(Dice die : allDice){
            if (die.getValue() == 2){
                score += 2;
            }
        }
        return score;
    }

    public int scoreThrees(ArrayList<Dice> allDice){
        int score = 0;
        for(Dice die : allDice){
            if (die.getValue() == 3){
                score += 3;
            }
        }
        return score;
    }

    public int scoreFours(ArrayList<Dice> allDice){
        int score = 0;
        for(Dice die : allDice){
            if (die.getValue() == 4){
                score += 4;
            }
        }
        return score;
    }

    public int scoreFives(ArrayList<Dice> allDice){
        int score = 0;
        for(Dice die : allDice){
            if (die.getValue() == 5){
                score += 5;
            }
        }
        return score;
    }

    public int scoreSixes(ArrayList<Dice> allDice){
        int score = 0;
        for(Dice die : allDice){
            if (die.getValue() == 6){
                score += 6;
            }
        }
        return score;
    }

    public int upperSectionBonus(TreeMap<String, Integer> scoreCard){
        // if score for Aces to Sixes is >= 63, return 35.  Else return 0.
        return 0;
    }

    public int getUpperSectionTotal(TreeMap<String, Integer> scoreCard){
        return 0;
    }

    public boolean hasThreeOfAKind(ArrayList<Dice> allDice){
        // returns true if there are at least 3 dice with the same values
        return false;
    }

    public int scoreThreeOfAKind(ArrayList<Dice> allDice){
        // if hasThreeOfAKind returns true, returns the sum of all Dice
        // else returns 0
        return 0;
    }

    public boolean hasFourOfAKind(ArrayList<Dice> allDice){
        // return true if there are at least 4 dice with the same values
        return false;
    }

    public int scoreFourOfAKind(ArrayList<Dice> allDice){
        // if hasFourOfAKind returns true, returns the sum of all dice
        // else returns 0
        return 0;
    }

    public boolean hasFullHouse(ArrayList<Dice> allDice){
        // returns true if there are 3 of the same dice and 2 of the same dice
        // that are not the same value as the 3 dice
        return false;
    }

    public int scoreFullHouse(ArrayList<Dice> allDice){
        // if hasFullHouse, returns 25
        // else returns 0
        return 0;
    }

    public boolean hasSmallStraight(ArrayList<Dice> allDice){
        // if allDice has dice with values 1,2,3,4  2,3,4,5  or 3,4,5,6 return true
        // else return false
        return false;
    }

    public int scoreSmallStraight(ArrayList<Dice> allDice){
        // if hasSmallStraight return 30
        // else returns 0
        return 0;
    }

    public boolean hasLargeStraight(ArrayList<Dice> allDice){
        // if allDice has dice with values 1,2,3,4.5 or  2,3,4,5,6 return true
        // else return false
        return false;
    }

    public int scoreLargeStraight(ArrayList<Dice> allDice){
        // if hasLargeStraight return 40
        // else returns 0
        return 0;
    }

    public boolean hasYahtzee(ArrayList<Dice> allDice){
        // if allDice has 5 of a kind, return true
        // else return false
        return false;
    }

    public int scoreYahtzee(ArrayList<Dice> allDice){
        // if yahtzeePlayer.hasYahtzee is true  and hasYahtzee is true, return 100;
        // else if hasYahtzee, yahtzeePlayer.setHasYahtzee(true) return 50
        // else return 0
        return 0;
    }

    public int scoreChance(ArrayList<Dice> allDice){
        // returns the sum of all Dice
        return 0;
    }

    public int getLowerSectionTotal(TreeMap<String, Integer> scoreCard){
        // return sum of all lower section values
        return 0;
    }

    public int getTotalScore(TreeMap<String, Integer> scoreCard){
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
}
