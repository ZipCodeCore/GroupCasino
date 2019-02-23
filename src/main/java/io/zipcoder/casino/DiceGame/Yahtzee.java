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
        return null;
    }

    // this method will get the score for the entered category based on the dice
    public int getScoreForCategoty(String category, ArrayList<Dice> allDice){
        return 0;
    }

    public int scoreAces(ArrayList<Dice> allDice){
        // returns sum of all Aces in Dice
        return 0;
    }

    public int scoreTwos(ArrayList<Dice> allDice){
        // returns sum of all Twos in Dice
        return 0;
    }

    public int scoreThrees(ArrayList<Dice> allDice){
        // returns sum of all Threes in dice
        return 0;
    }

    public int scoreFours(ArrayList<Dice> allDice){
        // returns sum of all Fours in dice
        return 0;
    }

    public int scoreFives(ArrayList<Dice> allDice){
        // returns sum of all Fives in dice
        return 0;
    }

    public int scoreSixes(ArrayList<Dice> allDice){
        // returns sum of all Sixes in dice
        return 0;
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

}
