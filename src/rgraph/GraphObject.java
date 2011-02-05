package rgraph;

/**
 * Created by IntelliJ IDEA.
 * User: nnombela
 * Date: 3/01/11
 * Time: 15:36
 * To change this template use File | Settings | File Templates.
 */
public interface GraphObject {
    enum Direction { adjacent, incident }
    enum Hyper { vertex, edge }

    enum Type { link, node, graph }
    enum Family { directed, hyper, recursive }


    boolean is(Type type);
    boolean is(Family family);

    GraphFactory factory();

    void free();
}
