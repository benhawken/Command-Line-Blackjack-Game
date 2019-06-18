import java.util.ArrayList;
import java.util.List;

public class Dealer extends Deck {




    // Player specific attributes
    protected double bankroll;
    public int hitOrStick;
    private int dealerHandTotal;
    private int noOfAces;


    // dealer constructor

    public Dealer(double bankroll){
        this.bankroll = bankroll;


    }


    // Player specific methods


    // getter and setter methods for bankroll
    public double getBankroll() {
        return bankroll;
    }

    public void setBankroll(int bankroll) {
        this.bankroll = bankroll;
    }

    //method to deal cards to a hand
    public void deal(Deck deckFrom){

        this.deck.add(deckFrom.getCard(0));
        deckFrom.removeCard(0);

    }


    // Dealer AI

    public void makeChoices(Deck deckFrom){
        while(true) {
            if (dealerHandTotal < 17) {
                this.findDealerTotal();
                this.deal(deckFrom);
                System.out.println("The dealer hits");
                System.out.println(this.getDealerHandTotal());
                this.printDeck();

                if (dealerHandTotal > 21) {
                    System.out.println("The dealer has bust");
                    break;
                }


            }

            else{
                break;
            }
        }

    }

    // print dealer deck (One card face up and the rest face down)
    public void printDealerDeck(){

        System.out.println(deck.get(0).convrtToString());

        for(int i = 1; i < deck.size(); i++){
            System.out.println("[HIDDEN]");
        }
    }

    // find the total of the dealers total
    public void findDealerTotal(){
        dealerHandTotal = 0;
        noOfAces = 0;




        for(int i = 0; i < deck.size(); i++){
            if(deck.get(i).getValue() == Value.ACE){
                noOfAces ++;
            }
        }

        for(int i = 0; i < deck.size(); i++){
            if(deck.get(i).getValue() == Value.ACE){
                dealerHandTotal += 0;
            }

            else {
                deck.get(i).findCardValue();
                dealerHandTotal += deck.get(i).getNumValue();
            }
        }

        for(int i = 0; i < noOfAces; i++){
            if(dealerHandTotal > 10){
                dealerHandTotal += 1;
            }

            else{
                dealerHandTotal += 11;
            }
        }




    }

    // method to check and display the dealers hand (one card face up one card face down)

    public void checkDealerHand(){
        System.out.println("The dealer's cards are:");
        this.printDealerDeck();

        //Find and print the value of the players hand.

        this.findDealerTotal();
    }

    // method to take the cards out of a hand

    public void foldHand(){

           this.deck.removeAll(deck);
    }

    // Getter and Setter methods for the dealers hand total
    public int getDealerHandTotal() {
        return dealerHandTotal;
    }

    public void setDealerHandTotal(int dealerHandTotal) {
        this.dealerHandTotal = dealerHandTotal;
    }





}
