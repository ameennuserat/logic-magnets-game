package MyProject;

import java.util.PriorityQueue;

public class UCS extends Logic{

    PriorityQueue<state> Q = new PriorityQueue<>(new state());

    public UCS(Board b){
         Position = Actions.positionFinalState(b);
        state s = UCS(new state(null,b,0));
        solution(s);
        if(s!=null) System.out.println("cost solution = "+s.cost);
    }

    public state UCS(state s){
        Q.add(s);

        while(Q.size()>0){
            state node = Q.poll();
            VisitedList.add(node);
            if(Actions.isFinal(node.getValue())){
                System.out.println(node.getValue().h);
                return node;
            }

            for(Board b:Actions.generatAllstates(node.getValue(),Position)){
                    if(!isVisited(b)){
                        if(b.type == "A")
                        Q.add(new state(node,b,(node.cost+5)));

                        else {
                            Q.add(new state(node,b,(node.cost+1)));
                        }
                    }

            }
        }
        return null;
    }

}
