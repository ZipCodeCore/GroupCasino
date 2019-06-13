package io.zipcoder.casino.games;

import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.SlotsPlayer;

import java.lang.reflect.Array;

public class Slots extends Games implements GamblerGameInterface {
    Integer numOfLines;
    SlotsPlayer slotsPlayer = new SlotsPlayer();
    private Double currentBet;

    public Player player;

    public Slots(){
    }

    public Slots(Player player){
        this.player= player;
    }

    public static void main(String[] args) {
        Integer random =0;
        String[] characters = new String[]{" cherry ", " orange ", " bell ", " bars ", " apple ", " seven "};
        String[][] toSave = new String[3][3];
//        for (int i = 0; i <characters.length; i++) {
        int max = characters.length;
        int min = 1;
        int range = max - min + 1;

        int countDiag1 = 0;
        int countDiag2=0;
        int countHor = 0;

        // generate random numbers within 1 to 10
        for (int i = 0; i <=2; i++) {
            for (int j = 0; j <=2; j++) {
                int rand = (int)(Math.random() * range);
                System.out.print(characters[rand]);
                toSave[i][j]= characters[rand];

//                }
//
//              System.out.println();
//        }

                if (i==j&&toSave[i][j]=="cherry"){
                    countDiag1 +=1;
                }
                if (i+j==2 && toSave[i][j]=="cherry"){
                    countDiag2+=1;
                }
                if (toSave[i][j]=="cherry"){
                    countHor+=1;
                }
//                            if (toSave[j][i]=="cherry"){
//                                countVert+=1;
//                            }
            }
            if (countHor ==3){
                System.out.println("You won cherry");
            }
//                        if (countVert==3){
//                            System.out.println("You won cherry");
//                        }
            else{
                countHor =0;
//                            countVert = 0;
            }
            System.out.println();
        }
        if (countDiag1 ==3){

            System.out.println("You won cherry");
            if (countDiag2==3){

                System.out.println("You won cherry");
            }


        }

        System.out.println("You lost!");

    }


    @Override
    void nextTurn() {
    }

    @Override
    void endGame() {

    }

    @Override
    boolean getResults() {
        return false;
    }

    @Override
    public void display(String output) {
        super.display(output);
    }

    public Integer calcPayment(Integer bet, Integer odds) {
        return null;
    }

    public void updateAccount(Integer num) {

    }

    public Double getCurrentBet() {
        return currentBet;
    }

    public void setCurrentBet(Double currentBet) {
        this.currentBet = currentBet;
    }

    public Double calcPayment(Double bet, Double odds) {
        return null;
    }

    public void updateAccount(Double num) {


    }
}
