import java.util.ArrayList;

public class Game {

    private Deck deck;
    private ArrayList<Player> players;

    public Game(Deck deck) {
        this.deck = deck;
        this.players = new ArrayList<>();
    }

    public void addPlayerToGame(Player player) {
        this.players.add(player);
    }

    public void addDealerToTable(Dealer dealer) {
        this.players.add(dealer);
    }


    public void dealCards() {
        for (Player player : this.players) {
            player.addCardToHand(deck);
            player.addCardToHand(deck);
        }
    }

    public void hit(Player player) {
        player.addCardToHand(deck);
    }

    public int getPlayerCount() {
        return this.players.size();
    }

    public boolean playerHasCard(int playerIndex) {
        if (this.players.get(playerIndex).getNumberOfCardsInHand() >= 1) {
            return true;
        }
        return false;
    }

    public void takeTurn(Player player) {
        boolean turnOver = false;
        while (!turnOver) {
            if (player.valueOfCardsInHand() < 16) {
                hit(player);
            } else {
                turnOver = true;
            }
        } // return player.valueOfCardsInHand();
    }

    public void playGame(){
        for (Player player : players) {
            this.takeTurn(player);
        }
    }

    public String decideWinner() {
        if (this.players.get(0).valueOfCardsInHand() > 21 || this.players.get(0).valueOfCardsInHand() < this.players.get(1).valueOfCardsInHand()) {
            return "Dealer Wins";
        } else if (this.players.get(0).valueOfCardsInHand() > this.players.get(1).valueOfCardsInHand() || this.players.get(1).valueOfCardsInHand() > 21) {
                return "Player Wins";
            }
        return "Draw";
    }
}

//    if(player.getHandCopy().contains(Rank.ACE))

//    public Player decideWinner(){
//            if (this.players.get(0).valueOfCardsInHand() > this.players.get(1).valueOfCardsInHand()) {
//                return this.players.get(0);
//            } else if
//                (this.players.get(0).valueOfCardsInHand() < this.players.get(1).valueOfCardsInHand()) {
//                    return this.players.get(1);
//                }
//        return null;
//    }

