package org.example;

public abstract class Player {
    protected Symbols mySymbol;
    public Player() {}
    protected abstract void setSymbol(Symbols s);
    protected abstract Symbols getSymbol();
    public abstract Pair makeMove(Symbols[][] board);
}
