public class Player extends Dealer {

    // player specific attributes
    private String Username;
    private int handTotal;


    // Player specific constructor, inherited from Dealer class

    public Player(double bankroll, String username){

        super(bankroll);

        this.Username = username;
    }


    // method to place a bet

    public void placeBet(double newBet){
        this.bankroll -= newBet;

    }


    //method to add a card to deck in a 'hit' situation
    public void hit(Deck deckFrom){
        if(getHandTotal() <= 21){
            this.deal(deckFrom);
        }
    }

    //method to hit or stick based on users choice

    public void hitOrStick(Deck deckFrom) {
        hitOrStick = reader.getInt();

        switch (hitOrStick) {

            case 1:
                this.hit(deckFrom);
                break;

            case 2:
                break;

        }

    }



    // getter and setter for username

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    //method to print the bankroll
     public void printBankroll(){
        System.out.println(this.getUsername() + " has £" + this.getBankroll() + " available");
     }


     // method to find the total of the player deck
     public void findTotal(){
        handTotal = 0;

        for(int i = 0; i < this.deck.size(); i++ ){
            if(deck.get(i).getValue() == Value.ACE){
                System.out.println("Would you like the Ace to be worth 1 or 11?");
                deck.get(i).findAceValue(reader.getInt());
            }
            else{
                deck.get(i).findCardValue();
            }

        }

        for(int i = 0; i < this.deck.size(); i++){

            handTotal += deck.get(i).getNumValue();
        }

        if(handTotal > 21){
            System.out.println("Your hand is bust");

        }

        else{
            System.out.println("The total score for this hand of cards is " + handTotal);
        }


    }


    // method to consolidate the players hand value as it grows and stop it going over 21

    public void checkPlayerHand(){

        System.out.println("Your cards are:");
        this.printDeck();

        //Find and print the value of the players hand.

        this.findTotal();

    }

    // getter and setter for deck total
    public int getHandTotal() {
        return handTotal;
    }

    public void setHandTotal(int handTotal) {
        this.handTotal = handTotal;
    }


}
