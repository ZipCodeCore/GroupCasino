package com.github.zipcodewilmington.casino.games.cardGames;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Collections;

public class BlackJack implements GameInterface {
    private IOConsole input = new IOConsole(AnsiColor.AUTO);
    createDeck deck = new createDeck();
    Cards dealer;
    private Rank dealerRank;
    private Integer dealerValue;
    Integer totalDealerValue = 0;
    Cards player;
    private Rank playerRank;
    private Integer playerValue;
    Integer totalPlayerValue = 0;

    public static void main(String[] args) {
        BlackJack blackJack = new BlackJack();

        System.out.println(blackJack.rules());

        blackJack.run();
    }

    public String rules() {
        return "Blackjack is played with one or more standard 52-card decks, with each denomination assigned a\n " +
                "point value. The cards 2 through 10 are worth their face value. Kings, queens, and jacks are each\n" +
                " worth 10, and aces may be used as either 1 or 11. The object for the player is to draw cards\n" +
                " totaling closer to 21, without going over, than the dealer's cards.";
    }

    public void shuffleDeck() {
        Collections.shuffle(deck.cardsStack);
    }

    public void dealCards() {
        dealer = deck.cardsStack.pop();
        player = deck.cardsStack.pop();

        System.out.println("The dealer drew a " + dealer + "\n" + "You drew a " + player);
    }

    public void valueChecking() {
        dealerRank = dealer.getRank();
        dealerValue = dealerRank.getFirstValue();
        playerRank = player.getRank();
        playerValue = playerRank.getFirstValue();

        if (dealerRank.equals(Rank.ACE)) {
            if ((totalDealerValue + 11) < 17) {
                dealerValue = Rank.ACE.getFirstValue();
            } else if ((totalDealerValue + 11) <= 21) {
                dealerValue = Rank.ACE.getSecondValue();
            }
        }

        if (playerRank.equals(Rank.ACE)) {
            String choice = input.getStringInput("Is the value of your ACE a 1 or an 11: ");

            if (choice.equals("1")) {
                playerValue = Rank.ACE.getFirstValue();
            } else if (choice.equals("11")) {
                playerValue = Rank.ACE.getSecondValue();
            } else {
                System.out.println("Please choose 1 or 11.");
                valueChecking();
            }
        }

        if (dealerRank.equals(Rank.JACK) || dealerRank.equals(Rank.QUEEN) || dealerRank.equals(Rank.KING)) {
            dealerValue = Rank.TEN.getFirstValue();
        }

        if (playerRank.equals(Rank.JACK) || playerRank.equals(Rank.QUEEN) || playerRank.equals(Rank.KING)) {
            playerValue = Rank.TEN.getFirstValue();
        }
    }

    public void userAction() {
        String action = input.getStringInput("What do you want to do?\n" +
                                            "[HIT], [STAND], [DOUBLE DOWN]");

        switch (action.toLowerCase()) {
            case "hit":
                player = deck.cardsStack.pop();
                valueChecking();
                System.out.println("You drew a " + player + ".");
                break;
            case "stand":
                break;
            case "double down":
                System.out.println("you said double down");
                break;
            default:
                System.out.println("Please choose a valid option.");
        }
    }

    public void dealerAction() {
        if (totalDealerValue <= 16) {
            dealer = deck.cardsStack.pop();
            valueChecking();
            System.out.println("The dealer drew a " + dealer + ".");
        } else {
            System.out.println("The dealer has a " + dealer + ".");
        }
    }

    public void checkWinner() {

        if (totalDealerValue > 21) {
            totalDealerValue = 0;
            totalPlayerValue = 0;

            System.out.println("You are the winner!");
        } else if (totalPlayerValue > 21) {
            totalDealerValue = 0;
            totalPlayerValue = 0;

            System.out.println("The dealer won this game.");
        } else {
            totalDealerValue += dealerValue;
            totalPlayerValue += playerValue;
            userAction();
            dealerAction();
            checkWinner();
        }
    }

    public boolean continuePlaying() {
        boolean answer = false;
        String choice = input.getStringInput("Do you want to play again: (Yes or No)");

        if (choice.equalsIgnoreCase("yes")) {
            answer = true;
        } else if (choice.equalsIgnoreCase("no")) {
            answer = false;
        } else {
            System.out.println("Please say yes or no.");
            continuePlaying();
        }

        return answer;
    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        BlackJack blackJack = new BlackJack();

        do {
            deck = new createDeck();
            blackJack.shuffleDeck();
            blackJack.dealCards();
            blackJack.valueChecking();
            blackJack.checkWinner();
        } while (blackJack.continuePlaying());
    }
}
