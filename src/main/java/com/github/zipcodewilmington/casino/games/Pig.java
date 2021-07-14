package com.github.zipcodewilmington.casino.games;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Pig{
  public static void main(String[] args){
   Pig Pig = new Pig();
  }
    private static int playerTwo = 2;
    private static int playerOne = 1;
    private static int scoreToWin = 100;
    private int currentTurn;
    private int dieValue;
    private int rollCounter = 0;
    private int turnScore;
    private int pOneTotal;
    private int pTwoTotal;
    private int  rollAnswer;
    private String startTurn = "";
    public Scanner input = new Scanner(System.in);
  Random generator = new Random();
 // ThreadLocalRandom current = ThreadLocalRandom.current();
    //public void welcomeToPig () {
      //welcome screen
      //log player 2 in or create account
      //the rules
  // }

  public String currentStateOfTheGame () {
    return "It is Player " + currentTurn + "'s turn. \n Player 1 has " +
            pOneTotal + " points. \n Player 2 has " + pTwoTotal + " points.";
  }

  public void playerTurn (){
    while (rollCounter <= 5)
      System.out.println("Please enter 1 to roll or 0 to hold");
      //input.nextLine();
      rollAnswer = input.nextInt();
      if (rollAnswer == 1) {
        dieValue = generator.nextInt(6) + 1;
        // dieValue = ThreadLocalRandom.current().nextInt(1, 7);
        if (dieValue == 1) {
          System.out.println("You rolled a 1; your turn is over and any banked points have been lost.");
          System.out.println("Next player enter 'r' to roll the die!");
          input.nextLine();
          startTurn = input.nextLine();
        }
      }else {
        System.out.println("You rolled a " + dieValue);
        turnScore += dieValue;
        rollCounter += 1;
        playerTurn();
      }
     if (currentTurn % 2 != 1) {
        pOneTotal += turnScore;
      } else {
        pTwoTotal += turnScore;
      }
      System.out.println("Player " + currentTurn + "earned " + turnScore + " points.");
    }


  public void switchingPlayers () {
    System.out.println(currentStateOfTheGame());
    if (currentTurn % 2 == 0) {
      System.out.println("It's Player 2's turn.");
    } else {
      System.out.println("It's Player 1's turn");
    }
    playerTurn();
  }

  private boolean getWinner(){
    if (pOneTotal == 100) {
      System.out.println("Player 1 won!");
    } else if (pTwoTotal == 100) {
      System.out.println("Player 2 won!");
    } return false;
  }


  public Pig() {
    currentTurn = 1;
    pOneTotal = 0;
    pTwoTotal = 0;

    while (!getWinner()) {
      switchingPlayers();
    }
  }
  }













