package MyProject;

import java.util.Arrays;
public class Board {
    int nrow,ncol,steps;
     char[][] board;
     String type ;
     int h = 0;
    public Board (int nrow,int ncol,int steps,char[][] board){
        this.nrow = nrow;
        this.ncol = ncol;
        this.steps = steps;
        this.board = board;
        //this.h = h;
    }
    
    public Board(Board board){
        this.nrow = board.nrow;
        this.ncol = board.ncol;
        this.steps = board.steps;
        //this.h = board.h;
        this.board = new char[board.nrow][board.ncol];

        // Deep copy each value in passed array, to current instance of game
        for(int i=0; i<this.nrow; i++)
        {
            System.arraycopy(board.board[i], 0, this.board[i], 0, this.ncol);
        }
    }
     

    public boolean Isequals(Board b){
            return  Arrays.deepEquals(this.board, b.board);
        }
        
        

    public int getNrow() {
        return this.nrow;
    }

    public int getNcol() {
        return this.ncol;
    }

    public int getSteps() {
        return this.steps;
    }

    public char[][] getBoard() {
        return this.board;
    }
        

}
        
    

