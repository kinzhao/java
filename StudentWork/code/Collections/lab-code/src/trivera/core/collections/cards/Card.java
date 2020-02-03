package trivera.core.collections.cards;

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
 * This class represents a card from a standard card deck.
 *
 * When the deck is constructed it will fill itself with the 52 cards in a
 * standard deck (no jokers!).
 *
 * While there are constants defined to represent the different suits and
 * values, they would probably never be used outside of the code that is already
 * written here.
 *
 * A card has a natural sort order of suit followed by number. This works well
 * for displaying all the cards in a deck, where all the hearts are shown,
 * followed by all diamonds, etc. This is not the ideal way to show cards in a
 * hand, where cards are usually grouped by their number (2 of a kind, etc.).
 */
public class Card implements Comparable<Card> {

    public final static int HEARTS = 0, DIAMONDS = 1, CLUBS = 2, SPADES = 3;

    public final static int DEUCE = 2, THREE = 3, FOUR = 4, FIVE = 5, SIX = 6,
            SEVEN = 7, EIGHT = 8, NINE = 9, TEN = 10, JACK = 11, QUEEN = 12,
            KING = 13, ACE = 14;

    private int suit;

    private int number;

    /**
     * Constructs the card.
     *
     * The suit and number value are verified to ensure they are in the correct
     * range.
     *
     * @param suit
     *            The card suit - HEARTS, SPADES, DIAMONDS, or CLUBS
     * @param number
     *            A value between DEUCE and ACE
     * @throws IllegalArgumentException
     *             If a value is provided that is outside the valid range.
     */
    public Card(int suit, int number) {
        super();

        if (suit < Card.HEARTS || suit > Card.SPADES)
            throw new IllegalArgumentException(
                    "Suit must be HEARTS, DIAMONDS, CLUBS, or SPADES");

        if (number < Card.DEUCE || number > Card.ACE)
            throw new IllegalArgumentException("Invalid card number");

        this.suit = suit;
        this.number = number;
    }

    /**
     * Compares this card with the specified card for order.
     *
     * A card is determined to be less than another card by comparing its suit
     * and its number. The priority is to first compare the suits. Only if the
     * suits are equal are the numbers then compared. This makes for good deck
     * sorting, but inappropriate hand sorting.
     *
     * @param o
     *            the Card to be compared.
     * @return a negative integer, zero, or a positive integer as this Card is
     *         less than, equal to, or greater than the specified Card.
     *
     * @throws ClassCastException
     *             if the specified object's type is not Card
     */

    public int compareTo(Card o) {

        // LAB HINT: Complete the compareTo() method according to instructions
    	return 0;
    }

    /**
     * Compares this card to another card to see if they are the same.
     *
     * A card is considered equal to another card if the suit and number are the
     * same.
     *
     * @return boolean
     * @param other
     *            The other card to compare with
     */
    public boolean equals(Object other) {

        // LAB HINT: Complete the equals() method according to instructions
    	return false;
    }

    /**
     * Returns the number of the card.
     *
     * @return The number of this card
     */
    public int getNumber() {
        return number;
    }

    /**
     * Returns the card's suit.
     *
     * The suit values are represented by constants in this class.
     *
     * @return The suit of this card
     */
    public int getSuit() {
        return suit;
    }

    /**
     * Returns a String that represents the value of this card.
     *
     * @return a string representation of the card
     */
    public String toString() {

        String suit, number;

        switch (this.suit) {
        case Card.HEARTS:
            suit = new String("hearts");
            break;
        case Card.DIAMONDS:
            suit = new String("diamonds");
            break;
        case Card.CLUBS:
            suit = new String("clubs");
            break;
        case Card.SPADES:
            suit = new String("spades");
            break;
        default:
            suit = new String("????");
            break;
        }

        switch (this.number) {
        case Card.ACE:
            number = new String("Ace");
            break;
        case Card.KING:
            number = new String("King");
            break;
        case Card.QUEEN:
            number = new String("Queen");
            break;
        case Card.JACK:
            number = new String("Jack");
            break;
        default:
            number = Integer.toString(this.number);
        }

        return new String(number + " of " + suit);
    }
}
