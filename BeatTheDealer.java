// Kapri Lisehora
// Vegas style Blackjack


/*
 * for aces... check after each time is delt if it;s an ace to the total plus 11 or 1 see which works better and keep that value for it
 * 
 * make decimal show two places
 * 
 * make sure 'the player' is in second person not third
 * 
 *  System.out.println("The dealer plays his initial two cards. His visible card is: " + dealer.get(1) + " (first card for testing: " + dealer.get(0)); //second card 
 fix that later
 */
package beatTheDealer;

import java.util.Scanner;
import java.util.ArrayList;

public class BeatTheDealer
{
    static Scanner scanner = new Scanner(System.in);
    
    static final int LIMIT = 21;
    static final int DEALER_STAND = 17;
    
    // Deck newDeck = new Deck();
    
    static int i = 2; //for when the dealer hits. needs to be called outside and this is useful
    static int temp3 = 0;
    static String decision = "";
    
    static boolean playerWon = false;
    static boolean dealerWon = false;
    
    static boolean playerAce = false;
    static boolean dealerAce = false; //if they have an ace... 1vs11
    
    static double bankBalance = 100.00; //for gambling
    static int wager = 0;
    
    static int counter = 0;
    static int playerCounter = 0;
    
    static ArrayList<String> dealer = new ArrayList<String>(); //keep track of the cards CURRENLTY in the dealer's hand. first card is not available to player
    static int dealersPoints = 0; //total points that round
    static ArrayList<String> player = new ArrayList<String>(); //player's hand
    static int playersPoints = 0; //total points that round
    
  public static void main(String[] args)
  {
    
    if ((playerWon == false) && (dealerWon == false)) //new game
    {

      
      System.out.println("Let's play Blackjack! Face cards are worth 10. An Ace is either worth 1 or 11; your call."); //start the game
      
      //betting
      System.out.println("Your bank balance is $" + bankBalance + ". Bets are payed out 3:2. How much would you like to bet?");
      wager = scanner.nextInt();
      while (wager < 5)
      {
        System.out.println("Bets must be at least $5. How much would you like to bet?");
        wager = scanner.nextInt();
      }
      while (wager > bankBalance)
      {
        System.out.println("Bets can only be made with available funds. Your bank balance is $" + bankBalance + ". How much would you like to bet?");
        wager = scanner.nextInt();
      }
      
      //dealer plays first
      dealer.add(Deck.Deck()); //add one card; keep secret
      dealer.add(Deck.Deck()); //add second card; show
      System.out.println("The dealer plays his initial two cards. His visible card is: " + dealer.get(1) + " (first card for testing: " + dealer.get(0)); //second card 
      
      if ((CardValue.cardValue(dealer.get(0)) == 1) || (CardValue.cardValue(dealer.get(1)) == 1)) //if has an ace
      {
        dealerAce = true;
      }
      
      dealersPoints = CardValue.cardValue(dealer.get(0)) + CardValue.cardValue(dealer.get(1)); //slot one and 2 in arraylist 
      //if total array value is less than DEALER_STAND; hit
      //else stand and play 
      // class that checks the value... 
      while (dealersPoints < DEALER_STAND) //16 or less
      {
        //oh, you have an ace? let's check which value you want :D
        if ((dealerAce == true) && ((dealersPoints + 10 <= LIMIT) && (dealersPoints + 10 >= DEALER_STAND))) //if has ace and that ace being 11 is between 17 and 21
        {
          dealersPoints = dealersPoints + 10; //now that ace is worth 11
          dealerAce = true;
        }
        
        else // no ace, do it normally
        {
          dealer.add(Deck.Deck());
          counter += 1; //number of cards added
          // add to dealersPoints
          while (counter > 0) //imbedding following code instead,, fixed
          {
            System.out.println("The dealer hit. His card was: "+ dealer.get(i));
            dealersPoints += CardValue.cardValue(dealer.get(i)); //add the value of new card
            i++; //next part in array
            counter =+ counter -1; //should put it back to 0
            
          }
        }
      }
      
      //give player cards
      player.add(Deck.Deck()); //add one card; keep secret
      player.add(Deck.Deck()); //add second card; show
      System.out.println("You're dealt your first card: The " + player.get(0) +". Your second card is: The " + player.get(1));
      int temp = CardValue.cardValue(player.get(0));
      int temp2 = CardValue.cardValue(player.get(1));
      playersPoints = temp + temp2;  //cannot add CardValue.cardvalue etc directly.
      
      if (CardValue.cardValue(player.get(0)) == 1) playerAce = true; //has ace
      if (CardValue.cardValue(player.get(1)) == 1) playerAce = true;
      
      
      
      //FOR TESTING XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
      System.out.println("Dealers's points = " + dealersPoints);
      System.out.println("Card value... dealer.get(0) = " + CardValue.cardValue(dealer.get(0)));
      System.out.println("Player's points = " + playersPoints);
      System.out.println("Card value... player.get(0) = " + CardValue.cardValue(player.get(0)));
      
      
      
//dealer reached 17 or higher
      //dealer is at 21 and so is player 
      if ((dealersPoints == LIMIT) && (playersPoints == LIMIT))
      {
        //tie.
        //cards discarded. arrays wiped clean. game restarts.
        System.out.println("You have reached 21. The dealer flips his card. He is also at 21. The cards are discarded and play restarts with new cards. You keep your bet.");
        playersPoints = 0;
        dealersPoints = 0;
        dealer.clear(); //clears the arraylist
        player.clear();
        //going through the loop again will restart the game w/o the cards
      }
      
      //dealer is at 21 and player is not
      else if ((dealersPoints == LIMIT) && (playersPoints < LIMIT))
      {
        playOutPlayer();
      }
      
      
      //dealer is above 21 and so is player
      else if ((dealersPoints > LIMIT) && (playersPoints > LIMIT))
      {
        //draw, play again, bets... etc... both lost?
        System.out.println("The dealer flips his card. He has " + dealersPoints + " points. You and the dealer have both exceeded 21. The cards are discarded and play restarts with new cards. You keep your bet.");
        playersPoints = 0;
        dealersPoints = 0;
        dealer.clear();
        player.clear();
      }
      //dealer is above 21 and player is not
      else if ((dealersPoints > LIMIT) && (playersPoints < LIMIT))
      {
        playOutPlayer();
      }
      
      //dealer is under 21 and so is player
      else if ((dealersPoints < LIMIT) && (playersPoints < LIMIT)) // PLAY OUT PLAYER
      {
        playOutPlayer();
      }
      //dealer is under 21 and player is not
      else if ((dealersPoints < LIMIT) && (playersPoints > LIMIT))
      {
        System.out.println("Player busts!");
        dealerWon = true;
      }  
      
      else System.out.println("Comparison error."); //if it cannot compare either score
    }
    
    
    
//if the player won
    if ((playerWon == true) && (dealerWon == false))
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
    if ((dealerWon == true) && (playerWon == false))
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
    }
  }
  
  private static void playOutPlayer()
  {
            //play out player
        System.out.println("The dealer stands. He has " + (dealersPoints - CardValue.cardValue(dealer.get(0))) + " visible points."); //how many points dealer has minus first card that's hidden to the player
        System.out.println("Hit or stand?");
        decision = scanner.nextLine();
        
        if (decision.toLowerCase().equals("hit"))
        {
          //hit
          if (playersPoints <= LIMIT) //21 or less ... if not should go to the other if statement where player loses
          {
            player.add(Deck.Deck()); //add another card
            playerCounter += playerCounter + 1; //number of cards added
            System.out.println("You are dealt: " + player.get(playerCounter) + "."); //tell them which card
            playersPoints += CardValue.cardValue(dealer.get(playerCounter)); //add value of that card to their total points
          }
        }
        else if (decision.toLowerCase().equals("stand")) //stand
        {
          //oh, you have an ace? let's check which value you want :D
          if ((playerAce == true) && (playersPoints + 10 <= LIMIT)) //if has ace and that ace being 11 is less than or equal to 21
          {
            dealersPoints = dealersPoints + 10; //now that ace is worth 11
          }
          
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
}



