package fgraph.impl;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class NodeImpl extends DualContainerImpl<Halfedge> implements Node {
    Container<Node> container;

    public NodeImpl(GraphObject belongsTo, Type type) {
        super(type);
        left.owner = this;
        right.owner = this;
    }

    public Graph belongsTo() {
        return (Graph)super.belongsTo();
    }

    public void setOwner(GraphObject owner) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public Container<Halfedge> halfedges(Halfedge.Direction direction) {
        return direction == Halfedge.Direction.adjacent? left : right;
    }

    public Halfedge.Direction direction(Container<Halfedge> halfedges) {
        return halfedges == left? Halfedge.Direction.adjacent : halfedges == right? Halfedge.Direction.incident : null;
    }

    public Container<Halfedge> reverse(Container<Halfedge> halfedges) {
        return halfedges == left? right : halfedges == right? left : null;
    }

    public Container<Halfedge> inverse(Container<Halfedge> halfedges) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Graph graph() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Container<Node> container() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean is(Duality duality) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Duality duality() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
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
