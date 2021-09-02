package org.gerhardb.games.card.blackjack;

import java.util.ArrayList;

import org.gerhardb.games.card.deck.Card;
import org.gerhardb.games.card.deck.Deck;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BlackjackTest
{
	@Test
	public static void testGamePlay()
	{
		// If either player has 21 with their first two cards, they win (unless they both have 21 on their first two cards, in which case it is a tie)
   	ArrayList<Card> cards = new ArrayList<>(52);
   	cards.add(TestDeck.aceOfClubs); // player's first card
   	cards.add(TestDeck.aceOfDiamonds); // dealer's first card
   	cards.add(TestDeck.kingOfClubs); // player's second card
   	cards.add(TestDeck.queenOfClubs); // dealer's second card

		System.out.println(" ");
		System.out.println("Game #1");
		Deck deck = new Deck(cards);	
		Hand player = new Hand();
		Hand dealer = new Hand();
		Decider.Outcome outcome = Blackjack.dealCards(deck, player, dealer);
		Assert.assertEquals(outcome, Decider.Outcome.TIE); 

	  	cards = new ArrayList<>(52);
   	cards.add(TestDeck.aceOfClubs); // player's first card
   	cards.add(TestDeck.aceOfDiamonds); // dealer's first card
   	cards.add(TestDeck.kingOfClubs); // player's second card
   	cards.add(TestDeck.nineOfClubs); // dealer's second card
   	
		System.out.println(" ");
		System.out.println("Game #2");
		deck = new Deck(cards);
		player = new Hand();
		dealer = new Hand();
		outcome = Blackjack.dealCards(deck, player, dealer);
		Assert.assertEquals(outcome, Decider.Outcome.PLAYER); 
		
	  	cards = new ArrayList<>(52);
   	cards.add(TestDeck.aceOfClubs); // player's first card
   	cards.add(TestDeck.aceOfDiamonds); // dealer's first card
   	cards.add(TestDeck.nineOfClubs); // player's second card
   	cards.add(TestDeck.kingOfClubs); // dealer's second card
   	
		System.out.println(" ");
		System.out.println("Game #3");
		deck = new Deck(cards);
		player = new Hand();
		dealer = new Hand();
		outcome = Blackjack.dealCards(deck, player, dealer);
		Assert.assertEquals(outcome, Decider.Outcome.DEALER); 

	  	cards = new ArrayList<>(52);
   	cards.add(TestDeck.jackOfClubs); 	// player's first card
   	cards.add(TestDeck.jackOfDiamonds); // dealer's first card
   	cards.add(TestDeck.eightOfClubs); 	// player's second card
   	cards.add(TestDeck.sixOfClubs); 	// dealer's second card
   	cards.add(TestDeck.threeOfClubs); 
   	cards.add(TestDeck.twoOfClubs); 
   	
		System.out.println(" ");
		System.out.println("Game #4");
		deck = new Deck(cards);
		player = new Hand();
		dealer = new Hand();
		outcome = Blackjack.dealCards(deck, player, dealer);
		// player 18 dealer 16
		player.addCard(deck.getNextCard());
		// player 21 dealer 16
		outcome = Blackjack.dealerPlays(deck, player, dealer);
		Assert.assertEquals(outcome, Decider.Outcome.PLAYER);  
		System.out.println("=============================================================");
  	
		System.out.println(" ");
		System.out.println("Game #5");
		deck = new Deck(cards);
		player = new Hand();
		dealer = new Hand();
		outcome = Blackjack.dealCards(deck, player, dealer);
		// player 18 dealer 16
		outcome = Blackjack.dealerPlays(deck, player, dealer);
		Assert.assertEquals(outcome, Decider.Outcome.DEALER);  
		System.out.println("=============================================================");
		
	  	cards = new ArrayList<>(52);
   	cards.add(TestDeck.jackOfClubs); 	// player's first card
   	cards.add(TestDeck.jackOfDiamonds); // dealer's first card
   	cards.add(TestDeck.eightOfClubs); 	// player's second card
   	cards.add(TestDeck.sixOfClubs); 		// dealer's second card
   	cards.add(TestDeck.fourOfClubs); 

		System.out.println(" ");
		System.out.println("Game #6");
		deck = new Deck(cards);
		player = new Hand();
		dealer = new Hand();
		outcome = Blackjack.dealCards(deck, player, dealer);
		// player 18 dealer 16
		player.addCard(deck.getNextCard());
		// player 22 dealer 16
		outcome = Blackjack.dealerPlays(deck, player, dealer);
		Assert.assertEquals(outcome, Decider.Outcome.DEALER);  
		System.out.println("=============================================================");

		System.out.println(" ");
		System.out.println("Game #7");
		deck = new Deck(cards);
		player = new Hand();
		dealer = new Hand();
		outcome = Blackjack.dealCards(deck, player, dealer);
		// player 18 dealer 16
		outcome = Blackjack.dealerPlays(deck, player, dealer);
		Assert.assertEquals(outcome, Decider.Outcome.DEALER);  
		System.out.println("=============================================================");
		
	  	cards = new ArrayList<>(52);
   	cards.add(TestDeck.jackOfClubs); 	// player's first card
   	cards.add(TestDeck.jackOfDiamonds); // dealer's first card
   	cards.add(TestDeck.threeOfClubs); 	// player's second card
   	cards.add(TestDeck.fourOfClubs); 	// dealer's second card
   	cards.add(TestDeck.twoOfClubs); 
   	cards.add(TestDeck.fourOfHearts); 
   	cards.add(TestDeck.twoOfDiamonds); 
   	cards.add(TestDeck.threeOfDiamonds); 
   	cards.add(TestDeck.twoOfHearts); 
   	cards.add(TestDeck.threeOfHearts); 

		System.out.println(" ");
		System.out.println("Game #8");
		deck = new Deck(cards);
		player = new Hand();
		dealer = new Hand();
		outcome = Blackjack.dealCards(deck, player, dealer);
		// player 13 dealer 14
		outcome = Blackjack.dealerPlays(deck, player, dealer);
		Assert.assertEquals(outcome, Decider.Outcome.DEALER);  
		System.out.println("=============================================================");

		System.out.println(" ");
		System.out.println("Game #9");
		deck = new Deck(cards);
		player = new Hand();
		dealer = new Hand();
		outcome = Blackjack.dealCards(deck, player, dealer);
		// player 13 dealer 14
		player.addCard(deck.getNextCard());
		// player 15 dealer 16
		outcome = Blackjack.dealerPlays(deck, player, dealer);
		Assert.assertEquals(outcome, Decider.Outcome.DEALER);  
		System.out.println("=============================================================");

		System.out.println(" ");
		System.out.println("Game #10");
		deck = new Deck(cards);
		player = new Hand();
		dealer = new Hand();
		outcome = Blackjack.dealCards(deck, player, dealer);
		// player 13 dealer 14
		player.addCard(deck.getNextCard());
		// player 15 dealer 14
		player.addCard(deck.getNextCard());
		// player 19 dealer 14
		outcome = Blackjack.dealerPlays(deck, player, dealer);
		Assert.assertEquals(outcome, Decider.Outcome.TIE);  
		System.out.println("=============================================================");

		System.out.println(" ");
		System.out.println("Game #11");
		deck = new Deck(cards);
		player = new Hand();
		dealer = new Hand();
		outcome = Blackjack.dealCards(deck, player, dealer);
		// player 13 dealer 14
		player.addCard(deck.getNextCard());
		// player 15 dealer 14
		player.addCard(deck.getNextCard());
		// player 19 dealer 14
		player.addCard(deck.getNextCard());
		// player 21 dealer 14
		outcome = Blackjack.dealerPlays(deck, player, dealer);
		Assert.assertEquals(outcome, Decider.Outcome.PLAYER);  
		System.out.println("=============================================================");
	}
}