package MyProject;

import java.util.ArrayList;
import java.util.Collections;

public class Logic {
    ArrayList<state> VisitedList = new ArrayList<>();
    ArrayList<Board> SolutionList = new ArrayList<>();
    ArrayList<Integer> Position = new ArrayList<>();

    public boolean isVisited(Board board){
        for(state s : VisitedList){
            if(Actions.DeepEquals(s.getValue(),board)){
                return true;
            }
        }
        return false;
    }

    public void solution(state s){
        if(s == null) {
            System.out.println("NOT FOUND SOLUTION.");

        }
        else {

            Actions.printState(s.getValue());
            System.out.println("SOLVED |^_^|.");

            while (s != null) {
                SolutionList.add(s.getValue());
                s = s.getParent();
            }

            System.out.println("Solution Path :");
            Collections.reverse(SolutionList);
            for(Board B:SolutionList){
                Actions.printState(B);
            }

            System.out.println("Solution Depth = "+(SolutionList.size()-1));

            System.out.println("Visited Nodes = " + VisitedList.size());

        }
    }
}
