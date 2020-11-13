public class Card {
    private String colour;
    private String rank;
    private int value;
    public Card(String colour, String rank, int value ){
        this.colour = colour;
        this.rank = rank;
        this.value = value;
    }

    String[] colours = {"Clubs", "Diamonds", "Hearts", "Spades"};
    String[] values = {null, "Ace", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "Jack", "Queen", "King"};

    public String colour(){
        return colour;
    }

    public String rank(){
        return rank;
    }

    public int value(){
        return value;
    }


    public int compareTo(Card otherCard){
        if (this.value() > otherCard.value()) {
            return 1;
        }
        else if (this.value() == otherCard.value()) {
            return 0;
        }
        else {
            return -1;
        }

    }


}
