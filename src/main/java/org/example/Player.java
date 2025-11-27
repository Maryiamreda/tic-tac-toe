package org.example;

import org.example.enumeration.Symbols;

public abstract class Player {
    protected Symbols mySymbol;
    public Player() {}
    protected abstract void setSymbol(Symbols s);
    protected abstract Symbols getSymbol();
    // makeMove doesn't require the board
    public abstract Pair makeMove();
}
