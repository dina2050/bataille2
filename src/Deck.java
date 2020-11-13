import java.util.ArrayList;

public class Deck {
    private String colour;
    private String rank;
    private int size;
    public Deck (String[] colours, String[] ranks, int size){
        ArrayList<Card> myCards = new ArrayList<>(size);
    }

   // public  deal(){
        //???error
    //}
    String[] colours = {"Clubs", "Diamonds", "Hearts", "Spades"};
    String[] ranks = { "Ace", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "Jack", "Queen", "King"};

    int n = colours.length * ranks.length;

    String[] deck = new String[n];

    /*for (int i = 0; i < 13;  i++) {
        for (int j = 0; j <4; j++) {
            deck[colours.length*i + j] = ranks[i] + " of " + colours[j];
        }
    }*/
    public void shuffle(){
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n-i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }

        for (int i = 0; i < 52; i++) {
            System.out.println(deck[i]);
        }


    }

}
