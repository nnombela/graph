package rgraph;

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

    Node linkedTo();
    boolean isLinked();

    Halfedge pair();
    Halfedge link(Halfedge halfedge);
    Halfedge unlink();

    Node belongsTo();

    boolean is(Direction direction);
    Direction direction();

    Halfedge reverse();  // for directed family
    Halfedge inverse();  // for recursive family

    Node down();
}
