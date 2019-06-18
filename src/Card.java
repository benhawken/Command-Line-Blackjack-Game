
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Card {

   // the numerical value the card holds in the game
    private Value value;

    private int numValue;


    // the suit of the card
    private Suit suit;



   // main constructor for the card
    public Card(Value value, Suit suit){

        this.suit = suit;
        this.value = value;

    }


    public String convrtToString(){

        return this.suit.toString() + "_" + this.value.toString();
    }

    public Value getValue(){
        return this.value;
    }

    // method to find the integer value of a card not including an ace

    public void findCardValue(){

        if(value != Value.ACE){
        switch(value) {

            case TWO:
                numValue = 2;
                break;

            case THREE:
                numValue = 3;
                break;

            case FOUR:
                numValue = 4;
                break;

            case FIVE:
                numValue = 5;
                break;

            case SIX:
                numValue = 6;
                break;

            case SEVEN:
                numValue = 7;
                break;

            case EIGHT:
                numValue = 8;
                break;

            case NINE:
                numValue = 9;
                break;

            case TEN:
                numValue = 10;
                break;

            case JACK:
                numValue = 10;
                break;

            case QUEEN:
                numValue = 10;
                break;

            case KING:
                numValue = 10;
                break;
        }


        }

    }


    public void findAceValue(int i){

        if(value == Value.ACE){

            switch(i){

                case 1 :
                    numValue = 1;
                    break;
                case 11 :
                    numValue = 11;
                    break;
            }
        }
    }



    // getter and setter for the number value
    public int getNumValue() {
        return numValue;
    }

    public void setNumValue(int numValue) {
        this.numValue = numValue;
    }


}
