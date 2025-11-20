package org.example;

public class Board {
    private String[][] board ;
    public Board() {
        this.board=new String[3][3];
    }

    public String[][] getBoard() {
        return board;
    }

    public Board(String[][] b) {
        this.board=b;
    }
    public boolean isCellAvailable(int x, int y) {
        return this.board[x][y]==null;
    }
    protected boolean updateBoard(int x, int y, String s){
        if(isCellAvailable(x,y)){
            this.board[x][y]=s;
            return true;
        }
        return false;
    }
}

