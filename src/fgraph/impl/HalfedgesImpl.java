package fgraph.impl;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 8/06/11
 */
public class HalfedgesImpl extends ContainerImpl<Halfedge> implements Halfedges {

    @Override
    public Halfedge.Direction direction() {
        Node node = node();
        Halfedges adjs = node.halfedges(Halfedge.Direction.adjacent);
        Halfedges incs = node.halfedges(Halfedge.Direction.incident);
        return this == adjs ? Halfedge.Direction.adjacent :  this == incs? Halfedge.Direction.incident : null;
    }

    public Halfedges reverse() {
        Node node = node();
        Halfedges adjs = node.halfedges(Halfedge.Direction.adjacent);
        Halfedges incs = node.halfedges(Halfedge.Direction.incident);
        return this == adjs ? incs :  this == incs? adjs : node;
    }

    @Override
    public Halfedges inverse() {
        return node().up().direct().node().halfedges(direction().reverse());
    }
}
