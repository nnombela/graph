package rgraph;

/**
 * Created by IntelliJ IDEA.
 * User: nnombela
 * Date: 3/01/11
 * Time: 15:33
 * To change this template use File | Settings | File Templates.
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
