import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test

    public void testRoundPlayer1Wins() {
        Game game = new Game();
        Player player1 = new Player(1, "Player 1", 10);
        Player player2 = new Player(2, "Player 2", 8);
        game.register(player1);
        game.register(player2);

        int result = game.round("Player 1", "Player 2");

        assertEquals(1, result);
    }

    @Test
    public void testRoundPlayer2Wins() {
        Game game = new Game();
        Player player1 = new Player(1, "Player 1", 8);
        Player player2 = new Player(2, "Player 2", 10);
        game.register(player1);
        game.register(player2);

        int result = game.round("Player 1", "Player 2");

        assertEquals(2, result);
    }

    @Test
    public void testRoundDraw() {
        Game game = new Game();
        Player player1 = new Player(1, "Player 1", 10);
        Player player2 = new Player(2, "Player 2", 10);
        game.register(player1);
        game.register(player2);

        int result = game.round("Player 1", "Player 2");

        assertEquals(0, result);
    }

    @Test
    public void testPlayerGetId() {
        Player player = new Player(1, "Player 1", 10);
        int id = player.getId();

        assertEquals(1, id);
    }

    @Test
    public void testRoundPlayer2NotRegisteredException() {
        Game game = new Game();
        Player player1 = new Player(1, "Player 1", 10);
        game.register(player1);

        try {
            game.round("Player 1", "Player 2");
            fail("Expected NotRegisteredException to be thrown");
        } catch (NotRegisteredException e) {
            assertEquals("Both players must be registered", e.getMessage());
        }
    }

    @Test
    public void testRoundPlayer1NotRegisteredException() {
        Game game = new Game();
        Player player2 = new Player(1, "Player 1", 10);
        game.register(player2);

        try {
            game.round("Player 1", "Player 2");
            fail("Expected NotRegisteredException to be thrown");
        } catch (NotRegisteredException e) {
            assertEquals("Both players must be registered", e.getMessage());
        }
    }

    @Test
    public void testRoundPlayersNotRegisteredException() {
        Game game = new Game();

        try {
            game.round("Player 1", "Player 2");
            fail("Expected NotRegisteredException to be thrown");
        } catch (NotRegisteredException e) {
            assertEquals("Both players must be registered", e.getMessage());
        }
    }

}