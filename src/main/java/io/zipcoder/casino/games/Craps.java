package io.zipcoder.casino.games;


import io.zipcoder.casino.Handler;
import io.zipcoder.casino.player.CrapsPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;


public class Craps extends Games implements GamblerGameInterface {
    private CrapsPlayer crapsPlayer;
    public Handler handler;
    public CrapsDataHandler data = new CrapsDataHandler();





    public Craps() {}

    public Craps(CrapsPlayer player) {
        this.crapsPlayer = player;
        crapsPlayer.player.setPlaying(true);
        data.setStage(0);

    }

    public Craps(CrapsPlayer player, Console console /*, Handler handler*/) {
        this.crapsPlayer = player;
        data.setConsole(console);
        this.handler = handler;
        crapsPlayer.player.setPlaying(true);
        data.setStage(0);

    }

    public void runGame() {
        display("Welcome to the table " + crapsPlayer.player.getName() + "! \n");
        while(crapsPlayer.player.getPlaying() == true) {

            switch (data.getStage()) {
                case 0:
                    String input = data.getConsole().getStringInput("A game has just ended would you like to join the table?");
                    stage0Play(input);
                    break;
                case 1:
                    if (data.getComeFirstRound()) {
                        data.setFirstLineBet(data.getConsole().getDoubleInput("LET'S GET STARTED ON A NEW GAME!\n \n Losing rolls: [2] [3] [12]. \n Winning rolls: [7] [11]. \n [Any other roll becomes the on number]\n" + "\n"+ "Place your passline bet!"));
                    } else {keepPlayingOrQuit();}
                    if(hasMoenytoBet(data.getFirstLineBet(), crapsPlayer.player)){
                        data.setCurrentRoll(crapsPlayer.roll());
                        stage1Play(data.getFirstLineBet());
                    }
                    keepPlayingOrQuit();
                    break;
                case 2:
//                    keepPlayingOrQuit();
                   if(data.getPassFirstRound()) {
                        data.setSecondLineBet(data.getConsole().getDoubleInput("Winning roll: [" + data.getOnNumber() + "] \n Make your come out bet!"));
                        data.setMakePropBet(data.getConsole().getStringInput("Would you like to make a prop bet"));
                        if (checkForPropBet(data.getMakePropBet())) {
                            data.setFieldBetType(data.getConsole().getIntegerInput("What prop bet do you want to make?"));
                            data.setFieldBet(data.getConsole().getDoubleInput("how much do you want to bet on this?"));
                        } else {
                            display("NO PROP BETS PLACED, ROLL THE DICE! \n");}
                    }
                        if (hasMoenytoBet(data.getSecondLineBet() + data.getFieldBet(), crapsPlayer.player)) {
                            data.setCurrentRoll(crapsPlayer.roll());
                            stage2Play(data.getSecondLineBet(), data.getFieldBet(), data.getFieldBetType());
                       }
                    keepPlayingOrQuit();
                    break;
            }
        }
    }

/*----------------STAGE 0---------------*/

    protected void stage0Play(String input){
        Character firstLetter = input.toLowerCase().charAt(0);
        if(input.toLowerCase().equals("play") || firstLetter.equals('y')) {
            data.setStage(1);

        } else if (input.toLowerCase().equals("exit") || firstLetter.equals('n')){
            crapsPlayer.player.setPlaying(false);
        } else {
            display("Excuse me, I didnt understand");
        }
    }

/*----------------STAGE 1---------------*/


    protected void stage1Play(Double firstLineBet){
        if (data.getComeFirstRound()) {
            withdraw(firstLineBet);
        }
        data.setComeFirstRound(false);
        if(data.getCurrentRoll().equals(2) || data.getCurrentRoll().equals(3) || data.getCurrentRoll().equals(12)) {
            display("you rolled a " + data.getCurrentRoll() +  "\n" + "SORRY YOU CRAPPED OUT!");
            data.setStage(1);
            resetBets();
            display(displayCurrentState());
            resetFirstRoundState();
        } else if (data.getCurrentRoll().equals(7) || data.getCurrentRoll().equals(11)) {
            deposit(calcPayment(firstLineBet, data.getFirstLineOdds()));
            display(displayCurrentState());
            display("YOU ROLLED A " + data.getCurrentRoll() +  "\n" + "YOU WON " +  calcPayment(data.getFirstLineOdds(), firstLineBet));
        } else if(!data.getCurrentRoll().equals(2) && !data.getCurrentRoll().equals(3) && !data.getCurrentRoll().equals(12) && !data.getCurrentRoll().equals(7) && !data.getCurrentRoll().equals(11)){
            display(displayCurrentState());
            display("YOU ROLLED A " + data.getCurrentRoll() +  ".\n" + data.getCurrentRoll() + " IS NOW THE ON NUMBER! \n ");
            data.setOnNumber(data.getCurrentRoll());
            data.setStage(2);
        }


    }


/*-----------------STAGE 2----------------*/


    protected void stage2Play(Double secondLineBet, Double fieldBet, Integer fieldBetNumber ){
        if(data.getPassFirstRound()) {
            withdraw(secondLineBet);
            withdraw(fieldBet);
        }
        data.setPassFirstRound(false);
        if(data.getCurrentRoll().equals(7)) {
            display("YOU ROLLED A " + data.getCurrentRoll() +  "\n" + "SORRY YOU CRAPPED OUT!");
            data.setStage(1);
            display(displayCurrentState());
            resetBets();
            resetFirstRoundState();
        } else if (data.getCurrentRoll().equals(fieldBetNumber)) {
            display(displayCurrentState());
            Double wins = calcPayment(fieldBet, data.getfieldOdds(fieldBetNumber));
            deposit(wins);
            display(displayWinningRoll(wins));
        }else if (data.getCurrentRoll().equals(data.getOnNumber())) {
            display(displayCurrentState());
            Double wins =  calcPayment(data.getfieldOdds(data.getOnNumber()), secondLineBet) + calcPayment(data.getfieldOdds(data.getOnNumber()), data.getFirstLineBet());
            deposit(wins);
            display(displayWinningRoll(wins));
        } else {
            display(displayCurrentState());
            display( "YOU ROLLED A " + data.getCurrentRoll() +" NO WINNERS, ROLL AGAIN!");
        }
    }


    @Override
    void endGame() {
        deposit(data.getFirstLineBet());
        deposit(data.getSecondLineBet());
        deposit(data.getFieldBet());


        crapsPlayer.player.setPlaying(false);
    }

    @Override
    void nextTurn() {

    }

    @Override
    boolean getResults() {
        return false;
    }

    @Override
    protected void display(String output) {
        System.out.println(output);
    }

    public void withdraw(Double num) {
        Double temp = crapsPlayer.player.getAccount();
        crapsPlayer.player.setAccount(temp - num);
    }

    public void deposit(Double num) {
        Double temp = crapsPlayer.player.getAccount();
        crapsPlayer.player.setAccount(temp + num);
    }

    public Double calcPayment(Double bet, Double odds) {
        return bet * odds;
    }


    protected Boolean hasMoenytoBet(Double bet, Player player) {
        if (bet > player.getAccount()){
            display("Not enough Money!!! \n you only have - " +
                    crapsPlayer.player.getAccount());
            return false;
        } else return  true;
    }

    protected void keepPlayingOrQuit() {
        String quitOrContinue = data.getConsole().getStringInput("Would you like to keep playing?").toLowerCase();
        Character firstletter = quitOrContinue.toLowerCase().charAt(0);
        if (firstletter.equals('n')) {
            endGame();
        }

    }

    protected String displayCurrentState() {
           return
                    "*-----------------------------------*\n" +
                    "Current Balance: " + crapsPlayer.player.getAccount() + "\n" +
                    "Passline Bet: " + data.getFirstLineBet() + "\n" +
                    "Come Out Bet: " + data.getSecondLineBet() + "\n" +
                    "On Number: " + data.getOnNumber() + "\n" +
                    "Prop Bet Type: " + data.getFieldBetType() + "\n" +
                    "Prob Bet: " + data.getFieldBet() + "\n" + "\n" +
                            "*-----------------------------------*\n";
    }

    protected String  displayWinningRoll(Double wins){
       return  "YOU ROLLED A " + data.getCurrentRoll() + "\n" + "YOU WON " + wins + "!";
    }

    protected Boolean checkForPropBet (String string) {
        Character firstLetter = string.toLowerCase().charAt(0);
        if (firstLetter.equals('y')) {
            return true;
        }else return false;
    }
    protected void resetFirstRoundState() {
        data.setComeFirstRound(true);
        data.setPassFirstRound(true);
    }

    protected void resetBets() {
        data.setFirstLineBet(0.0);
        data.setSecondLineBet(0.0);
        data.setFieldBet(0.0);
        data.setFieldBetType(0);
    }



}
