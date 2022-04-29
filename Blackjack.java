import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Blackjack {
    public static void main(String[] args) throws InterruptedException {

        int pot = 100;
        Scanner keyboard = new Scanner(System.in);

        game:
        while (pot > 0 && pot < 200){
            Deck blackjackDeck = new Deck();
            Hand playerHand = new Hand();
            Hand dealerHand = new Hand();
            
            System.out.println();
            System.out.println("Welcome! You have started a new game of blackjack!");
            TimeUnit.SECONDS.sleep(3);           
            
            String regex = "\\d+";
            String betString = "";
            int bet = 0;

            while (bet < 1 || bet > pot){
                System.out.println();
                System.out.printf("You have $%d to play with, please set your bet ammount. Number value between $1 and $%d only please! ", pot, pot);
                betString = keyboard.nextLine();
                while (!betString.matches(regex)){
                    System.out.println();
                    System.out.printf("You have $%d to play with, please set your bet ammount. Number value between $1 and $%d only please! ", pot, pot);
                    betString = keyboard.nextLine();
                }
                bet = Integer.parseInt(betString);
            }
            
            pot -= bet;
            System.out.println();
            System.out.printf("You are betting $%d, and you have $%d left in your pot.", bet, pot);
            TimeUnit.SECONDS.sleep(3);

            blackjackDeck.shuffle();
            System.out.println();
            System.out.println();
            System.out.print("Shuffling cards.");
            Print.fourDots();
            System.out.println("Deck is shuffled. Time to begin the game!");
            TimeUnit.SECONDS.sleep(3);

            playerHand.add(blackjackDeck.remove());
            //playerHand.add(new Card("Spades", "Ace"));
            
            System.out.println();
            System.out.printf("The dealer dealt you a | %s | for your first card.", playerHand.getDeck().get(0).toString());
            System.out.println();
            System.out.println();
            System.out.print("| ");
            
            for (int i=0; i<playerHand.getDeck().size(); i++){
                System.out.print(playerHand.getDeck().get(i).toString());
                System.out.print(" | ");
            }

            Print.fourDots();
            
            dealerHand.add(blackjackDeck.remove());
            System.out.println();
            System.out.printf("The dealer dealt themselves a | %s | for their first card.", dealerHand.getDeck().get(0).toString());
            System.out.println();
            System.out.println();
            System.out.print("| ");
            
            for (int i=0; i<dealerHand.getDeck().size(); i++){
                System.out.print(dealerHand.getDeck().get(i).toString());
                System.out.print(" | ");
            }

            Print.fourDots();

            playerHand.add(blackjackDeck.remove());
            //playerHand.add(new Card("Hearts", "Ace"));

            System.out.println();
            System.out.printf("The dealer dealt you a | %s | for your second card.", playerHand.getDeck().get(1).toString());
            System.out.println();
            System.out.println();
            System.out.print("| ");

            for (int i=0; i<playerHand.getDeck().size(); i++){
                System.out.print(playerHand.getDeck().get(i).toString());
                System.out.print(" | ");
            }

            Print.fourDots();

            dealerHand.add(blackjackDeck.remove());
            System.out.println();
            System.out.printf("The dealer dealt themselves a | %s | for their second card.", "-HIDDEN-");
            System.out.println();
            System.out.println();
            System.out.print("| ");

            for (int i=0; i<dealerHand.getDeck().size(); i++){
                if (i == 1){
                    System.out.print("-HIDDEN-");
                    System.out.print(" | ");
                }
                else { 
                    System.out.print(dealerHand.getDeck().get(i).toString());
                    System.out.print(" | ");
                }
            }

            Print.fourDots();

            System.out.println();
            System.out.println("Player's current hand: ");
            System.out.println();
            System.out.print("| ");

            for (int i=0; i<playerHand.getDeck().size(); i++){
                System.out.print(playerHand.getDeck().get(i).toString());
                System.out.print(" | ");
            }

            //System.out.println("" + playerHand.getDeck().get(0).toString() + " " + playerHand.getDeck().get(1).toString()); 
            TimeUnit.SECONDS.sleep(3);
            System.out.println();

            int playerHandValue = 0;
            int dealerHandValue = 0;


            for (Card c : playerHand.getDeck()){
                playerHandValue += c.getValue();
            }
            
            System.out.println();
            System.out.println("Dealer's current hand: ");
            System.out.println();
            System.out.print("| ");
            for (int i=0; i<dealerHand.getDeck().size(); i++){
                if (i == 1){
                    System.out.print("-HIDDEN-");
                    System.out.print(" | ");
                }
                else { 
                    System.out.print(dealerHand.getDeck().get(i).toString());
                    System.out.print(" | ");
                }
            }
            //System.out.println("" + dealerHand.getDeck().get(0).toString() + " -HIDDEN-");

            Print.fourDots();

            int winnings = 0;
            
            if (playerHandValue == 21){
                System.out.println();
                System.out.println("\u2660 \u2660 \u2660 BLACKJACK! \u2660 \u2660 \u2660");
                TimeUnit.SECONDS.sleep(3);
                System.out.println();
                System.out.println("You win 1.5 times your original bet!");
                TimeUnit.SECONDS.sleep(3);
                System.out.println();
                winnings += bet * 1.5;
                pot += winnings;
                System.out.printf("Your original bet was %d dollars, and you won %d dollars!", bet, winnings);
                TimeUnit.SECONDS.sleep(5);
                System.out.println();
                System.out.println();
                System.out.printf("You now have a total of %d dollars in your pot!", pot);
                TimeUnit.SECONDS.sleep(3);
                System.out.println();
                System.out.println();
                System.out.println("Would you like to start another round?");
                TimeUnit.SECONDS.sleep(3);
                System.out.println();
                String continueString = "";

                while (!continueString.equals("Yes") && !continueString.equals("No")){
                    System.out.println();
                    System.out.println("Please enter \"Yes\" or \"No\". ");
                    System.out.println();
                    continueString = keyboard.nextLine();
                }

                if (continueString.equals("Yes")){
                    System.out.println();
                    System.out.println("New round starting shortly...");
                    Print.fourDots();
                    continue game;
                }

                else {
                    Print.smartPlayer();
                    Print.fourDots();
                    
                    
                    System.out.println();
                    System.out.printf("It looks like you are ending the game with %d dollars in your pot!", pot);
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println();
                    System.out.println();
                    System.out.println("GAME OVER.");
                    System.out.println();
                    TimeUnit.SECONDS.sleep(3);
                    System.exit(0);
                }
            }

            else if (playerHandValue > 21){
                System.out.println();
                System.out.println("\u2639 ROOKIE! \u2639");
                TimeUnit.SECONDS.sleep(3);
                System.out.println();
                System.out.println("How did you manage to choose 11 for both of your aces?");
                TimeUnit.SECONDS.sleep(3);
                System.out.println();
                winnings = 0;
                pot += winnings;
                System.out.printf("Your original bet was %d dollars, and you won %d dollars!", bet, winnings);
                TimeUnit.SECONDS.sleep(5);
                System.out.println();
                System.out.println();
                System.out.printf("You now have a total of %d dollars in your pot!", pot);
                TimeUnit.SECONDS.sleep(3);
                System.out.println();
                System.out.println();

                System.out.println("Would you like to start another round?");
                TimeUnit.SECONDS.sleep(3);
                System.out.println();
                String continueString = "";

                while (!continueString.equals("Yes") && !continueString.equals("No")) {
                    System.out.println();
                    System.out.println("Please enter \"Yes\" or \"No\". ");
                    System.out.println();
                    continueString = keyboard.nextLine();
                }

                if (continueString.equals("Yes")){
                    System.out.println();
                    System.out.println("New round starting shortly...");
                    Print.fourDots();
                    continue game;
                }

                else { 
                    Print.smartPlayer();
                    Print.fourDots();
                    
                    System.out.println();
                    System.out.printf("It looks like you are ending the game with %d dollars in your pot!", pot);
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println();
                    System.out.println();
                    System.out.println("GAME OVER.");
                    System.out.println();
                    TimeUnit.SECONDS.sleep(3);
                    System.exit(0);
                }
            }

            else {

                Boolean stay = false;
                int cardCounter = 1;

                stayLoop:
                while (stay == false) {
                    cardCounter ++;

                    System.out.println();
                    System.out.println("Player's current hand: ");
                    System.out.println();
                    System.out.print("| ");
                    for (int i=0; i<playerHand.getDeck().size(); i++){
                        System.out.print(playerHand.getDeck().get(i).toString());
                        System.out.print(" | ");
                    }

                    System.out.println();
                    TimeUnit.SECONDS.sleep(3);

                    System.out.println();
                    System.out.println("Dealer's current hand: ");
                    System.out.println();
                    System.out.print("| ");
                    for (int i=0; i<dealerHand.getDeck().size(); i++){
                        if (i == 1){
                            System.out.print("-HIDDEN-");
                            System.out.print(" | ");
                        }
                        else { 
                            System.out.print(dealerHand.getDeck().get(i).toString());
                            System.out.print(" | ");
                        }
                    }

                    TimeUnit.SECONDS.sleep(3);
                    System.out.println();
                    String stayOrHit = "";

                    while (!stayOrHit.equals("Hit") && !stayOrHit.equals("Stay")) {
                        System.out.println();
                        System.out.println("Please enter \"Hit\" for another card, or \"Stay\" for no more cards. ");
                        System.out.println();
                        stayOrHit = keyboard.nextLine();
                    }

                    if (stayOrHit.equals("Hit")){

                        playerHand.add(blackjackDeck.remove());
                        System.out.println();
                        System.out.printf("The dealer dealt you a | %s | for your next card.", playerHand.getDeck().get(cardCounter).toString());
                        
                        System.out.println();
                        System.out.println();
                        System.out.print("| ");

                        for (int i=0; i<playerHand.getDeck().size(); i++){
                            System.out.print(playerHand.getDeck().get(i).toString());
                            System.out.print(" | ");
                        }
                    
                        Print.fourDots();

                        playerHandValue += playerHand.getDeck().get(cardCounter).getValue();

                        if (playerHandValue > 21){
                            System.out.println();
                            System.out.println("Bust! Your card total is over 21!");
                            System.out.println();
                            winnings = 0;
                            pot += winnings;
                            TimeUnit.SECONDS.sleep(3);
                            System.out.printf("Your original bet was %d dollars, and you won %d dollars!", bet, winnings);
                            TimeUnit.SECONDS.sleep(5);
                            System.out.println();
                            System.out.println();
                            System.out.printf("You now have a total of %d dollars in your pot!", pot);
                            TimeUnit.SECONDS.sleep(3);
                            System.out.println();
                            System.out.println();

                            System.out.println("Would you like to start another round?");
                            TimeUnit.SECONDS.sleep(3);
                            System.out.println();
                            String continueString = "";

                            while (!continueString.equals("Yes") && !continueString.equals("No")) {
                                System.out.println();
                                System.out.println("Please enter \"Yes\" or \"No\". ");
                                System.out.println();
                                continueString = keyboard.nextLine();
                            }

                            if (continueString.equals("Yes")){
                                System.out.println();
                                System.out.println("New round starting shortly...");
                                Print.fourDots();
                                continue game;
                            }
                            
                            else { 
                                Print.smartPlayer();
                                Print.fourDots();
                                
                                System.out.println();
                                System.out.printf("It looks like you are ending the game with %d dollars in your pot!", pot);
                                TimeUnit.SECONDS.sleep(3);
                                System.out.println();
                                System.out.println();
                                System.out.println("GAME OVER.");
                                System.out.println();
                                TimeUnit.SECONDS.sleep(3);
                                System.exit(0);
                            }
                        }

                        else {
                            continue stayLoop;
                        }
                    }

                    else {
                        System.out.println();
                        System.out.print("You chose to stay, dealer will now flip their second card.");
                        Print.fourDots();
                        stay = true;
                        continue stayLoop;
                    }
                }

                System.out.print("The dealer's hidden card is... ");
                Print.fourDots();

                    
                System.out.println("Dealer's current hand: ");
                System.out.println();
                System.out.print("| ");
                for (int i=0; i<dealerHand.getDeck().size(); i++){
                    System.out.print(dealerHand.getDeck().get(i).toString());
                    System.out.print(" | ");
                }
                System.out.println();
                TimeUnit.SECONDS.sleep(3);
                System.out.println();

                for (Card c : dealerHand.getDeck()){
                    dealerHandValue += c.getValue();
                }

                if (dealerHandValue < 17){
                    int dealerCardCounter = 1;
                    dealerLoop:
                    while (dealerHandValue < 17) {
                        dealerCardCounter ++;
                        dealerHand.add(blackjackDeck.remove());
                        System.out.println("The dealer's total is less than 17.");
                        TimeUnit.SECONDS.sleep(4);
                        System.out.println();
                        System.out.printf("The dealer dealt themselves a | %s | for their next card.", dealerHand.getDeck().get(dealerCardCounter).toString());
                        System.out.println();
                        System.out.println();
                        System.out.print("| ");

                        for (int i=0; i<dealerHand.getDeck().size(); i++){
                            System.out.print(dealerHand.getDeck().get(i).toString());
                            System.out.print(" | ");
                        }
                        Print.fourDots();

                        dealerHandValue += dealerHand.getDeck().get(dealerCardCounter).getValue();
                        continue dealerLoop;
                    }

                    if (dealerHandValue >= 17 && dealerHandValue <= 21){

                        if (playerHandValue > dealerHandValue){

                            System.out.print("The value of your hand is greater than the dealers!");
                            Print.fourDots();
                            System.out.println("That means you beat the dealer! ");
                            TimeUnit.SECONDS.sleep(3);
                            System.out.println();

                            System.out.println("You win 2 times your original bet!");
                            TimeUnit.SECONDS.sleep(3);
                            System.out.println();
                            winnings += bet * 2;
                            pot += winnings;
                            System.out.printf("Your original bet was %d dollars, and you won %d dollars!", bet, winnings);
                            TimeUnit.SECONDS.sleep(5);
                            System.out.println();
                            System.out.println();
                            System.out.printf("You now have a total of %d dollars in your pot!", pot);
                            TimeUnit.SECONDS.sleep(3);
                            System.out.println();
                            System.out.println();
                            System.out.println("Would you like to start another round?");
                            TimeUnit.SECONDS.sleep(3);
                            System.out.println();
                            String continueString = "";

                            while (!continueString.equals("Yes") && !continueString.equals("No")){
                                System.out.println();
                                System.out.println("Please enter \"Yes\" or \"No\". ");
                                System.out.println();
                                continueString = keyboard.nextLine();
                            }
                        
                            if (continueString.equals("Yes")){
                                System.out.println();
                                System.out.println("New round starting shortly...");
                                Print.fourDots();
                            
                                continue game;
                            }
                        
                            else {
                                Print.smartPlayer();
                                Print.fourDots();


                                System.out.println();
                                System.out.printf("It looks like you are ending the game with %d dollars in your pot!", pot);
                                TimeUnit.SECONDS.sleep(3);
                                System.out.println();
                                System.out.println();
                                System.out.println("GAME OVER.");
                                System.out.println();
                                TimeUnit.SECONDS.sleep(3);
                                System.exit(0);
                            }
                        }

                        else {

                            System.out.println();
                            System.out.println("The value of your hand is not greater than the dealers!");
                            System.out.println();
                            winnings = 0;
                            pot += winnings;
                            TimeUnit.SECONDS.sleep(3);
                            System.out.printf("Your original bet was %d dollars, and you won %d dollars!", bet, winnings);
                            TimeUnit.SECONDS.sleep(5);
                            System.out.println();
                            System.out.println();
                            System.out.printf("You now have a total of %d dollars in your pot!", pot);
                            TimeUnit.SECONDS.sleep(3);
                            System.out.println();
                            System.out.println();

                            System.out.println("Would you like to start another round?");
                            TimeUnit.SECONDS.sleep(3);
                            System.out.println();
                            String continueString = "";

                            while (!continueString.equals("Yes") && !continueString.equals("No")) {
                                System.out.println();
                                System.out.println("Please enter \"Yes\" or \"No\". ");
                                System.out.println();
                                continueString = keyboard.nextLine();
                            }

                            if (continueString.equals("Yes")){
                                System.out.println();
                                System.out.println("New round starting shortly...");
                                Print.fourDots();
                                continue game;
                            }
                            
                            else { 
                                Print.smartPlayer();
                                Print.fourDots();
                                
                                System.out.println();
                                System.out.printf("It looks like you are ending the game with %d dollars in your pot!", pot);
                                TimeUnit.SECONDS.sleep(3);
                                System.out.println();
                                System.out.println();
                                System.out.println("GAME OVER.");
                                System.out.println();
                                TimeUnit.SECONDS.sleep(3);
                                System.exit(0);
                            }
                        }
                    }

                    else {
                        System.out.print("Bust! The dealer's card total is over 21!");
                        Print.fourDots();
                        System.out.println("That means you beat the dealer! ");
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println();

                        System.out.println("You win 2 times your original bet!");
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println();
                        winnings += bet * 2;
                        pot += winnings;
                        System.out.printf("Your original bet was %d dollars, and you won %d dollars!", bet, winnings);
                        TimeUnit.SECONDS.sleep(5);
                        System.out.println();
                        System.out.println();
                        System.out.printf("You now have a total of %d dollars in your pot!", pot);
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println();
                        System.out.println();
                        System.out.println("Would you like to start another round?");
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println();
                        String continueString = "";

                        while (!continueString.equals("Yes") && !continueString.equals("No")){
                            System.out.println();
                            System.out.println("Please enter \"Yes\" or \"No\". ");
                            System.out.println();
                            continueString = keyboard.nextLine();
                        }
                    
                        if (continueString.equals("Yes")){
                            System.out.println();
                            System.out.println("New round starting shortly...");
                            Print.fourDots();
                        
                            continue game;
                        }
                    
                        else {
                            Print.smartPlayer();
                            Print.fourDots();


                            System.out.println();
                            System.out.printf("It looks like you are ending the game with %d dollars in your pot!", pot);
                            TimeUnit.SECONDS.sleep(3);
                            System.out.println();
                            System.out.println();
                            System.out.println("GAME OVER.");
                            System.out.println();
                            TimeUnit.SECONDS.sleep(3);
                            System.exit(0);
                        }
                    }
                }

                else {

                    System.out.println("It looks like the value of the dealer's first 2 cards is 17 or more");
                    Print.fourDots();

                    if (dealerHandValue <= 21){

                        if (playerHandValue > dealerHandValue){

                            System.out.print("The value of your hand is greater than the dealers!");
                            Print.fourDots();
                            System.out.println("That means you beat the dealer! ");
                            TimeUnit.SECONDS.sleep(3);
                            System.out.println();

                            System.out.println("You win 2 times your original bet!");
                            TimeUnit.SECONDS.sleep(3);
                            System.out.println();
                            winnings += bet * 2;
                            pot += winnings;
                            System.out.printf("Your original bet was %d dollars, and you won %d dollars!", bet, winnings);
                            TimeUnit.SECONDS.sleep(5);
                            System.out.println();
                            System.out.println();
                            System.out.printf("You now have a total of %d dollars in your pot!", pot);
                            TimeUnit.SECONDS.sleep(3);
                            System.out.println();
                            System.out.println();
                            System.out.println("Would you like to start another round?");
                            TimeUnit.SECONDS.sleep(3);
                            System.out.println();
                            String continueString = "";

                            while (!continueString.equals("Yes") && !continueString.equals("No")){
                                System.out.println();
                                System.out.println("Please enter \"Yes\" or \"No\". ");
                                System.out.println();
                                continueString = keyboard.nextLine();
                            }
                        
                            if (continueString.equals("Yes")){
                                System.out.println();
                                System.out.println("New round starting shortly...");
                                Print.fourDots();
                            
                                continue game;
                            }
                        
                            else {
                                Print.smartPlayer();
                                Print.fourDots();


                                System.out.println();
                                System.out.printf("It looks like you are ending the game with %d dollars in your pot!", pot);
                                TimeUnit.SECONDS.sleep(3);
                                System.out.println();
                                System.out.println();
                                System.out.println("GAME OVER.");
                                System.out.println();
                                TimeUnit.SECONDS.sleep(3);
                                System.exit(0);
                            }
                        }

                        else {

                            System.out.println();
                            System.out.println("The value of your hand is not greater than the dealers!");
                            System.out.println();
                            winnings = 0;
                            pot += winnings;
                            TimeUnit.SECONDS.sleep(3);
                            System.out.printf("Your original bet was %d dollars, and you won %d dollars!", bet, winnings);
                            TimeUnit.SECONDS.sleep(5);
                            System.out.println();
                            System.out.println();
                            System.out.printf("You now have a total of %d dollars in your pot!", pot);
                            TimeUnit.SECONDS.sleep(3);
                            System.out.println();
                            System.out.println();

                            System.out.println("Would you like to start another round?");
                            TimeUnit.SECONDS.sleep(3);
                            System.out.println();
                            String continueString = "";

                            while (!continueString.equals("Yes") && !continueString.equals("No")) {
                                System.out.println();
                                System.out.println("Please enter \"Yes\" or \"No\". ");
                                System.out.println();
                                continueString = keyboard.nextLine();
                            }

                            if (continueString.equals("Yes")){
                                System.out.println();
                                System.out.println("New round starting shortly...");
                                Print.fourDots();
                                continue game;
                            }
                            
                            else { 
                                Print.smartPlayer();
                                Print.fourDots();
                                
                                System.out.println();
                                System.out.printf("It looks like you are ending the game with %d dollars in your pot!", pot);
                                TimeUnit.SECONDS.sleep(3);
                                System.out.println();
                                System.out.println();
                                System.out.println("GAME OVER.");
                                System.out.println();
                                TimeUnit.SECONDS.sleep(3);
                                System.exit(0);
                            }
                        }
                    }

                    else {

                        System.out.print("Bust! The dealer's card total is over 21!");
                        Print.fourDots();
                        System.out.println("That means you beat the dealer! ");
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println();

                        System.out.println("You win 2 times your original bet!");
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println();
                        winnings += bet * 2;
                        pot += winnings;
                        System.out.printf("Your original bet was %d dollars, and you won %d dollars!", bet, winnings);
                        TimeUnit.SECONDS.sleep(5);
                        System.out.println();
                        System.out.println();
                        System.out.printf("You now have a total of %d dollars in your pot!", pot);
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println();
                        System.out.println();
                        System.out.println("Would you like to start another round?");
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println();
                        String continueString = "";

                        while (!continueString.equals("Yes") && !continueString.equals("No")){
                            System.out.println();
                            System.out.println("Please enter \"Yes\" or \"No\". ");
                            System.out.println();
                            continueString = keyboard.nextLine();
                        }
                    
                        if (continueString.equals("Yes")){
                            System.out.println();
                            System.out.println("New round starting shortly...");
                            Print.fourDots();
                        
                            continue game;
                        }
                    
                        else {
                            Print.smartPlayer();
                            Print.fourDots();


                            System.out.println();
                            System.out.printf("It looks like you are ending the game with %d dollars in your pot!", pot);
                            TimeUnit.SECONDS.sleep(3);
                            System.out.println();
                            System.out.println();
                            System.out.println("GAME OVER.");
                            System.out.println();
                            TimeUnit.SECONDS.sleep(3);
                            System.exit(0);
                        }
                    }
                }
            }
        }

        if (pot >= 200){
            Print.potOneWin();
            System.out.printf("You are ending the game with %d dollars in your pot!", pot);
            Print.potTwo();
        }

        else if (pot == 0){
            Print.potOneLose();
            System.out.printf("You are ending the game with %d dollars in your pot!", pot);
            Print.potTwo();
        }

        else {
            ;
        }
    }
}




                //while stay is false
                // dealer asks if you want another card
                // hit for another card
                    // if you go over 21 you bust and lose your bet
                // stay for no more cards
                    // go on

                //dealer flips second card

                // if value is less than 17
                // while dealervalue is less than 17
                // hit for another card
                // Stop when value is 17 or more
                    // if value is 17 to 21 
                        // players with smaller hand lose their bet
                        // players with larger hand win 2x their bet
                    // if the value is more than 21
                        // dealer busts everyone gets 2x bet
                
                // if value is 17 or more
                //if dealer doesnt bust not 22
                    // players with smaller hand lose their bet
                    // players with larger hand win 2x their bet
                // if the dealer busts 22
                    // dealer busts everyone gets 2x bet