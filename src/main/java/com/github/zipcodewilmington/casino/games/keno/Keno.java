package com.github.zipcodewilmington.casino.games.keno;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Random;
import java.util.Scanner;

public class Keno implements GameInterface, PlayerInterface {
    int playerNumbers[] = new int[15];
    int computerGeneratedNumbers[] = new int[20];
    int kenoSpot, kenoCatch;
    boolean continueGame = true;
    Integer bet;
    Player player;
    Integer multiplier;

    public Integer getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Integer multiplier) {
        this.multiplier = multiplier;
    }



    public void setPlayerNumbers(int[] playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    @Override
    public void add(PlayerInterface player) {
    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        //playerNums = getUserInput();
        //bet = getBet(player.getBalance());
        //player.makeBet(bet);
        computerGeneratedNumbers = getComputerGeneratedNames();
        kenoSpot = getSpot(playerNumbers);
        kenoCatch = getCatch(playerNumbers, computerGeneratedNumbers);
        System.out.println("Catch: " + (kenoCatch + 1));
        Integer winningsAmount = 0;

        Integer winnings[][] =
                {
                        {7, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {3, 9, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0},
                        {4, 2, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 10, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 3, 15, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 1, 2, 3, 30, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {6, 0, 1, 6, 12, 64, 100, 0, 0, 0, 0, 0, 0, 0, 0},
                        {3, 0, 1, 3, 6, 30, 90, 120, 0, 0, 0, 0, 0, 0, 0},
                        {2, 0, 1, 2, 4, 8, 20, 80, 1200, 0, 0, 0, 0, 0, 0},
                        {1, 0, 1, 2, 3, 5, 10, 30, 600, 1800, 0, 0, 0, 0, 0},
                        {0, 1, 1, 1, 2, 6, 15, 25, 180, 1000, 3000, 0, 0, 0, 0},
                        {0, 0, 5, 1, 2, 4, 24, 72, 250, 500, 2000, 4000, 0, 0, 0},
                        {0, 0, 4, 0, 3, 4, 5, 20, 80, 240, 500, 3000, 6000, 0, 0},
                        {0, 0, 0, 0, 2, 3, 5, 12, 50, 150, 500, 1000, 2000, 7500, 0},
                        {0, 0, 0, 0, 1, 2, 5, 15, 50, 150, 300, 600, 1200, 2500, 10000}
                };
        if(kenoCatch < 0)
        {
            multiplier = 0;
        }
        else
            multiplier=winnings[kenoSpot][kenoCatch];

    }


    public static int getCatch(int[] playerArray, int[] computerArray)
    {
        int playerIndex;
        int computerIndex;
        int kenoCatch = 0;
        for (playerIndex = 0; playerIndex < playerArray.length; playerIndex++)
        {
            for(computerIndex = 0; computerIndex < computerArray.length; computerIndex++)
            {
                if(playerArray[playerIndex] == computerArray[computerIndex])
                {
                    kenoCatch++;
                }
            }
        }
        kenoCatch-=1;
        return kenoCatch;
    }

    public static int getSpot(int[] playerArray)
    {
        int index;
        int spot = 0;
        for (index = 0; index < playerArray.length; index++)
        {
            if(playerArray[index] != 0)
            {
                spot++;
            }

        }
        spot -= 1; //Subtract one so it works properly in array
        return spot;
    }

    public static int[] getComputerGeneratedNames()
    {
        int[] computerNums = new int[20];
        Random rand = new Random();
        int index;
        int randomNumber = 0;

        for (index = 0; index < computerNums.length; index++)
        {
            randomNumber = rand.nextInt(80) + 1;
            if(isUnique(randomNumber, computerNums))
            {
                computerNums[index] = randomNumber;
            }
            else
            {
                index--;
            }

        }
        return computerNums;
    }

    public static int[] getUserInput()
    {
        Scanner input = new Scanner(System.in); // for input
        boolean invalidInput = true;
        boolean continuePlayer = true;
        int playerNums[] = new int[15];
        int index;
        int numberEntered;
        String enterString;
        System.out.println("You may enter up to 15 numbers");
        for (index = 0; index < playerNums.length; index++ )
        {
            playerNums[index] = 0;
        }
        index = 0;
        while(continuePlayer && index < 15)
        {
            do
            {
                do
                {
                    System.out.println("Enter number " + (index+1));
                    numberEntered = input.nextInt();
                    if ((numberEntered > 0) && (numberEntered < 81))
                    {
                        if(isUnique(numberEntered, playerNums))
                        {
                            invalidInput = false;
                            playerNums[index] = numberEntered;
                        }
                        else
                        {
                            System.out.println("Sorry, you already entered that number before!");
                            System.out.println("Try again!	");
                            invalidInput = true;
                        }
                    }
                    else
                    {
                        invalidInput = true;
                        System.out.println("Sorry, the number you entered is either less than 0 or greater than 80");
                        System.out.println("Try again");
                        System.out.println("");
                    }
                } while(invalidInput);

            }while(invalidInput);

            index++;
        }
        return playerNums;
    }

    public static boolean isUnique(int number, int[] array)
    {
        int index;
        for (index = 0; index < array.length; index++)
        {
            if(number == array[index])
            {
                return false;
            }
        }
        return true;
    }


    @Override
    public Integer calculateWinnings(Integer multiplier, Integer betAmount) {
        return this.multiplier*betAmount;
    }

    @Override
    public void subtractBetFromBalance(Integer betAmount) {
        player.setBalance(player.getBalance()-betAmount);
    }

    @Override
    public void addMoneyToBalance(PlayerInterface Player, Integer winnings) {

    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return null;
    }
}
