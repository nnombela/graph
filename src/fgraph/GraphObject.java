package fgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */
public interface GraphObject {
    enum Type {
        graph, nodes, node, halfes, halfe;

        public boolean is(Type type) {
            return this == type;
        }
    }

    Type type();

    GraphFactory factory();

    String id();
    int index();

    void free();
    GraphObject belongsTo();
    void setOwner(GraphObject owner);

    GraphObject closest(Type type);
    Graph graph();
    Nodes nodes();
    Node node();
    Halfes halfes();
    Halfe halfe();

    int ordinal();
}
