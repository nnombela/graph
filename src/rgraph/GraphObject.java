package rgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */
public interface GraphObject {
    enum Type { halfedge, node, graph }
    enum Family { directed, hyper, recursive }


    boolean is(Type type);
    boolean is(Family family);

    Type type();
    Family[] families();

    GraphFactory factory();

    void free();
    GraphObject belongsTo();

    long ordinal();
}
