package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Pig implements GameInterface {
  public static void main(String[] args){
    Pig Pig = new Pig();
  }
  // private static int playerTwo = 2;
  // private static int playerOne = 1;
  // private static int scoreToWin = 100;
  private int currentTurn;
  private int dieValue;
  private int rollCounter = 0;
  private int turnScore;
  private int pOneTotal;
  private int pTwoTotal;
  private int  rollAnswer;
  public Scanner input = new Scanner(System.in);
  //Random generator = new Random();
  // ThreadLocalRandom current = ThreadLocalRandom.current();
  //public void welcomeToPig () {
  //welcome screen
  //log player 2 in or create account
  //the rules
  // }

  public String currentStateOfTheGame () {
    return "Player 1 has " + pOneTotal + " points. \n Player 2 has " + pTwoTotal + " points.";
  }

  public int playerTurn () {


      System.out.println("Please enter 1 to roll or 0 to hold");
      //input.nextLine();
      rollAnswer = input.nextInt();
      if (rollAnswer == 1) {
        Random generator = new Random();
        dieValue = generator.nextInt(6) + 1;
        turnScore += dieValue;
        // dieValue = ThreadLocalRandom.current().nextInt(1, 7);
        if (dieValue == 1) {
          currentTurn++;
          turnScore = 0;
          System.out.println("You rolled a 1; your turn is over and any banked points have been lost.");
          switchingPlayers();
        } else {
          System.out.println("You rolled a " + dieValue);
          rollCounter++;
          System.out.println("Player earned " + turnScore + " points.");
          playerTurn();
        }
      } else if (rollAnswer == 0) {
        currentTurn++;
        switchingPlayers();
      }


    return turnScore;
  }


  public void switchingPlayers () {
    if (currentTurn % 2 == 0) {
      pOneTotal += turnScore;
      System.out.println("It's Player 2's turn.");
    } else {
      pTwoTotal += turnScore;
      System.out.println("It's Player 1's turn");
    }
    turnScore = 0;
    System.out.println(currentStateOfTheGame());
    playerTurn();
  }

  public boolean getWinner(){
    if (pOneTotal >= 100) {
      System.out.println("Player 1 won!");
      return true;
    } else if (pTwoTotal >= 100) {
      System.out.println("Player 2 won!");
      return true;
    } return false;
  }


  public Pig() {

    currentTurn = 1;
    pOneTotal = 0;
    pTwoTotal = 0;

    while (!getWinner()) {
      playerTurn();
    }
  }

  public void add(PlayerInterface player) {

  }

  public void remove(PlayerInterface player) {

  }

  public void run() {

  }
}













