package org.example;

public class Board {
    private Symbols[][] board ;
    public Board() {
        this.board=new Symbols[3][3];
    }
    public Symbols[][] getBoard() {
        return board;
    }
    public Board( Symbols[][]  b) {
        this.board=b;
    }
    public boolean isCellAvailable(int x, int y) {
        return this.board[x][y]==null;
    }
    public boolean isFull(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j]==null){
                    return false;
                }
            }
        }
        return true;
    }
    protected boolean updateBoard(int x, int y, Symbols s){
        if(isCellAvailable(x,y)){
            this.board[x][y]=s;
            return true;
        }
        return false;
    }
}

