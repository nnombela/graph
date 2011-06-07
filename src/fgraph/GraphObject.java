package fgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */
public interface GraphObject {
    enum Type { graph, node, halfedge }

    boolean is(Type type);
    Type type();

    GraphFactory factory();

    void free();
    GraphObject belongsTo();
    void setOwner(GraphObject owner);
}
