package rgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */

// Links are edges with only one end, also called half-edges. Should I rename it as HalfEdge?
// The name half-edge seems something uncompleted which I don't like

public interface Link extends GraphObject {
    enum Direction {
        adjacent, incident;

        Direction reverse(Direction direction) {
            return direction == adjacent ? incident : adjacent;
        }
    }

    Node linksTo();    // pair().belongsTo()
    Node belongsTo();

    boolean isPaired();
    Link pair();

    Link bind(Link link);
    void unbind();

    boolean is(Direction direction);
    Direction direction();

    // for directed family
    boolean isBidirectional();     // reverse() != null
    Link reverse();

    // for recursive family
    Node down();
    Link inverse();
}
