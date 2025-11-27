package org.example;
import org.example.enumeration.Symbols;
public class BoardView {
    private final Symbols[][] myBoardView;
    public BoardView(Symbols[][] board) {
        myBoardView = new Symbols[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                myBoardView[i][j] = board[i][j];
            }
        }
    }
    public Symbols[][] getCopy() {
        return myBoardView;
    }
}
