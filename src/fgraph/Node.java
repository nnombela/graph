package fgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */
public interface Node extends GraphObject {
    enum Duality {
        hvert, hedge;   //hyper-vertex, hyper-edge

        public Duality dual() {
            return this == hvert ? hedge : hvert;
        }
        public boolean is(Duality duality) {
            return this == duality;
        }
    }

    Halfes halfes();
    Nodes belongsTo();

    // Dual
    Duality duality();

    // Directed
    Halfes halfes(Halfe.Direction direction);

    // Fractal
    Node inverse();

    Graph down();
    void setDown(Graph down);

    Halfe up();
    void setUp(Halfe up);

}
