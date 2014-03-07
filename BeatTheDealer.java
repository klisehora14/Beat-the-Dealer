/* Kapri Lisehora
 Vegas style Blackjack
 
 The player starts the game with $100 and continues to make bets and play blackjack for as long as they want. When they end the game
 the system tells them how much money they ultimately won or lost.
 
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
  
  
  static int i = 2; //for when the dealer hits
  static int temp3 = 0;
  static String decision = "";
  
  static boolean playerWon = false;
  static boolean dealerWon = false;
  
  static boolean playerAce = false;
  static boolean dealerAce = false; //if they have an ace
  static boolean gameOver = false;
  
  static double bankBalance = 100.00; //for gambling
  static double wager = 0;
  
  static int counter = 0;
  static int playerCounter = 1; //player starts off with two cards in their hand but array starts at slot 0
  static int choice = 0;
  
  static ArrayList<String> dealer = new ArrayList<String>(); //keep track of the cards currently in the dealer's hand. first card is not available to player
  static int dealersPoints = 0; //total points that round
  static ArrayList<String> player = new ArrayList<String>(); //player's hand
  static int playersPoints = 0; //total points that round
  
  public static void main(String[] args) //beatTheDealer()
  {
    while ((playerWon == false) && (dealerWon == false)) //new game
    {
      System.out.println("Let's play Blackjack! Face cards are worth 10. An Ace is either worth 1 or 11; your call."); //start the game
      playGame();
    }
  }
  
  private static void playGame() //sets up the game and starts it
  {
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
  
  private static void betting() //has the player place a wager at the beginning of each round
  {
    System.out.println("Your bank balance is $" + bankBalance + ". Bets are payed out 3:2. How much would you like to bet?");
    wager = scanner.nextDouble();
    while (wager < 5)
    {
      System.out.println("Bets must be at least $5. How much would you like to bet?");
      wager = scanner.nextDouble();
    }
    while (wager > bankBalance)
    {
      System.out.println("Bets can only be made with available funds. Your bank balance is $" + bankBalance + ". How much would you like to bet?");
      wager = scanner.nextDouble();
    }
  }
  
  private static void dealCards() //plays cards to the dealer and plays out the dealer. plays cards to the player
  {
    //dealer plays first
    dealer.add(Deck.deck()); //add one card; keep secret
    dealer.add(Deck.deck()); //add second card; show
    System.out.println("The dealer plays his initial two cards. His visible card is: " + dealer.get(1)); //second card 
    
    if ((CardValue.cardValue(dealer.get(0)) == 1) || (CardValue.cardValue(dealer.get(1)) == 1)) //checks to see if the dealer has an ace
    {
      dealerAce = true;
    }
    
    dealersPoints = CardValue.cardValue(dealer.get(0)) + CardValue.cardValue(dealer.get(1)); //keeps track of the dealer's total points for the current round
    
//if the dealer has 17 or higher he stands. if he has 16 or less he hits. 
    while (dealersPoints < DEALER_STAND) //16 or less
    {
      //checks to see if the dealer has an ace. if he does, checks to see if that ace is more useful as a 1 or an 11
      if ((dealerAce == true) && ((dealersPoints + 10 <= LIMIT) && (dealersPoints + 10 >= DEALER_STAND)))
      {
        dealersPoints = dealersPoints + 10; //now that ace is worth 11
      }
      
      else
      {
        dealer.add(Deck.deck());
        counter += 1; //number of cards added
        
        while (counter > 0)
        {
          System.out.println("The dealer hit. His card was: "+ dealer.get(i));
          dealersPoints += CardValue.cardValue(dealer.get(i)); //add the value of new card
          i++; //next part in array
          counter =+ counter -1; //put it back to 0
        }
      }
    }
    
    //give player cards
    player.add(Deck.deck());
    player.add(Deck.deck());
    System.out.println("You're dealt your first card: The " + player.get(0) +". Your second card is: The " + player.get(1));
    int temp = CardValue.cardValue(player.get(0));
    int temp2 = CardValue.cardValue(player.get(1));
    playersPoints = temp + temp2;  //cannot add CardValue.cardvalue etc directly.
  }
  
  private static void playPlayer() //checks the scores between the player and the dealer and alters the boolean conditions depending on their scores
  {
    //dealer reached 17 or higher
    //dealer is at 21 and so is player 
    if ((dealersPoints == LIMIT) && (playersPoints == LIMIT))
    {
      System.out.println("You have reached 21. The dealer flips his card. He is also at 21. The cards are discarded and play restarts with new cards. You keep your bet.");
      reset();
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
    else if ((dealersPoints < LIMIT) && (playersPoints < LIMIT)) 
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
  
  private static void playOutPlayer() //interacts with the player. this is where they can hit/stand
  {
    if (playersPoints < 21)
    {
      System.out.println("The dealer has " + (dealersPoints - CardValue.cardValue(dealer.get(0))) + " visible points.");
      
      System.out.println("Hit or stand?");
      decision = sc.nextLine();
      
      if (decision.toLowerCase().equals("hit"))
      {
        if (playersPoints <= LIMIT)
        {
          player.add(Deck.deck()); //add another card
          playerCounter += playerCounter + 1; //number of cards added
          System.out.println("You are dealt: " + player.get(playerCounter - 1) + ".");
          playersPoints += CardValue.cardValue(dealer.get(dealer.size()-1));
        }
        else
        {
          dealerWon = true;
          whoWon(playerWon, dealerWon);
        }
      }
      if (decision.toLowerCase().equals("stand"))
      {
        //checks to see if the player has an ace. if there is one it checks to see if it's worth more as 1 or 11
        for (int i = 0; i < player.size(); i ++) 
        {
          if (CardValue.cardValue(player.get(i)) == 1) 
          {
            playerAce = true; 
          }
        }
        
        if ((playerAce == true) && ((playersPoints + 10) <= LIMIT))
        {
          playersPoints = playersPoints + 10; //now that ace is worth 11
        }
        System.out.println("You stand. Your total is " + playersPoints + ". The dealer flips his first card. His total is " + dealersPoints + ". ");
        
        checkStand(dealersPoints, playersPoints);
      }
    }
    
    if (playersPoints == 21)
    {
      playerWon = true;
      whoWon(playerWon, dealerWon);
    }
    
    else if ((playersPoints >= LIMIT) || (dealersPoints >= LIMIT)) //they're both at, or over, 21
    {
      
      if ((dealersPoints > playersPoints) && (dealersPoints < LIMIT)) //dealer has more points than player and is at most 21
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
    else if ((dealersPoints == playersPoints) && (playersPoints == LIMIT)) //if they're equal to 21
    {
      System.out.println("The player and the dealer tie. The cards are discarded and play restarts with new cards. The player keeps the bet.");
      reset();
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
    
    whoWon(playerWon, dealerWon);
  }
  
  private static void whoWon(boolean playerWon, boolean dealerWon) //determines who wins the round, awards or subtracts money from the players bank, and asks if the player wants to play again or not
  {
    //if the player won
    if ((playerWon == true) && (dealerWon == false))
    {
      bankBalance = bankBalance + (wager*.5); //house rules = 3:2
      System.out.println("Dealer busts. The player wins! Bank balance: " + bankBalance);
      System.out.println("Play again? 1 = yes, 2 = no.");
      int choice = scanner.nextInt();
      
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
    
//if dealer won
    else if ((dealerWon == true) && (playerWon == false))
    {
      bankBalance = bankBalance - wager; //lose the money they bet
      
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
      reset();
    }
    
    else //both false
    {
      System.out.println("Both came in false. Error.");
    }
  }
  
  private static void reset() //resets the accounts
  {
    //play again. refills the deck with the cards the player and dealer had. resets the entire game except for the players bank
    playersPoints = 0;
    dealersPoints = 0;
    counter = 0;
    playerCounter = 1;
    choice = 0;
    
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
    
    playerWon = false;
    dealerWon = false;
    
    BeatTheDealer.playGame();
  }
  
  private static void noMoreGames() //game over. tells the player how much money they gained/lost and ends the program
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
    
    
    try 
    {
      Thread.sleep(10000); //pauses screen before ending program
    } 
    catch(InterruptedException ex) 
    {
      Thread.currentThread().interrupt();
    }
    System.exit(0); //ends the program
  }
}




