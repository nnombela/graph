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
            return direction == adjacent ? incident : adjacent;
        }
    }

    enum JoinType {
        direct, reverse, inverse   // joins to make a full direct edge, a bidirectional halfedge (reverse) or a full inverse edge
    }

    Node belongsTo();
    Node linkedTo();

    Halfedge pair();
    Halfedge join(Halfedge halfedge);
    Halfedge disjoin();

    Halfedge pair(JoinType type);
    Halfedge join(JoinType type, Halfedge halfedge);
    Halfedge disjoin(JoinType type);

    boolean is(Direction direction);
    Direction direction();

    Node down();
}
