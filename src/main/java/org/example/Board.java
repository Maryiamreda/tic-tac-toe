package org.example;

public class Board {
    private String[][] board ;
    public Board() {
        this.board=new String[3][3];
    }
    public Board(String[][] b) {
        this.board=b;
    }
    public boolean isCellAvailable(int x, int y) {
        System.out.println("hkjdskjsakjkjsjsk");
        return false;
    }
    public boolean updateBoard(int x, int y, String s) throws RuntimeException{
        return true;
    }
}

