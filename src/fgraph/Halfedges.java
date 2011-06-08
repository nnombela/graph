package fgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 8/06/11
 */
public interface Halfedges extends Container<Halfedge> {
    Halfedge.Direction direction();

    Halfedges reverse();
    Halfedges inverse();
}
