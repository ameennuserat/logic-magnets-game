package MyProject;

import java.util.Scanner;
import java.util.ArrayList;

public class Player {
     Scanner s;
    boolean start;
    private Board board;
    ArrayList<Board> list1;
    public Player(Board board) {
        this.start = true;
        this.board = board;
       s = new Scanner(System.in);
        list1  = new ArrayList<>();
        list1.add(new Board(board));
        this.play();
    }

    public void play() {
        ArrayList<Integer> list = new ArrayList<>();
        list = Actions.positionFinalState(board);
        int count = 0;
        System.out.println("beeegining play____________________________________");
        Actions.printState(board);
        while (this.start) {
            System.out.println("Select the stone you want to move");
            int row = s.nextInt();
            int column = s.nextInt();
            if (CheckAction.checkchoosstone(row, column, board)) {
                System.out.println("where?");
                int i = s.nextInt();
                int j = s.nextInt();
               if(!Actions.Equals(Actions.move(row, column, i, j, board),board)){
                   count++;
                    board = Actions.move(row, column, i, j, board);
                   Actions.reinitializeFinalState(board, list);
                }
            }

            Actions.printState(board);
            if (count == board.steps) this.start = !this.start;
        }
        if (Actions.isFinal(board)) System.out.println("solveed");
        else System.out.println("game ovver");

        //getStates();
    }

public void getStates() {
    for (int i = 0; i < this.list1.size(); i++) {
        Actions.printState(((Board) this.list1.get(i)));
        System.out.println("___________________________");
    }
}

}
