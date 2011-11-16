package fgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */
public interface Node extends GraphObject {
    Graph graph();
    Nodes belongsTo();
    Links links();

    Link bind(Node node);
    void unbind(Node node);

    // ---- Direction
    Link bind(Node node, Link.Direction direction);

    Links links(Link.Direction direction);

    // ---- Duality

    enum Duality {
        none, hvert, hedge;

        public Duality dual() {
            return this == hvert ? hedge : this == hedge? hvert : none;
        }
        public boolean is(Duality duality) {
            return this == duality;
        }
    }

    Duality duality();

    // ---- Fractal

    Node inverse();
    Graph down();
    Link up();
}
