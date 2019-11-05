package io.zipcoder.casino.DiceGames;

import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.Arrays;

public class Yahtzee implements Game {
    private Player user;
    private static Console console = new Console(System.in, System.out);

    private boolean continuePlay;

    private Dice[] myDice;
    int points;
    private String[] availableOptionsNames = {"","1s", "2s", "3s", "4s", "5s","6s","3 of a kind","4 of a kind",
                                              "Small Straight", "Large Straight", "Full House", "Yahtzee", "Chance"};



    public Yahtzee(Player player){
        this.user = player;
        this.myDice = createDice();
        this.points = 0;
        continuePlay = false;
    }

    public void startGame(){

        for(int i = 0; i < 13; i++) {
            //rollDice
            //chooseEvaluation
        }
        displayResults();
        promptLeaveGame();
    }

    public void promptLeaveGame(){
        console.getStringInput("Would you like to play again?\n1. Play again\n2. Exit");

    }
    public void displayResults(){
         console.println("Your final score is: " + this.points);
         console.getStringInput("Press enter to continue ");
    }

    public Dice[] createDice(){
        Dice[] dice = new Dice[5];
        for(int i = 0; i < dice.length; i++){
            dice[i] = new Dice();
        }
        return dice;
    }


/*
// Following methods for rolling dice and choosing which ones to keep---------------------------------------------------

    public void resetDice(){
        for(int i = 0; i < myDice.length; i++){
            myDice[i].setKept(false);
        }
    }

    public void threeDiceRolls(){
        resetDice();
        roll5Dice();
        chooseToKeep();
        roll5Dice();
        chooseToKeep();
        roll5Dice();
    }

    public void roll5Dice(){
        for(Dice s : this.myDice){
            if(!s.isKept()){
                s.rollDice();
            }
        }
    }

    public void chooseToKeep(){
        String keepthis = "";
        while(!keepthis.toLowerCase().equals("roll")) {
            for (int i = 0; i < this.myDice.length; i++) {
                console.print((i + 1) + ". " + this.myDice[i].getValue() + " : " + this.myDice[i].isKept() + "\n");
            }
            keepthis = console.getStringInput(" Enter the number of the dice to keep, then press enter\nType 'continue' when finished");
            switch (keepthis){
                case "1": this.myDice[0].keptOrRolled();   break;
                case "2": this.myDice[1].keptOrRolled();   break;
                case "3": this.myDice[2].keptOrRolled();   break;
                case "4": this.myDice[3].keptOrRolled();   break;
                case "5": this.myDice[4].keptOrRolled();   break;
                case "continue": keepthis = "roll"; break;
                default: break;
            }
        }
    }


// Following methods are for evaluating the dice at the end of three rolls----------------------------------------------

    public int checkForEvaluation(Dice[] dice){
        int choice = 0;
        boolean evaluated = false;
        Integer[] diceValues = getDiceValues();

        for(int i = 1; i < availableOptionsNames.length; i++){
            console.println((i) + ".  " + availableOptionsNames[i]);
        }

        while(!evaluated){
            try{
                for(Dice s: dice){
                    console.println(s.toString());
                }
                choice = console.getIntegerInput("Which one do you want to choose? ");
                if(choice == 0){}
                else if(choice < 1 || choice > 13){
                    console.println("Please pick an option within the bounds.");
                }
                else if(this.availableOptionsName[choice].equals(" ")){
                    console.println("Box already picked.  Please choose again.");
                }
                else{
                    availableOptionsNames[choice] = " ";
                    evaluated = true;
                }
            }
            catch(Exception NumberFormatException){
                console.println("Please enter a number.");
                choice = 0;
            }
        }

        switch (choice){
            case 1: return checkForFaces(diceValues, 1);
            case 2: return checkForFaces(diceValues, 2);
            case 3: return checkForFaces(diceValues, 3);
            case 4: return checkForFaces(diceValues, 4);
            case 5: return checkForFaces(diceValues, 5);
            case 6: return checkForFaces(diceValues, 6);
            case 7: return checkFor3Kind(diceValues);
            case 8: return checkFor4Kind(diceValues);
            case 9: return checkForSmallStraight(diceValues);
            case 10: return checkForLargeStraight(diceValues);
            case 11: return checkForFullHouse(diceValues);
            case 12: return checkForYahtzee(diceValues);
            case 13: return chance(diceValues);
        }
        return 0;
    }
*/

    public int checkForFaces(Integer[] diceValues, int valueToLookFor){
        int results = 0;
        for(int i = 0; i < diceValues.length; i++){
            if(diceValues[i] == valueToLookFor){
                results += valueToLookFor;
            }
        }
        return results;
    }

    public int chance(Integer[] diceValues){
        int points = 0;
        for(int i = 0; i < diceValues.length; i++){
            points += diceValues[i];
        }
        return points;
    }

    public int checkFor3Kind(Integer[] diceValues){
        int counter;
        for(int i = 0; i < diceValues.length - 2; i++){
            counter = 1;
            for(int j = i + 1; j < diceValues.length; j++){
                if(diceValues[i] == diceValues[j]){
                    counter++;
                }
            }
            if(counter >= 3){ return this.chance(diceValues); }
        }
        return 0;
    }

    public int checkFor4Kind(Integer[] diceValues){
        int counter;
        for(int i = 0; i < diceValues.length - 3; i++){
            counter = 1;
            for(int j = i + 1; j < diceValues.length; j++){
                if(diceValues[i] == diceValues[j]){
                    counter++;
                }
            }
            if(counter >= 4){
                return this.chance(diceValues);
            }
        }
        return 0;
    }

    public int checkForFullHouse(Integer[] diceValues){
        if(this.checkFor3Kind(diceValues) != 0){
            int counter;
            for(int i = 0; i < diceValues.length - 2; i++){
                counter = 1;
                for(int j = 0; j < diceValues.length; j++){
                    if(diceValues[i] == diceValues[j] && i !=j){
                        counter++;
                    }
                }
                if(counter == 2){
                    return 25;
                }
            }
        }
        return 0;
    }

    public int checkForSmallStraight(Integer[]diceValues){
        boolean found1 = false;
        boolean found2 = false;
        boolean found3 = false;
        boolean found4 = false;
        boolean found5 = false;
        boolean found6 = false;

        for (int i = 0; i < diceValues.length; i++){
            if(diceValues[i] == 1){ found1 = true; }
            else if(diceValues[i] == 2){ found2 = true; }
            else if(diceValues[i] == 3){ found3 = true; }
            else if(diceValues[i] == 4){ found4 = true; }
            else if(diceValues[i] == 5){ found5 = true; }
            else if(diceValues[i] == 6){ found6 = true; }
        }
        if((found1 && found2 && found3 && found4)||
                (found2 && found3 && found4 && found5)||
                (found3 && found4 && found5 && found6)){

            return 30;
        }


        return 0;
    }

    public int checkForLargeStraight(Integer[]diceValues){
        boolean found1 = false;
        boolean found2 = false;
        boolean found3 = false;
        boolean found4 = false;
        boolean found5 = false;
        boolean found6 = false;

        for (int i = 0; i < diceValues.length; i++){
            if(diceValues[i] == 1){ found1 = true; }
            else if(diceValues[i] == 2){ found2 = true; }
            else if(diceValues[i] == 3){ found3 = true; }
            else if(diceValues[i] == 4){ found4 = true; }
            else if(diceValues[i] == 5){ found5 = true; }
            else if(diceValues[i] == 6){ found6 = true; }
        }
        if((found1 && found2 && found3 && found4 && found5)||
                (found2 && found3 && found4 && found5 && found6)){

            return 40;
        }
        return 0;
    }

    public int checkForYahtzee(Integer[] diceValues){
        for(int i = 0; i < diceValues.length; i++){
            if(diceValues[0] != diceValues[i]){
                return 0;
            }
        }
        return 50;
    }
/*
    public Integer[] getDiceValues(){
        Integer[] values = new Integer[5];
        for(int i = 0; i < this.myDice.length; i++){
            values[i] = this.myDice[i].getValue();
        }
        return values;

    }
*/

}
