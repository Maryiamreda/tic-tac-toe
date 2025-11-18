package org.example;
public class Game {
    // what are the default access modifiers?
    // only classes within the same package can access it.
    // what should the actual access modifiers be?
    private Board board;
    private Player player1;
    private Player player2;
    private Turns turn = Turns.PLAYER1;

    public Game(
            Player player1,
            Player player2
    ) {
        this.board = new Board();
        this.player1=player1;
        this.player2=player2;
    }
     public void setTurns(Turns turn) {
        this.turn = turn;
    }
    public Turns getTurn() {
//        board.updateBoard(8,9,"h");
        return null;
    }
    public Status getGameStatus() {
        board.isCellAvailable(3,3);
        return null;
    }
    public void play() {}
    // if the board is part of the game then why have setters and getters?
// public void setBoard(String[][] finalBoardState) {
// }
    // if the board is part of the game then why have setters and getters?
    // we need a getter to display our board in ui or other things
    public Board getBoard() {
        return null;
    }
    public void playTurn(Player player) {
    }
}
