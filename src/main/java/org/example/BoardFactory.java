package org.example;

public class BoardFactory {
    private static Board board;
    private BoardFactory() {
    }
    static public Board createBoard() {
        if (board == null) {
            board = new Board();
        }
        return board;
    }
}
