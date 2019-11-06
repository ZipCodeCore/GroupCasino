package io.zipcoder.casino.DiceGames;

import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;

public class Yahtzee implements Game {

    //------------------------------------------------------------------------------------------------------------------
    // Fields-----------------------------------------------------------------------------------------------------------

    private Player user;
    private static Console console = new Console(System.in, System.out);
    private Dice[] myDice;
    private int points;
    private String[] availableOptions = {" ","1s", "2s", "3s", "4s", "5s", "6s", "3 of a kind", "4 of a kind",
                                         "Small Straight", "Large Straight", "Full House", "Yahtzee", "Chance"};
    private boolean continuePlay;

    //------------------------------------------------------------------------------------------------------------------
    // Constructor------------------------------------------------------------------------------------------------------

    public Yahtzee(Player player){
        this.user = player;
        this.myDice = createDice();
        this.points = 0;
        continuePlay = true;
    }


    //------------------------------------------------------------------------------------------------------------------
    // Method called to play the game-----------------------------------------------------------------------------------

    public void startGame(){
        console.println("Welcome to Yahtzee!");
        console.getStringInput("\nPress enter to begin.");

        while(continuePlay) {
            for (int i = 0; i < 13; i++) {
                resetDice();
                console.getStringInput("Press enter to make your first roll.");
                console.println("First roll results:");
                roll5Dice();
                chooseToKeep();
                console.getStringInput("Press enter to make your second roll.");
                console.println("Second roll results:");
                roll5Dice();
                chooseToKeep();
                console.getStringInput("Press enter to make your final roll.");
                console.println("Final roll results:");
                roll5Dice();
                int pointsAdded = checkForEvaluation(chooseEvaluation(), getDiceValues());
                updateScore(pointsAdded);
            }
            displayResults();
            promptLeaveGame();
            if (!this.continuePlay) { return; }
        }
    }


    //------------------------------------------------------------------------------------------------------------------
    // Method for game setup and score keeping--------------------------------------------------------------------------

    public Dice[] createDice(){
        Dice[] dice = new Dice[5];
        for(int i = 0; i < dice.length; i++){
            dice[i] = new Dice();
        }
        return dice;
    }

    private void updateScore(int pointsAdded) {
        console.println("points added: " + pointsAdded);
        this.points += pointsAdded;
        console.println("Your current score is: " + this.points);
    }

    public void displayResults(){
        console.println("Your final score is: " + this.getPoints());
    }

    public void promptLeaveGame(){
        String exitOrNo;
        boolean c = false;
        while (!c) {

            exitOrNo = console.getStringInput("Would you like to play again?\n1. Play again\n2. Exit");

            if(exitOrNo.equals("")){
                exitOrNo = " ";
            }

            switch (exitOrNo.charAt(0)) {
                case '1': case 'p': case 'P':
                    this.continuePlay = true;
                    c = true;
                    break;
                case '2': case 'e': case 'E':
                    this.continuePlay = false;
                    c = true;
                    break;
                default:
                    console.println("Please choose one of the options.");
                    break;
            }
        }
    }


    //------------------------------------------------------------------------------------------------------------------
    // Following methods are for rolling dice and choosing which ones to keep-------------------------------------------

    public void resetDice(){
        for(int i = 0; i < myDice.length; i++){
            myDice[i].setKept(false);
        }
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
            for(int i = 0; i < myDice.length; i++){
                console.print(this.getDiceArt(myDice[i],i + 1));
            }
            keepthis = console.getStringInput("\n\nType the corresponding number of the dice and press enter to " +
                                                      "switch it between keeping and re-rolling.\n" +
                                                      "Type 'continue' when finished\n");
            if(keepthis.equals("")){ keepthis = " "; }

            switch (keepthis.charAt(0)){
                case '1': this.myDice[0].keptOrRolled();    break;
                case '2': this.myDice[1].keptOrRolled();    break;
                case '3': this.myDice[2].keptOrRolled();    break;
                case '4': this.myDice[3].keptOrRolled();    break;
                case '5': this.myDice[4].keptOrRolled();    break;
                case 'c': keepthis = "roll";                break;
                default:                                    break;
            }
        }
    }


    //------------------------------------------------------------------------------------------------------------------
    // Following methods are for evaluating the dice at the end of three rolls------------------------------------------

    public int chooseEvaluation(){
        int choice = 0;
        boolean goodChoice = false;

        for(int i = 0; i < myDice.length; i++){
            console.print(this.getDiceArt(myDice[i],i + 1));
        }

        for(int i = 1; i < availableOptions.length; i++) { console.println((i) + ".  " + availableOptions[i]); }

        while(!goodChoice){
            try{

                choice = console.getIntegerInput("\n\nWhich one do you want to choose? ");
                if(choice == 0){}
                else if(choice < 1 || choice > 13){
                    console.println("Please pick an option within the bounds.");
                }
                else if(this.availableOptions[choice].equals(" ")){
                    console.println("Box already picked.  Please choose again.");
                }
                else{
                    availableOptions[choice] = " ";
                    goodChoice = true;
                }
            }
            catch(Exception NumberFormatException){
                console.println("Please enter a number.");
                choice = 0;
            }
        }
        return choice;
    }

    public int checkForEvaluation(int choice,Integer[] diceValues){

        switch (choice){
            case 1: return checkForFaces(diceValues, 1);
            case 2: return checkForFaces(diceValues, 2);
            case 3: return checkForFaces(diceValues, 3);
            case 4: return checkForFaces(diceValues, 4);
            case 5: return checkForFaces(diceValues, 5);
            case 6: return checkForFaces(diceValues, 6);
            case 7: return checkForSameKind(diceValues, 3);
            case 8: return checkForSameKind(diceValues,4);
            case 9: return checkForStraight(diceValues, 4);
            case 10: return checkForStraight(diceValues, 5);
            case 11: return checkForFullHouse(diceValues);
            case 12: return checkForYahtzee(diceValues);
            case 13: return chance(diceValues);
            default: return 0;
        }
    }

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

    public int checkForSameKind(Integer[] diceValues, int threeOrFour){
        int counter;
        for(int i = 0; i < diceValues.length - (threeOrFour - 1); i++){
            counter = 1;
            for(int j = i + 1; j < diceValues.length; j++){
                if(diceValues[i] == diceValues[j]){
                    counter++;
                }
            }
            if(counter >= threeOrFour){ return this.chance(diceValues); }
        }
        return 0;
    }

    public int checkForFullHouse(Integer[] diceValues){
        if(this.checkForSameKind(diceValues, 3) != 0){
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


    public int checkForStraight(Integer[]diceValues, int size){
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
        switch(size){
            case 4:
                if((found1 && found2 && found3 && found4)||
                        (found2 && found3 && found4 && found5)||
                        (found3 && found4 && found5 && found6)){
                    return 30;
                }
            case 5:
                if((found1 && found2 && found3 && found4 && found5)||
                        (found2 && found3 && found4 && found5 && found6)){
                    return 40;
                }
            default:
                return 0;
        }
    }

    public int checkForYahtzee(Integer[] diceValues){
        for(int i = 0; i < diceValues.length; i++){
            if(diceValues[0] != diceValues[i]){
                return 0;
            }
        }
        return 50;
    }


    //------------------------------------------------------------------------------------------------------------------
    // getters and setters----------------------------------------------------------------------------------------------

    public Integer[] getDiceValues(){
        Integer[] values = new Integer[5];
        for(int i = 0; i < this.myDice.length; i++){
            values[i] = this.myDice[i].getValue();
        }
        return values;
    }

    public Player getUser() {
        return user;
    }

    public void setUser(Player user) {
        this.user = user;
    }

    public Dice[] getMyDice() {
        return myDice;
    }

    public void setMyDice(Dice[] myDice) {
        this.myDice = myDice;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }





    public String getDiceArt(Dice dice, int index){

        String keepOrReRoll;
        if(dice.isKept()){
            keepOrReRoll = "Keep";
        }
        else{
            keepOrReRoll = "Re-roll";
        }
        String d1 = " ";
        String d2 = " ";
        String d3 = " ";
        String d4 = " ";
        String d5 = " ";
        String d6 = " ";
        String d7 = " ";

        switch (dice.getValue()){
            case 1:
                d4 = "0";
                break;
            case 2:
                d1 = "0";
                d7 = "0";
                break;
            case 3:
                d1 = "0";
                d4 = "0";
                d7 = "0";
                break;
            case 4:
                d1 = "0";
                d2 = "0";
                d6 = "0";
                d7 = "0";
                break;
            case 5:
                d1 = "0";
                d2 = "0";
                d4 = "0";
                d6 = "0";
                d7 = "0";
                break;
            case 6:
                d1 = "0";
                d2 = "0";
                d3 = "0";
                d5 = "0";
                d6 = "0";
                d7 = "0";
                break;

        }
        return String.format(
                        "     ###############\n"+
                        "     #  %s       %s  #\n"+
                        "     #             #\n"+
                 index + ".   #  %s   %s   %s  #     "+ keepOrReRoll + "\n"+
                        "     #             #\n"+
                        "     #  %s       %s  #\n"+
                        "     ###############\n",
                            d1,d2,d3,d4,d5,d6,d7);
    }
}