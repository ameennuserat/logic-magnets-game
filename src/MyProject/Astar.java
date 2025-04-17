package MyProject;

import java.util.PriorityQueue;

public class Astar extends Logic {

    PriorityQueue<state> Q = new PriorityQueue<>(new state());

    public Astar(Board b){
        Position = Actions.positionFinalState(b);
        state s = Astar(new state(null,b));
        super.solution(s);
    }

    public state Astar(state s){

        if(Actions.isFinal(s.getValue())) return s;

            Q.add(s);

            while(!Q.isEmpty()){
                state node = Q.poll();
                VisitedList.add(node);
                if(Actions.isFinal(node.getValue())) {
                    System.out.println(node.cost+ " : "+node.heuristic);
                    return node;}
                for(Board b: Actions.generatAllstates(node.getValue(),Position)){
                    if(!isVisited(b)){
                        state s1 = new state(node,b,node.cost+1);
                        s1.heuristic = b.h;
                        Q.add(s1);
                    }
                }
            }
            return null;
    }
}
