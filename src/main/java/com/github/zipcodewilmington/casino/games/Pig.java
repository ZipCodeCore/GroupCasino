package com.github.zipcodewilmington.casino.games;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Pig {

  private final int numOfDice = 1;
  private int dieValue;
  private int rollCounter;
  private int turnScore;
  private int pOneTotal;
  private int pTwoTotal;
  private char rollAgainAnswer;
  private char startTurn;
  public Scanner input;


  public Pig() {

    Scanner input = new Scanner(System.in);
  }

  //will open with a welcome screen
    //get player 2
    //the rules
    //s to start

    public void pig(){

    }

    public void playPig(){

    }

    public int rollDie(){
      dieValue = ThreadLocalRandom.current().nextInt(1, 7);
      System.out.println("You rolled a " + dieValue);
      return dieValue;
    }

}
