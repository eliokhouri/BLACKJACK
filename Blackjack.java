import java.util.Scanner;
import java.util.concurrent.TimeUnit;



public class Blackjack {
    public static void main(String[] args) throws InterruptedException {

        int pot = 100;
        Scanner keyboard = new Scanner(System.in);

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
            System.out.println("Shuffling cards.");
            for (int i=0; i<3; i++){
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.println();
            }
            System.out.println();
            System.out.println("Deck is shuffled. Time to begin the game!");
            TimeUnit.SECONDS.sleep(3);

            //playerHand.add(blackjackDeck.remove());
            playerHand.add(new Card("Spades", "Ace"));
            
            System.out.println();
            System.out.printf("The dealer dealt you a | %s | for your first card.", playerHand.getDeck().get(0).toString());
            System.out.println();
            System.out.println();
            System.out.print("| ");
            for (int i=0; i<playerHand.getDeck().size(); i++){
                System.out.print(playerHand.getDeck().get(i).toString());
                System.out.print(" | ");
            }
            System.out.println();
            System.out.println();
            for (int i=0; i<2; i++){
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                System.out.println();
            }
            System.out.println();
            
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
            System.out.println();
            System.out.println();
            for (int i=0; i<2; i++){
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                System.out.println();
            }
            System.out.println();

            //playerHand.add(blackjackDeck.remove());
            playerHand.add(new Card("Hearts", "Ace"));

            System.out.println();
            System.out.printf("The dealer dealt you a | %s | for your second card.", playerHand.getDeck().get(1).toString());
            System.out.println();
            System.out.println();
            System.out.print("| ");
            for (int i=0; i<playerHand.getDeck().size(); i++){
                System.out.print(playerHand.getDeck().get(i).toString());
                System.out.print(" | ");
            }
            System.out.println();
            System.out.println();
            for (int i=0; i<2; i++){
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                System.out.println();
            }
            System.out.println();

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
            System.out.println();
            System.out.println();
            for (int i=0; i<2; i++){
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
                System.out.println();
            }
            System.out.println();

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
            System.out.println();
            System.out.println();
            TimeUnit.SECONDS.sleep(3);

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
                    System.out.println();
                    
                    for (int i=0; i<2; i++){
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print(".");
                        System.out.println();
                    }

                    System.out.println();
                    continue;
                }

                else {
                    System.out.println();
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("Smart player...");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println();
                    System.out.print("Looks like you are calling it early.");
                    System.out.println();
                    System.out.println();

                    for (int i=0; i<2; i++){
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print(".");
                        System.out.println();
                    }

                    System.out.println();
                    System.out.println();
                    System.out.printf("It looks like you are ending the game with %d dollars in your pot!", pot);
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println();
                    System.out.println();
                    System.out.println("GAME OVER.");
                    System.out.println();
                    System.exit(0);
                }
            }

            else if (playerHandValue > 21){
                for (int i=0; i<3; i++){
                    TimeUnit.SECONDS.sleep(2);
                    System.out.print(".");
                }
                System.out.println();
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
                    System.out.println();
                    
                    for (int i=0; i<2; i++){
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print(".");
                        System.out.println();
                    }

                    System.out.println();
                    continue;
                }

                else { 
                    System.out.println();
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("Smart player...");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println();
                    System.out.print("Looks like you are calling it early.");
                    System.out.println();
                    System.out.println();

                    for (int i=0; i<2; i++){
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print(".");
                        System.out.println();
                    }

                    System.out.println();
                    System.out.println();
                    System.out.printf("It looks like you are ending the game with %d dollars in your pot!", pot);
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println();
                    System.out.println();
                    System.out.println("GAME OVER.");
                    System.out.println();
                    System.exit(0);
                }
            }

            /*else {

            }*/
        

        }

        if (pot > 200){
            System.out.println();
            System.out.println("It looks like you beat the house! We are going to have to end the night early for you.");
            System.out.println();
            TimeUnit.SECONDS.sleep(5);
            System.out.printf("You are ending the game with %d dollars in your pot!", pot);
            TimeUnit.SECONDS.sleep(3);
            System.out.println();
            System.out.println();
            System.out.println("GAME OVER.");
            System.out.println();

        }

        else if (pot == 0){
            System.out.println();
            System.out.println("It looks like you squandered your bankroll! You do not have any more money to gamble with.");
            System.out.println();
            TimeUnit.SECONDS.sleep(5);
            System.out.printf("You are ending the game with %d dollars in your pot!", pot);
            TimeUnit.SECONDS.sleep(3);
            System.out.println();
            System.out.println();
            System.out.println("GAME OVER.");
            System.out.println();

        }

        else {
            ;
        }

    }
    
}
