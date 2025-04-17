
package MyProject;

import java.util.Scanner;
public class Initialization {
    private char[][] board;
    private  int rows,columns,steps;
    Scanner input;

    public  Board initial(int rows, int columns, int steps) {
        this.rows = rows;
        this.columns = columns;
        this.steps = steps;
        this.board = new char[rows][columns];
        for(int i=0;i<rows;i++)
        for(int j=0;j<columns;j++)
               board[i][j] = '-';
        input = new Scanner(System.in);
        this.addToboard();
        return new Board(this.rows,this.columns,this.steps,this.board);
            }
    
    public  void addToboard(){
    System.out.println("Enter A to add Attractive stone \n"
                        + "Enter R to add Reliable stone \n"
                            + "Enter @ to add Mineral stone\n"
                                +"Enter X to add obstacle\n"
                                    +"Enter O to add final stat\n"
                                        +"Enter E to stop");
            char a;
            int r,c;
            while(true){
                a = input.next().charAt(0);
                switch(a){
                    case 'A':
                        System.out.println("enter position by line and column");
                        r = input.nextInt();
                        c = input.nextInt();
                        this.InitialStones(r, c,'A');
                        System.out.println("Added");
                        break;
                    case 'R':   
                        System.out.println("enter position by line and column");
                        r = input.nextInt();
                        c = input.nextInt();
                        this.InitialStones(r, c,'R');
                        System.out.println("Added");
                        break;
                    case '@':
                        System.out.println("enter position by line and column");
                        r = input.nextInt();
                        c = input.nextInt();
                        this.InitialStones(r, c,'@');
                        System.out.println("Added");
                        break;
                    case 'O':
                        System.out.println("enter position by line and column");
                        r = input.nextInt();
                        c = input.nextInt();
                        this.InitialStones(r, c,'O');
                        System.out.println("Added");
                        break;
                    case 'X':
                        System.out.println("enter position by line and column");
                        r = input.nextInt();
                        c = input.nextInt();
                        this.InitialStones(r, c,'X');
                        System.out.println("Added");
                        break;                        
                    case 'E': return;    

                    default:
                        break;
                        
                }
            }
        }
    
    
       public void InitialStones(int row,int col, char type){
        this.board[row][col] = type;
    }
    
//        public void InitialMineralStones(int row,int col){
//        this.board[row][col] = '@';
//    }
//
//        public void InitialObstacles(int row,int col){
//        this.board[row][col] = 'X';
//    }
//
//        public void FinalState(int row,int col){
//        this.board[row][col] = 'O';
//    }

    
    
}
