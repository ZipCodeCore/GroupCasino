package io.zipcoder.casino.CasinoClasses;


import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Logger;

public class Casino{
    String casinoName = "";
    HashMap<String, Double> Players;

    public Casino (String CasinoName){
        this.casinoName = CasinoName;
    }

    // ******************************************************************************************** Welcome **********

    public void welcomeMessage(){
        System.out.println(    "Hello  Welcome to casino    " + casinoName + "\n");
        System.out.println(    "Hope you enjoy your stay at " + casinoName + "\n");
    }

    // ******************************************************************************************** Getting String iput from User **********
    public String getUserInput(){

        Scanner readInput = new Scanner(System.in);
        String userInput = readInput.nextLine();
        return userInput;
    }

    // ******************************************************************************************** Getting AGE from User **********
    public boolean getMemberStatus() {
        boolean answer = false;
        System.out.println("Are you an existing member or new ?         : ");
        System.out.print("Please        Enter  ' Y ' or ' N '         : ");

        String userInput = getUserInput();
        boolean exitInputLoop = false;

        while(exitInputLoop == false){

            if (userInput.equals("y") || userInput.equals("Y")) {
                //call method to collect ID
                exitInputLoop = true;
                answer = true;
            } else if (userInput.equals("n") || userInput.equals("N")) {
                //Call method to create accountt

                exitInputLoop = true;
                answer = false;
            } else {
                System.out.print("Invalid:      Enter  ' Y ' or ' N '         : ");
                userInput = getUserInput();
            }
        }
        return answer;
    }

    // ******************************************************************************************** Getting A Number from User --- (Try catch - ensure a number is provided )**********
    public Integer getNumber(){
        Integer numberInput = 0;
        boolean validNumber = false;

        while(validNumber == false){
            try{
                Scanner readInput = new Scanner(System.in);
                String holder = readInput.nextLine();
                numberInput = Integer.parseInt(holder);
                validNumber = true;

            }catch(NumberFormatException e){
                System.out.print("                    Error : Enter a Number  : ");
            }
        }


        return numberInput;
    }
    // ******************************************************************************************** Getting Account # from User - Must be 4 digits **********
    public Integer collectAccountNumber(String userName){
        System.out.print("Thank you " + userName + "\n" +
                "Now provide a valid 4 digit Account number  : ");

        Integer userPin = getNumber();

        boolean validPin = false;
        while(validPin == false){

            int length = String.valueOf(userPin).length();
            if(length < 4){
                System.out.print("                    Error :    # too short  : ");
            }else if(length > 4){
                System.out.print("                    Error :     # too long  : ");
            }else if(length == 4){
                System.out.println("         Thank You                   Name = : " + userName + "\n" +
                                   "                           Account Number = : " + userPin);
                validPin = true;
                break;
            }
            userPin = getNumber();
        }
        return userPin;
    }
    // ******************************************************************************************** Getting Initial balance from User - $50 minimum & $10,000 Max **********
    public Integer collectStartingBalance(String userName, Integer accountNumber){
        Integer userBalance = getNumber();

        boolean validBalance = false;
        while(validBalance == false){

            if(userBalance < 50){
                System.out.print("                Error :     $50 Minimum     : $");          //"                    Error : Enter a Number  : "
            }else if(userBalance > 10000){
                System.out.print("                Error :     $10,000 Maximum : $");
            }else if(userBalance >= 50 && userBalance <= 10000){
                                 //"         Thank You                   Name = : "
                System.out.println("\n" + "                   : Thank You :" +
                                   "\n" + "          Account Name    = " + userName +
                                   "\n" + "          Account Number  = " + accountNumber +
                                   "\n" + "          Account Balance = " + userBalance + "\n");
                validBalance = true;
                break;
            }
            userBalance = getNumber();
        }
        return userBalance;
    }

    // ******************************************************************************************** Getting Name from User **********
    public String collectName(){
        System.out.println("\n" + "No problem we will set up an account for you! " + "\n");  //System.out.int("Please        Enter  ' Y ' or ' N '         : ");
        System.out.print("First Provide us with your name             : ");
        String userName = getUserInput();
        return userName;
    }

    // ******************************************************************************************** Getting AGE from User **********
    public Integer collectAge(String userName, Integer accountNumber, Integer userBalance){
                       //"First Provide us with your name             : "
        System.out.print("Last Item needed is age :  Please Provide   : ");
        Integer age = getNumber();
        boolean validAge = false;
        while(validAge == false){
            if(age < 18){
                               //"                    Error :     # too long  : "
                System.out.print("                    Error :     Must be 18  : ");
            } else if(age > 100){
                               //"                    Error :     # too long  : "
                System.out.print("                    Error :        Too Old  : ");
            } else if(age >= 18 && age <= 100){
                System.out.println("\n" + "             : Account Created :" +
                                   "\n" + "          Account Name    = " +  userName +
                                   "\n" + "          Account Number  = " + accountNumber +
                                   "\n" + "          Account Balance = " + userBalance +
                                   "\n" + "          Account Age     = " + age);
                validAge = true;
                break;
            }

            age = getNumber();
        }
        return age;
    }

    // ******************************************************************************************** Method to collect all account data from User ( Calls other methods )**********
    public Membership createrMembership(){

        String userName = collectName();
        Integer accountNumber = collectAccountNumber(userName);
        Integer startingBalance = collectStartingBalance(userName,accountNumber);
        Integer userAge = collectAge(userName,accountNumber,startingBalance);

        Membership newMember = new Membership(userName,accountNumber,startingBalance,userAge);
        return newMember;
    }

    // ******************************************************************************************** Temporary main for running Casino Methods *******************************************
    public static void main(String[] args) {
        Casino vegas = new Casino("King Jimmy");
        vegas.welcomeMessage();
        boolean ismember = vegas.getMemberStatus();
        if(ismember == false){
            Membership current = vegas.createrMembership();
        }
    }
}
