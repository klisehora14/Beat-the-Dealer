package beatTheDealer;

public class Reset
{
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
}