package org.example;
public class Bot extends Player {
    public int level;
    public Bot(int level) {
        this.level=level;
    }
    @Override
    public Pair makeMove() {
        System.out.println("bot is making a move");
        return new Pair(0,9);
    }
    public int chooseRandom(){
        return 0;
    }
    public void calculateBestMove(){}
}