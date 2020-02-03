package trivera.core.collections.cards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * This component and its source code representation are copyright protected
 * and proprietary to Trivera Technologies, LLC, Worldwide D/B/A Trivera Technologies
 *
 * This component and source code may be used for instructional and
 * evaluation purposes only. No part of this component or its source code
 * may be sold, transferred, or publicly posted, nor may it be used in a
 * commercial or production environment, without the express written consent
 * of Trivera Technologies, LLC
 *
 * Copyright (c) 2020 Trivera Technologies, LLC.
 * http://www.triveratech.com   
 * </p>
 * @author Trivera Technologies Tech Team.
 */


/**
 * Runs the Collection Poker card game.
 */

public class RunGame {
    /**
     * Starts the card game.
     *
     * @param args
     *            Not used
     */
    public static void main(java.lang.String[] args) {

        Deck deck = new Deck();
        List<Card> cards = null;
        Iterator<Card> iterator;
        String cmd;

        // Creates the reader to read lines from standard input
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        while (true) {

            System.out.println("Welcome to One-Hand Collections Poker!");
            System.out.println("--------------------------------------");
            System.out.println("Please enter one of the following values:");
            System.out.println("1 - Deal me in!");
            System.out.println("2 - Cheater! Show me the deck!");
            System.out.println("3 - Exit");
            
            try {
                cmd = reader.readLine();
            } catch (IOException ioe) {
            	System.out.println(ioe.getMessage());
                return;
            }


            if (cmd.startsWith("1")) {

                // Shuffle the deck
                deck.shuffle();

                // Get the five cards
                cards = deck.getCards(5);
            } else if (cmd.startsWith("2"))

                // Get the list of the entire deck
                cards = deck.showDeck();
            else if (cmd.startsWith("3"))

                System.exit(0);

            else

                // Bad value, just re-display menu
                continue;



            // Iterate through the returned list, printing the cards in list
            // order
            // The toString method of Card is sufficient to print the cards
            // correctly

            iterator = cards.iterator();
            while (iterator.hasNext())
                System.out.println(iterator.next());

            System.out.println();

            // verify the version of Java that is running
            System.out.println(System.getProperty("java.version"));

        }

    }
}
