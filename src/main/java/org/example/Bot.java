package org.example;
public class Bot extends Player {
    final int level;
    public Bot(int level) {
        this.level=level;
    }
    @Override
    public Pair makeMove() {
        return new Pair(0,9);
    }
    public int chooseRandom(){
        return 0;
    }
    public void calculateBestMove(){}
}