package io.zipcoder.casino.DiceGames.Craps;

import io.zipcoder.casino.DiceGames.Dices.Dice;
import io.zipcoder.casino.DiceGames.Dices.DiceGame;
import io.zipcoder.casino.Games.Game;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;

public class Craps extends DiceGame implements Game {
    Console console = new Console(System.in,System.out);
    Dice dice = new Dice();

    private ArrayList<Dice> thrownDice;
    private Integer sumOfDice;
    private Integer pointNumber;

    public void runGame() {
        int playOrDont = console.getIntegerInput("Would you like to sit at the Craps table?\nEnter 1 for yes or 2 to exit to casino floor.");
        if(playOrDont == 1) {
            int passOrDont = console.getIntegerInput("What would you like to bet\n1 for PASS LINE or 2 for DON'T PASS BAR");
            crapsStart();
        }else {
            System.out.println("Thank you for visiting the Craps Table.");

        }
    }

    public void wager(){
        double tablePot = console.getDoubleInput("Please enter your wager.");
    }
    public void askWagerOntSecondToss(){
        double askPhase2 = console.getDoubleInput("Do you want to add a wager for the second toss?");
    }



    private void crapsStart() {
        int point = 0;
        GameState state;

        Double tablePot = console.getDoubleInput("Please enter your wager.");
        // bet pass line to win on 7 or 11 roll
        // lose at 2,3,12
        // dont pass bar to win at 2,3, push even at 12
        // will also win with 7 after point phase

        int sumOfDices = dice.roll2Dices();
//        System.out.println(sumOfDices);
        switch (sumOfDices){
            case Seven:
            case Yoleven:
                state = GameState.won;
                break;

            case SnakeEyes:
            case AceDuece:
            case BoxCars:
                state = GameState.lose;
                break;

            default:
                // 4,5,66,8,9,10 are point numbers
                state = GameState.Continue;
                point = sumOfDices;
                System.out.println("Place number is" + " " + point);
                // come bet to win at 7 or 11
                // field bet to win on next roll , 3,4,9,10,11. double for 2 & 12
                askWagerOntSecondToss();


                double tablePot2 = console.getDoubleInput("Please enter your wager.");
                while(state == GameState.Continue) {


                int sumOfDices2 = dice.roll2Dices2();

                if (sumOfDices2 == point) {
                    state = GameState.won;

                } else if (sumOfDices2 == Seven) {
                    state = GameState.lose;
                    System.out.println("Out Seven");

                } else {

                    System.out.println(sumOfDices2);

                }
                    System.out.println(sumOfDices2);
            }
        }
        if(state == GameState.won){

            System.out.println("You won!" + tablePot);

        } else {
            System.out.println("You lost!" + tablePot);
        }
    }



    public void getResults() {
    }

    public void endGame() {

    }


    private enum GameState{
        Continue,
        won,
        lose
    }

    private static final int SnakeEyes = 2;
    private static final int AceDuece= 3;
    private static final int Seven = 7;
    private static final int Yoleven = 11;
    private static final int BoxCars = 12;


}




