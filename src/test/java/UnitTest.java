import org.example.*;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class UnitTest {
    @Test
    public void test1()  {
        String[][] board = {
                {null, "o", "x"},
                {"x",  "o", null},
                {"x",  null, null}};
        Player mockPlayer1=mock(Human.class);
        Player bot=new Bot(3);
        // player two's turn to make a move
        Board mockBoard=new Board(board);
        Game game = new Game( mockPlayer1, bot);
        when(game.getBoard()).thenReturn(mockBoard);
        game.setTurns(Turns.PLAYER2);
        game.playTurn(bot);
        assertEquals(new Pair(2,1), bot.makeMove());
        assertEquals(Status.O_WINS,game.getGameStatus());
    }
    //op on the actual board
    @Test
    public void test2()  {
        Player mockPlayer1=mock(Human.class);
        Player Bot=new Bot(3);
        Game game = new Game( mockPlayer1, Bot);
        for (int i = 0; i < 1; i++) {
            game.getBoard().updateBoard(0,i,"o");
            game.getBoard().updateBoard(1,i,"x");
        }
        game.setTurns(Turns.PLAYER2);
        game.playTurn(Bot);
        assertEquals(new Pair(0,2), Bot.makeMove());
        assertEquals(Status.O_WINS,game.getGameStatus());
    }
    //use spy
    @Test
    public void test3()  {
        Player mockPlayer1=mock(Human.class);
        Player bot=new Bot(3);
        Game game = new Game( mockPlayer1, bot);
        for (int i = 0; i < 1; i++) {
            game.getBoard().updateBoard(0,i,"o");
        }
        game.setTurns(Turns.PLAYER2);
        game.playTurn(bot);
        assertEquals(new Pair(0,2), bot.makeMove());
        assertEquals(Status.O_WINS,game.getGameStatus());
    }
}
