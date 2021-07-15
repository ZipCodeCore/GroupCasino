package com.github.zipcodewilmington.casino.games.CardGame;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.keno.KenoPlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;
import com.github.zipcodewilmington.casino.games.CardGame.CardHand;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BlackJack extends Deck implements GameInterface {
CardHand playerHand;
CardHand dealerHand;
Deck deck =new Deck();
Integer minimumWager=20;
Set<BlackJackPlayer> players = new HashSet<>();
BlackJackPlayer blackJackPlayer;

public BlackJack(){
    super();
}
public BlackJack(int numberOfDecks){
    super(numberOfDecks);
}

    public BlackJackPlayer getPlayer(String playerUsername) {
        for (BlackJackPlayer player : players) {
            if (player.getArcadeAccount().getUsername().equals(playerUsername)) {
                return player;
            }
        }
        return null;
    }

public void playBlackjack(){
    IOConsole input = new IOConsole(AnsiColor.PURPLE);
    Deck blackjackDeck= new Deck(1);
    double playerMoney = 100.0;
    blackjackDeck.shuffle();

    input.println("Lets play Blackjack!!! You have "+playerMoney+"$");
    {
        while(playerMoney > 0) {
            Integer playerWager = input.getIntegerInput("How much would you like to play for?");
            if (playerWager < minimumWager) {
                input.println("The minimum wager is 20$! Increase your wager.Bye for now!!");
                return;
            }
            else if (playerWager > playerMoney)
            {
                input.println("You dont have enough money.. Go home and sleep!!");
                return;
            }
            else {
                boolean endGame = false;
                playerHand=new CardHand(blackjackDeck.dealCards(2));
                dealerHand = new CardHand(blackjackDeck.dealCards(2));
                Integer playerHandValue =0;
                Integer dealerHandValue = 0;
                input.println("Lets start this round! You have "+playerMoney+"$");
                while(true) {
                    playerHandValue = checkHandValue(playerHand);
                    dealerHandValue = checkHandValue(dealerHand);
                    input.println("Player Hand:\n" + playerHand.displayHand());
                    input.println("Player total hand value is :" + playerHandValue);
                    input.println("Dealer Hand:\n" + dealerHand.displayHand());
                    input.println("Dealer total hand value is :" + dealerHandValue);
                    if(dealerHandValue==21){
                        playerMoney -= playerWager;
                        input.println("Dealer got BlackJack!Better luck next time!");
                        endGame=true;
                        break;
                    }
                    else if(playerHandValue==21){
                        playerMoney += playerWager;
                        input.println("You got BlackJack!Poor Dealer");
                        endGame=true;
                        break;
                    }
                    Integer hitOrStay = input.getIntegerInput("Do you want to 1.Hit or 2.Stay?");
                    if(hitOrStay == 1)
                    {
                        this.playerHand.userHand.add(blackjackDeck.drawCard());
                        playerHandValue = checkHandValue(playerHand);
                        input.println("Player Hand:\n" + playerHand.displayHand());
                        input.println("Player total hand value is :" + playerHandValue);
                        if(checkBust(playerHandValue))
                        {
                            input.println("Busted!! You lose!!");
                            playerMoney -= playerWager;
                            endGame = true;
                            break;
                        }


                    }
                    if(hitOrStay == 2)
                    {
                        break;
                    }
                }
                if(dealerHandValue > playerHandValue && endGame == false)
                {
                    input.println("Dealer won.. You Lost!!");
                    playerMoney -= playerWager;
                    endGame = true;
                }
                while(dealerHandValue <= 16 && endGame == false)
                {
                    this.dealerHand.userHand.add(blackjackDeck.drawCard());
                    dealerHandValue = checkHandValue(dealerHand);
                    input.println("Dealer Hand:" + dealerHand.displayHand());
                }
                dealerHandValue = checkHandValue(dealerHand);
                input.println("Dealer total hand value is :" + dealerHandValue);
                if(checkBust(dealerHandValue))
                {
                    input.println("Dealer Busted!! You won!!");
                    playerMoney += playerWager;
                    endGame = true;
                }
                if(playerHandValue == dealerHandValue && endGame == false)
                {
                    input.println("Its a tie!! Push");
                    endGame = true;
                }
                if(playerHandValue > dealerHandValue && endGame == false)
                {
                    input.println("You won this round");
                    playerMoney += playerWager;
                    endGame = true;
                }
                else if(endGame == false)
                {
                    input.println("You lost this round");
                    playerMoney -= playerWager;
                    endGame = true;
                }

                input.println("You have  "+playerMoney+"$ left!!");

            }
        }
    }
}

public Boolean checkBust(Integer totalValue)
{
    if(totalValue > 21)
        return true;
    else
        return false;

}
//public Boolean gotBlackJack(Integer totalValue)
//{
//    if(totalValue == 21)
//        return true;
//    else
//        return false;
//}

    public Integer checkHandValue(CardHand hand) {
        Integer totalValue = 0;
        Integer numberOfAces = 0;

        for (Card card : hand.userHand) {
            FaceValueOfCard faceValueOfCard = card.getFaceValueOfCard();
            //ignore ace value
            if(faceValueOfCard.toString().equals("ACE"))
            {
                numberOfAces++;
            }
            else
            {
                totalValue += (Integer) faceValueOfCard.getCardIntegerValue();
            }
        }
        //calculate ace value in the end
        for(int i = 0;i<numberOfAces;i++)
        {
            if( totalValue > 10)
                totalValue +=1;
            else
                totalValue +=11;
        }

        return totalValue;
    }




    @Override
    public void add(PlayerInterface player) {
        players.add((BlackJackPlayer) player);
    }

    @Override
    public void remove(PlayerInterface player) {
        players.remove(player);
    }

@Override
public void run() {

}
}
