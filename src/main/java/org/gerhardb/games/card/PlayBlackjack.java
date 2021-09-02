package org.gerhardb.games.card;

import java.util.Scanner;

import org.gerhardb.games.card.blackjack.Blackjack;

/**
 * @author Gerhard
 * Sample program for NextCentury.
 * 
 * Goals:
 * a) Get job at NextCentry
 * b) Demonstrate reusability
		i) Set up so deck can be reused in other games
		ii) Set up so graphical interface can be added at a later time
 * c) Demonstrate testability
 * 
 * Non-Goals:
 * a) Performance
 * b) JavaDocs
 * 	
 */
public class PlayBlackjack
{
	public static void main(String[] args)
	{
		System.out.println("Welcome to Blackjack!");
		try(Scanner scanner = new Scanner(System.in))
		{
			Game game = new Blackjack(scanner);
			String play = "y";
			while(play.equals("y"))
			{
				game.play();
				System.out.println("Would you like to play again? [y/n]");
				play = scanner.next().substring(0, 1).toLowerCase();
			}
		}
		System.out.println("Thanks for playing!  Come again soon!");
	}
}
