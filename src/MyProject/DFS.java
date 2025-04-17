package MyProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
public class DFS extends Logic {

    private Stack<state> stackStates = new Stack<state>();

    public DFS(Board game)
    {   Position = Actions.positionFinalState(game);
        state sol = SolveDFS(new state(null, game));
        this.solution(sol);
    }

    state SolveDFS(state state)
    {
        stackStates.push(state);
        while (stackStates.size() > 0)
        {
            state node = stackStates.pop();
            VisitedList.add(node);

            if (Actions.isFinal(node.getValue()))
                return node;

            if(node.depth>=node.getValue().steps) continue;

            ArrayList<Board> l = Actions.generatAllstates(node.getValue(),Position);
            Collections.reverse( l);
            for (Board child : l) {
                if (!isVisited(child)) {
                    stackStates.push(new state(node.depth+1,node, child));
                }
            }
        }
        return null;
    }
}
