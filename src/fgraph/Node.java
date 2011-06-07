package fgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */
public interface Node extends Container<Halfedge> {
    enum Duality {
        hypervertex, hyperedge;

        public Duality dual() {
            return this == hypervertex? hyperedge : hypervertex;
        }
    }

    Container<Halfedge> halfedges(Halfedge.Direction direction);
    Halfedge.Direction direction(Container<Halfedge> halfedges);

    Container<Halfedge> reverse(Container<Halfedge> halfedges);
    Container<Halfedge> inverse(Container<Halfedge> halfedges);

    Node inverse();

    Graph graph();

    boolean is(Duality duality);
    Duality duality();

    Graph down();
    Halfedge up();
}
