package org.example;

public class Board {
    private String[][] board = new String[3][3];
    public Board() {}
    public Board( String[][] board ) {
        this.board=board;
    }
    public boolean isCellAvailable(int x, int y) {
        return false;
    }
    public boolean updateBoard(int x, int y, String s) throws RuntimeException{
        return true;
    }

}

