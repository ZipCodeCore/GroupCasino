package models.games;

import Interfaces.GamblingGame;
import Interfaces.Game;
import models.gamecomponents.Dice;
import models.people.players.Player;
import services.DiceService;

public class CrapsGame extends DiceGame implements Game, GamblingGame {
    Double minimumBet;
    Double betAmount = 0.00;
    DiceService diceService = new DiceService();
    Integer pointNumber;

    public CrapsGame(){
    }
/*
    public CrapsGame(Player player) {
        this.player = player;
    }

    public Integer firstRoll(){
        if(value)
        return null;


        Integer input = console.getIntegerInput("Welcome to craps! Press 1 to roll the dice!");
        if (input == 1) {
            Dice firstDice = diceService.createDie();
            Dice secondDice = diceService.createDie();
            Integer firstDieValue = diceService.rollDice(firstDice);
            Integer secondDieValue = diceService.rollDice(secondDice);
            Integer sum = firstDieValue + secondDieValue;
            determineWin(sum);
        }
    }

    public Boolean determineWin(Integer diceValue) {
        if (diceValue == 7 || diceValue == 11) {
            return true;
        } else setPointNumber(sum);
    }

    public Integer subsequentRolls(){
        return null;
    }

    public Integer setPointNumber(Integer diceValue){
        this.pointNumber = diceValue;
        return this.pointNumber;
    }
*/
    public Double payOut() {
        return null;
    }

    public Double addToBet() {
        return null;
    }



}
