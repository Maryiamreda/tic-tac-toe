//import org.example.*;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mock;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//public class MainTest {
//    Player player1;
//    Player player2;
//    @Mock
//    private Board board;
//
//    @Before
//    public void setUp() {
//        player2 = new Human();
//        player1 = new Bot(1);
//    }
//    @Test
//    public void gameWithTurns_WhenPlayer1Moves_SwitchesToPlayer2() {
//        Player mockPlayer1=mock(Human.class);
//        Player mockPlayer2=mock(Bot.class);
//        Game game = new Game(mockPlayer1, mockPlayer2);
//        game.setTurns(Turns.PLAYER1);
//        game.playTurn(mockPlayer1);
//        assertEquals(Turns.PLAYER2, game.getTurn());
//    }
//}