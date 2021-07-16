package com.github.zipcodewilmington.casino.games;


import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;



import java.util.Random;
import java.util.Scanner;


import static com.github.zipcodewilmington.casino.PigMenus.*;


public class Pig implements GameInterface {

  Casino casino;

  public static void main(String[] args){
    Pig pig = new Pig();
    pig.run();
  }

  private int currentTurn;
  private int dieValue;
  private int turnScore;
  public int pOneTotal;
  public int pTwoTotal;
  private String  rollAnswer;
  private int rollCounter;
  public Scanner input = new Scanner(System.in);
  // ThreadLocalRandom current = ThreadLocalRandom.current();

  public Pig() {
  }

public void welcomeToPig () {
  playerTwoWon();
 }

  public String currentStateOfTheGame () {
   currentStateScreen();
    return  "|*****                    Player 1 has " + pOneTotal + " points.                  *****|\n" +
            "|*****                    Player 2 has " + pTwoTotal + " points.                  *****|\n" +
            "|**********************************************************************|\n" +
            "|**********************************************************************|\n";

  }

  public int playerTurn () {
      System.out.println("Please enter 'r' to roll or 'h' to hold");
      //input.nextLine();
      rollAnswer = input.next();
      if (rollAnswer.equals("r")) {
        Random generator = new Random();
        dieValue = generator.nextInt(6) + 1;
        turnScore += dieValue;
        // dieValue = ThreadLocalRandom.current().nextInt(1, 7);
        if (dieValue == 1) {
          currentTurn++;
          turnScore = 0;
          youRolledAOne();
          switchingPlayers();
        } else {

          rollCounter++;
          System.out.println("Player earned " + turnScore + " points.");
          playerTurn();
        }
      } else if (rollAnswer.equals("h")) {
        currentTurn++;
        switchingPlayers();
      }
    return turnScore;
  }

  public void switchingPlayers () {
    if (currentTurn % 2 == 0) {
      pOneTotal += turnScore;
    } else {
      pTwoTotal += turnScore;
    }
    getWinner();
    if (getWinner() == false) {
      turnScore = 0;
      System.out.println(currentStateOfTheGame());
      playerTurn();
    }
  }

  public boolean getWinner(){
    if (pOneTotal >= 10) {
      player1Wins();
      return true;
    } else if (pTwoTotal >= 10) {
      player2Wins();
      return true;
    } return false;
  }

  public void player1Wins(){
    playerOneWon();
    System.out.println( "|*****                    Player 1 has " + pOneTotal + " points.                 *****|\n" +
            "|*****                    Player 2 has " + pTwoTotal + " points.                  *****|\n" +
            "|**********************************************************************|\n" +
            "|**********************************************************************|\n");

  }

  public void player2Wins(){
    playerTwoWon();
    System.out.println( "|*****                    Player 1 has " + pOneTotal + " points.                  *****|\n" +
            "|*****                    Player 2 has " + pTwoTotal + " points.                 *****|\n" +
            "|**********************************************************************|\n" +
            "|**********************************************************************|\n");

  }

  public void doYouWantToPlayAgain(){
    System.out.println("Do you want to play again?\n" + "Enter 'y' to start again\n" + "Enter 'q' to quit to the main menu\n");
    String playAgain = input.next();
    if (playAgain.equals("y")){
      pOneTotal = 0;
      pTwoTotal = 0;
      currentTurn =0;
      playerTurn();
    } else if (playAgain.equals("q")){
      casino.run();
    }
  }

  public int roll(){
    return 1;
  }


  @Override
  public void add(PlayerInterface player) {

  }

  @Override
  public void remove(PlayerInterface player) {

  }

  public void run(){
    welcomeToPig();
      currentTurn = 1;
      pOneTotal = 0;
      pTwoTotal = 0;

      while (getWinner() == false) {
        playerTurn();

    }
  }
}













