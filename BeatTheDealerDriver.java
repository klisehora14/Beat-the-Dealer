/* Kapri Lisehora
 * beatTheDealer driver class
 * 
 * This class asks the player whether they want to be the player and play against the dealer or whether they want to place a bet on either an automated player or a dealer
 * in a set of rounds. 
 */

// runs BeatTheDealer which is the person playing the Dealer and betting as they would in a casino
//run AutomatedPlayer which is the person betting on either the AutomatedPlayer or the Dealer for who comes out ontop after 10 rounds

package beatTheDealer;
import java.util.Scanner;

public class BeatTheDealerDriver
{
  static Scanner scanner = new Scanner(System.in);
  static Scanner sc = new Scanner(System.in);
  static double bankBalance = 100;
  static int betAmount = 0;
  static String assumedWinner = "";
  static int gameNumber = 0;
  
  public static void main(String[] args)
  {
    System.out.println("Welcome to the casino! Would you like to: 1. try your own hand against the Dealer, or 2. bet on either the Dealer or an Automated Player?");
    int gameType = scanner.nextInt();
    
    if (gameType == 1)
    {
      BeatTheDealer.beatTheDealer();
    }
    
    if (gameType == 2)
    {
      betting();
      String str = AutoGame.autoGame(gameNumber);
      resolveAccounts(str); //figures out if person won and alters bank account as such
    }
    
    else //didn't pick 1 or 2
    {
      System.out.println("Please pick either 1 or 2.");
      gameType = scanner.nextInt();
    }
  }
  
  private static void resolveAccounts(String str) //checks to see if the guessed winner actually won. changes bank depending 
  { 
    if (assumedWinner.equals(str))
    {
      bankBalance = bankBalance*1.5;
      System.out.println("You win! Your bank balance is now: $" + bankBalance + ".");
    }
    
    else if (str.equals("tie"))
    {
      bankBalance = bankBalance - betAmount;
      System.out.println("The AutoPlayer and the dealer tied. You lost. Your bank balance is now: $" + bankBalance + ".");
    }
    
    else //lost
    {
      bankBalance = bankBalance - betAmount;
      System.out.println("You lost! Your bank balance is now: $" + bankBalance + ".");
    }
  }
  
  
  private static void betting()
  {
    System.out.println("How many games would you like to bet against?");
    gameNumber = scanner.nextInt();
    
    System.out.println("Who do you think will win the majority of the games? The Dealer, or the Player?");
    assumedWinner = sc.nextLine().toLowerCase();
    
    if (!(assumedWinner.equals("dealer")) && !(assumedWinner.equals("player"))) //if entered something other than dealer or player
    {
      System.out.println("Please pick either the dealer or the player.");
      assumedWinner = sc.nextLine().toLowerCase();
    }
    
    
    System.out.println("How much would you like to bet? You have $" + bankBalance + ". Bets are payed out 3:2");
    betAmount = scanner.nextInt();
    
    while (betAmount < 5)
    {
      System.out.println("Bets must be at least $5. How much would you like to bet?");
      betAmount = scanner.nextInt();
    }
    while (betAmount > bankBalance)
    {
      System.out.println("Bets can only be made with available funds. Your bank balance is $" + bankBalance + ". How much would you like to bet?");
      betAmount = scanner.nextInt();
    }
  }
}