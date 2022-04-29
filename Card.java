import java.util.Scanner;

public class Card {

    private String suit;
    private String name;

    private static final String [] suits = new String [] {"Clubs", "Diamonds", "Hearts", "Spades"};
    private static final String [] names = new String [] {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};


    public Card (String suit, String name){
        this.setSuit(suit);
        this.setName(name);
    }

    public Card clone(){

        Card cardClone;
    
        if (this.getSuit().equals("\u2663")){
            cardClone = new Card("Clubs", this.getName());
        }

        else if (this.getSuit().equals("\u2666")){
            cardClone = new Card("Diamonds", this.getName());   
        }

        else if (this.getSuit().equals("\u2665")){
            cardClone = new Card("Hearts", this.getName()); 
        }

        else {
            cardClone = new Card("Spades", this.getName());
        }

        return cardClone;
    }

    public void setSuit (String suit){
        for (String i : suits){
            if (suit.equalsIgnoreCase(i)){
                if (suit.equalsIgnoreCase("Clubs")){
                    this.suit = "\u2663";
                    return;
                }
                else if (suit.equalsIgnoreCase("Diamonds")){
                    this.suit = "\u2666";
                    return;
                }
                else if (suit.equalsIgnoreCase("Hearts")){
                    this.suit = "\u2665";
                    return;
                }
                else {
                    this.suit = "\u2660";
                    return;
                }
            }
            else {
                continue;
            }
        }
        throw new IllegalArgumentException("Card suit can only be \"Clubs\", \"Diamonds\", \"Hearts\" or \"Spades\"");
    }

    public void setName (String name){
        for (String i : names){
            if (name.equalsIgnoreCase(i)){
                this.name = name;
                return;
            }
            else {
                continue;
            }
        }
        throw new IllegalArgumentException("Card name can only be \"Ace\", \"2\", \"3\", \"4\", \"5\", \"6\", \"7\", \"8\", \"9\", \"10\", \"Jack\", \"Queen\" or \"King\".");
    }

    public String getSuit(){
        return this.suit;
    }

    public String getName(){
        return this.name;
    }

    public static String [] getSuits(){
        String [] suitsCopy = suits.clone();
        return suitsCopy;
    }

    public static String [] getNames(){
        String [] namesCopy = names.clone();
        return namesCopy;
    }

    public String toString(){
        return (this.name + " " + this.suit);
    }   
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card)) {
         return false;
        }
        Card c = (Card) obj;
        return (this.getSuit().equals(c.getSuit())  && this.getName().equals(c.getName()));
    }

    public int getValue(){

        if (this.getName().equals("Jack") || this.getName().equals("Queen") || this.getName().equals("King")){
            return 10;
        }

        else if (this.getName().equals("Ace")){
            Scanner keyboard = new Scanner(System.in);
            String input = "";

            while (!input.equals("1") && !input.equals("11")){
                System.out.println();
                System.out.printf("Please enter 1 or 11 to set the value of the Ace of %s. ", this.getSuit());
                input = keyboard.nextLine();
            }

            int aceValue = Integer.parseInt(input);
            return aceValue;
        }

        else {
            int result = Integer.parseInt(this.getName());
            return result;
        }
    }       
}
