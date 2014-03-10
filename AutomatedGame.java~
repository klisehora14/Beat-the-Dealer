package beatTheDealer;
import java.util.ArrayList;
// driver that runs AutomatedPlayer against the Dealer x times...

public class AutomatedGame
{
  static ArrayList<String> dealer = new ArrayList<String>(); //keep track of the cards CURRENLTY in the dealer's hand. first card is not available to player
  static ArrayList<String> autoPlayer = new ArrayList<String>();
  
  static int gameNumber = 1; //what game of however many they're on 
  static boolean dealerAce = false;
  static boolean playerAce = false;
  static int dealersPoints = 0;
  static double playersPoints = 0;
  static int counter = 0;
  static int i = 0;
  static String playerMove = "";
  static int playerCounter = 0; //starts off with two cards in the player's hand
  static int dealersGame = 0; //how many games the dealer won
  static int playersGame = 0; //how many games the automated player won
  
  public static String automatedGame(int numberOfGames)
  {
    dealersGame = 0;
    playersGame = 0;
      
    while (gameNumber <= numberOfGames) //still going through as many as the better wanted
    { 
      for (int i = 1; i <= numberOfGames; i++) //what to do for each game
      {
        //play dealer cards
        //dealer does his thing
        // play player cards
        dealCards();
        
        // call automated player to see what it says to do.. give it dealer and autoPlayer arraylists
        playerMove = AutomatedPlayer.automatedPlayer(dealer, autoPlayer); //will return either "hit" or "stand" based on that stuff
        
        //tell who had what cards: just a check
        for (int k = 0; i < autoPlayer.size(); i++)
        {
          System.out.println(autoPlayer.get(k) + ", ");
        }
        
        for (int k = 0; i < dealer.size(); i++)
        {
          System.out.println(dealer.get(k) + ", ");
        }
        
        
        
        //if hit, play player another card and add points to playersPoints
        if (playerMove.equals("hit"))
        {
          System.out.println("said hit");
          autoPlayer.add(Deck.deck()); //add another card
          System.out.println("added another card");
          playerCounter += playerCounter + 1; //number of cards added
          System.out.println("added another to playercounter"); //GETS THIS FAR
          System.out.println(playerCounter +"= playercounter");
          double temp = CardValue.cardValue(dealer.get(playerCounter)); //BREAKS HERE
          System.out.println("temp = " + temp);
          playersPoints += temp; //add value of that card to their total points
          System.out.println("finished hit");
        }
        
        //if stand, stay still and check to see if soft hand and if so then if having the ace worth 11 is worht anything better
        if (playerMove.equals("stand"))
        {
          System.out.println("said stand");
          for (int x = 0; x <= autoPlayer.size(); x ++) // go through each card
          {
            if (CardValue.cardValue(autoPlayer.get(x)) == 1) //has ace
            {
              playerAce = true;
              System.out.println("has ace");
            }
            else
            {
              System.out.println("doesn't have ace");
            }
          }
          // BREAKS HERE FOR ACE THING. never gets out of that loop ^
          System.out.println("Outside of has ace loop");
          
          if ((playerAce == true) && ((playersPoints + 10) <= 21)) //if has ace and that ace being 11 is less than or equal to 21
          {
            playersPoints = playersPoints + 10; //now that ace is worth 11
            System.out.println("counted ace");
          }
          
          System.out.println("Automated player stands. Total points: " + playersPoints + ". Dealer's total is: " + dealersPoints + ". ");
        }
        
        //saving data on who won that round
        if ((dealersPoints <= 21) && (playersPoints <= 21))
        {
          if (dealersPoints > playersPoints)
          {
            dealersGame =+ 1; //add a win to the dealer
          }
          
          else if (playersPoints > dealersPoints)
          {
            playersGame =+ 1; //add a win to the player
          }
          
          else if (playersPoints == dealersPoints) //tie
          {
            System.out.println("There is a tie. The cards are removed and the game restarts.");
            gameNumber = gameNumber - 1; //because redoing this round
            restart();
          }
          
          else System.out.println("Comparison error for both <= 21.");
        }
        
        else if ((dealersPoints > 21) && (playersPoints > 21)) //both busts
        {
          System.out.println("Both bust. The cards are removed and the game restarts.");
          gameNumber = gameNumber - 1;
          restart();
        }
        
        else if ((dealersPoints > 21) && (playersPoints < 22)) //dealer busts
        {
          System.out.println("Dealer busts.");
          playersGame =+ 1;
        }
        
        else if ((playersPoints > 21) && (dealersPoints < 22)) //player busts
        {
          System.out.println("Automated player busts.");
          dealersGame =+ 1;
        }
        gameNumber =+ 1; //played another game
      }
    }
      
      
      //after gone through all of the games...
      // tell player who won, what are the betting stuff, etc
      if (numberOfGames == 1)
      {
        System.out.println("The game has been completed.");
      }
      else //for plurality
      {
        System.out.println("All " + numberOfGames + " games have been completed.");
      }
      System.out.print("Dealer:Automated player = " + dealersGame + ":" + playersGame + ".");
      
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
        while (counter > 0) //imbedding following code instead,, fixed
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
  
  
  private static void restart() //resets hands and puts cards back into deck
  {
    playersPoints = 0;
    dealersPoints = 0;
    
    for (int i = 0; i <= dealer.size(); i++) //go through however many cards the dealer has
    {
      Deck.refillTheDeck(dealer.get(i)); //give the 'copy' of the card so it can be put back into the deck
    }
    
    for (int i = 0; i <= autoPlayer.size(); i++) //go through however many cards the player has
    {
      Deck.refillTheDeck(autoPlayer.get(i)); //give the 'copy' of the card so it can be put back into the deck
    }
    
    dealer.clear(); //clear all of the cards from the dealer and player's hands
    autoPlayer.clear();
  }
}