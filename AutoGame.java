//Kapri Lisehora
// driver that runs AutomatedPlayer against the Dealer x times
//SECOND VERSION
package beatTheDealer;
import java.util.ArrayList;


public class AutoGame
{
  static ArrayList<String> dealer = new ArrayList<String>(); //keep track of the cards currently in the dealer's hand
  static ArrayList<String> autoPlayer = new ArrayList<String>();
  
  static int gameNumber = 1; //what game of however many they're on 
  static boolean dealerAce = false;
  static boolean playerAce = false;
  static int dealersPoints = 0;
  static int playersPoints = 0;
  static int counter = 0;
  static int i = 0;
  static String playerMove = "";
  static int playerCounter = 0; //starts off with two cards in the player's hand
  static int dealersGame = 0; //how many games the dealer won
  static int playersGame = 0; //how many games the automated player won
  static boolean dealerWon = false;
  static boolean playerWon = false;
  
  public static String autoGame(int numberOfGames)
  { 
    while (gameNumber <= numberOfGames) //still going through as many as the better wanted
    { 
      playerWon = false;
      dealerWon = false; //start each loop as false because each loop is a new game
      
      for (int i = 1; i <= numberOfGames; i++) //what to do for each game
      {
        System.out.println("Game number: " +gameNumber + ". Dealer won: " + dealersGame + ". Player won: " + playersGame + ".");
        //play dealer and player their cards
        dealCards();
        
        // call automated player to see what it says to do.. give it dealer and autoPlayer arraylists
        playerMove = AutomatedPlayer.automatedPlayer(dealer, autoPlayer); //will return either "hit" or "stand" based on that stuff
        
        //tell what cards the dealer/player originally have (doesn't print player hit cards)
        // listCards();
        
        //hit or stand?
        while (playerMove.equals("hit")) //keep going through autoplayer until it says to stand
        {
          if (playersPoints < 17)
          {
            hit();
            playerMove = AutomatedPlayer.automatedPlayer(dealer, autoPlayer);
          }
          
          else if (playersPoints > 16) 
          {
            playerMove = "stand";
          }
        }
        
        if (playerMove.equals("stand")) //can finish the loop and end that game
        {
          stand();
        }
        
        checkStand(dealersPoints, playersPoints); //checks to see who has more points; adds appropriate numbers to dealersgame and playersgame
        
        gameNumber += 1; //next game
      }
    }
    
    //completed all rounds
    //check to see if dealer or autoplayer won
    
    System.out.println("All game(s) have been completed.");
   
    System.out.println("Dealer's score: " + dealersGame + ". AutoPlayer's score: " + playersGame + ".");
    
    if (dealersGame > playersGame)
    {
      System.out.println("The dealer won.");
      return "dealer";
    }
    
    else if (playersGame > dealersGame)
    {
      System.out.println("The player won.");
      return "autoPlayer";
    }
    
    else //tie
    {
      System.out.println("There is a tie. You keep your bet.");
      return "tie";
    }
    
  }
  
  private static void dealCards()
  {
    //dealer plays first
    dealer.add(Deck.deck()); //add one card; keep secret
    dealer.add(Deck.deck()); //add second card; show
    System.out.println("The dealer plays his cards and deals in the automated player. Game continues.");
    
    if ((CardValue.cardValue(dealer.get(0)) == 1) || (CardValue.cardValue(dealer.get(1)) == 1)) //if has an ace
    {
      dealerAce = true;
    }
    //if total array value is less than 16; hit
    //else stand and play  
    while (dealersPoints < 17)
    {
      //oh, you have an ace? let's check which value you want :D
      if ((dealerAce == true) && ((dealersPoints + 10 <= 21) && (dealersPoints + 10 >= 17))) //if has ace and that ace being 11 is between 17 and 21
      {
        dealersPoints = dealersPoints + 10; //now that ace is worth 11
        dealerAce = true;
      }
      
      
      else // no ace, do it normally
      {
        dealer.add(Deck.deck());
        counter += 1; //number of cards added
        // add to dealersPoints
        while (counter > 0) 
        {
          dealersPoints += CardValue.cardValue(dealer.get(i)); //add the value of new card
          i++; //next part in array
          counter =+ counter -1; //should put it back to 0
        }
      }
    }
    //give player cards
    autoPlayer.add(Deck.deck()); //add one card
    autoPlayer.add(Deck.deck()); //add second card; show
    int temp = CardValue.cardValue(autoPlayer.get(0));
    int temp2 = CardValue.cardValue(autoPlayer.get(1));
    playersPoints = temp + temp2;  //cannot add CardValue.cardvalue etc directly.
    
  }
  
  private static void listCards() //lists original cards dealt to player and dealer. mostly a bug check
  {
    //tell who had what cards: just a check
    System.out.println("The player's cards are:");
    for (int k = 0; k < autoPlayer.size(); k++)
    {
      System.out.println(autoPlayer.get(k));
    }
    
    System.out.println("The dealer's cards are:");
    for (int k = 0; k < dealer.size(); k++)
    {
      System.out.println(dealer.get(k));
    }
  }
  
  
  
  private static void hit()
  {
    //if hit, play player another card and add points to playersPoints
    autoPlayer.add(Deck.deck()); //add another card
    playerCounter += 1; //number of cards added
    
    int temp = CardValue.cardValue(dealer.get(playerCounter - 1));
    playersPoints += temp; //add value of that card to their total points
  }
  
  private static void stand()
  {
    //if stand, stay still and check to see if soft hand and if so then if having the ace worth 11 is worth anything better
    for (int x = 0; x < autoPlayer.size(); x ++) // go through each card
    {
      if (CardValue.cardValue(autoPlayer.get(x)) == 1) //has ace
      {
        playerAce = true;
      }
    }
    if ((playerAce == true) && ((playersPoints + 10) <= 21)) //if has ace and that ace being 11 is less than or equal to 21
    {
      playersPoints = playersPoints + 10; //now that ace is worth 11
    }
    
    System.out.println("Automated player stands. Total points: " + playersPoints + ". Dealer's total is: " + dealersPoints + ". ");
  }
  
  
  private static void checkStand(int dealersPoints, int playersPoints) 
  {
    //if dealer > player && dealer <= 21
    if ((dealersPoints > playersPoints) && (dealersPoints <= 21))
    {
      dealerWon = true;
    }
    
    //if dealer < player && player <= 21
    if ((dealersPoints < playersPoints) && (playersPoints <= 21))
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
  
  private static void whoWon (boolean playerWon, boolean dealerWon)
  {
    if ((playerWon == true) && (dealerWon == true))
    {
      System.out.println("AutoPlayer and Dealer tied. Round not counted.");
      gameNumber = gameNumber - 1; //because it automatically adds one at the end of the loop
    }
    else if ((playerWon == true) && (dealerWon == false))
    {
      playersGame = playersGame + 1;
      System.out.println("AutoPlayer won that round.");
    }
    else if ((playerWon == false) && (dealerWon == true))
    {
      dealersGame = dealersGame + 1;
      System.out.println("The Dealer won that round.");
    }
    else //both false
    {
      System.out.println("AutoPlayer and Dealer busted. Round not counted.");
      gameNumber = gameNumber - 1; //because it automatically adds one at the end of the loop
    }
    
    reset();
    
  }
  
  private static void reset() //resets the accounts
  {
    //play again. refills the deck with the cards the player and dealer had. resets the entire game
    dealerAce = false;
    playerAce = false;
    dealersPoints = 0;
    playersPoints = 0;
    counter = 0;
    i = 0;
    playerMove = "";
    playerCounter = 0;
    dealerWon = false;
    playerWon = false;
    
    
    for (int i = 0; i < dealer.size(); i++) //go through however many cards the dealer has
    {
      Deck.refillTheDeck(dealer.get(i)); //give the 'copy' of the card so it can be put back into the deck
    }
    
    for (int i = 0; i < autoPlayer.size(); i++) //go through however many cards the player has
    {
      Deck.refillTheDeck(autoPlayer.get(i)); //give the 'copy' of the card so it can be put back into the deck
    }
    
    dealer.clear(); //clear all of the cards from the dealer and player's hands
    autoPlayer.clear();
    
    dealerWon = false;
    playerWon = false;
    
  }
  
}