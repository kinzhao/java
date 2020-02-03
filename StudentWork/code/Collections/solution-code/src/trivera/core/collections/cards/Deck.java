package trivera.core.collections.cards;

import java.util.ArrayList;
import java.util.Collections;
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
 * This class is a wrapper around a List, and represents a deck of cards.
 *
 * While it would make more sense to represent the deck as a set than as a list,
 * there is no sufficient standard implementation of a set that would provide
 * the correct behavior. The HashSet cannot preserve order, which we want to do
 * to give our "shuffle" operation some meaning. The TreeSet always sorts the
 * elements in natural ordering, making it impossible to shuffle at all. So
 * while we really don't want the List behaviors of indexed access (you can only
 * take a card off the top), we do want the benefits of List, which are to
 * shuffle and to sort, and we want the order preserved without being forced
 * into natural object ordering.
 */
public class Deck {

    private List<Card> deck;

    /**
     * Constructs the deck of cards.
     *
     * This method creates an array of 52 Cards to store the list of cards. The
     * cards are created by using four for loops, each loop creating the range
     * of cards in that suit.
     * <P>
     * Once the array is filled with 52 cards, the deck is shuffled.
     */
    public Deck() {

        int i = 0;
        this.deck = new ArrayList<Card>(52);

        // Create the cards for each of the four suits.
        for (int a = Card.DEUCE; a <= Card.ACE; a++, i++)
            this.deck.add(i, new Card(Card.HEARTS, a));

        for (int a = Card.DEUCE; a <= Card.ACE; a++, i++)
            this.deck.add(i, new Card(Card.DIAMONDS, a));

        for (int a = Card.DEUCE; a <= Card.ACE; a++, i++)
            this.deck.add(i, new Card(Card.CLUBS, a));

        for (int a = Card.DEUCE; a <= Card.ACE; a++, i++)
            this.deck.add(i, new Card(Card.SPADES, a));

        // Shuffle the deck
        Collections.shuffle(deck);

    }

    /**
     * Returns the Card at the specified position in the deck.
     *
     * This method is used to perform sorting and shuffling.
     *
     * @param index
     *            Index of the card to return.
     *
     * @return The card at the specified position in the deck.
     *
     * @throws IndexOutOfBoundsException
     *             If the given index is out of range (<tt>index &lt; 0 || index &gt;= size()</tt>).
     */


    /**
     * Returns the supplied number of cards from the top of the deck.
     *
     * This method returns (and removes) the first N cards
     * from the top of the deck. The new list is sorted using the custom
     * comparator that sorts according to number, not suit.
     *
     * @return java.util.List The list of cards in the hand
     * @param count
     *            The number of cards to take from the top of the deck
     */
  public List<Card> dealCards(int count) {

        // Create the sub-list of N cards
        List<Card> cardHand = new ArrayList<Card>(count);

  // Deal each card into the hand
  for (int i=0; i<count; i++) {
	Card topCard = (Card)deck.remove(0);
	cardHand.add(topCard);
  }

        // Sort the sub-list, using our custom comparator
        Collections.sort(cardHand, new HandComparator());

        // Return the sorted sub-list
        return cardHand;
    }

    /**
     * Replaces the card at the specified position in the deck with the
     * specified card.
     * <p>
     *
     * This method is used for sorting and shuffling.
     *
     * @param index
     *            Index of card to replace.
     * @param element
     *            Card to be stored at the specified position.
     * @return The card previously at the specified position.
     *
     * @throws IllegalArgumentException
     *             If the object is not a Card
     *
     * @throws IndexOutOfBoundsException
     *             If the specified index is out of range (<tt>index &lt; 0 || index &gt;= size()</tt>).
     */


    /**
     * Returns the list of cards in the deck, sorted by suit.
     *
     * This method makes a copy of the deck, and sorts the copy using the
     * natural object ordering of the cards.
     *
     * An unmodifiable copy of the sorted copy is returned to the caller. Since
     * we've already made a copy of the real deck, we don't really have to make
     * yet a second copy that is unmodifiable, but we do so anyway just because
     * it's there!
     *
     * @return java.util.List An unmodifiable list of sorted cards
     */

  public List<Card> showDeck() {

        // Create a copy of the deck of cards
        List<Card> cardList = new ArrayList<Card>(deck);

        // Sort the copy using the natural object ordering of the cards
        Collections.sort(cardList);

        // Create an unmodifiable copy of the sorted copy, and return it
        return Collections.unmodifiableList(cardList);
    }

    /**
     * Shuffles the deck of cards.
     *
     * Before each hand is dealt, the cards are shuffled. Since we are dealing
     * from the true deck, it is the true deck contained as an instance field of
     * this class that must be shuffled.
     */
    public void shuffle() {

        // Shuffle this.deck

        Collections.shuffle(deck);

    }

    /**
     * Returns the number of cards in the deck.
     *
     * Should always return back 52.
     *
     * @return The number of cards in the deck
     */

}
