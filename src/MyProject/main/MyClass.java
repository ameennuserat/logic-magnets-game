package MyProject.main;
import MyProject.*;

import java.util.Scanner;

public class MyClass {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
       Board level = Level.level7();


        long c =0;
        long c1 =0;


        while (true) {
            System.out.println("Choose Algorithm:");
            System.out.println("q: Quit");
            System.out.println("1- User Play");
            System.out.println("2- DFS");
            System.out.println("3- BFS");
            System.out.println("4- UCS");
            System.out.println("5- Hill Climbing");
            System.out.println("6- A*");
            char option = new Scanner(System.in).next().charAt(0);
            switch (option) {
                case '1':
                    c = System.currentTimeMillis();
                    new Player(level);
                    c1 = System.currentTimeMillis();
                    break;
                case '2':
                    c = System.currentTimeMillis();
                    new DFS(level);
                    c1 = System.currentTimeMillis();
                    break;
                case '3':
                    c = System.currentTimeMillis();
                    new BFS(level);
                    c1 = System.currentTimeMillis();
                    break;
                case '4':
                    c = System.currentTimeMillis();
                    new UCS(level);
                    c1 = System.currentTimeMillis();
                    break;
                case '5':
                    c = System.currentTimeMillis();
                    new HillClimbing(level);
                    c1 = System.currentTimeMillis();
                    break;
                    case '6':
                    c = System.currentTimeMillis();
                    new Astar(level);
                    c1 = System.currentTimeMillis();
                    break;

                case 'q':
                    return;
            }
            System.out.println("total time = "+ (double)(c1-c)/1000 + "s");
        }


    }
}
