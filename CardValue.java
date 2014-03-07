//Kapri Lisehora
// takes in a string... one value from the dealer or player's array
//at a time. checks the (first letter, maybe? if that's all that
//decides if ace, eight, nine, king, etc and last letter)
// returns the numberic value of that card

/*
 CardValue takes in a string that looks something like 'Ace of Spades'.
 The class checks to see which card that string represents (an ace, a 2, a face card, etc) and returns the numberic value of the card.
 */

package beatTheDealer;

public class CardValue
{
  public static int cardValue(String str)
  {
    if (str.substring(0,1).equals("A"))// is an ace.. check in beat the dealer class for an ace and set a boolean flag or something
      return 1;
    if (str.substring(0,1).equals("2"))
      return 2;
    if (str.substring(0,1).equals("3"))
      return 3;
    if (str.substring(0,1).equals("4"))
      return 4;
    if (str.substring(0,1).equals("5"))
      return 5;
    if (str.substring(0,1).equals("6"))
      return 6;
    if (str.substring(0,1).equals("7"))
      return 7;
    if (str.substring(0,1).equals("8"))
      return 8;
    if (str.substring(0,1).equals("9"))
      return 9;
    if (str.substring(0,2).equals("10"))
      return 10;
    if (str.substring(0,1).equals("J"))
      return 10;
    if (str.substring(0,1).equals("Q"))
      return 10;
    if (str.substring(0,1).equals("K"))
      return 10;

    else return 5000;
  }
}