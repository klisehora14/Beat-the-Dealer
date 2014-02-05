// takes in a string... one value from the dealer or player's array
//at a time. checks the (first letter, maybe? if that's all that
//decides if ace, eight, nine, king, etc and last letter)
// returns the numberic value of that card
package beatTheDealer;

public class CardValue
{
  public static int cardValue(String str)
  {
    int i = str.length(); //simplify
    
    //a,t,th,f,fi,s,se,e,n,te,j,q,k
    
    if (str.substring(0,1) == "a")// is an ace.. check in beat the dealer class for an ace and set a boolean flag or something
      return 1;
    if (str.substring(0,1) == "t")
      return 2;
    if (str.substring(0,2) == "th")
      return 3;
    if (str.substring(0,1) == "f")
      return 4;
    if (str.substring(0,2) == "fi")
      return 5;
    if (str.substring(0,1) == "s")
      return 6;
    if (str.substring(0,2) == "se")
      return 7;
    if (str.substring(0,1) == "e")
      return 8;
    if (str.substring(0,1) == "n")
      return 9;
    if (str.substring(0,2) == "te")
      return 10;
    if (str.substring(0,1) == "j")
      return 10;
    if (str.substring(0,1) == "q")
      return 10;
    if (str.substring(0,1) == "k")
      return 10;
    
    else return 5000;
      
  }
}