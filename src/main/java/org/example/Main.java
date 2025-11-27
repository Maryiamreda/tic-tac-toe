package org.example;
import org.example.enumeration.Levels;
import org.example.enumeration.Symbols;

import java.util.Scanner;
import static org.example.enumeration.Symbols.O;
import static org.example.enumeration.Symbols.X;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Symbols[][] bibi =  {
                {O, X, X},
                {X, O, O},
                {null, O, X}};
        Player player1=new Human();
        System.out.println("Choose bot level:");
        System.out.println("1 EASY");
        System.out.println("2 MEDIUM");
        System.out.println("3 HARD");
        int choice = sc.nextInt();
        if (choice < 1 || choice > 3) {
            System.out.println("Invalid choice Default is level 3");
            choice = 3;
        }
        Levels level = (choice == 1 ? Levels.EASY :
                (choice == 2 ? Levels.MEDIUM : Levels.HARD));
        Player player2=new Bot(level);
        Game g=new Game(player1,player2);
         g.play();
    }
}