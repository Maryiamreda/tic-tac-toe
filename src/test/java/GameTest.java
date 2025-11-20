//import org.example.*;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;
//
//import org.powermock.api.mockito.PowerMockito;
//public class GameTest {
//    @Test
//    public void updateBoardCell_WhenCellOccupied_ReturnFalse() {
//      Board board=mock(Board.class);
//      when(board.isCellAvailable(2,0)).thenReturn(false);
//      assertFalse(board.updateBoard(2,0,"x"));
//    }
//    @Test
//    public void wrongMove_WhenCellOccupied_GameTurnStayTheSame() {
//        Player mockPlayer1=mock(Human.class);
//        Player mockPlayer2=mock(Bot.class);
//        Game game = new Game(mockPlayer1, mockPlayer2);
//        game.getBoard().updateBoard(2, 0, "x");
//        when(mockPlayer1.makeMove()).thenReturn(new Pair(2,0));
//        game.playTurn(mockPlayer1);
//        assertEquals(Turns.PLAYER1,game.getTurn());
//    }
//
//    @Test
//    public void getGameStatus_WhenBotAtLevelThree_BotWins()  {
//        String[][] mockBoard = {
//                {null, "o", "x"},
//                {"x",  "o", null},
//                {"x",  null, null}};
//        PowerMockito.whenNew(Board.class).withNoArguments().thenReturn(mockBoard);
//        Player mockPlayer1=mock(Human.class);
//
//            Player mockPlayer2=new Bot(3);
//            Game game = new Game( mockPlayer1, mockPlayer2);
//            Board myboard = game.getBoard();
//
//
//            game.setTurns(Turns.PLAYER2);
//            game.playTurn(mockPlayer2);
//            assertEquals(new Pair(2,1), mockPlayer2.makeMove());
//            assertEquals(Status.O_WINS,game.getGameStatus());
//    }
//
//    @Test
//    public void getGameStatus_WhenStart_ReturnsINPROGRESS() {
//        Player mockPlayer1=mock(Human.class);
//        Player mockPlayer2=mock(Bot.class);
//        Game game = new Game(mockPlayer1, mockPlayer2);
//        assertEquals(Status.IN_PROGRESS, game.getGameStatus());
//    }
//    @Test
//    public void getGameStatus_WhenHumanPlay_HumanWins() {
//        String[][] mockBoard = {
//                {"x", "o", null},
//                {"x", "o", null},
//                {null, null, null}};
//        Player mockPlayer1=mock(Human.class);
//        Player mockPlayer2=mock(Bot.class);
//        Game game = new Game(mockPlayer1, mockPlayer2);
//        game.setBoard(mockBoard);
//        when(mockPlayer1.makeMove()).thenReturn(new Pair(2,0));
//        game.playTurn(mockPlayer1);
//        assertEquals(Status.X_WINS, game.getGameStatus());
//    }
//    @Test
//    public void getStatus_WhenLastTurn_ReturnTIE() {
//        String[][] mockBoard = {
//                {"o", "x", "x"},
//                {"x", "o", "o"},
//                {null, "x", "x"}};
//        Player mockPlayer1=mock(Human.class);
//        Player mockPlayer2=mock(Bot.class);
//        Game game = new Game(mockPlayer1, mockPlayer2);
//        game.setBoard(mockBoard);
//        game.setTurns(Turns.PLAYER1);
//        game.play();
//        assertEquals(Status.TIE, game.getGameStatus());
//    }
//}
//
//
