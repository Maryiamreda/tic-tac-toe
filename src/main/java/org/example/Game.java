package org.example;

public class Game {
    private Turns turn = Turns.PLAYER1;
    private Player player1;
    private Player player2;
    private Board board;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board();
    }
    public Turns getTurn() {
          return this.turn;
    }
    public String[][] getBoard() {
        return this.board.getBoard();
    }
    public Boolean playTurn() {
        boolean boardState=false;
        switch (this.getTurn()) {
            case PLAYER2 : {
              Pair p=  player2.makeMove(this.getBoard());
              boardState=this.board.updateBoard(p.x,p.y,"o");
            }
        }
        return boardState;
    }
    public Status getGameStatus() {
        return null;
    }
}
