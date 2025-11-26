package org.example;

import java.util.Scanner;

public class Human extends Player  {
    private Pair nextMove = null;

    public Human() {}

    @Override
    public void setSymbol(Symbols s) {
        this.mySymbol=s;
    }

    @Override
    protected Symbols getSymbol() {
        return this.mySymbol;
    }
    public void setMove(int x, int y) {
        this.nextMove = new Pair(x, y);
    }
    @Override
    public Pair makeMove(Symbols[][] board) {
        return nextMove;
    }
}
