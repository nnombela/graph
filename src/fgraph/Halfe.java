package fgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */


// The name halfe (half-edge) is kind of ugly, maybe I should rename it to link, hook or port

public interface Halfe extends GraphObject {
    enum Direction {
        adj, inc;  // adjacent, incident

        public Direction reverse() {
            return this == adj ? inc : adj;
        }

        public boolean is(Direction direction) {
            return this == direction;
        }
    }

    enum Join {
        converse, reverse, inverse   // joins to make a full edge, a bidirectional halfe (reverse) or a full inverse edge
    }

    Node linksTo();
    Halfes belongsTo();

    Halfe converse();
    Halfe reverse();
    Halfe inverse();

    Halfe pair(Join join);
    Halfe join(Join join, Halfe halfe);
    boolean disjoin(Join join);

    Direction direction();

    Node down();

    void setDown(Node down);
}
