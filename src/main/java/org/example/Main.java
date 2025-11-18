package org.example;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Player player1=new Human();
        Player player2=new Bot(87598);
        player1.makeMove();
        player2.makeMove();
        Human human=new Human();
        Bot bot=new Bot(1);
        human.makeMove();
        bot.makeMove();
        int k= ((Bot) player2).chooseRandom(); //type casting !!!!!
        Game g=new Game(player1,player2);
        g.getGameStatus();
    }
}