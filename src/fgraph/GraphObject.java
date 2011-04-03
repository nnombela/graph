package fgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */
public interface GraphObject {
    enum Type { graph, node, halfedge }
    enum Family { directed, dual, fractal }


    boolean is(Type type);
    boolean is(Family family);

    Type type();
    Family[] families();

    GraphFactory factory();

    void free();
    GraphObject belongsTo();
}
