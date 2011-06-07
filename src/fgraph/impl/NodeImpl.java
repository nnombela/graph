package fgraph.impl;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class NodeImpl extends DualContainerImpl<Halfedge> implements Node {

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

    public Container<Halfedge> inverse(Container<Halfedge> halfedges) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
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
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Halfedge up() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Halfedge link(Node node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Halfedge link(Node node, Halfedge.Direction direction) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Halfedge unlink(Node node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
