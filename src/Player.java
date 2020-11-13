import java.util.ArrayList;

public class Player {

        ArrayList<Card> myCards = new ArrayList<>(52);


        public void addCard (Card aCard){
            myCards.add(aCard);
        }

        public Card playCard () {
            myCards.remove(0);
            return null;
        }

        public int cardCount () {
            return myCards.size();
        }

}
