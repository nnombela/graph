package fgraph;

import com.sun.istack.internal.Nullable;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */
public interface Node extends Halfedges {
    enum Duality {
        hypervertex, hyperedge;

        public Duality dual() {
            return this == hypervertex? hyperedge : hypervertex;
        }
        public boolean is(Duality duality) {
            return this == duality;
        }
    }

    Duality duality();

    Halfedges halfedges(Halfedge.Direction direction);

    Graph down();

    Halfedge up();

    void setDown(Graph down);

    void setUp(Halfedge up);

}
