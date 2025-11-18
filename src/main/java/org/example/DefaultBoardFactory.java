package org.example;

public class DefaultBoardFactory  implements BoardFactory {
    @Override
    public Board createBoard() {
        return new Board();
    }
}