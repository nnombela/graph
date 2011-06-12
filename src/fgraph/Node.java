package fgraph;

import com.sun.istack.internal.Nullable;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */
public interface Node extends GraphObject {
    enum Duality {
        hypervertex, hyperedge;

        public Duality dual() {
            return this == hypervertex? hyperedge : hypervertex;
        }
        public boolean is(Duality duality) {
            return this == duality;
        }
    }

    Halfedges halfedges();
    Nodes belongsTo();

    // Dual
    Duality duality();

    // Directed
    Halfedges halfedges(Halfedge.Direction direction);

    // Fractal
    Graph down();
    void setDown(Graph down);

    Halfedge up();
    void setUp(Halfedge up);

}
