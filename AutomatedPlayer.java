package beatTheDealer;
import java.util.ArrayList;
// plays like a smart player BUT DOESNT COUNT CARDS... maybe implement that later or have another AI that DOES count cards.
// play round of like 10 games? when the person is betting on the player vs computer

/*
 * check to see if ace.. then hardHand or softHand
 * return 'hit' or 'stand'
 */
public class AutomatedPlayer
{
  static boolean hasAce = false; //whether the player has at least one ace or not
  
  public static String automatedPlayer(ArrayList<String> dealersCards, ArrayList<String> playersCards)// take two arraylists... the players cards and the dealers cards.
  {
    for (int i = 0; i <playersCards.size(); i ++) //itterate through the number of cards the player has, check for an ace
    {
      if (CardValue.cardValue(playersCards.get(i)) == 1) //if ace
      {
        hasAce = true;
      }
    }
    
    if (hasAce == true)
    {
      System.out.println("returning hardHand");
      return hardHand(dealersCards, playersCards); //give hardHand both arraylists and it will return a string of either hit or stand
    }
    
    else //no ace
    {
      System.out.println("returning softHand");
      return softHand(playersCards); 
    }
    
  }
    
    private static String hardHand(ArrayList<String> dealersCards, ArrayList<String> playersCards) //no aces
    {
      //from 3-11 hit
      // if you have 12-16, hit unless dealer has 2-6. if 7 or better, hit.
      // always stand on 17-21 regardless
      int playersPoints = 0;
      int dealersPoints = 0;
      
      for (int i = 0; i < playersCards.size(); i++)
      {
        playersPoints =+ CardValue.cardValue(playersCards.get(i)); //add value of that card to total points
      }
      
      for (int i = 0; i < dealersCards.size(); i++)
      {
        dealersPoints =+ CardValue.cardValue(dealersCards.get(i));
      }
      
      if ((playersPoints >= 3) && (playersPoints <= 11)) //3-11
      {System.out.println("returning hit 1");
        return "hit";
      }
      
      else if ((playersPoints >= 12) && (playersPoints <= 16))
      {
        if ((dealersPoints >= 2) && (dealersPoints <= 6))
        {
          System.out.println("returning stand; dealer>=2; <=6");
          return "stand";
        }
        System.out.println("returning hit; greater than 7");
        return "hit"; //greater than 7
      }
      
      System.out.println("returning stand");
      return "stand"; //greater or equal to 17
    }
    
    private static String softHand(ArrayList<String> playersCards) //ace
    {
      //stand if you have 8 or above
      // otherwise hit because you can always turn the ace into a 1
      int playersPoints = 0;
      
      for (int i = 0; i < playersCards.size(); i++)
      {
        playersPoints =+ CardValue.cardValue(playersCards.get(i));
      }
      
      if ((playersPoints >= 8) && (playersPoints <= 10))
      {
        return "stand";
      }
      
      else return "hit";
    }
  
}