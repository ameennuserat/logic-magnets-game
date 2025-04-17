/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyProject;


public class CheckAction {

    public static boolean checkchoosstone(int i, int j, Board board) {
        if(!CheckAction.checkdirction(i, j, board)) return false;
        else if (board.board[i][j] != 'A' && board.board[i][j] != 'R' && board.board[i][j] != 'N' && board.board[i][j] != 'W') return false;
        else return true;
    }

    public static boolean checkmove(int i, int j, Board board) {
        if(!CheckAction.checkdirction(i, j, board)) return false;
        else if (board.board[i][j] == '-' || board.board[i][j] == 'O') return true;
        else return false;
    }

    public static boolean checkdirction(int row, int column, Board board) {
        if (!CeckTop(row)) return false;
        else if (!CeckDown(row, board)) return false;
        else if (!CeckLeft(column)) return false;
        else if (!CeckRight(column, board)) return false;
        else return true;
    }

    public static boolean CeckTop(int i) {
        if (i >= 0) return true;
        else return false;
    }

    public static boolean CeckDown(int i, Board board) {
        if (i < board.nrow) return true;
        else return false;
    }

    public static boolean CeckLeft(int j) {
        if (j >= 0) return true;
        else return false;
    }

    public static boolean CeckRight(int j, Board board) {
        if (j < board.ncol) return true;
        else return false;
    }

    public static boolean CeckType(int i,int j, Board board) {
        if (board.board[i][j] == '@' || board.board[i][j] == 'M' ||
                board.board[i][j] == 'R' || board.board[i][j] == 'A' ||
                board.board[i][j] == 'N' || board.board[i][j] == 'W') return true;
        else return false;
    }

    public static boolean CeckNextCascade(int i,int j, Board board) {
        if (board.board[i][j] != '-' && board.board[i][j] != 'O') return true;
        else return false;
    }
}
