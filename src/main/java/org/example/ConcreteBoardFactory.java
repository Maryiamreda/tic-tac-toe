package org.example;

public class ConcreteBoardFactory {
    private static Board board;
    private ConcreteBoardFactory() {
    }
    static public Board createBoard() {
        if (board == null) {
            board = new Board();
        }
        return board;
    }
}
