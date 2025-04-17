package MyProject;

import java.util.Comparator;

public class state implements Comparator<state> {
    state parent;
    Board value;
    int cost = 0;
    int heuristic = 0;
    int depth = 0;
    public state(state p,Board ch){
        this.parent = p;
        this.value = ch;
    }

    public state(){}

    public state(state parent, Board value, int cost) {
        this.parent = parent;
        this.value = value;
        this.cost = cost;
    }


    public state( int depth,state parent,Board value) {
        this.parent = parent;
        this.value = value;
        this.depth = depth;
    }


    public state getParent() {
        return parent;
    }

    public Board getValue() {
        return value;
    }

    @Override
    public int compare(state s1, state s2) {
        if(s2.heuristic < s1.heuristic) return -1;
        else if(s2.heuristic > s1.heuristic) return 1;
        else if(s1.cost < s2.cost) return -1;
        else if(s1.cost > s2.cost) return 1;
        else return 0;

    }

//    public int compare(state s1, state s2) {
//        return Integer.compare(s1.cost,s2.cost);
//    }

//    public int compare(state s1, state s2) {
//        //return Integer.compare(s2.heuristic,s1.heuristic);
//        if(s2.heuristic < s1.heuristic) return -1;
//        else if(s2.heuristic > s1.heuristic) return 1;
//        else return 0;
//    }
}
