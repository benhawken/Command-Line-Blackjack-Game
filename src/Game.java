public class Game {

    EasyIn2 reader = new EasyIn2();

     // Pot of total money bet in a hand
     Pot mainPot = new Pot(0.00);

     // full main deck of cards
     Deck deck = new Deck();

     // dealer
     Dealer dealer = new Dealer(1000.00);

     //player
     Player player1;

     // game specific attributes

    public double betSize;

    // methods for player winning and dealer winning
    public void dealerWins(){
        dealer.bankroll += betSize;
        mainPot.reset();
        System.out.println("The dealer had: ");
        dealer.printDeck();
        player1.foldHand();
        dealer.foldHand();
        System.out.println("Your bet has gone to the house... next round starting...");
    }

    public void playerWins(){
        player1.bankroll += (betSize * 2);
        dealer.bankroll -= betSize;
        mainPot.reset();
        System.out.println("The dealer had: ");
        dealer.printDeck();
        player1.foldHand();
        dealer.foldHand();
        System.out.println("You won the hand and doubled your bet... next round starting...");
    }





    // divider
    private String divider =
            "------------------------------------------------------------------------------------------";

    public void run(){

        // establishing and creating the player
        System.out.println("Greetings, what is your name?");
         player1 = new Player(100.00, reader.getString());

        System.out.println(divider);

        //creating the deck
        System.out.println("Hello, " + player1.getUsername() + ", welcome to this game of Blackjack.");

        // Game loop continues to play the game as long as the player and bank have funds to
        while(player1.getBankroll() > 0 && dealer.getBankroll() > 0) {

            System.out.println("The Deck is being shuffled...");
            deck.createFullDeck();
            deck.shuffle();


            player1.printBankroll();

            //taking the first bet
            System.out.println("Please choose your desired bet amount:");
            betSize = reader.getDouble();
            player1.placeBet(betSize);
            mainPot.recieveBet(betSize);


            System.out.println(divider);

            player1.printBankroll();
            mainPot.printPot();

            System.out.println(divider);

            // dealing cards

            player1.deal(deck);
            player1.deal(deck);

            dealer.deal(deck);
            dealer.deal(deck);

            // total up hand and print the current score
            player1.checkPlayerHand();

            // ask if the player wants to "Hit or Stick"?

            System.out.println(divider);

            dealer.checkDealerHand();

            System.out.println("Would you like to hit (1) or stick (2) ?");

            player1.hitOrStick(deck);

            // loop to keep asking if the player wants to hit or stick until they stick
            while (player1.hitOrStick == 1) {

                player1.checkPlayerHand();

                if (player1.getHandTotal() <= 21) {
                    System.out.println("Would you like to hit (1) or stick (2) ?");
                    player1.hitOrStick(deck);
                } else {

                    dealerWins();
                    break;

                }
            }

            // once the player sticks the dealer makes choices and then their cards are compared.
            if (player1.hitOrStick == 2) {
                System.out.println("You have stuck on " + player1.getHandTotal());

                dealer.makeChoices(deck);

                if((dealer.getDealerHandTotal() > player1.getHandTotal() ) && (dealer.getDealerHandTotal() < 22)){
                    dealerWins();
                }

                else if ((dealer.getDealerHandTotal() < player1.getHandTotal() ) && (player1.getHandTotal() < 22)){
                    playerWins();
                }
            }







        }

        // announcing the two endings of the game depending on who loses their bankroll first.

        System.out.println(divider);

        if(player1.getBankroll() == 0){
            System.out.println(player1.getUsername() + " has reached the end of their bankroll, the house has won.");

        }

        else if(dealer.getBankroll() == 0){
            System.out.println("Congratulations " + player1.getUsername() + ", you have successfully brought the house down.");
        }
    }




}


// TO DO






