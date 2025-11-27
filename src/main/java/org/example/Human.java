package org.example;
import org.example.enumeration.Symbols;
import java.util.Scanner;

public class Human extends Player implements Runnable  {
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
    public Pair  makeMove() {
//        Scanner sc=new Scanner(System.in);
//        int x=sc.nextInt();
//        int y=sc.nextInt();
//        Pair nextMove=new Pair(x,y);
//        wait for a click event
//      then return coordinates we take something in constructor
        return nextMove;
    }


    @Override
    public void run() {

    }
}
