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

    Node bindedTo();    // pair().belongsTo()
    Node belongsTo();

    boolean isBinded();
    Halfedge pair();

    Halfedge bind(Halfedge halfedge);
    void unbind();

    boolean is(Direction direction);
    Direction direction();

    // for directed family
    boolean hasReverse();   // is bidirectional
    Halfedge reverse();

    // for recursive family
    Halfedge inverse();
    boolean hasInverse(); // belongsTo().up().pair()

    Node down();
}
