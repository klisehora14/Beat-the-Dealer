/* array list of all 52 cards.... shuffle.. picks random card and returns it*/

//ace = 1; if thing = 1 then use 1 or 11- whichever works best in the situation... assume 1 unless needed better
package beatTheDealer;

import java.util.ArrayList;
public class Deck
{ 
  public static String Deck() //returns one randomly selected card... value
  {
      int cardsRemaining = 52; //minus 1 everytime the class is called to represent one less card in the deck
      int spades = 1;
      int clubs = 2;
      int diamonds = 3;
      int hearts = 4;
      ArrayList<String> deck = new ArrayList<String>();              //how to actually declare this?
      deck.add("1-1","1-2","1-3","1-4","1-5","1-6","1-7","1-8","1-9","1-10","1-11","1-12",
         "2-1","2-2","2-3","2-4","2-5","2-6","2-7","2-8","2-9","2-10","2-11","2-12",
         "3-1","3-2","3-3","3-4","3-5","3-6","3-7","3-8","3-9","3-10","3-11","3-12",
         "4-1","4-2","4-3","4-4","4-5","4-6","4-7","4-8","4-9","4-10","4-11","4-12");
    
    //arraylist deck... randomly pick one, getSuit; getValue (substring)... return that.... beatthedealer can just call deck twice the first time
         //and only once everytime someone takes a hit
 
    int choice = (int)(Math.random()*cardsRemaining)+1; //pick a random number between 1 and available number of cards left 
    String chosenCard = deck.get(choice); //... how to do this? pick that slot in the array list
    
    cardsRemaining += cardsRemaining - 1; //one less card in the array
    
    deck.remove(chosenCard); //remove that card from the arraylist
    
    return getValue(chosenCard) + " of " + getSuit(chosenCard); //returns the words.. like "Ace of Spades"
  }
  
  private static String getSuit(String card) //is given a selection from arraylist deck... gets the suit based on the first number in the string
  {
    if (card.substring(0,1).equals(1)) //card of spades
      return "Spades";
    if (card.substring(0,1).equals(2)) //card of clubs
      return "Clubs";
    if (card.substring(0,1).equals(3)) //card of diamonds
      return "Diamonds";
    if (card.substring(0,1).equals(4)) // card of hearts
      return "Hearts";
    else return "getSuit error";
  }
  
  private static String getValue(String card) //is given a selection from arraylist deck... gets the value of the card based on the last number
  {
    if (card.substring(3).equals(1)) //ace
      return "Ace";
    if (card.substring(3).equals(2)) //2
      return "2";
    if (card.substring(3).equals(3)) //3
      return "3";
    if (card.substring(3).equals(4)) //4
      return "4";
    if (card.substring(3).equals(5)) //5
      return "5";
    if (card.substring(3).equals(6)) //6
      return "6";
    if (card.substring(3).equals(7)) //7
      return "7";
    if (card.substring(3).equals(8)) //8
      return "8";
    if (card.substring(3).equals(9)) //9
      return "9";
    if (card.substring(3).equals(10)) //10
      return "10";
    if (card.substring(3).equals(11)) //jack
      return "Jack";
    if (card.substring(3).equals(12)) //queen
      return "Queen";
    if (card.substring(3).equals(13)) //king
      return "King";
    
    else return "getValue error";
  }

}



