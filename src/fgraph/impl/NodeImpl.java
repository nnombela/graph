package fgraph.impl;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class NodeImpl extends DualContainerImpl<Halfedge> implements Node {
    protected Halfedge up;
    protected Graph down;

    public NodeImpl() {
        left.setOwner(this);
        right.setOwner(this);
    }

    public void free() {
        left.free();
        right.free();
        super.free();
    }

    public Container<Halfedge> halfedges(Halfedge.Direction direction) {
        return direction == Halfedge.Direction.adjacent? left : right;
    }

    public Halfedge.Direction direction(Container<Halfedge> halfedges) {
        return halfedges == left? Halfedge.Direction.adjacent : halfedges == right? Halfedge.Direction.incident : null;
    }

    public Container<Halfedge> reverse(Container<Halfedge> halfedges) {
        return halfedges == left? right : halfedges == right? left : this;
    }

    public Node inverse() {
        return up().pair().down();
    }

    public Container<Halfedge> inverse(Container<Halfedge> halfedges) {
        return inverse().halfedges(direction(halfedges).reverse());
    }

    public Type type() {
        return Type.node;
    }

    public Graph graph() {
        return (Graph)owner.belongsTo();
    }

    public boolean is(Duality duality) {
        return duality() == duality;
    }

    public Duality duality() {
        return graph().duality((Container<Node>)owner);
    }

    public Graph down() {
        return down;
    }

    public Halfedge up() {
        return up;
    }

}
