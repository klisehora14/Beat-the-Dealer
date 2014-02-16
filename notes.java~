/*
 *   errors on run through... just to keep them safe... error record & fixes
 * 
 * 
Welcome to DrJava.  Working directory is /Users/klisehora14/Desktop/Miss Elily/Classes/APCS/Java Project
> run beatTheDealer.BeatTheDealer
Let's play Blackjack! Face cards are worth 10. An Ace is either worth 1 or 11; your call.
Your bank balance is $100.0. Bets are payed out 3:2. How much would you like to bet?
 [DrJava Input Box]
The dealer plays his initial two cards. His visible card is: Queen of Diamonds
You're dealt your first card: The 9 of Spades. Your second card is: The Ace of Diamonds
You and the dealer have both exceeded 21. The cards are discarded and play restarts with new cards. You keep your bet.
The dealer wins! Bank balance: 0.0
Play again? 1 = yes, 2 = no.

--FIXED. CHANGED AN OR TO AN AND. NOW DEALER DOESN'T AUTOMATICALLY OVERDRAW IF HE HAS AN ACE

Welcome to DrJava.  Working directory is /Users/klisehora14/Desktop/Miss Elily/Classes/APCS/Java Project
> run beatTheDealer.BeatTheDealer
Let's play Blackjack! Face cards are worth 10. An Ace is either worth 1 or 11; your call.
Your bank balance is $100.0. Bets are payed out 3:2. How much would you like to bet?
 [DrJava Input Box]
The dealer plays his initial two cards. His visible card is: 10 of Clubs
You're dealt your first card: The 4 of Clubs. Your second card is: The 5 of Spades
You and the dealer have both exceeded 21. The cards are discarded and play restarts with new cards. You keep your bet.
The dealer wins! Bank balance: 81.0
Play again? 1 = yes, 2 = no.
 [DrJava Input Box]

-- error has to deal with the both over 21 'else if' statement. .... not really sure what's wrong at this point?

Welcome to DrJava.  Working directory is /Users/klisehora14/Desktop/Miss Elily/Classes/APCS/Java Project
> run beatTheDealer.BeatTheDealer
Let's play Blackjack! Face cards are worth 10. An Ace is either worth 1 or 11; your call.
Your bank balance is $100.0. Bets are payed out 3:2. How much would you like to bet?
 [DrJava Input Box]
The dealer plays his initial two cards. His visible card is: 4 of Clubs
You're dealt your first card: The 7 of Clubs. Your second card is: The 7 of Diamonds
You and the dealer have both exceeded 21. The cards are discarded and play restarts with new cards. You keep your bet.
The dealer wins! Bank balance: 90.0
Play again? 1 = yes, 2 = no.
 [DrJava Input Box]
> 2

-- also doesn't replay... so there's that.

-- didn't fix the replay issue, but will get back to that. now this:

Welcome to DrJava.  Working directory is /Users/klisehora14/Desktop/Miss Elily/Classes/APCS/Java Project
> run beatTheDealer.BeatTheDealer
Let's play Blackjack! Face cards are worth 10. An Ace is either worth 1 or 11; your call.
Your bank balance is $100.0. Bets are payed out 3:2. How much would you like to bet?
 [DrJava Input Box]
The dealer plays his initial two cards. His visible card is: 9 of Hearts
You're dealt your first card: The 2 of Spades. Your second card is: The 6 of Clubs
You and the dealer have both exceeded 21. The cards are discarded and play restarts with new cards. You keep your bet.
You came to the table with $100 and are leaving with $100.0. 
Breaking even is better than losing.> 

Welcome to DrJava.  Working directory is /Users/klisehora14/Desktop/Miss Elily/Classes/APCS/Java Project
> run beatTheDealer.BeatTheDealer
Let's play Blackjack! Face cards are worth 10. An Ace is either worth 1 or 11; your call.
Your bank balance is $100.0. Bets are payed out 3:2. How much would you like to bet?
 [DrJava Input Box]
The dealer plays his initial two cards. His visible card is: 4 of Diamonds
You're dealt your first card: The Ace of Diamonds. Your second card is: The 2 of Clubs
You and the dealer have both exceeded 21. The cards are discarded and play restarts with new cards. You keep your bet.
> 

-- WAS mising a parenthesis but not where i thought and not for what i though... also changed it to an 'if' not an else statement for the dealerWon
-- somehow the values aren't adding up right. need to fix that.
-- also, aces aren't working. values and aces. maybe it's just aces. maybe it thinks all aces are 11. but they're not. i got this.

Welcome to DrJava.  Working directory is /Users/klisehora14/Desktop/Miss Elily/Classes/APCS/Java Project
> run beatTheDealer.Testing
testerPoints = 0
Adding card: 3 of Hearts
Value of card is: 5000
testerPoints = 0
Adding card: 3 of Hearts
Value of card is: 5000
testerPoints = 0
Adding card: 3 of Hearts
Value of card is: 5000
testerPoints = 0
Adding card: 3 of Hearts
Value of card is: 5000
testerPoints = 0

.... yea cardValue is giving me crap.

Welcome to DrJava.  Working directory is /Users/klisehora14/Desktop/Miss Elily/Classes/APCS/Java Project
> run beatTheDealer.Testing
8 of Spades
> 

-- so cardvalue is getting the right string.it's the figuring out WHICH ONE IT IS that is the problem... which is bombin that's an easier problem to fix yesssss
-- changed from == to .equals("")

-- something that checks what their total is... if it's over 21... always says it is... error there
  
  
  Welcome to DrJava.  Working directory is /Users/klisehora14/Desktop/Miss Elily/Classes/APCS/Java Project
> run beatTheDealer.BeatTheDealer
Let's play Blackjack! Face cards are worth 10. An Ace is either worth 1 or 11; your call.
Your bank balance is $100.0. Bets are payed out 3:2. How much would you like to bet?
 [DrJava Input Box]
The dealer plays his initial two cards. His visible card is: 3 of Spades (first card for testing: 2 of Spades
You're dealt your first card: The 9 of Spades. Your second card is: The 6 of Diamonds
Dealers's points = 10000
Player's points = 10000
You and the dealer have both exceeded 21. The cards are discarded and play restarts with new cards. You keep your bet.
> 

-- still breaking in cardvalue. also, sometimes it won't run, it breaks.... not sure why.
-- WAIT. IM GIVING IT WORDS BUT IT WANTS NUMBERS. ho shit

Welcome to DrJava.  Working directory is /Users/klisehora14/Desktop/Miss Elily/Classes/APCS/Java Project
> run beatTheDealer.BeatTheDealer
Let's play Blackjack! Face cards are worth 10. An Ace is either worth 1 or 11; your call.
Your bank balance is $100.0. Bets are payed out 3:2. How much would you like to bet?
 [DrJava Input Box]
java.lang.IndexOutOfBoundsException: Index: 50, Size: 48
 at java.util.ArrayList.RangeCheck(ArrayList.java:547)
 at java.util.ArrayList.get(ArrayList.java:322)
 at beatTheDealer.Deck.Deck(Deck.java:71)
 at beatTheDealer.BeatTheDealer.main(BeatTheDealer.java:67)
 at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
 at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:39)
 at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:25)
 at java.lang.reflect.Method.invoke(Method.java:597)
 at edu.rice.cs.drjava.model.compiler.JavacCompiler.runCommand(JavacCompiler.java:272)
 
 -- wtf is this...
 
 Welcome to DrJava.  Working directory is /Users/klisehora14/Desktop/Miss Elily/Classes/APCS/Java Project
> run beatTheDealer.BeatTheDealer
Let's play Blackjack! Face cards are worth 10. An Ace is either worth 1 or 11; your call.
Your bank balance is $100.0. Bets are payed out 3:2. How much would you like to bet?
 [DrJava Input Box]
The dealer plays his initial two cards. His visible card is: 8 of Spades (first card for testing: Jack of Spades
You're dealt your first card: The 10 of Hearts. Your second card is: The 4 of Spades
Dealers's points = 5008
Player's points = 5004
You and the dealer have both exceeded 21. The cards are discarded and play restarts with new cards. You keep your bet.

-- HOOO I FIXED SOMETHING check out those point values. ONE of the cards is working. wtffffff. 
-- FIRST CARD is getting 5000. SECOND CARD is getting value. i got this.

Welcome to DrJava.  Working directory is /Users/klisehora14/Desktop/Miss Elily/Classes/APCS/Java Project
> run beatTheDealer.BeatTheDealer
Let's play Blackjack! Face cards are worth 10. An Ace is either worth 1 or 11; your call.
Your bank balance is $100.0. Bets are payed out 3:2. How much would you like to bet?
 [DrJava Input Box]
The dealer plays his initial two cards. His visible card is: 9 of Clubs (first card for testing: 3 of Hearts
The dealer hit. His card was: 5 of Hearts
You're dealt your first card: The Queen of Spades. Your second card is: The 5 of Hearts
Dealers's points = 17
Card value... dealer.get(0) = 3
Player's points = 5005
Card value... player.get(0) = 5000
Player busts!
The dealer wins! Bank balance: 95.0
Play again? 1 = yes, 2 = no.
 [DrJava Input Box]


... so sometimes the first card works. but only for the player OR the dealer.. not for both...? wow sometimes both
  
  
  Welcome to DrJava.  Working directory is /Users/klisehora14/Desktop/Miss Elily/Classes/APCS/Java Project
> run beatTheDealer.BeatTheDealer
Let's play Blackjack! Face cards are worth 10. An Ace is either worth 1 or 11; your call.
Your bank balance is $100.0. Bets are payed out 3:2. How much would you like to bet?
 [DrJava Input Box]
The dealer plays his initial two cards. His visible card is: 5 of Hearts (first card for testing: 9 of Spades
The dealer hit. His card was: 9 of Clubs
You're dealt your first card: The 6 of Diamonds. Your second card is: The Jack of Diamonds
Dealers's points = 23
Card value... dealer.get(0) = 9
Player's points = 5006
Card value... player.get(0) = 6
You and the dealer have both exceeded 21. The cards are discarded and play restarts with new cards. You keep your bet.
> still need to fix...

--IT HITS THO THATS BOMBIN

Welcome to DrJava.  Working directory is /Users/klisehora14/Desktop/Miss Elily/Classes/APCS/Java Project
> run beatTheDealer.BeatTheDealer
Let's play Blackjack! Face cards are worth 10. An Ace is either worth 1 or 11; your call.
Your bank balance is $100.0. Bets are payed out 3:2. How much would you like to bet?
 [DrJava Input Box]
The dealer plays his initial two cards. His visible card is: 5 of Clubs (first card for testing: 2 of Hearts
The dealer hit. His card was: 6 of Spades
The dealer hit. His card was: 6 of Spades
You're dealt your first card: The 8 of Clubs. Your second card is: The Ace of Diamonds
Dealers's points = 19
Card value... dealer.get(0) = 2
Player's points = 5008
Card value... player.get(0) = 8
Player busts!
The dealer wins! Bank balance: 95.0
Play again? 1 = yes, 2 = no.

... got 6 of spades twice..

Welcome to DrJava.  Working directory is /Users/klisehora14/Desktop/Miss Elily/Classes/APCS/Java Project
> run beatTheDealer.BeatTheDealer
Let's play Blackjack! Face cards are worth 10. An Ace is either worth 1 or 11; your call.
Your bank balance is $100.0. Bets are payed out 3:2. How much would you like to bet?
 [DrJava Input Box]
The dealer plays his initial two cards. His visible card is: 8 of Hearts (first card for testing: 2 of Hearts
The dealer hit. His card was: 2 of Clubs
The dealer hit. His card was: 2 of Clubs
The dealer hit. His card was: 2 of Clubs
The dealer hit. His card was: 2 of Clubs

.. so all the numbers work. it's like ace, jack, queen, and king that are creating problems.
also, they can pull the same card. actually, when they hit, it's always the same card if they hit more than once.

Welcome to DrJava.  Working directory is /Users/klisehora14/Desktop/Miss Elily/Classes/APCS/Java Project
> run beatTheDealer.Testing
5000
5000
5000
5000
> 
... somehow it doesn't get it when substring calls for a letter instead of a number? and the difference is not the way it equals..
--FIIIXED It.. changed it so it's not looking for the first letter it's looking for the SECOND. booyah.

Welcome to DrJava.  Working directory is /Users/klisehora14/Desktop/Miss Elily/Classes/APCS/Java Project
> run beatTheDealer.BeatTheDealer
Let's play Blackjack! Face cards are worth 10. An Ace is either worth 1 or 11; your call.
Your bank balance is $100.0. Bets are payed out 3:2. How much would you like to bet?
 [DrJava Input Box]
The dealer plays his initial two cards. His visible card is: 2 of Hearts (first card for testing: 3 of Hearts
The dealer hit. His card was: 2 of Clubs
The dealer hit. His card was: Queen of Clubs
You're dealt your first card: The Jack of Clubs. Your second card is: The 8 of Diamonds
Dealers's points = 17
Card value... dealer.get(0) = 3
Player's points = 18
Card value... player.get(0) = 10
The dealer stands. He has 14 visible points.
Hit or stand?
You stand. Your total is 18. The dealer flips his first card. His total is 17. 
The player exceeds the dealer by 1.The player wins! Bank balance: 45.0
Play again? 1 = yes, 2 = no.


-- boom. next problem. player automatically stands. whichhhhh is hopefully a minor problem! ahh the enthusiasm.

Let's play Blackjack! Face cards are worth 10. An Ace is either worth 1 or 11; your call.
Your bank balance is $100.0. Bets are payed out 3:2. How much would you like to bet?
 [DrJava Input Box]
The dealer plays his initial two cards. His visible card is: 5 of Diamonds (first card for testing: Jack of Diamonds
The dealer hit. His card was: 7 of Diamonds
You're dealt your first card: The Ace of Diamonds. Your second card is: The 5 of Clubs
Dealers's points = 22
Card value... dealer.get(0) = 10
Player's points = 6
Card value... player.get(0) = 1

-- might have fixed that problem?
-- new problem. when dealer is over 21 and player is not
... big problem. considering rewriting the entire class so i know that  there are the correct brackets and stuff eerywhere

-- yea so fixed the bracket problem.. I THINK hopefully that saves some trouble

Welcome to DrJava.  Working directory is /Users/klisehora14/Desktop/Miss Elily/Classes/APCS/Java Project
> run beatTheDealer.BeatTheDealer
Let's play Blackjack! Face cards are worth 10. An Ace is either worth 1 or 11; your call.
Your bank balance is $100.0. Bets are payed out 3:2. How much would you like to bet?
 [DrJava Input Box]
The dealer plays his initial two cards. His visible card is: 6 of Hearts (first card for testing: 5 of Spades
The dealer hit. His card was: 2 of Clubs
The dealer hit. His card was: 3 of Clubs
The dealer hit. His card was: Queen of Diamonds
You're dealt your first card: The 6 of Diamonds. Your second card is: The 7 of Spades
Dealers's points = 26
Card value... dealer.get(0) = 5
Player's points = 13
Card value... player.get(0) = 6
Dealer busts!
> 

looks like we're getting somewhere. why doesn't it go into the whole whenPlayerWon=true stuff

fixed it! it's else if and if stuff. gotta be if if 

Welcome to DrJava.  Working directory is /Users/klisehora14/Desktop/Miss Elily/Classes/APCS/Java Project
> run beatTheDealer.BeatTheDealer
Let's play Blackjack! Face cards are worth 10. An Ace is either worth 1 or 11; your call.
Your bank balance is $100.0. Bets are payed out 3:2. How much would you like to bet?
 [DrJava Input Box]
The dealer plays his initial two cards. His visible card is: 6 of Diamonds (first card for testing: 2 of Hearts
The dealer hit. His card was: 9 of Spades
You're dealt your first card: The Jack of Diamonds. Your second card is: The 6 of Spades
Dealers's points = 17
Card value... dealer.get(0) = 2
Player's points = 16
Card value... player.get(0) = 10
The dealer stands. He has 15 visible points.
Hit or stand?
You stand. Your total is 16. The dealer flips his first card. His total is 17. 
Player busts!The dealer wins! Bank balance: 95.0
Play again? 1 = yes, 2 = no.
 [DrJava Input Box]

-- still hit/stand issues... now it's when player and dealer and under 21
-- only if player overdraws does the game end faa;lsdkfjasdf

-- the hit/stand is the biggest issue right now... why won't it ask for an answer?
-- changed it to toLowerCase and created new string values to just check it against... changed general format; asked to check for stand instead of just saying else 

--The dealer stands. He has 10 visible points.
Hit or stand?
> hit
Static Error: Undefined name 'hit'

-- still error with that. took out strings that i was checking it against and now just .equals("hit/stand") stuff. still undefined error...

.....

MAJOR CHANGE:
created playOutPlayer() within beatTheDealer.BeatTheDealer ... hopefully will make it easier to read and will simplify things. seems to work because i'm still
getting the same stupid error :P haha. reduced that code by 66% :D

- SYNCHEDDDD

MAJOR CHANGES:
-------------------------reduce amount of code by quite a bit. simplify the read. more organized. such better. much love. 
- added dealCards()
- added betting()
- added reset()
     - which also REFILLS THE DECK with the lost cards, which was an issue I had from the beginnning but I FIGURED IT OUT BOOYAAAHHH
           - through beatTheDealer.Deck
                 - added refillTheDeck(), cardSuit(), and cardValue() to Deck
- added noMoreGames()

Welcome to DrJava.  Working directory is /Users/klisehora14/Desktop/Miss Elily/Classes/APCS/Java Project
> run beatTheDealer.BeatTheDealer
Let's play Blackjack! Face cards are worth 10. An Ace is either worth 1 or 11; your call.
Your bank balance is $100.0. Bets are payed out 3:2. How much would you like to bet?
 [DrJava Input Box]
The dealer plays his initial two cards. His visible card is: 7 of Diamonds (first card for testing: 5 of Diamonds
The dealer hit. His card was: 3 of Clubs
The dealer hit. His card was: 2 of Clubs
You're dealt your first card: The Ace of Spades. Your second card is: The 7 of Hearts
Dealers's points = 17
Card value... dealer.get(0) = 5
Player's points = 8
Card value... player.get(0) = 1
The dealer stands. He has 12 visible points.
Hit or stand?
 [DrJava Input Box]
You are dealt: 7 of Hearts.

 -- keep calling... add a check... until the booleans are true?
 fixeddd! created new instance of scanner. thanks wyatt.
 
 Welcome to DrJava.  Working directory is /Users/klisehora14/Desktop/Miss Elily/Classes/APCS/Java Project
> run beatTheDealer.BeatTheDealer
Let's play Blackjack! Face cards are worth 10. An Ace is either worth 1 or 11; your call.
Your bank balance is $100.0. Bets are payed out 3:2. How much would you like to bet?
 [DrJava Input Box]
The dealer plays his initial two cards. His visible card is: Queen of Clubs (first card for testing: Ace of Diamonds
You're dealt your first card: The Ace of Spades. Your second card is: The Queen of Hearts
Dealers's points = 21
Card value... dealer.get(0) = 1
Player's points = 11
Card value... player.get(0) = 1
The dealer stands. He has 20 visible points.
Hit or stand?
 [DrJava Input Box]
You are dealt: Queen of Hearts.
The dealer stands. He has 20 visible points.
Hit or stand?
 [DrJava Input Box]
You stand. Your total is 21. The dealer flips his first card. His total is 21. 
The player and the dealer tie. The cards are discarded and play restarts with new cards. The player keeps the bet.
Str is: Ace of DiamondsThe card being added to the deck it: 3-1
Str is: Queen of ClubsThe card being added to the deck it: 2-12
java.lang.IndexOutOfBoundsException: Index: 2, Size: 2
 at java.util.ArrayList.RangeCheck(ArrayList.java:547)
 at java.util.ArrayList.get(ArrayList.java:322)
 at beatTheDealer.BeatTheDealer.reset(BeatTheDealer.java:296)
 at beatTheDealer.BeatTheDealer.playOutPlayer(BeatTheDealer.java:205)
 at beatTheDealer.BeatTheDealer.main(BeatTheDealer.java:83)
 at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
 at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:39)
 at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:25)
 at java.lang.reflect.Method.invoke(Method.java:597)
 at edu.rice.cs.drjava.model.compiler.JavacCompiler.runCommand(JavacCompiler.java:272)
> 


--- WOOOO fixed that. NEW PROBLEM:
-- what to do when tied

Welcome to DrJava.  Working directory is /Users/klisehora14/Desktop/Miss Elily/Classes/APCS/Java Project
> run beatTheDealer.BeatTheDealer
Let's play Blackjack! Face cards are worth 10. An Ace is either worth 1 or 11; your call.
Your bank balance is $100.0. Bets are payed out 3:2. How much would you like to bet?
 [DrJava Input Box]
The dealer plays his initial two cards. His visible card is: Ace of Spades (first card for testing: 5 of Diamonds
The dealer hit. His card was: 4 of Hearts
You're dealt your first card: The 7 of Spades. Your second card is: The 10 of Spades
Dealers's points = 20
Card value... dealer.get(0) = 5
Player's points = 17
Card value... player.get(0) = 7
The dealer stands. He has 15 visible points.
Hit or stand?
 [DrJava Input Box]
You are dealt: 10 of Spades.
The dealer stands. He has 15 visible points.
Hit or stand?
 [DrJava Input Box]
You stand. Your total is 18. The dealer flips his first card. His total is 20. 
Player busts!The dealer stands. He has 15 visible points.
Hit or stand?
 [DrJava Input Box]

-- created playPlayer()

-- LOOK AT ALL THOSE BUGS DAYUM SEXAY BUGS YEA ugh lol

Welcome to DrJava.  Working directory is /Users/klisehora14/Desktop/Miss Elily/Classes/APCS/Java Project
> run beatTheDealer.BeatTheDealer
Let's play Blackjack! Face cards are worth 10. An Ace is either worth 1 or 11; your call.
Your bank balance is $100.0. Bets are payed out 3:2. How much would you like to bet?
 [DrJava Input Box]
The dealer plays his initial two cards. His visible card is: 6 of Clubs (first card for testing: 2 of Clubs
The dealer hit. His card was: 3 of Hearts
The dealer hit. His card was: 9 of Hearts
You're dealt your first card: The Queen of Spades. Your second card is: The 6 of Diamonds
Dealers's points = 20
Card value... dealer.get(0) = 2
Player's points = 16
Card value... player.get(0) = 10
The dealer has 18 visible points.
Hit or stand?
 [DrJava Input Box]
You are dealt: 6 of Diamonds.
The dealer has 18 visible points.
Hit or stand?
 [DrJava Input Box]
You stand. Your total is 22. The dealer flips his first card. His total is 20. 
The dealer has 18 visible points.
Hit or stand?
 [DrJava Input Box]


You stand. Your total is 13. The dealer flips his first card. His total is 24. 
The dealer has 14 visible points.
Hit or stand?
 [DrJava Input Box]


- aqui esta mi problemo...


You're dealt your first card: The Ace of Spades. Your second card is: The 2 of Diamonds
Dealers's points = 24
Card value... dealer.get(0) = 7
Player's points = 3
Card value... player.get(0) = 1
The dealer has 17 visible points.
Hit or stand?
 [DrJava Input Box]
You stand. Your total is 3. The dealer flips his first card. His total is 34. 
The dealer has 27 visible points.
Hit or stand?

Hit or stand?
 [DrJava Input Box]
There is an ace.
There is an ace.
java.lang.IndexOutOfBoundsException: Index: 2, Size: 2

-- BUGS:
 - aces for player
    - think fixed
       - or not
 - tells you how many points hte dealer has
 - not changing the boolean/acting on the boolean.
 - so much extra wording
 - error when player stands
  */

public class notes
{
}