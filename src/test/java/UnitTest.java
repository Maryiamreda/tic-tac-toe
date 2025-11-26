import org.example.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


import static org.example.Symbols.O;
import static org.example.Symbols.X;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
@RunWith(PowerMockRunner.class)
@PrepareForTest(ConcreteBoardFactory.class)
public class UnitTest {
    @Test
    public void getGameStatus_WhenBotAtLevelThree_BotWins() {
        Symbols[][] mockBoard = {
                {null, O, null},
                {X, O, null},
                {X, null, null}
        };
         Board b = new Board(mockBoard);
        PowerMockito.mockStatic(ConcreteBoardFactory.class);
        BDDMockito.given(ConcreteBoardFactory.createBoard()).willReturn(b);
        // player1 is human player
        Player player1 = new Bot(Levels.HARD);
        // player2 is a bot player set to hardest difficulty
        Player player2 = new Human();
        // game has player 1 and player 2
        Game game = new Game(player1, player2);
        // there is a winning move on the board for player2
        game.playTurn();
        // game board should be updated by the winning move
        assertEquals(X, mockBoard[0][0]);
        // game should return that player two won
        assertEquals(Status.X_WINS, game.getGameStatus());
    }
    @Test
    public void getStatus_WhenLastTurn_ReturnTIE() {
        Symbols[][] mockBoard = {
                {O, X, X},
                {X, O, O},
                {null, O, X}};
        Board b = new Board(mockBoard);
        PowerMockito.mockStatic(ConcreteBoardFactory.class);
        BDDMockito.given(ConcreteBoardFactory.createBoard()).willReturn(b);
        // player1 is bot player  set to hardest difficulty
        Player player1 = new Bot(Levels.HARD);
        // player2 is a human player
        Player player2 = new Human();
        // game has player 1 and player 2
        Game game = new Game(player1, player2);
        //player take the only empty cell
        game.playTurn();
        //no empty cell and no winner
        assertEquals(Status.TIE, game.getGameStatus());
    }
    @Test
    public void wrongMove_WhenCellOccupied_GameTurnStayTheSame() {
        Symbols[][] mockBoard = {
                {O, X, X},
                {X, O, O},
                {null, O, X}};
        Board b = new Board(mockBoard);
        PowerMockito.mockStatic(ConcreteBoardFactory.class);
        BDDMockito.given(ConcreteBoardFactory.createBoard()).willReturn(b);
        //mock human player to make illegal move
        Player player1 = mock(Human.class);
        // player1 is bot player  set to hardest difficulty
        Player player2 = new Bot(Levels.HARD);
        //   mock human player's illegal move
        when(player1.makeMove(mockBoard)).thenReturn(new Pair(2, 2));
        // game has player 1 and player 2
        Game game = new Game(player1, player2);
        //start first turn
        game.playTurn();
        //turns stay the same
        assertEquals(Turns.PLAYER1, game.getTurn());
    }
    @Test
    public void getGameStatus_WhenStart_ReturnsINPROGRESS() {
        Board b = new Board();
        PowerMockito.mockStatic(ConcreteBoardFactory.class);
        BDDMockito.given(ConcreteBoardFactory.createBoard()).willReturn(b);
        Player player1 = new Human();
        Player player2 = new Human();
        Game game = new Game(player1, player2);
        assertEquals(Status.IN_PROGRESS, game.getGameStatus());
    }
}
