package fgraph.impl;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 8/06/11
 */
public class NodeImpl extends ContainerImpl<Halfedge> implements Node {

    @Override
    public Container<Halfedge> halfedges(Halfedge.Direction direction) {
        return this;
    }

    @Override
    public Halfedge.Direction direction(Container<Halfedge> halfedges) {
        return null;
    }

    @Override
    public Container<Halfedge> reverse(Container<Halfedge> halfedges) {
        return this;
    }

    @Override
    public Container<Halfedge> inverse(Container<Halfedge> halfedges) {
        return null;
    }

    @Override
    public Node inverse() {
        return null;
    }

    @Override
    public boolean is(Duality duality) {
        return duality() == duality;
    }

    @Override
    public Duality duality() {
        return graph().duality((Container<Node>)owner);
    }

    @Override
    public Graph down() {
        return null;
    }

    @Override
    public Halfedge up() {
        return null;
    }


}
