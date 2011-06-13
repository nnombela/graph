package fgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */


// The name halfedge is kind of ugly, maybe I should rename it to link, hook or port

public interface Halfedge extends GraphObject {
    enum Direction {
        adjacent, incident;

        public Direction reverse() {
            return this == adjacent? incident : adjacent;
        }

        public boolean is(Direction direction) {
            return this == direction;
        }
    }

    enum Join {
        direct, reverse, inverse   // joins to make a full direct edge, a bidirectional halfedge (reverse) or a full inverse edge
    }

    Node linksTo();
    Halfedges belongsTo();

    Halfedge direct();
    Halfedge reverse();
    Halfedge inverse();

    Halfedge pair(Join join);
    Halfedge join(Join join, Halfedge halfedge);
    boolean disjoin(Join join);

    Direction direction();

    Node down();

    void setDown(Node down);
}
