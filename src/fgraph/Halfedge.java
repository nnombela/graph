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

        Direction reverse(Direction direction) {
            return direction == adjacent? incident : adjacent;
        }
    }

    enum Join {
        direct, reverse, inverse   // joins to make a full direct edge, a bidirectional halfedge (reverse) or a full inverse edge
    }

    Node belongsTo();
    Node linksTo();

    // currying for direct join type
    Halfedge pair();
    Halfedge join(Halfedge halfedge);
    Halfedge disjoin();

    Halfedge pair(Join join);
    Halfedge join(Join join, Halfedge halfedge);
    Halfedge disjoin(Join join);

    boolean is(Direction direction);
    Direction direction();

    Node down();
}
