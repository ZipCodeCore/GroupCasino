package com.github.zipcodewilmington.casino.games;

import java.util.Random;
import java.util.Scanner;


/**
 * Created by leon on 7/21/2020.
 */
public class Slots {

     public static void main(String[] arg) {
         Random generator = new Random();
         Scanner console = new Scanner(System.in);

         int playerInput;
         int bet = 10;
         int wheel1;
         int wheel2;
         int wheel3;
         System.out.println("    SLOT MACHINE!!!");
         System.out.println(" ");
         System.out.println("      ____________________");
         System.out.println("     /___________________/|");
         System.out.println("     |  ⚜️ JACKPOT ⚜️   |  |");
         System.out.println("     |   ------------- | o|");
         System.out.println("     |  |   |   |   |  |/ |");
         System.out.println("     |  | 7⃣ | 7⃣ | 7⃣ |__/  |");
         System.out.println("     |  |   |   |   |  |  |");
         System.out.println("     |  -------------  |  |");
         System.out.println("     |      |    |     |  |");
         System.out.println("     |                 |  |");
         System.out.println("     |                 |  /");
         System.out.println("     |                 | / ");
         System.out.println("     |_________________|/   ");



         do {

             System.out.println("tokens:" + bet);
             System.out.println("PRESS 1 TO PULL OR 2 TO QUIT");

             playerInput = console.nextInt();
             if (playerInput == 2){
                 System.out.println("THANKS FOR PLAYING");
             }
           else { //{ if (playerInput > 2){
               //System.out.println("ERROR");
            // }



                 wheel1 = generator.nextInt(8) + 1; //range
                 wheel2 = generator.nextInt(8) + 1;
                 wheel3 = generator.nextInt(8) + 1;


                 System.out.println(wheel1 + " " + '|'  + " " +  wheel2 +  " " + '|' + wheel3);

                 if (wheel1 == wheel2 && wheel1 == wheel3) {
                     System.out.println("YOU WIN 15 TOKENS ☺︎!!!");
                     bet += 15;

                 } else if (wheel1 == wheel2 || wheel1 == wheel3 || wheel2 == wheel3) {
                     System.out.println("YOU WIN 7 TOKENS ☺︎!!!");
                     bet += 7;
                 } else {

                     System.out.println("YOU LOOSE 3 TOKENS !!");
                     bet -= 3;
                 }


             }
             }
             while (playerInput == 1) ;
         }



}
















