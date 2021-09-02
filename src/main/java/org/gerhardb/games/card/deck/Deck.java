package org.gerhardb.games.card.deck;

import java.util.ArrayList;
import java.util.Random;

public class Deck
{
	/**
	 * Like a brand new deck of cards you are opening.
	 */
	private ArrayList<Card> cardsInBoxOrder;
	ArrayList<Card> shuffledCards;
   Random random = new Random(); 
	
   public static Deck get52CardDeck()
   {
   	ArrayList<Card> cards = new ArrayList<>(52);
   	cards.addAll(Card.makeSuit(Card.SuitType.CLUBS));
   	cards.addAll(Card.makeSuit(Card.SuitType.DIAMONDS));
   	cards.addAll(Card.makeSuit(Card.SuitType.HEARTS));
   	cards.addAll(Card.makeSuit(Card.SuitType.SPADES));
   	return new Deck(cards);
   }
   
   public static Deck get54CardDeck()
   {
   	ArrayList<Card> cards = new ArrayList<>(52);
   	cards.addAll(Card.makeSuit(Card.SuitType.CLUBS));
   	cards.addAll(Card.makeSuit(Card.SuitType.DIAMONDS));
   	cards.addAll(Card.makeSuit(Card.SuitType.HEARTS));
   	cards.addAll(Card.makeSuit(Card.SuitType.SPADES));
   	cards.add(new Card(Card.CardType.JOKER, Card.SuitType.JOKER));
   	cards.add(new Card(Card.CardType.JOKER, Card.SuitType.JOKER));
   	return new Deck(cards);
   }
   
	@SuppressWarnings("unchecked")
	public Deck(ArrayList<Card> cardInBoxOrderInput)
	{
		if (cardInBoxOrderInput == null || cardInBoxOrderInput.size() < 2)
		{
			throw new RuntimeException("A deck needs more than one card.");
		}
		this.cardsInBoxOrder = cardInBoxOrderInput;
		this.shuffledCards = (ArrayList<Card>)this.cardsInBoxOrder.clone();
	}
	
	public Card getNextCard()
	{
		if (this.shuffledCards.size() == 0)
		{
			return null;
		}
		return this.shuffledCards.remove(0);
	}
	
	public void shuffle()
	{
		this.shuffledCards = new ArrayList<>(this.cardsInBoxOrder.size());
		
		// We will pick a card from the unshuffled deck and add it to the shuffled deck to shuffle.
		@SuppressWarnings("unchecked")
		ArrayList<Card> unshuffled = (ArrayList<Card>)this.cardsInBoxOrder.clone();
		while(!unshuffled.isEmpty())
		{
			this.shuffledCards.add(unshuffled.remove(this.random.nextInt(unshuffled.size())));
		}
		//System.out.println("Shuffling: Number of cards to start: " + this.cardsInBoxOrder.size() + "  Number of cards in shuffled deck: " + this.shuffledCards);
	}
	
	@Override
	public String toString()
	{
		StringBuffer buff = new StringBuffer(1000);
		for(Card card:this.shuffledCards)
		{
			buff.append(card);
			buff.append("\n");
		}
		return buff.toString();
	}

	@Override
	public int hashCode()
	{
		return this.shuffledCards.hashCode();
	}	
	
	@Override
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Deck))
		{
			return false;
		}
		
		Deck otherDeck = (Deck)obj;
		if (this.shuffledCards.size() != otherDeck.shuffledCards.size())
		{
			return false;
		}
		
		for(int i = 0; i<this.shuffledCards.size(); i++)
		{
			//System.out.println(this.shuffledCards.get(i) + "    " + otherDeck.shuffledCards.get(i));
			if (!this.shuffledCards.get(i).equals(otherDeck.shuffledCards.get(i)))
			{
				return false;
			}			
		}
		return true;
	}
}
