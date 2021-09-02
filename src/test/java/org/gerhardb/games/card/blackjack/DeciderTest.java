package org.gerhardb.games.card.blackjack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeciderTest
{	
	@Test
	public static void testDeciderWhoWon()
	{
		// If the player’s or dealer’s cards total over 21, they bust and their turn is over
		Assert.assertEquals(Decider.whoWon(21, 22), Decider.Outcome.PLAYER); 
		Assert.assertEquals(Decider.whoWon(22, 21), Decider.Outcome.DEALER); 
		
		// If both players bust, the dealer wins
		Assert.assertEquals(Decider.whoWon(22, 22), Decider.Outcome.DEALER);
		
		// If both players have the same score, they tie
		Assert.assertEquals(Decider.whoWon(19, 19), Decider.Outcome.TIE); 
		Assert.assertEquals(Decider.whoWon(20, 20), Decider.Outcome.TIE); 
		Assert.assertEquals(Decider.whoWon(21, 21), Decider.Outcome.TIE); 
		
		// Other Scores - constant dealer
		Assert.assertEquals(Decider.whoWon(15, 17), Decider.Outcome.DEALER); 
		Assert.assertEquals(Decider.whoWon(16, 17), Decider.Outcome.DEALER); 
		Assert.assertEquals(Decider.whoWon(17, 17), Decider.Outcome.TIE); 
		Assert.assertEquals(Decider.whoWon(18, 17), Decider.Outcome.PLAYER); 
		Assert.assertEquals(Decider.whoWon(19, 17), Decider.Outcome.PLAYER); 
		Assert.assertEquals(Decider.whoWon(20, 17), Decider.Outcome.PLAYER); 
		Assert.assertEquals(Decider.whoWon(21, 17), Decider.Outcome.PLAYER); 
		Assert.assertEquals(Decider.whoWon(22, 17), Decider.Outcome.DEALER); 
		
		// Other Scores - constant player
		Assert.assertEquals(Decider.whoWon(19, 15), Decider.Outcome.PLAYER); 
		Assert.assertEquals(Decider.whoWon(19, 16), Decider.Outcome.PLAYER); 
		Assert.assertEquals(Decider.whoWon(19, 17), Decider.Outcome.PLAYER); 
		Assert.assertEquals(Decider.whoWon(19, 18), Decider.Outcome.PLAYER); 
		Assert.assertEquals(Decider.whoWon(19, 19), Decider.Outcome.TIE); 
		Assert.assertEquals(Decider.whoWon(19, 20), Decider.Outcome.DEALER); 
		Assert.assertEquals(Decider.whoWon(19, 21), Decider.Outcome.DEALER); 
		Assert.assertEquals(Decider.whoWon(19, 22), Decider.Outcome.PLAYER); 
	}
}
