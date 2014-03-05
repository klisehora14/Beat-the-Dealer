// Kapri Lisehora
// Vegas style Blackjack


/*
 * make decimal show two places
 *
 */
package beatTheDealer;

import java.util.Scanner;
import java.util.ArrayList;

public class BeatTheDealer
{
  static Scanner scanner = new Scanner(System.in);
  static Scanner sc = new Scanner(System.in);
  
  static final int LIMIT = 21;
  static final int DEALER_STAND = 17;
  
  
  static int i = 2; //for when the dealer hits. needs to be called outside and this is useful
  static int temp3 = 0;
  static String decision = "";
  
  static boolean playerWon = false;
  static boolean dealerWon = false;
  
  static boolean playerAce = false;
  static boolean dealerAce = false; //if they have an ace... 1vs11
  static boolean gameOver = false;
  
  static double bankBalance = 100.00; //for gambling
  static int wager = 0;
  
  static int counter = 0;
  static int playerCounter = 1; //player starts off with two cards in their hand but array starts at slot 0
  static int choice = 0;
  
  static ArrayList<String> dealer = new ArrayList<String>(); //keep track of the cards CURRENLTY in the dealer's hand. first card is not available to player
  static int dealersPoints = 0; //total points that round
  static ArrayList<String> player = new ArrayList<String>(); //player's hand
  static int playersPoints = 0; //total points that round
  
  public static void main(String[] args) //beatTheDealer()
  {
    if (gameOver == false)
    {
      while ((playerWon == false) && (dealerWon == false)) //new game
      {
        System.out.println("Let's play Blackjack! Face cards are worth 10. An Ace is either worth 1 or 11; your call."); //start the game
        
        //ask the player what his/her bet is
        betting();
        
        //deal out cards to dealer and player
        dealCards();
        
        while ((playerWon == false) || (dealerWon == false))
        {
          if (playersPoints == 21) playerWon = true;
          if (dealersPoints == 21) dealerWon = true;
          
          playPlayer();
          
        }
      }
    }
    
    if (gameOver == true)
    {
      System.out.println("Game over.");
    }
  }
  
  

  private static void playOutPlayer()
  {
    //play out player
    if (playersPoints < 21)
    {
      System.out.println("The dealer has " + (dealersPoints - CardValue.cardValue(dealer.get(0))) + " visible points."); //how many points dealer has minus first card that's hidden to the player
      
      System.out.println("Hit or stand?");
      decision = sc.nextLine();
      
      if (decision.toLowerCase().equals("hit"))
      {
        //hit
        if (playersPoints <= LIMIT) //21 or less ... if not should go to the other if statement where player loses
        {
          player.add(Deck.deck()); //add another card
          playerCounter += playerCounter + 1; //number of cards added
          System.out.println("playercounter = " + playerCounter); // TO CHECK
          
          System.out.println("You are dealt: " + player.get(playerCounter - 1) + "."); //tell them which card
          playersPoints += CardValue.cardValue(dealer.get(dealer.size()-1)); //add value of that card to their total points
          System.out.println("playersPoints = " + playersPoints); //bug checker
        }
        else
        {
          dealerWon = true;
          whoWon(playerWon, dealerWon);
        }
      }
      if (decision.toLowerCase().equals("stand")) //stand
      {
        //oh, you have an ace? let's check which value you want :D
        for (int i = 0; i < player.size(); i ++) // go through each card
        {
          if (CardValue.cardValue(player.get(i)) == 1) 
          {
            playerAce = true; //has ace
            System.out.println("There is an ace."); //bug checker
          }
          else System.out.println("There wasn't an ace."); //bug checker
        }
        
        if ((playerAce == true) && ((playersPoints + 10) <= LIMIT)) //if has ace and that ace being 11 is less than or equal to 21
        {
          playersPoints = playersPoints + 10; //now that ace is worth 11
          System.out.println("Added 10 because of ace being good."); //bug checker
        }
        if ((playerAce == true) && ((playersPoints + 10) > LIMIT)) //ace should be worth 1
        {
          //bug check
          System.out.println("Ace = 1.");
        }
        
        System.out.println("Outside of ace loop."); // bug checker
        
        System.out.println("You stand. Your total is " + playersPoints + ". The dealer flips his first card. His total is " + dealersPoints + ". ");
        
        //check to see who has larger CHECKXDX
        checkStand(dealersPoints, playersPoints);
        
//        System.out.println("playerWon = " + playerWon + "; dealerWon = " + dealerWon); //bug check
//        whoWon(playerWon, dealerWon); //added new
      }
    }
    
    if (playersPoints == 21) 
    {
      playerWon = true;
      whoWon(playerWon, dealerWon);
    }
    
    else if ((playersPoints >= LIMIT) || (dealersPoints >= LIMIT)) //they're both at, or over, 21
    {
      
      if ((dealersPoints > playersPoints) && (dealersPoints <= LIMIT)) //dealer has more points than player and is at most 21
      {
        System.out.print("Player busts!");
        dealerWon = true;
        whoWon(playerWon, dealerWon);
      }
      else if ((dealersPoints < playersPoints) && (playersPoints <= LIMIT)) //player has more points than dealer and is at most 21
      {
        System.out.print("The player exceeds the dealer by " + (playersPoints - dealersPoints) + " points.");
        playerWon = true;
        whoWon(playerWon, dealerWon);
      }
    }
    else if ((dealersPoints == playersPoints) && (playersPoints == LIMIT)) //if they're equal 21
    {
      System.out.println("The player and the dealer tie. The cards are discarded and play restarts with new cards. The player keeps the bet.");
      reset();
    }     
  }
  
  private static void dealCards()
  {
    //dealer plays first
    dealer.add(Deck.deck()); //add one card; keep secret
    dealer.add(Deck.deck()); //add second card; show
    System.out.println("The dealer plays his initial two cards. His visible card is: " + dealer.get(1)); //second card 
    
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
        dealer.add(Deck.deck());
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
    player.add(Deck.deck()); //add one card; keep secret
    player.add(Deck.deck()); //add second card; show
    System.out.println("You're dealt your first card: The " + player.get(0) +". Your second card is: The " + player.get(1));
    int temp = CardValue.cardValue(player.get(0));
    int temp2 = CardValue.cardValue(player.get(1));
    playersPoints = temp + temp2;  //cannot add CardValue.cardvalue etc directly.
    
    
    //FOR TESTING XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    System.out.println("Dealers's points = " + dealersPoints);
    System.out.println("Player's points = " + playersPoints);
  }
  
  private static void betting()
  {
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
  }
  
  private static void reset() //resets the accounts
  {
    //play again... refill deck somehow
    playersPoints = 0;
    dealersPoints = 0;
    
    for (int i = 0; i < dealer.size(); i++) //go through however many cards the dealer has
    {
      Deck.refillTheDeck(dealer.get(i)); //give the 'copy' of the card so it can be put back into the deck
    }
    
    for (int i = 0; i < player.size(); i++) //go through however many cards the player has
    {
      Deck.refillTheDeck(player.get(i)); //give the 'copy' of the card so it can be put back into the deck
    }
    
    dealer.clear(); //clear all of the cards from the dealer and player's hands
    player.clear();
    System.out.println("cleared dealer and player"); //bug check
    
    playerWon = false;
    dealerWon = false;
    System.out.println("playerwon and dealerwon = false"); //bug check
  }
  
  
  
  private static void noMoreGames() //game over
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
      System.out.print("You lost $" + (100 - Math.abs(bankBalance)) + ". Better luck next time."); //absolute value
    }
    
    gameOver = true;
    System.out.println("gameOver == " + gameOver); //bug check
  }
  
  
  
  private static void playPlayer() //goes through possible transactions the player would have with the cards/dealer... allows the player to play the game
  {
    //dealer reached 17 or higher
    //dealer is at 21 and so is player 
    if ((dealersPoints == LIMIT) && (playersPoints == LIMIT))
    {
      //tie.
      //cards discarded. arrays wiped clean. game restarts.
      System.out.println("You have reached 21. The dealer flips his card. He is also at 21. The cards are discarded and play restarts with new cards. You keep your bet.");
      reset(); //clears hands and dealer/playersPoints
    }
    
    //dealer is at 21 and player is not
    else if ((dealersPoints == LIMIT) && (playersPoints < LIMIT))
    {
      dealerWon = true;
      whoWon(playerWon, dealerWon);
    }
    
    //dealer is above 21 and so is player
    else if ((dealersPoints > LIMIT) && (playersPoints > LIMIT))
    {
      //draw, play again, bets... etc... both lost?
      System.out.println("The dealer flips his card. He has " + dealersPoints + " points. You and the dealer have both exceeded 21. The cards are discarded and play restarts with new cards. You keep your bet.");
      reset();
    }
    //dealer is above 21 and player is not
    else if ((dealersPoints > LIMIT) && (playersPoints < LIMIT))
    {
      playerWon = true;
      whoWon(playerWon, dealerWon);
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
      whoWon(playerWon, dealerWon);
    }  
    
    else System.out.println("Comparison error."); //if it cannot compare either score
  }
  
  private static void whoWon(boolean playerWon, boolean dealerWon)
  {
    System.out.println("Inside whoWon method."); //bug checker
    //if the player won
    if ((playerWon == true) && (dealerWon == false))
    {
      bankBalance = bankBalance + (wager*.5); //house rules = 3:20
      System.out.println("Dealer busts. The player wins! Bank balance: " + bankBalance);
      System.out.println("Play again? 1 = yes, 2 = no.");
      int choice = scanner.nextInt();
      
      if (choice == 1)
      {
        //play again
        reset();
      }
      else //no more games
      {
        noMoreGames();
      }
    }
    
//if dealer won
    else if ((dealerWon == true) && (playerWon == false))
    {
      bankBalance = bankBalance - wager; //lost the bet. ouchy
      
      System.out.println("The dealer wins! Bank balance: " + bankBalance);
      System.out.println("Play again? 1 = yes, 2 = no.");
      choice = scanner.nextInt();
      
      if (choice == 1)
      {
        //play again
        reset();
      }
      
      else
      {
        noMoreGames();
      }
    }
    
    else if ((dealerWon == true) && (playerWon == true)) //tie
    {
      //tie.
      //cards discarded. arrays wiped clean. game restarts.
      System.out.println("You have reached 21. The dealer flips his card. He is also at 21. The cards are discarded and play restarts with new cards. You keep your bet.");
      reset(); //clears hands and dealer/playersPoints
    }
    
    else //both false
    {
      System.out.println("Both came in false. Error.");
    }
  }
  
  private static void checkStand(int dealersPoints, int playersPoints)
  {
    //if dealer > player && dealer <= 21
    if ((dealersPoints > playersPoints) && (dealersPoints <= LIMIT))
    {
      dealerWon = true;
    }
    
    //if dealer < player && player <= 21
    if ((dealersPoints < playersPoints) && (playersPoints <= LIMIT))
    {
      playerWon = true;
    }
    
    //if dealer > 21 && player > 21
    if ((dealersPoints > 21) & (playersPoints > 21))
    {
      dealerWon = false;
      playerWon = false;
    }
    
    //if player > 21 && dealer < 21
    if ((playersPoints > 21) && (dealersPoints < 21))
    {
      dealerWon = true;
    }
    
    //if dealer > 21 && player < 21
    if ((dealersPoints > 21) && (playersPoints < 21))
    {
      playerWon = true;
    }
    
    //if player && dealer > 21
    if ((playersPoints > 21) && (dealersPoints > 21))
    {
      playerWon = false;
      dealerWon = false;
    }
    
    //if player == dealer && < 21
    if ((playersPoints == dealersPoints) && (playersPoints < 21))
    {
      playerWon = true;
      dealerWon = true;
    }
      
    //if player == dealer == 21
    if ((playersPoints == dealersPoints) && (playersPoints == 21))
    {
      playerWon = true;
      dealerWon = true;
    }
          
    System.out.println("dealerWon ==" + dealerWon + " playerWon ==" + playerWon +".");
    whoWon(playerWon, dealerWon);
                         
  }
}




