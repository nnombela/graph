package rgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */

// Links are edges with only one end, also called half-edges. Should I rename it as Halfedge?
// The name half-edge seems something uncompleted which I don't like

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
