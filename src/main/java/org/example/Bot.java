package org.example;
import org.example.enumeration.Levels;
import org.example.enumeration.Symbols;
import java.util.Random;
import static org.example.enumeration.Symbols.O;
import static org.example.enumeration.Symbols.X;
public class Bot extends Player {
    final Levels level;
    private BoardView boardView;
    public void updateView(BoardView boardView) {
        this.boardView = boardView;
    }
    public Bot(Levels level) {
        this.level = level;
    }
    @Override
    public void setSymbol(Symbols s) {
        this.mySymbol = s;
    }
    @Override
    protected Symbols getSymbol() {
        return this.mySymbol;
    }
    @Override
    public Pair makeMove() {
        Symbols[][] board = boardView.getCopy();
        if (level == Levels.HARD) return calculateBestMove(board, this.getSymbol());
        if (level == Levels.EASY) return chooseRandom(board);
        if (level == Levels.MEDIUM) {
            int randomBit = (Math.random() < 0.5) ? 0 : 1;
            if (randomBit == 0) return chooseRandom(board);
            else return calculateBestMove(board, this.getSymbol());
        }
        return null;
    }
    public Pair chooseRandom(Symbols[][] board) {
        boolean valid = false;
        int randomRow = -1;
        int randomCol = -1;
        while (!valid) {
            Random random = new Random();
            randomRow = random.nextInt(3);
            randomCol = random.nextInt(3);
            valid = board[randomRow][randomCol] == null;
        }
        return new Pair(randomRow, randomCol);
    }
    public Pair calculateBestMove(Symbols[][] board, Symbols s) {
        Pair winningMove = isWinning(board, s);
        if (winningMove != null) return winningMove;
        Symbols opponentSymbol = s == O ? X : O;
        Pair opponentWin = isWinning(board, opponentSymbol);
        if (opponentWin != null) return opponentWin;
        if (board[1][1] == null) {
            return new Pair(1, 1);
        }
        //check [0,0] , [0,2], [2,0],[2,2]
        for (int i = 0; i <= 2; i += 2) {
            for (int j = 0; j <= 2; j += 2) {
                if (board[i][j] == null) return new Pair(i, j);
            }
        }
        //check [0,1],[1,0],[2,1],[1,2]
        for (int i = 0; i <= 2; i += 2) {
            if (board[i][1] == null) return new Pair(i, 1);
            if (board[1][i] == null) return new Pair(1, i);
        }
//
        return new Pair(0, 0);
    }
    public Pair isWinning(Symbols[][] board, Symbols s) {
        //rows
        for (int i = 0; i < 3; i++) {
            int counter = 0;
            Pair myMove = null;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == null) {
                    myMove = new Pair(i, j);
                }
                else if (board[i][j] == s) {
                    counter++;
                }
            }
            if (counter == 2 && myMove != null) {
                return myMove;
            }
        }
        //columns
        for (int j = 0; j < 3; j++) {
            int counter = 0;
            Pair myMove = null;
            for (int i = 0; i < 3; i++) {
                if (board[i][j] == null) {
                    myMove = new Pair(i, j);
                }
                else if (board[i][j] == s) {
                    counter++;
                }
            }
            if (counter == 2 && myMove != null) {
                return myMove;
            }
        }
        int counter = 0;
        Pair myMove = null;
        //diagonal [0,0] , [1,1], [2,2]
        for (int i = 0; i < 3; i++) {
            if (board[i][i] == null) {
                myMove = new Pair(i, i);
            }
            else if (board[i][i] == s) {
                counter++;
            }
            if (counter == 2 && myMove != null) {
                return myMove;
            }
        }
        //diagonal [0,2] , [1,1] , [2,0]
        counter = 0;
        myMove = null;
        for (int i = 0; i < 3; i++) {
            int j = 2 - i;
            if (board[i][j] == null) myMove = new Pair(i, j);
            else if (board[i][j] == s) counter++;
        }
        if (counter == 2 && myMove != null) {
            return myMove;
        }
        return null;
    }
}