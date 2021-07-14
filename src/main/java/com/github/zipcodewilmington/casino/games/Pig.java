package com.github.zipcodewilmington.casino.games;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Pig {

  private static int scoreToWin = 100;
  private int dieValue;
  private int rollCounter;
  private int turnScore;
  private int pOneTotal;
  private int pTwoTotal;
  private String rollAnswer = "0";
  private char startTurn;
  public Scanner input = new Scanner(System.in);


  public void welcomeToPig(){
    //welcome screen
    //log player 2 in or create account
    //the rules
  }

  public void playerTurn(){
    System.out.println("Please enter 'r' to roll or 'h' to hold");
    input.nextLine();
    rollAnswer = input.nextLine();
    if(rollAnswer == "r"){
      dieValue = ThreadLocalRandom.current().nextInt(1, 7);
      System.out.println("You rolled a " + dieValue);
    } if (dieValue == 1){

    }

  }












  }

