package org.example;

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
        this.board = ConcreteBoardFactory.createBoard();
    }

    public Turns getTurn() {
        return this.turn;
    }

    public void setTurn() {
        this.turn = this.getTurn() == Turns.PLAYER1 ? Turns.PLAYER2 : Turns.PLAYER1;
    }

    public Symbols[][] getBoard() {
        // return presentation not actual reference
        return this.board.getBoard();
    }

    //resource-pattern/strategy-pattern/simple state
    public void playTurn(){
        System.out.println("board state");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (getBoard()[i][j] == null) System.out.print(".");
                else System.out.print(getBoard()[i][j] + " ");
            }
            System.out.println();
        }
        Player currentPlayer = this.getTurn() == Turns.PLAYER1 ? player1 : player2;
        Symbols playerSymbol = currentPlayer.getSymbol();
        Pair p = currentPlayer.makeMove(this.getBoard());
        boolean boardState = this.board.updateBoard(p.x, p.y, playerSymbol);
        if (!boardState) System.out.println("please make valid move");
        else this.setTurn();

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

    public void runGameLoop() {
        if (getTurn() != Turns.PLAYER1 || getGameStatus() != Status.IN_PROGRESS) {
            return;
        }
        playTurn();
        if (getGameStatus() == Status.IN_PROGRESS) {
            playTurn();
        }
    }

    public void reset() {
        Symbols[][] board = this.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = null;
            }
        }
        turn = Turns.PLAYER1;
    }
}
