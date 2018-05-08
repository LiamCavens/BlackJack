import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Card> getHandCopy() {
        ArrayList<Card> handCopy = new ArrayList<>(hand);
        return handCopy;
    }

    public int getNumberOfCardsInHand(){
        return this.hand.size();
    }

    public void addCardToHand(Deck deck){
        Card card = deck.removeCard();
        this.hand.add(card);
    }

    public int valueOfCardInHand(){
        return this.hand.get(0).getValueFromEnum();
    }

    public int valueOfCardsInHand() {
        int handTotal = 0;
        for (Card card : hand){
             handTotal += card.getValueFromEnum();
        }
        return handTotal;
    }
}
