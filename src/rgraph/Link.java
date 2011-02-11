package rgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */
public interface Link extends GraphObject {
    enum Direction {
        adjacent, incident;

        Direction reverse(Direction direction) {
            return direction == adjacent ? incident : adjacent;
        }
    }

    Node boundTo();
    Node belongsTo();

    boolean isLinked();
    Link linkedTo();

    Link link(Link link);
    void unlink();

    boolean is(Direction direction);
    Direction direction();

    // for directed family
    boolean isBidirectional();     // reverse() != null
    Link reverse();

    // for recursive family
    Node down();
    Link inverse();
}
