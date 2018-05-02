import java.util.ArrayList;

public class Game {

    private Deck deck;
    private ArrayList<Player> players;

    public Game(Deck deck) {
        this.deck = deck;
        this.players = new ArrayList<>();
        populateGame();
        dealCards();
    }

    private void populateGame() {
        Player player1 = new Player("Liam");
        Player player2 = new Player("Kelsie");
        this.players.add(player1);
        this.players.add(player2);
    }


    private void dealCards() {
        for (Player player : this.players){
            player.addCardtoHand(deck);
        }
    }

    public int getPlayerCount(){
        return this.players.size();
    }

    public boolean playerHasCard(int playerIndex) {
        if (this.players.get(playerIndex).getNumberOfCardsInHand() >= 1) {
            return true;
        }
        return false;
    }

    public String decideWinner(){
            if (this.players.get(0).valueOfCardInHand() > this.players.get(1).valueOfCardInHand()) {
                return "Player 1 Wins";
            } else if
                (this.players.get(0).valueOfCardInHand() < this.players.get(1).valueOfCardInHand()) {
                    return "Player 2 Wins";
                }
        return "Draw";
    }
}
