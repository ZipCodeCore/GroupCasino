package io.zipcoder.casino;

public class CrapsDisplay extends Display {

    public void rulesMenu1(){
        currentDisplaySP("Welcome to Craps!\nIn Craps, the 'shooter' rolls two dice repeatedly.\nTheir first roll, the 'come out roll,' has three potential outcomes.\nA 7 or 11 total is a pass. A 2, 3, or 12 is craps. Anything else is a point.\nYou can bet 'pass' (the shooter rolls a pass) or 'don't pass' (the shooter rolls craps) for 1 to 1 payout.\nThe shooter keeps rolling until a point is set. On a point outcome, the number rolled is saved.\nNow, the shooter can 'come' by hitting the point outcome again, or 'seven out,' ending the round by rolling a 7.\nYou can bet 'come' (shooter hits point before sevening out) or 'don't come' (vice versa) for 1 to 1 payout.\nType rules2 for more technical rules.");
    }

    public void rulesMenu2(){

    }

    public void optionsMenu(){

    }

    public void shooterScores(){
        currentDisplaySP("The shooter rolled got the point!");
    }

    public void shooterSevenedOut(){
        currentDisplaySP("The shooter sevened out...");
    }

    public void push(){
        currentDisplaySP("Your bet is a push.");
    }

    public void oneRolLBetLoss(){
        currentDisplaySP("Your one-roll proposition failed...");
    }

    public void oneRollBetWin(){
        currentDisplaySP("You won your one-roll proposition!");
    }

    public void natural(){
        currentDisplaySP("It's a natural!");
    }

    public void craps(){
        currentDisplaySP("It's craps!");
    }

    public void shooterRolled(){
        currentDisplaySP("The shooter rolled a " + 5);
    }

    public void setTypeOfBet(){
        currentDisplaySP("What kind of bet do you want to make?");
    }

    public void comeOutRoll(){
        currentDisplaySP("Here's the come out roll...");
    }
}












