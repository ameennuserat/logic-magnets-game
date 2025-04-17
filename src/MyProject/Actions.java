
package MyProject;

import java.util.ArrayList;


public class Actions {

    public static Board move(int r, int c, int i, int j, Board board) {
        Board b = new Board(board);
        if (CheckAction.checkmove(i, j, b)) {
            if (b.board[r][c] == 'N') {
                b.board[i][j] = 'A';
                b.board[r][c] = 'O';
            }
           else if (b.board[r][c] == 'W') {
                b.board[i][j] = 'R';
                b.board[r][c] = 'O';
            }
            else {
                b.board[i][j] = board.board[r][c];
                b.board[r][c] = '-';

            }
            if (b.board[i][j]=='A') EffectAttractive(i,j,b);
            else EffectReliable(i,j,b);

        }
    return b;
    }


    public static Board EffectAttractive(int r, int c, Board board) {
        //Board newboard = new Board(board);
        EffectAttractiveTop(r, c, board);
        EffectAttractiveDown(r, c, board);
        EffectAttractiveRight(r, c, board);
        EffectAttractiveLeft(r, c, board);
        return board;
    }

    public static Board EffectReliable(int r, int c, Board board) {
        //Board newboard = new Board(board);
        EffectReliableRight(r, c, board);
        EffectReliableLeft(r, c, board);
        EffectReliableTop(r, c, board);
        EffectReliableDown(r, c, board);
        return board;
    }


    public static Board EffectAttractiveRight(int r, int c, Board board) {
        if (c == board.ncol - 1 || c == board.ncol - 2) return board;
        else {
            for (int i = c+1; i < board.ncol; i++) {
                if (CheckAction.CeckType(r,i,board)) {
                    int index = FindCascadeRight(r, i, board);
                    if (CheckAction.CeckNextCascade(r,index,board)) break;
                    else {
                        for (int j = index; j > i; j--) {
                            if(board.board[r][j-1]=='M'){
                                board.board[r][j] = '@';
                                board.board[r][j - 1] = 'O';
                            }
                            else if(board.board[r][j-1]=='N'){
                                board.board[r][j] = 'A';
                                board.board[r][j - 1] = 'O';
                            }
                            else if(board.board[r][j-1]=='W'){
                                board.board[r][j] = 'R';
                                board.board[r][j - 1] = 'O';
                            }
                            else {
                                board.board[r][j] = board.board[r][j - 1];
                                board.board[r][j - 1] = '-';
                            }
                                board.h++;
                        }
                        break;
                    }
                }
            }
        }
        return board;
    }

    public static Board EffectAttractiveLeft(int r, int c, Board board) {
        if (c == 0 || c == 1) return board;
        else {
            for (int i = c-1; i > 0; i--) {
                if (CheckAction.CeckType(r,i,board)) {
                    int index = FindCascadeLeft(r, i, board);
                    if (CheckAction.CeckNextCascade(r,index,board)) break;
                    else {
                        for (int j = index; j < i; j++) {
                            if (board.board[r][j + 1] == 'M') {
                                board.board[r][j] = '@';
                                board.board[r][j + 1] = 'O';
                            }
                            else if(board.board[r][j+1]=='N'){
                                board.board[r][j] = 'A';
                                board.board[r][j + 1] = 'O';
                            }
                            else if(board.board[r][j+1]=='W'){
                                board.board[r][j] = 'R';
                                board.board[r][j + 1] = 'O';
                            }
                            else {
                                board.board[r][j] = board.board[r][j + 1];
                                board.board[r][j + 1] = '-';
                            }
                            board.h++;
                        }
                        break;
                    }
                }
            }
        }
        return board;
    }

    public static Board EffectAttractiveDown(int r, int c, Board board) {
        if (r == board.nrow - 1 || r == board.nrow - 2) return board;
        else {
            for (int i = r+1; i < board.nrow; i++) {
                if (CheckAction.CeckType(i,c,board)) {
                    int index = FindCascadeDown(i, c, board);
                    if (CheckAction.CeckNextCascade(index,c,board)) break;
                    else {
                        for (int j = index; j > i; j--) {
                            if (board.board[j - 1][c] == 'M') {
                                board.board[j][c] = '@';
                                board.board[j - 1][c] = 'O';
                            }
                            else if(board.board[j-1][c]=='N'){
                                board.board[j][c] = 'A';
                                board.board[j - 1][c] = 'O';
                            }
                            else if(board.board[j-1][c]=='W'){
                                board.board[j][c] = 'R';
                                board.board[j - 1][c] = 'O';
                            }
                            else {
                                board.board[j][c] = board.board[j - 1][c];
                                board.board[j - 1][c] = '-';
                            }
                            board.h++;
                        }
                        break;
                    }
                }
            }
        }
        return board;
    }

    public static Board EffectAttractiveTop(int r, int c, Board board) {
        if (r == 0 || r == 1) return board;
        else {
            for (int i = r-1; i > 0; i--) {
                if (CheckAction.CeckType(i,c,board)) {
                    int index = FindCascadeTop(i, c, board);
                    if (CheckAction.CeckNextCascade(index,c,board)) break;
                    else {
                        for (int j = index; j < i; j++) {
                            if (board.board[j + 1][c] == 'M') {
                                board.board[j][c] = '@';
                                board.board[j + 1][c] = 'O';
                            }
                            else if(board.board[j + 1][c]=='N'){
                                board.board[j][c] = 'A';
                                board.board[j + 1][c] = 'O';
                            }else if(board.board[j + 1][c]=='W'){
                                board.board[j][c] = 'R';
                                board.board[j + 1][c] = 'O';
                            }
                            else {
                                board.board[j][c] = board.board[j + 1][c];
                                board.board[j + 1][c] = '-';
                            }
                            board.h++;
                        }
                        break;
                    }
                }
            }
        }
        return board;
    }

    public static Board EffectReliableRight(int r, int c, Board board) {
        if (c == board.ncol - 1 || c == board.ncol - 2) return board;
        else {
            for (int i = c + 1; i < board.ncol; i++) {
                if (CheckAction.CeckType(r,i,board)) {
                    if (CheckAction.checkmove(r, i - 1, board)) {
                        if (board.board[r][i] == 'M') {
                            board.board[r][i - 1] = '@';
                            board.board[r][i] = 'O';
                        }
                        else if (board.board[r][i] == 'N') {
                            board.board[r][i - 1] = 'A';
                            board.board[r][i] = 'O';
                        }else if (board.board[r][i] == 'W') {
                            board.board[r][i - 1] = 'R';
                            board.board[r][i] = 'O';
                        }
                        else {
                            board.board[r][i - 1] = board.board[r][i];
                            board.board[r][i] = '-';
                        }
                        board.h++;
                    }
                }
            }
        }
        return board;
    }

    public static Board EffectReliableDown(int r, int c, Board board) {
        if (r == board.nrow - 1 || r == board.nrow - 2) return board;
        else {
            for (int i = r + 1; i < board.nrow; i++) {
                if (CheckAction.CeckType(i,c,board)) {
                    if (CheckAction.checkmove(i - 1, c, board)) {
                        if (board.board[i][c] == 'M') {
                            board.board[i - 1][c] = '@';
                            board.board[i][c] = 'O';
                        }
                        else if (board.board[i][c] == 'N') {
                            board.board[i - 1][c] = 'A';
                            board.board[i][c] = 'O';
                        }else if (board.board[i][c] == 'W') {
                            board.board[i - 1][c] = 'R';
                            board.board[i][c] = 'O';
                        }
                        else {
                            board.board[i - 1][c] = board.board[i][c];
                            board.board[i][c] = '-';
                        }
                        board.h++;
                    }
                }
            }
        }
        return board;
    }


    public static Board EffectReliableTop(int r, int c, Board board) {
        if (r == 0 || r == 1) return board;
        else {
            for (int i = r - 1; i >= 0; i--) {
                if (CheckAction.CeckType(i,c,board)) {
                    if (CheckAction.checkmove(i + 1, c, board)) {
                        if (board.board[i][c] == 'M') {
                            board.board[i + 1][c] = '@';
                            board.board[i][c] = 'O';
                        }
                       else if (board.board[i][c] == 'N') {
                            board.board[i + 1][c] = 'A';
                            board.board[i][c] = 'O';
                        }else if (board.board[i][c] == 'W') {
                            board.board[i + 1][c] = 'R';
                            board.board[i][c] = 'O';
                        }
                        else {
                            board.board[i + 1][c] = board.board[i][c];
                            board.board[i][c] = '-';
                        }
                        board.h++;
                    }
                }
            }
        }
        return board;
    }


    public static Board EffectReliableLeft(int r, int c, Board board) {
        if (c == 0 || c == 1) return board;
        else {
            for (int i = c - 1; i >= 0; i--) {
                if (CheckAction.CeckType(r,i,board)) {
                    if (CheckAction.checkmove(r, i + 1, board)) {
                        if (board.board[r][i] == 'M') {
                            board.board[r][i + 1] = '@';
                            board.board[r][i] = 'O';
                        }
                        else if (board.board[r][i] == 'N') {
                            board.board[r][i + 1] = 'A';
                            board.board[r][i] = 'O';
                        }else if (board.board[r][i] == 'W') {
                            board.board[r][i + 1] = 'R';
                            board.board[r][i] = 'O';
                        }
                        else {
                            board.board[r][i + 1] = board.board[r][i];
                            board.board[r][i] = '-';
                        }
                        board.h++;
                    }
                }
            }
        }
        return board;
    }

    public static int FindCascadeLeft(int r, int c, Board board) {
        for (int j = c; j >= 0; j--)
            if (board.board[r][j] == '-' || board.board[r][j] == 'X' || board.board[r][j] == 'O') return j;

        return c;
    }

    public static int FindCascadeRight(int r, int c, Board board) {
        for (int j = c; j < board.ncol; j++)
            if (board.board[r][j] == '-' || board.board[r][j] == 'X' || board.board[r][j] == 'O') return j;

        return c;
    }

    public static int FindCascadeDown(int r, int c, Board board) {
        for (int j = r; j < board.nrow; j++)
            if (board.board[j][c] == '-' || board.board[j][c] == 'X' || board.board[j][c] == 'O') return j;

        return r;
    }

    public static int FindCascadeTop(int r, int c, Board board) {
        for (int j = r; j >= 0; j--)
            if (board.board[j][c] == '-' || board.board[j][c] == 'X' || board.board[j][c] == 'O') return j;

        return r;
    }


    public static boolean isFinal(Board board) {
        for (int i = 0; i < board.nrow; i++) {
            for (int j = 0; j < board.ncol; j++) {
                if (board.board[i][j] == 'O') return false;
            }
        }
        return true;
    }

    public static boolean Equals(Board board1, Board board2) {
        return board1.equals(board2);
    }
    public static boolean DeepEquals(Board board1, Board board2) {
        for(int i=0;i<board1.nrow;i++){
            for(int j=0;j<board1.ncol;j++){
                if(board1.board[i][j] != board2.board[i][j]) return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> positionFinalState(Board board) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < board.nrow; i++) {
            for (int j = 0; j < board.ncol; j++) {
                if (board.board[i][j] == 'O'|| board.board[i][j] == 'M' || board.board[i][j] == 'N' || board.board[i][j] == 'N') {
                    list.add(i);
                    list.add(j);
                }
            }
        }
        return list;
    }

    public static void reinitializeFinalState(Board board, ArrayList<Integer> list) {
        for (int i = 0; i < list.size()-1; i += 2) {
            if (board.board[list.get(i)][list.get(i + 1)] == '-') {
                board.board[list.get(i)][list.get(i + 1)] = 'O';
            }
        }
    }

    //All the position that can be moved to on the board
    public static void AllMovesAvailable(int r,int c,Board board,ArrayList list,ArrayList list1){
        for(int i=0;i<board.nrow;i++){
            for(int j=0;j<board.ncol;j++){
              if(!Actions.Equals(Actions.move(r,c,i,j,board),board)) {
                  Board p1 = Actions.move(r,c,i,j,board);
                  Actions.reinitializeFinalState(p1,list1);
                  if(p1.board[i][j] == 'A' || p1.board[i][j] == 'N') {
                        p1.type = "A";
                    }
                  else {
                      p1.type = "R";
                  }
                  list.add(p1);
              }
            }
        }
    }

    public static ArrayList<Board> generatAllstates(Board board,ArrayList list1){
        ArrayList<Board> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        list.add(board);
        for(int i=0;i<board.nrow;i++){
            for(int j=0;j<board.ncol;j++){
                if(CheckAction.checkchoosstone(i,j,board)){
                    AllMovesAvailable(i,j,board,list,list1);
                }
            }
        }
        return list ;
    }

    //public void

    // Print Game Board
    public static void printState(Board board) {
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
        System.out.println("");
        for (int i = 0; i < board.nrow; i++) {
            for (int j = 0; j < board.ncol; j++) {
                System.out.print(" | ");
                System.out.print(board.board[i][j]);
                System.out.print(" | ");
            }
            System.out.println("");
            System.out.println("");
        }
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");


    }
}
