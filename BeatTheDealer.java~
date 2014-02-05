// Kapri Lisehora
// Vegas style Blackjack


/*
 * for aces... check after each time is delt if it;s an ace to the total plus 11 or 1 see which works better and keep that value for it
 */
package beatTheDealer;

import java.util.Scanner;
import java.util.ArrayList;

public class BeatTheDealer extends CardValue
{
  public static void main(String[] args)
  {
      Scanner scanner = new Scanner(System.in);
  
      final int LIMIT = 21;
      final int DEALER_STAND = 17; //elements that can be referenced to check size
  
      boolean playerWon = false;
      boolean dealerWon = false;
  
      double bankBalance = 100; //for gambling
      int wager;
  
      int counter;
  
      ArrayList<String> dealer = new ArrayList<String>(); //keep track of the cards CURRENLTY in the dealer's hand. first card is not available to player
      int dealersPoints; //total points that round
      ArrayList<String> player = new ArrayList<String>(); //player's hand
      int playersPoints; //total points that round
  
    
    if ((playerWon == false) && (dealerWon == false)) //new game
    {
    System.out.println("Let's play Blackjack! Face cards are worth 10. An Ace is either worth 1 or 11; your call."); //start the game
    
    //betting
    System.out.println("The player's bank balance is $" + bankBalance + ". Bets are payed out 3:2. How much would you like to bet?");
    wager = scanner.nextInt();
    while (wager < 5)
    {
      System.out.println("Bets must be at least $5. How much would you like to bet?");
      wager = scanner.nextInt();
    }
    while (wager > bankBalance)
    {
      System.out.println("Bets can only be made with available funds. The player's bank balance is $" + bankBalance + ". How much would you like to bet?");
      wager = scanner.nextInt();
    }
    
    //dealer plays first
    dealer.add(Deck()); //add one card; keep secret
    dealer.add(Deck()); //add second card; show
    System.out.println("The dealer plays his initial two cards. His visible card is: " + dealer.get(1)); //second card 
    
    dealersPoints = cardValue(dealer.get(0)) + cardValue(dealer.get(1)); //format?? slot one and 2 in arraylist 
    //if total array value is less than DEALER_STAND; hit
         //else stand and play 
    // class that checks the value... 
    while (dealersPoints < DEALER_STAND) //16 or less
    {
      dealer.add(Deck());
      counter ++; //number of cards added
      // add to dealersPoints
      while (counter > 0) //imbedding following code instead,, fixed
      {
        int i = 2;
        System.out.println("The dealer hit. His card was: "+ dealer.get(i));
        dealersPoints += cardValue(dealer.get(i)); //add the value of new card
        i++; //next part in array
        counter =+ counter -1; //should put it back to 0
        
      }
    }
    
    //give player cards
    player.add(Deck()); //add one card; keep secret
    player.add(Deck()); //add second card; show
    System.out.println("The player is dealt the first card: The " + player.get(0) +". The second card is: The " + player.get(1));
    playersPoints = cardValue(player.get(0)) + cardValue(player.get(1)); //format?? slot one and 2 in arraylist 
    
    
    
//dealer reached 17 or higher
    //dealer is at 21 and so is player 
    if ((dealersPoints == LIMIT) && (playersPoints == LIMIT))
    {
      //tie.
      //cards discarded. arrays wiped clean. game restarts.
      System.out.println("Player has reached 21. The dealer flips his card. He is also at 21. The cards are discarded and play restarts with new cards. The player keeps the bet.");
      playersPoints = 0;
      dealersPoints = 0;
      dealer.clear(); //clears the arraylist
      player.clear();
      //going through the loop again will restart the game w/o the cards
    }
    //dealer is at 21 and player is not
    else if ((dealersPoints == LIMIT) && (playersPoints < LIMIT))
    {
      //dealer won... bet issues
      dealerWon = true;
    }
    
    //dealer is above 21 and so is player
    else if ((dealersPoints > LIMIT) && (playersPoints > LIMIT))
    {
      //draw, play again, bets... etc... both lost?
      System.out.println("The player and the dealer have both exceeded 21. The cards are discarded and play restarts with new cards. The player keeps the bet.");
      playersPoints = 0;
      dealersPoints = 0;
      dealer.clear();
      player.clear();
    }
    //dealer is above 21 and player is not
    else if ((dealersPoints > LIMIT) && (playersPoints < LIMIT))
    {
      //player wins
      System.out.println("Dealer busts!");
      playerWon = true;
    }
    
    //dealer is under 21 and so is player
    else if ((dealersPoints < LIMIT) && (playersPoints < LIMIT))
    {
      //play out player
      System.out.println("The dealer stands. He has " + (dealersPoints - cardValue(dealer.get(0))) + " points."); //how many points dealer has minus first card that's hidden to the player
      System.out.println("Hit or stand?");
      String decision = scanner.nextLine();
      
      if ((decision.equals("hit")) || (decision.equals("Hit")))
      {
        //hit
      }
      else
      {
        System.out.println("You stand. Your total is " + playersPoints + ". The dealer flips his first card. His total is " + dealersPoints + ". ");
        if (dealersPoints > playersPoints)
        {
          System.out.print("Player busts!");
          dealerWon = true;
        }
        else if (dealersPoints < playersPoints)
        {
          System.out.print("The player exceeds the dealer by " + (playersPoints - dealersPoints) +".");
          playerWon = true;
        }
        else //if they're equal
        {
          System.out.println("The player and the dealer tie. The cards are discarded and play restarts with new cards. The player keeps the bet.");
          playersPoints = 0;
          dealersPoints = 0;
          dealer.clear();
          player.clear();
        }
      }
      
    }
    //dealer is under 21 and player is not
    else if ((dealersPoints < LIMIT) && (playersPoints > LIMIT))
    {
      System.out.println("Player busts!");
      dealerWon = true;
    }  
    else System.out.println("Comparison error.");
    }
    
    //if the player won
    else if ((playerWon == true) && (dealerWon == false))
    {
      bankBalance =+ (wager*1.5); //house rules = 3:2
      System.out.println("The player wins! Bank balance: " + bankBalance);
      System.out.println("Play again? 1 = yes, 2 = no.");
      int choice = scanner.nextInt();
      
      if (choice == 1)
      {
        //play again... refill deck somehow
        playersPoints = 0;
        dealersPoints = 0;
        dealer.clear();
        player.clear();
      }
      else //no more games
      {
        System.out.println("You came to the table with $100 and are leaving with $" + bankBalance+". ");
        if (bankBalance == 100)
        {
          System.out.print("Breaking even is better than losing.");
        }
        else if (bankBalance > 100)
        {
          System.out.print("You are walking away with an extra $" + (bankBalance - 100) + "!");
        }
        else //lost money
        {
          System.out.print("You lost $" + (100 - bankBalance) + ". Better luck next time.");
        }
      }
    }
    
    //if dealer won
    else
    {
      bankBalance = bankBalance - wager; //lost the bet. ouchy
      
      System.out.println("The dealer wins! Bank balance: " + bankBalance);
      System.out.println("Play again? 1 = yes, 2 = no.");
      int choice = scanner.nextInt();
      
      if (choice == 1)
      {
        //play again... refill deck somehow
        playersPoints = 0;
        dealersPoints = 0;
        dealer.clear();
        player.clear();
      }
      else //no more games
      {
        System.out.println("You came to the table with $100 and are leaving with $" + bankBalance+". ");
        if (bankBalance == 100)
        {
          System.out.print("Breaking even is better than losing.");
        }
        else if (bankBalance > 100)
        {
          System.out.print("You are walking away with an extra $" + (bankBalance - 100) + "!");
        }
        else //lost money
        {
          System.out.print("You lost $" + (100 - bankBalance) + ". Better luck next time.");
        }
      }
    }
    }
  }