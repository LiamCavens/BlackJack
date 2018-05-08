import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class GameTest {

    Game game;
    Deck deck;
    Player player;
    Dealer dealer;


    @Before
    public void before(){
        player = new Player("Liam");
        dealer = new Dealer("Chris");
        deck = new Deck();
        game = new Game(deck);

        game.addPlayerToGame(player);
        game.addDealerToTable(dealer);

        game.dealCards();

    }

    @Test
    public void gameStartsWith2Players(){
        assertEquals(2, game.getPlayerCount());
    }

    @Test
    public void playersGivenCard(){
        assertEquals(true, game.playerHasCard(0));
    }

    @Test
    public void gameHasOutcome() {
        game.playGame();
        System.out.println(player.valueOfCardsInHand());
        System.out.println(dealer.valueOfCardsInHand());
        System.out.println(game.decideWinner());
        assertNotNull(game.decideWinner());
    }

    //    @Test //0.05% Chance of Draw/Fail
//    public void gameHasWinner(){
//        assertTrue(game.getPlayers().contains(game.decideWinner()));
//    }
}
