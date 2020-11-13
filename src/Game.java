
import java.util.ArrayList;
public class Game {


        Player p1, p2;
        Card p1Card, p2Card;
        Deck theDeck;
        ArrayList<Card> p1Pile, p2Pile;
        boolean justWarred;

    public Game() {
            justWarred = false;
            p1Pile = new ArrayList<Card>();
            p2Pile = new ArrayList<Card>();
            p1 = new Player();
            p2 = new Player();
            String[] colours = {"Clubs", "Diamonds", "Hearts", "Spades"};
            String[] ranks = {null, "Ace", "2", "3", "4", "5", "6",
                    "7", "8", "9", "10", "Jack", "Queen", "King"};
            int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
            theDeck = new Deck(ranks, colours, 52);
            theDeck.shuffle();
            for (int i = 0; i < 26; i++) {
                //p1.addCard(theDeck.deal());
                //p2.addCard(theDeck.deal());
            }
            beginGame();
        }

        private void beginGame () {
            String winner = "";
            while (true) {
                pause(100);
                if (!justWarred) {
                    if (p1.cardCount() > 0) {
                        p1Pile.add(p1.playCard());
                    } else {
                        winner = "p2";
                        break;
                    }
                    if (p2.cardCount() > 0) {
                        p1Pile.add(p2.playCard());
                    } else {
                        winner = "p1";
                        break;
                    }
                }
                justWarred = false;
                p1Card = p1Pile.get(p1Pile.size() - 1);
                p2Card = p2Pile.get(p2Pile.size() - 1);

                if (p1Card.compareTo(p2Card) > 0) {
                    winner = "p1";
                } else if (p1Card.compareTo(p2Card) < 0) {
                    winner = "p2";
                } else {
                    winner = "none";
                }

                if (winner.equals("p1")) {
                    while (p1Pile.size() > 0) {
                        p1.addCard(p1Pile.remove(0));
                    }
                    while (p2Pile.size() > 0) {
                        p1.addCard(p2Pile.remove(0));
                    }
                }

                if (winner.equals("p2")) {
                    while (p1Pile.size() > 0) {
                        p1.addCard(p1Pile.remove(0));
                    }
                    while (p2Pile.size() > 0) {
                        p1.addCard(p2Pile.remove(0));
                    }
                }

                if (winner.equals("none")) {
                    justWarred = true;
                    int count = 0;

                    while (p1.cardCount() > 0 && count < 4) {
                        p1Pile.add(p1.playCard());
                        count++;
                    }
                    count = 0;
                    while (p2.cardCount() > 0 && count < 4) {
                        p2Pile.add(p2.playCard());
                        count++;
                    }
                }
            }
            System.out.println("The winner is " + winner + ".");
            System.out.println("P1 has " + p1.cardCount() +
                    " cards. P2 has " + p2.cardCount() + " cards");
        }

        public void pause ( int milliseconds){
            try {
                Thread.sleep(milliseconds);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.println("\u000C");
        }

   /* public void showCards(){
    for(int i=0; i<p1.cardCount();i++){
        System.out.println("[]");
    }
    System.out.println();
        for(int i=0; i<p2.cardCount();i++){
            System.out.println("[]");
        }
        System.out.println();
        System.out.println("Player 1 stack =" +p1.cardCount()+" "+"Player 2 stack");
    }*/
    }
