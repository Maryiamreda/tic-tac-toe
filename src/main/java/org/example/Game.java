package org.example;

import org.example.enumeration.Status;
import org.example.enumeration.Symbols;
import org.example.enumeration.Turns;

public class Game {
    private Turns turn = Turns.PLAYER1;
    private Player player1;
    private Player player2;
    private Board board;
    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player1.setSymbol(Symbols.X);
        this.player2 = player2;
        this.player2.setSymbol(Symbols.O);
        this.board = BoardFactory.createBoard();

//        if (player1 instanceof Bot bot1)
//            bot1.updateView(getBoardView());
    }
    public Turns getTurn() {
        return this.turn;
    }

    private void switchTurn() {
        this.turn = (this.turn == Turns.PLAYER1) ? Turns.PLAYER2 : Turns.PLAYER1;
    }

    public Symbols[][] getBoard() {
        // return presentation not actual reference
        return this.board.getBoard();
    }
    private Player currentPlayer() {
        return (turn == Turns.PLAYER1) ? player1 : player2;
    }
    public BoardView getBoardView() {
        //we make a deep copy of the board
        return new BoardView(board.getBoard());
    }
    public void playTurn() {
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(this.board.getBoard()[i][j]+" ");
//            }
//            System.out.println();
//        }
        if (getGameStatus() != Status.IN_PROGRESS) return;
        Player currentPlayer = currentPlayer();
        if (currentPlayer instanceof Bot bot) {
            //bot get the new copy of the board
            bot.updateView(getBoardView());
        }
        Pair move = currentPlayer.makeMove();
        boolean success = board.updateBoard(move.x, move.y, currentPlayer.getSymbol());
        if (!success) {
            return;
        }
        switchTurn();
    }
    public Status getGameStatus() {
        Symbols[][] myBoard = this.getBoard();
        Symbols s = null;
        //  rows
        for (int i = 0; i < 3; i++) {
            if (myBoard[i][0] != null && myBoard[i][0] == myBoard[i][1] && myBoard[i][2] == myBoard[i][1])
                s = myBoard[i][0];
        }
        //  columns
        for (int j = 0; j < 3; j++) {
            if (myBoard[0][j] != null && myBoard[0][j] == myBoard[1][j] && myBoard[2][j] == myBoard[1][j])
                s = myBoard[0][j];
        }
        //  diagonals
        if (myBoard[0][0] != null && myBoard[0][0] == myBoard[1][1] && myBoard[2][2] == myBoard[1][1])
            s = myBoard[0][0];
        if (myBoard[0][2] != null && myBoard[0][2] == myBoard[1][1] && myBoard[2][0] == myBoard[1][1])
            s = myBoard[0][2];
        if (s != null) {
            if (s == Symbols.O) return Status.O_WINS;
            if (s == Symbols.X) return Status.X_WINS;
        }
        if (this.board.isFull()) return Status.TIE;
        return Status.IN_PROGRESS;
    }
    public void play() {
        while (getGameStatus() == Status.IN_PROGRESS) {
            playTurn();
        }
        if (getGameStatus() == Status.O_WINS) {
            System.out.println("o wins");
        } else if (getGameStatus() == Status.X_WINS) {
            System.out.println("x wins");
        } else {
            System.out.println("it's a Tie!!");
        }
    }
    public void runNextIteration() {
        if (getTurn() != Turns.PLAYER1 || getGameStatus() != Status.IN_PROGRESS) {
            return;
        }
        playTurn();
        if (getGameStatus() == Status.IN_PROGRESS) {
            playTurn();
        }
    }
    public void reset() {
        board.reset();
        turn = Turns.PLAYER1;
    }
}
