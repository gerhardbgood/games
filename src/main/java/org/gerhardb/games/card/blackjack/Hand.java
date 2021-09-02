package org.gerhardb.games.card.blackjack;

import java.util.ArrayList;

import org.gerhardb.games.card.deck.Card;

class Hand
{
	ArrayList<Card> cards = new ArrayList<>(12);
	
	Card getUpCard()
	{
		return this.cards.get(0);
	}
	
	void addCard(Card card)
	{
		this.cards.add(card);
	}
	
	int getScore()
	{
		int score = 0;
		int numberOfAces = 0;
		for(Card card:this.cards)
		{
			switch(card.getCardType())
			{
			case TWO:
				score += 2;
				break;
			case THREE:
				score += 3;
				break;
			case FOUR:
				score += 4;
				break;
			case FIVE:
				score += 5;
				break;
			case SIX:
				score += 6;
				break;
			case SEVEN:
				score += 7;
				break;
			case EIGHT:
				score += 8;
				break;
			case NINE:
				score += 9;
				break;
			case TEN:
			case JACK:
			case QUEEN:
			case KING:
				score += 10;
				break;
			case ACE:
				numberOfAces += 1;
				break;
			default:
				// do nothing
			}
			
		}		
		
		// Ace can be 1 or 11
		// Add in the aces to get as close to 21 as possible without going over.
		int acesLow = score + numberOfAces;
		
		// Only one ace can possibly be high because two high aces is 22 so player would be bust.
		int acesHigh = acesLow;
		if (numberOfAces > 0)
		{
			// All the aces have been added in already.
			// So just add in 10 which is 11 for one high minus the fact that we added the one with the numberOfAces.
			acesHigh += 10;
		}
		
		//System.out.println("Cards: " + this.cards.size() + "  Score: " + score + "  Aces: " + numberOfAces + "  Low: " + acesLow + "  High: " + acesHigh);
		
		if (acesHigh < 22)	
		{
			return acesHigh;
		}
		
		return acesLow;
	}
	
	@Override
	public String toString()
	{
		if (this.cards.size() == 0)
		{
			return "no cards in hand";
		}
		StringBuffer buff = new StringBuffer(200);
		for(Card card:this.cards)
		{
			buff.append(card);
			buff.append("  ");
		}
		return buff.toString();
	}
}
