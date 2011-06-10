package fgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 8/06/11
 */
public interface Halfedges extends Container<Halfedge> {
//    interface Iterator extends Container.Iterator<Halfedge> {
//    }
//    interface Closure extends Container.Closure<Halfedge> {
//    }

    Halfedge.Direction direction();

    Halfedges reverse();
    Halfedges inverse();
}
