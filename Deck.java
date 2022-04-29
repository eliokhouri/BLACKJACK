import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class Deck {

    private ArrayList <Card> deck;

    public Deck () {
        this.deck = new ArrayList<Card>();

        for (String i : Card.getSuits()) {
            for (String j : Card.getNames()) {
                deck.add(new Card(i, j));
            }
        }
    }

    public ArrayList <Card> clone(){
        ArrayList <Card> deckClone = new ArrayList<Card>();
        for (Card c : this.deck){
            deckClone.add(c.clone());
        }
        return deckClone;
    }

    public ArrayList <Card> getDeck(){
        if (deck == null) {
            throw new NullPointerException();
        }
        else {
            return this.deck;
        }
    }

    public void setDeck(Deck deck){
        if (deck == null){
            throw new IllegalArgumentException("You cannot pass a null value as this argmuent!");
        }
        else {
            this.deck = deck.getDeck();
        }
    }

    public void setDeck(){
        ArrayList <Card> emptyDeck = new ArrayList<Card>();
        this.deck = emptyDeck;
    }

    public void clearDeck(){
        this.deck.clear();
    }

    public String toString(){
        return (this.getDeck().toString());
    }

    public int size(){
        return this.deck.size();
    }

    public void shuffle(){
        Collections.shuffle(this.getDeck());
    }

    public void add(Card card){
        if (card == null){
            throw new IllegalArgumentException("You cannot pass a null value as this argmuent!");
        }
        else {
            if ((!this.getDeck().contains(card)) && (this.size() < 52)){
                this.getDeck().add(card);
            }
            else {
                throw new IllegalArgumentException("Duplicate Card!");
            }
        }
    }

    public Card remove(){
        return this.getDeck().remove(0);
    }

    public Card remove(Card card){

        if (this.getDeck().remove(card)){
            return card;
        }
        else {
            throw new NoSuchElementException();
        }
    }

    public boolean containsCard (Card card){
        if (this.getDeck().contains(card)){
            return true;
        }
        else {
            return false;
        }
    }

    public void sort(){
        ArrayList <Card> sortedList = new ArrayList<Card>();
        for (String i : Card.getSuits()) {
            for (String j : Card.getNames()) {
                Card tempCard = new Card(i, j);
                if (this.containsCard(tempCard)){
                    sortedList.add(tempCard);
                }
            }
        }
        this.deck = sortedList;
    }

}
