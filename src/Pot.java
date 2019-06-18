public class Pot {

    //pot container attribute
    private double pot;


    //pot constructor
    public Pot(double pot){
        this.pot = pot;

    }



    //getter and setter methods for pot size
    public double getPot() {
        return pot;
    }

    public void setPot(double pot) {
        this.pot = pot;
    }

    // method to rest the pot
    public void reset(){
        pot = 0.00;
    }


    public void recieveBet(double newBet){
        pot += newBet;

    }

    // method to print out the pot size

    public void printPot(){
        System.out.println("The pot currently contains £" + this.getPot());
    }
}
