package org.gerhardb.games.card.blackjack;

import java.util.Scanner;

import org.gerhardb.games.card.Game;
import org.gerhardb.games.card.deck.Deck;

/**
 * 
 	The Object Of The Game: to get as close to or equal to 21 without going over.
	The Rules Are As Follows:
	- There will be only 2 players a human player and a dealer
	- The players are each dealt 2 cards to start the hand
	- The player can choose to hit one or more times, or stand with any amount
	- The dealer must hit if his cards total less than 17 and stand otherwise
	- If the player's or dealer's cards total over 21, they bust and their turn is over
	- If either player has 21 with their first two cards, they win (unless they both have 21 on their first two cards, in which case it is a tie)
	- If both players bust, the dealer wins
	- If both players have the same score, they tie
	- The player always takes their turn before the dealer
	- All cards count as their face value, except A which can be 1 or 11 and J, Q, K all count as 10
	- The deck should be shuffled before each game
	- You do not need to implement advanced blackjack rules (split, double or insurance)
	- Only one deck will be used per game
 *
 * @author Gerhard
 *
 */
public class Blackjack implements Game
{
	Scanner scanner;
	
	public Blackjack(Scanner scanner)
	{
		this.scanner = scanner;
	}
	
	@Override
	public void play()
	{
		Deck deck = Deck.get52CardDeck();
		deck.shuffle();		
		
		// There will be only 2 players � a �human� player and a dealer
		Hand player = new Hand();
		Hand dealer = new Hand();
		Decider.Outcome outcome = dealCards(deck, player, dealer);
		
		// Edge case of player or dealer having 21 on first round ends game.
		// If dealer had it, game is dealer or tie so only need to check player for edge case.
		if (outcome != Decider.Outcome.PLAYER || player.getScore() == 21)
		{
			System.out.println(" ");
			System.out.println("The winner is: " + outcome);	
			return;			
		}
		
		//  If the player�s or dealer�s cards total over 21, they bust and their turn is over
		while(player.getScore() < 22)
		{
			// The player can choose to hit one or more times, or stand with any amount
			System.out.println("Would you like another card? [y/n]");
			String takeAnotherCard = this.scanner.next().substring(0, 1).toLowerCase();
			if (takeAnotherCard.equals("n"))
			{
				break;
			}
			player.addCard(deck.getNextCard());
			System.out.println("The dealer is showing: " + dealer.getUpCard());
			System.out.println("Your hand is: " + player);		
		}
		
		outcome = dealerPlays(deck, player, dealer);
		System.out.println(" ");
		System.out.println("The winner is: " + outcome);		
	}
	
	static Decider.Outcome dealCards(Deck deck, Hand player, Hand dealer)
	{
		// The players are each dealt 2 cards to start the hand
		player.addCard(deck.getNextCard());
		dealer.addCard(deck.getNextCard());
		player.addCard(deck.getNextCard());
		dealer.addCard(deck.getNextCard());
		
		// If either player has 21 with their first two cards, they win (unless they both have 21 on their first two cards, in which case it is a tie)
		if (player.getScore() == 21 || dealer.getScore() == 21)
		{
			System.out.println(" ");
			System.out.println("Dealer's hand: " + dealer);
			System.out.println("Your hand is: " + player);		
			return Decider.whoWon(player.getScore(), dealer.getScore());
		}

		System.out.println(" ");
		System.out.println("The dealer is showing: " + dealer.getUpCard());
		System.out.println("Your hand is: " + player);		
		
		//  If the player�s or dealer�s cards total over 21, they bust and their turn is over
		if (player.getScore() > 21)
		{
			return Decider.whoWon(player.getScore(), dealer.getScore());
		}
		return Decider.Outcome.PLAYER;
	}
	
	static Decider.Outcome dealerPlays(Deck deck, Hand player, Hand dealer)
	{
		//  If the player�s or dealer�s cards total over 21, they bust and their turn is over
		if (player.getScore() > 21)
		{
			return Decider.whoWon(player.getScore(), dealer.getScore());
		}
		
		// Now we get to see dealer's hand
		System.out.println(" ");
		System.out.println("Dealer's hand: " + dealer);
		System.out.println("Your hand is: " + player);	
		
		//The dealer must hit if his cards total less than 17 and stand otherwise
		while(dealer.getScore() < 17)
		{
			dealer.addCard(deck.getNextCard());
			System.out.println(" ");
			System.out.println("Dealer's hand: " + dealer);
			System.out.println("Your hand is: " + player);		
		}

		return Decider.whoWon(player.getScore(), dealer.getScore());
	}
}
