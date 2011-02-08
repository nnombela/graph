package rgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */
public interface Link extends GraphObject {
    enum Direction { adjacent, incident }

    Node boundTo();
    Node belongsTo();

    boolean isLinked();
    Link linkedTo();

    Link link(Link link);
    void unlink();

    boolean is(Direction direction);
    Direction direction();

    boolean isBidirectional();     // reverse() != null
    Link reverse();

    Node up();
    Link inverse();
}
