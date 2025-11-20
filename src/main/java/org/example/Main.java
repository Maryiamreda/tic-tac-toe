package org.example;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[][] bibi =  {
                {null, "o", null},
                {"x",  "o", null},
                {"x",  null, null}};
        Board board = new Board(bibi);
        Player player1=new Human();
        Player player2=new Bot(Levels.HARD);
//        Pair b= ((Bot) player2).calculateBestMove(bibi);
//        System.out.println("x : " + b.x);
//        System.out.println("y : "+b.y);
//        player1.makeMove(getBoard());
//        player2.makeMove(getBoard());
        Human human=new Human();
        Bot bot=new Bot(Levels.EASY);
//        human.makeMove(getBoard());
//        bot.makeMove(getBoard());
        int k= ((Bot) player2).chooseRandom(); //type casting !!!!!
        Game g=new Game(player1,player2);
        g.playTurn();
        String[][] n=g.getBoard();
    }
}