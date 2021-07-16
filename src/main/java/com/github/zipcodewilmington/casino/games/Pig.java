package com.github.zipcodewilmington.casino.games;
//package com.github.zipcodewilmington.utils;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Random;
import java.util.Scanner;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PigMenus;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.concurrent.ThreadLocalRandom;


import static com.github.zipcodewilmington.casino.PigMenus.welcomeScreen;


public class Pig implements GameInterface {
  public static void main(String[] args){
    Pig pig = new Pig();
    pig.run();
  }

  // private static int playerTwo = 2;
  // private static int playerOne = 1;
  // private static int scoreToWin = 100;
  private int currentTurn;
  private int dieValue;
  private int turnScore;
  private int pOneTotal;
  private int pTwoTotal;
  private String  rollAnswer;
  private int rollCounter;
  public Scanner input = new Scanner(System.in);
  //Random generator = new Random();
  // ThreadLocalRandom current = ThreadLocalRandom.current();

  public Pig() {

  }

//  public void welcomeToPig () {
//  PigMenus.welcomeMenu();
//  }

  public String currentStateOfTheGame () {
    return "Player 1 has " + pOneTotal + " points. \n Player 2 has " + pTwoTotal + " points.";
  }

  public int playerTurn () {


      System.out.println("Please enter 'r' to roll or 'h' to hold");
      //input.nextLine();
      rollAnswer = input.next();
      if (rollAnswer == "r'") {
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
      } else if (rollAnswer == "h") {
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
    if (pOneTotal >= 15) {
      System.out.println("Player 1 won!");
      return true;
    } else if (pTwoTotal >= 15) {
      System.out.println("Player 2 won!");
      return true;
    } return false;
  }



  public void add(PlayerInterface player) {

  }

  public void remove(PlayerInterface player) {

  }

  public void run(){
      //welcomeToPig();

      currentTurn = 1;
      pOneTotal = 0;
      pTwoTotal = 0;



      while (getWinner() == false) {
        playerTurn();

    }

  }
}













