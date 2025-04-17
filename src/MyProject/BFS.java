package MyProject;

import java.util.LinkedList;
import java.util.Queue;

public class BFS extends Logic {

    Queue<state> Qstates = new LinkedList<>();


    public BFS(Board b){
        state s = SolveBfs(new state(null,b));
        this.solution(s);
    }


    public state SolveBfs(state s) {
        Position =  Actions.positionFinalState(s.getValue());
        Qstates.add(s);
        while (Qstates.size() > 0) {


            state node = Qstates.poll();

            VisitedList.add(node);

            if (Actions.isFinal(node.getValue())) {
                return node;
            }

            for(Board b : Actions.generatAllstates(node.getValue(),Position))
                if (!isVisited(b)) {
                        Qstates.add(new state(node, b));
                }
        }
        return null;
    }
}