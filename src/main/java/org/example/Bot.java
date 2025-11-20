package org.example;
public class Bot extends Player {
    final Levels level;
    public Bot(Levels level) {
        this.level=level;
    }
    @Override
    public Pair makeMove(String[][] board) {
       if (level==Levels.HARD){
          return  calculateBestMove(board);
       }
        return null;
    }
    public int chooseRandom(){
        return 0;
    }
    public Pair calculateBestMove(String[][] board) {
        //write the worst code you ever think off
        //we loop through every column and row , without the intersects ----
        //if we start of with x we break , if we have null we store this as our position --- for now !!!
        //at the end we check our previous count if its more we toggele it
        int counter = 0;
        Pair mymove=new Pair(-1,-1) ;
        //rows
        for (int i = 0; i < 3 && counter<2; i++) {
            Pair pair ;
            int x=-1; int y= -1;
            int currentCounter=0;
            for (int j = 0; j < 3; j++) {
                if(board[i][j]==null) {
                    x=i;y=j;
                }
                else if(!board[i][j].equals("o")) {
                    currentCounter=0;
                    break;
                }
                else if (board[i][j].equals("o")) {
                    currentCounter++;
                }
            }
            if(currentCounter>counter){
                counter=currentCounter;
                mymove.x=x;
                mymove.y=y;
            }
        }
        //columns
        for (int i = 0; i < 3 && counter <2; i++) {
            Pair pair ;
            int x=-1; int y= -1;
            int currentCounter=0;
            for (int j = 0; j < 3; j++) {
                if(board[j][i]==null) {
                    x=j;y=i;
                }
                else if(!board[j][i].equals("o")) {
                    currentCounter=0;
                    break;
                }
                else if (board[j][i].equals("o")) {
                    currentCounter++;
                }
            }
            if(currentCounter>counter){
                counter=currentCounter;
                mymove.x=x;
                mymove.y=y;
            }
        }
        //diagonal top-left to bottom-right
        if (counter<2){
            int x=-1; int y= -1;
            int currentCounter=0;
            for (int i = 0; i < 3; i++) {
                if(board[i][i]==null) {
                    x=i;y=i;
                }
                else if(!board[i][i].equals("o")) {
                    currentCounter=0;
                    break;
                }
                else if (board[i][i].equals("o")) {
                    currentCounter++;
                }
            }
            if(currentCounter>counter){
                counter=currentCounter;
                mymove.x=x;
                mymove.y=y;
            }
        }
        //diagonal top-right to bottom-left
        if (counter<2){
            int x=-1; int y= -1;
            int currentCounter=0;
            for (int i = 0; i < 3; i++) {
                int j = 2-i;
                if(board[i][j]==null) {
                    x=i;y=j;
                }
                else if(!board[i][j].equals("o")) {
                    currentCounter=0;
                    break;
                }
                else if (board[i][j].equals("o")) {
                    currentCounter++;
                }
            }
            if(currentCounter>counter){
                counter=currentCounter;
                mymove.x=x;
                mymove.y=y;
            }
        }
        return mymove;
    }
}