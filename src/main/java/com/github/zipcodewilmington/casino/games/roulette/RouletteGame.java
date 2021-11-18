package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class RouletteGame implements GameInterface {
    private Integer[] red;
    private Integer[] black;
    private Integer choice;
    private Integer wins;
    private Integer loses;
    private Integer spins;
    private Double betAmount;
    private Double balance;
    private String response;
    private Integer rouletteNumber;
    private RoulettePlayer roulettePlayer;


    private final IOConsole consoleRed = new IOConsole(AnsiColor.PURPLE);
    // private final IOConsole console2 = new IOConsole(AnsiColor.GREEN);

    public RouletteGame() {

        this.roulettePlayer = new RoulettePlayer(); //Composition
        this.balance = roulettePlayer.getArcadeAccount().getBalance();
        this.rouletteNumber = null;
        this.red = new Integer[]{1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
        this.black = new Integer[]{2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};
    }


    public void printBalance(){
        System.out.println(getBalance());

    }


    public void evenChoice() {
      this.rouletteNumber = ThreadLocalRandom.current().nextInt(1, 36);
        System.out.println("Roulette Number: " + this.rouletteNumber);
        String result = "";

        if (rouletteNumber % 2 == 0) {
           this.balance += betAmount * 2;
            result = ("you won $" + betAmount * 2);


        } else {
           this.balance -= betAmount;
            result = "you lost";
        }

        consoleRed.println(result);
        System.out.println("your balance is: " + this.balance);
    }

    public void oddChoice() {
        this.rouletteNumber = ThreadLocalRandom.current().nextInt(1, 36);
        System.out.println("Roulette Number: " + this.rouletteNumber);
        String result = "";

        if (rouletteNumber % 2 == 1) {
            this.balance += betAmount * 2;
            result = "you won $" + betAmount * 2;

        } else {
            this.balance -= betAmount;
            result = "you lost ";
        }

        consoleRed.print(result);
       consoleRed.println("Your Balance is: $" + this.balance);
    }

    public void redChoice() {
        this.rouletteNumber = ThreadLocalRandom.current().nextInt(1, 36);
        System.out.println("Roulette Number: " + this.rouletteNumber);
        String result = "";


        for (Integer num : this.red) {
            if (num == this.rouletteNumber) {
                this.balance += betAmount * 2;
                result = "you won $" + betAmount * 2;

                break;
            }
            else {
                this.balance -= betAmount;
                result = "you lost";
                break;
            }
        }
        consoleRed.println(result);
        System.out.println("Your Balance is: $" + this.balance);
    }

    public void blackChoice() {
        this.rouletteNumber = ThreadLocalRandom.current().nextInt(1, 36);
        String result = "";
        System.out.println("Roulette Number: " + this.rouletteNumber);
        for (Integer num : this.black) {
            if (num == this.rouletteNumber) {
                this.balance += betAmount * 2;
                result = "you won $" + betAmount * 2;
                break;
            } else {
                this.balance -= betAmount;
                result = "you lost";
                break;
            }
        }
        consoleRed.println(result);
        System.out.println("Your Balance is: $" + this.balance);
    }

    public void pickNumberChoice(){
        this.rouletteNumber = ThreadLocalRandom.current().nextInt(1, 36);
        String result = "";
        System.out.println(this.rouletteNumber); // to test if number matches
        Integer number = consoleRed.getIntegerInput("Place your bet on number(1-36): ");

        if(this.rouletteNumber == number){
         this.balance += betAmount * 35;
            result = ("you won $" + betAmount * 35);

        } else {
      this.balance -= betAmount;
            result = "you lost";
        }
     consoleRed.println(result);
        System.out.println("Your Balance is: $" + this.balance);
    }

    public void betweenOneAndEighteen(){
        this.rouletteNumber = ThreadLocalRandom.current().nextInt(1, 36);
     String result ="" ;
      System.out.println("Roulette Number: " + this.rouletteNumber);
     if(this.rouletteNumber >= 1 && this.rouletteNumber <= 18){
         this.balance += betAmount * 2;
        result = "you won $" + (betAmount * 2);

     }else {
         this.balance -= betAmount;
       result = "you lost"  ;
     }

     consoleRed.println(result);
        System.out.println("Your Balance is: $" + this.balance);
    }

    public void betweenNineteenAndThirtySix(){
        this.rouletteNumber = ThreadLocalRandom.current().nextInt(1, 36);
        String result ="" ;
        System.out.println("Roulette Number: " + this.rouletteNumber);

        if(this.rouletteNumber >= 19 && this.rouletteNumber <= 36){
            this.balance += betAmount * 2;
            result = "you won $" + (betAmount *2);

        }else {
            this.balance -= betAmount;
            result = "you lost"  ;
        }

        consoleRed.println(result);
        System.out.println("Your Balance is: $" + this.balance);
    }


    public Double rouletteGame() {
     do {
            consoleRed.println("Welcome to the Roulette Game!!!");
            this.betAmount = consoleRed.getDoubleInput("Please enter amount you would like to bet");
            consoleRed.println("PLease choose from the options below");
            choice = consoleRed.getIntegerInput("(1)Red  (2)Black  (3)Even  (4)Odd  (5)Pick Number (6)Low 1 to 18  (7)High 19 to 36");

            while (choice < 0 || choice > 7) {
                consoleRed.println("PLease choose from the options below");
                choice = consoleRed.getIntegerInput("(1)Red  (2)Black  (3)Even  (4)Odd  (5)Pick Number (6)Low 1 to 18  (7)High 19 to 36");
            }

            if (choice == 1) {
                redChoice();

            } else if (choice == 2) {
                blackChoice();

            } else if (choice == 3) {
                evenChoice();

            } else if (choice == 4) {
                oddChoice();

            } else if (choice == 5) {
                pickNumberChoice();

            } else if (choice == 6) {
                betweenOneAndEighteen();

            } else if (choice == 7) {
                betweenNineteenAndThirtySix();
            }


         response =  consoleRed.getStringInput("Would you like to play another game? (Y/N) ");
            if(response.equals("N") || response.equals("n")){
               break;
            }

        }while (true);

        return null;
    }


    public Integer[] getRed() {
        return red;
    }

    public Integer[] getBlack() {
        return black;
    }

    public Integer getChoice() {
        return choice;
    }

    public void setChoice(Integer choice) {
        this.choice = choice;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLoses() {
        return loses;
    }

    public void setLoses(Integer loses) {
        this.loses = loses;
    }

    public Integer getSpins() {
        return spins;
    }

    public void setSpins(Integer spins) {
        this.spins = spins;
    }

    public Double getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(Double betAmount) {
        this.betAmount = betAmount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getRouletteNumber() {
        return rouletteNumber;
    }


    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        RouletteGame rouletteGame = new RouletteGame();
        Double money = rouletteGame.rouletteGame();
    }
}
