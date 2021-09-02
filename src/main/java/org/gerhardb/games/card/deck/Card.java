package org.gerhardb.games.card.deck;

import java.util.ArrayList;
import java.util.EnumSet;

public class Card
{
	public enum CardType 
	{
		// Ranked low to high for poker
	   TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE, JOKER
	}
	
	public enum SuitType 
	{
		// Ranked low to high for poker
	  	CLUBS, DIAMONDS, HEARTS, SPADES, JOKER
	}
	
	public static ArrayList<Card> makeSuit(SuitType suitType) 
	{
		if (suitType == null || suitType == SuitType.JOKER)
		{
			throw new RuntimeException("You need a SuitType to make a suit.");
		}
		ArrayList<Card> suit = new ArrayList<>(13);
		EnumSet.allOf(CardType.class).forEach(cardType -> addCard(suit, cardType, suitType));
		return suit;
	}
	
	private static void addCard(ArrayList<Card> suit, CardType cardType, SuitType suitType)
	{
		if (cardType != CardType.JOKER) 
		{
			suit.add(new Card(cardType, suitType));
		}
	}
	
	private CardType cardType;
	private SuitType suitType;
	
	public Card(CardType cardType, SuitType suitType)
	{
		if (cardType == null || suitType == null)
		{
			throw new RuntimeException("Cards need CardType and SuitType");
		}
		this.cardType = cardType;
		this.suitType = suitType;
	}

	public CardType getCardType()
	{
		return this.cardType;
	}

	public SuitType getSuitType()
	{
		return this.suitType;
	}
	
	@Override
	public String toString()
	{
		return this.cardType + " of " + this.suitType;
	}
	
	@Override
	public int hashCode()
	{
		return this.cardType.hashCode() + this.suitType.hashCode();
	}	
	
	@Override
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Card))
		{
			return false;
		}
		
		Card otherCard = (Card)obj;
		if (!this.cardType.equals(otherCard.cardType))
		{
			return false;
		}
		
		if (!this.suitType.equals(otherCard.suitType))
		{
			return false;
		}
		
		return true;
	}
}
