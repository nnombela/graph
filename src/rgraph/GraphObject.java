package rgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
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
