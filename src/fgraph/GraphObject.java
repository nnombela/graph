package fgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */
public interface GraphObject {
    enum Type {
        graph, nodes, node, links, link;

        public boolean is(Type type) {
            return this == type;
        }
    }

    Type type();

    GraphFactory factory();

    String label();
    int index();

    void free();
    GraphObject belongsTo();
    GraphObject belongsTo(Type type);
    //void setOwner(GraphObject owner);

    int ordinal();
}
