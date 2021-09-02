package org.gerhardb.games.card.blackjack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HandTest
{
	@Test
	public static void testHands()
	{
		Hand aHand = new Hand();

		// Individual Cards
		aHand = new Hand();
		aHand.addCard(TestDeck.twoOfClubs);
		Assert.assertEquals(aHand.getScore(), 2); 

		aHand = new Hand();
		aHand.addCard(TestDeck.threeOfClubs);
		Assert.assertEquals(aHand.getScore(), 3); 

		aHand = new Hand();
		aHand.addCard(TestDeck.fourOfClubs);
		Assert.assertEquals(aHand.getScore(), 4); 

		aHand = new Hand();
		aHand.addCard(TestDeck.fiveOfClubs);
		Assert.assertEquals(aHand.getScore(), 5); 

		aHand = new Hand();
		aHand.addCard(TestDeck.sixOfClubs);
		Assert.assertEquals(aHand.getScore(), 6); 

		aHand = new Hand();
		aHand.addCard(TestDeck.sevenOfClubs);
		Assert.assertEquals(aHand.getScore(), 7); 

		aHand = new Hand();
		aHand.addCard(TestDeck.eightOfClubs);
		Assert.assertEquals(aHand.getScore(), 8); 

		aHand = new Hand();
		aHand.addCard(TestDeck.nineOfClubs);
		Assert.assertEquals(aHand.getScore(), 9); 

		aHand = new Hand();
		aHand.addCard(TestDeck.tenOfClubs);
		Assert.assertEquals(aHand.getScore(), 10); 

		aHand = new Hand();
		aHand.addCard(TestDeck.jackOfClubs);
		Assert.assertEquals(aHand.getScore(), 10); 

		aHand = new Hand();
		aHand.addCard(TestDeck.queenOfClubs);
		Assert.assertEquals(aHand.getScore(), 10); 

		aHand = new Hand();
		aHand.addCard(TestDeck.kingOfClubs);
		Assert.assertEquals(aHand.getScore(), 10); 

		aHand = new Hand();
		aHand.addCard(TestDeck.aceOfClubs);
		Assert.assertEquals(aHand.getScore(), 11); 		
		
		// Lowest Possible Deal
		aHand = new Hand();
		aHand.addCard(TestDeck.aceOfClubs);
		Assert.assertEquals(aHand.getScore(), 11); 
		aHand.addCard(TestDeck.aceOfDiamonds);
		Assert.assertEquals(aHand.getScore(), 12); 
		aHand.addCard(TestDeck.aceOfHearts);
		Assert.assertEquals(aHand.getScore(), 13); 
		aHand.addCard(TestDeck.aceOfSpades);
		Assert.assertEquals(aHand.getScore(), 14); 
		
		aHand.addCard(TestDeck.twoOfClubs);
		Assert.assertEquals(aHand.getScore(), 16); 
		aHand.addCard(TestDeck.twoOfHearts);
		Assert.assertEquals(aHand.getScore(), 18); 
		aHand.addCard(TestDeck.twoOfHearts);
		Assert.assertEquals(aHand.getScore(), 20); 
		aHand.addCard(TestDeck.twoOfSpades);
		Assert.assertEquals(aHand.getScore(), 12); 
		
		aHand.addCard(TestDeck.threeOfClubs);
		Assert.assertEquals(aHand.getScore(), 15); 
		aHand.addCard(TestDeck.threeOfHearts);
		Assert.assertEquals(aHand.getScore(), 18); 
		aHand.addCard(TestDeck.threeOfHearts);
		Assert.assertEquals(aHand.getScore(), 21); 
		aHand.addCard(TestDeck.threeOfSpades);
		Assert.assertEquals(aHand.getScore(), 24); 
		
		// Ace Deal
		aHand = new Hand();
		aHand.addCard(TestDeck.kingOfClubs);
		Assert.assertEquals(aHand.getScore(), 10); 
		aHand.addCard(TestDeck.aceOfDiamonds);
		Assert.assertEquals(aHand.getScore(), 21); 
		
		// High Deal
		aHand = new Hand();
		aHand.addCard(TestDeck.kingOfClubs);
		Assert.assertEquals(aHand.getScore(), 10); 
		aHand.addCard(TestDeck.kingOfHearts);
		Assert.assertEquals(aHand.getScore(), 20); 
		aHand.addCard(TestDeck.aceOfDiamonds);
		Assert.assertEquals(aHand.getScore(), 21); 
		aHand.addCard(TestDeck.aceOfHearts);
		Assert.assertEquals(aHand.getScore(), 22); 
		
		// "Random" Deal
		aHand = new Hand();
		aHand.addCard(TestDeck.fourOfClubs);
		Assert.assertEquals(aHand.getScore(), 4); 
		aHand.addCard(TestDeck.sevenOfClubs);
		Assert.assertEquals(aHand.getScore(), 11); 
		aHand.addCard(TestDeck.fiveOfClubs);
		Assert.assertEquals(aHand.getScore(), 16); 
		aHand.addCard(TestDeck.tenOfClubs);
		Assert.assertEquals(aHand.getScore(), 26); 
		
		// "Random" Deal
		aHand = new Hand();
		aHand.addCard(TestDeck.eightOfClubs);
		Assert.assertEquals(aHand.getScore(), 8); 
		aHand.addCard(TestDeck.threeOfClubs);
		Assert.assertEquals(aHand.getScore(), 11); 
		aHand.addCard(TestDeck.jackOfClubs);
		Assert.assertEquals(aHand.getScore(), 21); 
		aHand.addCard(TestDeck.aceOfClubs);
		Assert.assertEquals(aHand.getScore(), 22); 
		
		// To String
		aHand = new Hand();
		aHand.addCard(TestDeck.fourOfClubs);
		aHand.addCard(TestDeck.sevenOfClubs);
		aHand.addCard(TestDeck.jackOfClubs);
		Assert.assertEquals(aHand.toString(), "FOUR of CLUBS  SEVEN of CLUBS  JACK of CLUBS  "); 
	}
}
