package MyProject;

import java.util.PriorityQueue;

public class HillClimbing extends Logic {

    PriorityQueue<state> Q = new PriorityQueue<>(new state());

    public HillClimbing(Board b){
        Position = Actions.positionFinalState(b);
        state s = HillClimping(new state(null,b));
//        if(Actions.Equals(s.getValue(),b)) {
//            System.out.println("stop");
//        return ;}
        solution(s);
    }

//    public state HillClimping(state s) {
//        if (Actions.isFinal(s.getValue())) return s;
//        int h = s.heuristic;
//        state s1 = s;
//        while (true) {
//
//            for (Board b : Actions.generatAllstates(s1.getValue(), Position)) {
//
//                if (Actions.isFinal(s1.getValue())) return s1;
//
//                if (b.h > s1.heuristic) {
//                    h = b.h;
//                    s1 = new state(s1, b);
//                    s1.heuristic = h;
//                    //Actions.printState(s1.getValue());
//                }
//
//            }
//            if (Actions.Equals(s1.getValue(), s.getValue())) {
//                return s1;
//            }
//        }
//       // return s;
//    }

    public state HillClimping(state s){

        Q.add(s);

        while(Q.size()>0){
            state node = Q.poll();
            Actions.printState(node.getValue());
            VisitedList.add(node);
            if(Actions.isFinal(node.getValue())){
                return node;
            }

            for(Board b:Actions.generatAllstates(node.getValue(),Position)){
                if(!isVisited(b)){
                    //System.out.println(b.h);
                    state ss = new state(node,b);
                    ss.heuristic = b.h;
                    Q.add(ss);
                }

            }
        }
        return null;
    }

}
