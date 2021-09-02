package org.gerhardb.games.card.deck;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

@SuppressWarnings("static-method")
public class DeckTest
{
	@Test
	public void testCards()
	{
		Card aceOfSpades = new Card(Card.CardType.ACE, Card.SuitType.SPADES);
		Card anotherAceOfSpades = new Card(Card.CardType.ACE, Card.SuitType.SPADES);
		Card kingOfSpades = new Card(Card.CardType.KING, Card.SuitType.SPADES);
		Card kingOfClubs = new Card(Card.CardType.KING, Card.SuitType.CLUBS);
		
		Assert.assertEquals(aceOfSpades, anotherAceOfSpades); // test same card
		Assert.assertNotEquals(aceOfSpades, kingOfSpades); // test different card type
		Assert.assertNotEquals(kingOfSpades, kingOfClubs); // test different suit
	}
	
	@Test
	public void test52CardDeck()
	{
		Deck boxedOrder = Deck.get52CardDeck();
		//System.out.println(boxedOrder);
		//System.out.println("");
		Assert.assertTrue(boxedOrder.shuffledCards.size() == 52);
		
		Deck shuffledDeck = Deck.get52CardDeck();
		Assert.assertEquals(boxedOrder, shuffledDeck);
		
		shuffledDeck.shuffle();
		Assert.assertTrue(shuffledDeck.shuffledCards.size() == 52);
		Assert.assertNotEquals(boxedOrder, shuffledDeck);
		
		@SuppressWarnings("unchecked")
		ArrayList<Card> orginalShuffledCards = (ArrayList<Card>)shuffledDeck.shuffledCards.clone();
		shuffledDeck.shuffle();
		Assert.assertNotEquals(orginalShuffledCards, shuffledDeck.shuffledCards);
	}
	
	@Test
	public void test54CardDeck()
	{
		Deck boxedOrder = Deck.get54CardDeck();
		//System.out.println(boxedOrder);
		//System.out.println("");
		Assert.assertTrue(boxedOrder.shuffledCards.size() == 54);
		
		Deck shuffledDeck = Deck.get54CardDeck();
		Assert.assertEquals(boxedOrder, shuffledDeck);
		
		shuffledDeck.shuffle();
		Assert.assertTrue(shuffledDeck.shuffledCards.size() == 54);
		Assert.assertNotEquals(boxedOrder, shuffledDeck);
		
		@SuppressWarnings("unchecked")
		ArrayList<Card> orginalShuffledCards = (ArrayList<Card>)shuffledDeck.shuffledCards.clone();
		shuffledDeck.shuffle();
		Assert.assertNotEquals(orginalShuffledCards, shuffledDeck.shuffledCards);
	}
}
