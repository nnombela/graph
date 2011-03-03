package rgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */
public interface Node extends Container<Halfedge> {
    enum Hyper {
        vertex, edge;

        Hyper dual(Hyper hyper) {
            return hyper == vertex ? edge : vertex;
        }
    }

    Container<Halfedge> halfedges(Halfedge.Direction direction);
    Halfedge.Direction direction(Container<Halfedge> halfedges);

    Container<Halfedge> reverse(Container<Halfedge> halfedges);
    Container<Halfedge> inverse(Container<Halfedge> halfedges);

    Graph belongsTo();

    boolean is(Hyper hyper);
    Hyper hyper();

    Graph down();
    Halfedge up();

    Halfedge bind(Node node);
    Halfedge bindThrough(Node node, Halfedge.Direction direction);
    Halfedge unbind(Node node);
}
