import org.example.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UnitTest {
    @Test
    public void getGameStatus_WhenBotAtLevelThree_BotWins() {
        String[][] board = {
                {null, "o", null},
                {"x", "o", null},
                {"x", null, null}};
        // player1 is human player
        Player player1 = new Human();
        // player2 is a bot player set to hardest difficulty
        Player player2 = new Bot(Levels.HARD);
        // game has player 1 and player 2
        Game game = spy(new Game(player1, player2));
        //Game game = mock( new Game(player1, player2));
        // player two's turn to make a move
        when(game.getTurn()).thenReturn(Turns.PLAYER2);
        // there is a winning move on the board for player2
        when(game.getBoard()).thenReturn(board);
        game.playTurn();
        // game board should be updated by the winning move
        assertEquals("o", board[1][2]);
        // game should returns that player two won
//        assertEquals(Status.O_WINS, game.getGameStatus());
    }

}
