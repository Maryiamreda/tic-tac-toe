package org.example;
public class Game {
    Board board;
    Player player1;
    Player player2;
    Turns turn = Turns.PLAYER1;
    public Game(
            Player player1,
            Player player2
    ) {
        this.board = new Board();
    }
    public void setTurns(Turns turn) {
        this.turn = turn;
    }
    public Turns getTurn() {
        return null;
    }
    public Status getGameStatus() { return null; }
    public void play() {}

    public void setBoard(String[][] finalBoardState) {
    }

    public Board getBoard() {
        return null;
    }

    public void playTurn(Player mockPlayer2) {
    }
}
