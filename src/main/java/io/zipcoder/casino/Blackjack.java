package io.zipcoder.casino;

import io.zipcoder.casino.card.Deck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Blackjack {
    {
        private static int BLACKJACK = 21;
        private static int DECKSIZE = 52;
        private static boolean isPlayerDone;

        public static void main(String[] args)
        {
            Deck deck = null;
            Hand playersHand = null;
            Hand splitHand = null;
            Hand dealersHand = null;

            System.out.println("--------------------------------------------------------");
            System.out.println("-               BLACK               JACK               -");
            System.out.println("--------------------------------------------------------\n");
            boolean runGame = true;
            while(runGame)
                switch(options())
                {
                    case "deal":
                        dealersHand = new Hand("Dealer");
                        playersHand = new Hand("Player");
                        splitHand = null;

                        isPlayerDone = false;

                        deck = initialDraw(deck, playersHand, splitHand, dealersHand);

                        if (playersHand.getHandTotal() == BLACKJACK)
                        {
                            System.out.print("Player has BLACKJACK!\n\n");
                            isPlayerDone = true;
                            System.out.print("Dealer uncovers card...\n\n");
                            showHands(playersHand, splitHand, dealersHand);
                            System.out.print("Dealer's move...\n\n");
                            deck = dealerDraw(deck, playersHand, splitHand, dealersHand);
                            showHands(playersHand, splitHand, dealersHand);
                            compareHands(playersHand, splitHand, dealersHand);
                        } // end if()

                        break; // end case "deal"

                    case "hit":
                        if(!isPlayerDone)
                            deck = hit(deck, playersHand, splitHand, dealersHand);
                        else
                            System.out.print("You must deal cards first!\n\n");
                        break; // end case "hit"

                    case "stand":
                        if(!isPlayerDone)
                        {
                            isPlayerDone = true;
                            deck = stand(deck, playersHand, splitHand, dealersHand);
                        } // end if()
                        else
                            System.out.print("You must deal cards first!\n\n");
                        break; // end case "stand"

                    case "split":
                        if(!isPlayerDone)
                            splitHand = split(playersHand, splitHand, dealersHand);
                        else
                            System.out.print("You must deal cards first!\n\n");
                        break; // end case "split"

                    case "exit":
                        runGame = false;
                        System.out.print("Game ended.\n\n");
                        break; // end case "exit"

                    default:
                        System.out.print("Invalid entry\n\n");
                } // end switch()
        } // end main()

        private static Hand split(Hand player, Hand split, Hand dealer)
        {
            if(player == null)
                System.out.print("You must deal cards first!\n\n");
            else if(player.getHandSize() == 2 && player.bothEqual())
            {
                split = new Hand("Player");
                split.insert(player.deleteFirst());

                showHands(player, split, dealer);
                compareHands(player, split, dealer);
            } // end else if()
            else if(!player.bothEqual())
                System.out.print("Both card values must be the same!\n\n");
            else
                System.out.print("You must have no more than 2 cards to split!\n\n");

            return split;
        } // end split()

        private static Deck stand(Deck deck, Hand player, Hand split, Hand dealer)
        {
            if(player == null)
                System.out.print("You must deal cards first!\n\n");
            else
            {
                isPlayerDone = true;
                System.out.print("Dealer uncovers card...\n\n");
                showHands(player, split, dealer);
                System.out.print("Dealer's move...\n\n");
                deck = dealerDraw(deck, player, split, dealer);
                showHands(player, split, dealer);
                compareHands(player, split, dealer);
            } // end else

            return deck;
        } // end stay()

        private static Deck hit(Deck deck, Hand player, Hand split, Hand dealer)
        {
            if(player == null)
                System.out.print("You must deal cards first!\n\n");
            else
            {
                deck = drawFromDeck(deck, player);
                System.out.print("\n");

                if(split != null)
                {
                    deck = drawFromDeck(deck, split);
                    System.out.print("\n");
                } // end if()

                showHands(player, split, dealer);
                compareHands(player, split, dealer);

                if (player.getHandTotal() == BLACKJACK)
                {
                    System.out.print("Player has BLACKJACK!\n\n");
                    isPlayerDone = true;
                    System.out.print("Dealer uncovers card...\n\n");
                    showHands(player, split, dealer);
                    System.out.print("Dealer's move...\n\n");
                    deck = dealerDraw(deck, player, split, dealer);
                    showHands(player, split, dealer);
                    compareHands(player, split, dealer);
                } // end if()
                else if(player.getHandTotal() > BLACKJACK)
                {
                    System.out.print("Player Busted!\n\n");
                    isPlayerDone = true;
                    System.out.print("Dealer uncovers card...\n\n");
                    showHands(player, split, dealer);
                    compareHands(player, split, dealer);
                }
            } // end else

            return deck;
        } // end hit()

        private static Deck dealerDraw(Deck deck, Hand player, Hand split, Hand dealer)
        {
            if(player.getHandTotal() <= BLACKJACK)
            {
                // Dealer takes a precaution and only draws
                // if hand total is less than or equal to 16.
                while(dealer.getHandTotal() <= 16 &&
                        (dealer.getHandTotal() <= player.getHandTotal() ||
                                (split != null  && dealer.getHandTotal() <= split.getHandTotal())))
                    deck = drawFromDeck(deck, dealer);

                // Player has reached BLACKJACK!
                // There's no or little chance to win,
                // dealer risks and draws even if total is high.
                if (player.getHandTotal() == BLACKJACK || (split != null  &&
                        split.getHandTotal() == BLACKJACK))
                    while(dealer.getHandTotal() < BLACKJACK)
                        deck = drawFromDeck(deck, dealer);
            } // end if()

            return deck;
        } // dealerDraw()

        private static Deck drawFromDeck(Deck deck, Hand hand)
        {
            deck = checkDeck(deck);

            Card temp = new Card(deck.pop());

            if (hand.getName().equals("Dealer") && !isPlayerDone)
            {
                if(hand.getHandSize() < 1)
                    System.out.print("Drawing Dealer's card... X_X");
                else
                    System.out.print("Drawing Dealer's card... " + temp.toString());
            } // end if()
            else
            {
                if(hand.getName().equals("Dealer"))
                    System.out.print("Drawing Dealer's card... " + temp.toString() + "\n");
                else
                    System.out.print("Drawing Player's card... " + temp.toString());
            } // end else

            System.out.print("\n");

            hand.insert(temp);

            return deck;
        } // end drawFromDeck()

        private static void compareHands(Hand player, Hand split, Hand dealer)
        {
            if (isPlayerDone)
            {
                if(player.getHandTotal() > BLACKJACK ||
                        (split != null && split.getHandTotal() > BLACKJACK))
                {
                    System.out.print("Player Busted!\n");
                    if(dealer.getHandTotal() <= BLACKJACK)
                        System.out.print("Dealer Wins!\n\n");
                } // end if()
                else if(dealer.getHandTotal() > BLACKJACK)
                {
                    System.out.print("Dealer Busted!\n");
                    if(player.getHandTotal() <= BLACKJACK ||
                            (split != null && split.getHandTotal() <= BLACKJACK))
                        System.out.print("Player Wins!\n\n");
                } // end else if()
                else if(dealer.getHandTotal() > BLACKJACK &&
                        (player.getHandTotal() > BLACKJACK ||
                                (split != null && split.getHandTotal() > BLACKJACK)))
                {
                    System.out.print("Both Busted!\n");
                } // end else if()
                else
                {
                    if((player.getHandTotal() > dealer.getHandTotal() &&
                            player.getHandTotal() <= BLACKJACK) ||
                            (split != null && (split.getHandTotal() > dealer.getHandTotal() &&
                                    player.getHandTotal() <= BLACKJACK)))
                        System.out.print("Player Wins!\n\n");
                    else if((player.getHandTotal() < dealer.getHandTotal() &&
                            dealer.getHandTotal() <= BLACKJACK) ||
                            (split != null && (split.getHandTotal() < dealer.getHandTotal() &&
                                    dealer.getHandTotal() <= BLACKJACK)))
                        System.out.print("Dealer Wins!\n\n");

                    if(player.getHandTotal() == BLACKJACK ||
                            (split != null && split.getHandTotal() == BLACKJACK))
                        System.out.print("Player has BLACKJACK!\n\n");
                    if(dealer.getHandTotal() == BLACKJACK)
                        System.out.print("Dealer has BLACKJACK!\n\n");
                } // end else
            } // end if()
        } // end compareHands()

        private static Deck checkDeck(Deck deck)
        {
            if(deck == null)
                deck = createDeck();
            else if(deck.isEmpty())
            {
                System.out.print("\nDeck is empty! You must create and shuffle new deck of cards!\n\n");
                deck = createDeck();
            } // end else if()

            return deck;
        } // end checkDeck()

        private static Deck createDeck()
        {
            System.out.println("Creating deck...");
            Deck deck = new Deck(DECKSIZE);
            deck.createDeck();
            System.out.println("Shuffling deck...");
            deck.shuffleDeck();
            System.out.print("\n");

            return deck;
        } // end createDeck()

        private static Deck initialDraw(Deck deck, Hand player, Hand split, Hand dealer)
        {
            deck = drawFromDeck(deck, player);
            deck = drawFromDeck(deck, dealer);
            deck = drawFromDeck(deck, player);
            deck = drawFromDeck(deck, dealer);

            System.out.print("\n");

            showHands(player, split, dealer);
            compareHands(player, split, dealer);

            return deck;
        } // end initialDraw()

        private static void showHands(Hand player, Hand split, Hand dealer)
        {
            System.out.print("Dealers Hand:");

            if(!isPlayerDone)
            {
                dealer.peek();
                System.out.print(" X_X = " + dealer.peekValue() + "\n");
            } // end if()
            else
            {
                dealer.displayHand();
                System.out.print(" = " + (dealer.getHandTotal() == BLACKJACK ?
                        dealer.getHandTotal() + " : BLACKJACK!" :
                        ((dealer.getHandTotal() > BLACKJACK) ?
                                dealer.getHandTotal() + " : BUSTED!" :
                                dealer.getHandTotal())) + "\n");
            } // end else

            System.out.print("Players Hand:");
            player.displayHand();
            System.out.print(" = " + (player.getHandTotal() == BLACKJACK ?
                    player.getHandTotal() + " : BLACKJACK!" :
                    ((player.getHandTotal() > BLACKJACK) ?
                            player.getHandTotal() + " : BUSTED!" :
                            player.getHandTotal())) + "\n");

            if (split != null)
            {
                System.out.print("Players Hand:");
                split.displayHand();
                System.out.print(" = " + (split.getHandTotal() == BLACKJACK ?
                        split.getHandTotal() + " : BLACKJACK!" :
                        ((split.getHandTotal() > BLACKJACK) ?
                                split.getHandTotal() + " : BUSTED!" :
                                split.getHandTotal())) + "\n\n");
            } // end if()
            else
                System.out.print("\n");
        } // end showHands()

        private static String options() throws IOException
        {
            System.out.print("deal, hit, split, stand, exit: ");
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String s = br.readLine();
            System.out.print("\n");
            return s;
        } // end options()
    } // end BlackJack

    //test
}
