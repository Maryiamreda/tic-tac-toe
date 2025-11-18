package org.example;

public class Human extends Player  {
    public Human() {}
    @Override
    public Pair makeMove() {
        System.out.println("human is making a move");
        return new Pair(0,9);
    }
}
