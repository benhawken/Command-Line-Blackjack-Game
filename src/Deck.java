import java.util.ArrayList;
import java.util.Collections;



public class Deck {

    EasyIn2 reader = new EasyIn2();



   protected ArrayList<Card> deck = new ArrayList<>();


    // method to create a full deck of cards

    public void createFullDeck(){
        for(Suit cardSuit : Suit.values()){
            for(Value cardValue : Value.values()){
                this.deck.add(new Card(cardValue, cardSuit));
            }
        }

    }

    // shuffle method
    public void shuffle(){
        Collections.shuffle(deck);
    }

    // method to take cards from the deck
    public void removeCard(int i){
        this.deck.remove(i);
    }

    // method to add a card
    public void addCard(Card newCard){
        this.deck.add(newCard);
    }



    // method to return a card at an index
    public Card getCard(int i ){
        return this.deck.get(i);

    }

    // method to print all the cards in the deck

    public void printDeck(){
        for(int i = 0; i < deck.size(); i++){
            System.out.println(deck.get(i).convrtToString());
        }
    }

    // method to total the value of the players hand









}
