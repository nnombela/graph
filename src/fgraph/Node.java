package fgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */
public interface Node extends Container<Halfedge> {
    enum Duality {
        hypervertex, hyperedge;

        Duality dual(Duality duality) {
            return duality == hypervertex? hyperedge : hypervertex;
        }
    }

    Container<Halfedge> halfedges(Halfedge.Direction direction);
    Halfedge.Direction direction(Container<Halfedge> halfedges);

    Container<Halfedge> reverse(Container<Halfedge> halfedges);
    Container<Halfedge> inverse(Container<Halfedge> halfedges);

    Graph belongsTo();

    boolean is(Duality duality);
    Duality duality();

    Graph down();
    Halfedge up();

    Halfedge link(Node node);
    Halfedge link(Node node, Halfedge.Direction direction);
    Halfedge unlink(Node node);
}
