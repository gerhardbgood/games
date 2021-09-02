package org.gerhardb.games.card.blackjack;

/**
 * 
	The Rules Are As Follows:
	• There will be only 2 players – a “human” player and a dealer
	• If the player’s or dealer’s cards total over 21, they bust and their turn is over
	• If both players bust, the dealer wins
	• If both players have the same score, they tie
 *
 * @author Gerhard
 *
 */
public class Decider
{	
	public enum Outcome 
	{
	   PLAYER, DEALER, TIE
	}
	
	public static Outcome whoWon(int playerScore, int dealerScore)
	{
		// If both players bust, the dealer wins
		if (playerScore > 21)
		{
			return Outcome.DEALER;
		}
		if (dealerScore > 21)
		{
			return Outcome.PLAYER;
		}
		if (playerScore > dealerScore)
		{
			return Outcome.PLAYER;
		}
		if (dealerScore > playerScore)
		{
			return Outcome.DEALER;
		}
		return Outcome.TIE;
	}
	
}
