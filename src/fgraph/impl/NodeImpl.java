package fgraph.impl;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 8/06/11
 */
public class NodeImpl extends GraphObjectAbstract implements Node {
    protected Halfedges halfedges;

    @Override
    public GraphFactory factory() {
        return GraphFactory.get("graph");
    }

    public NodeImpl() {
        this(new HalfedgesImpl());
    }
    public NodeImpl(Halfedges halfedges) {
        this.halfedges = halfedges;
        halfedges.setOwner(this);
    }

    public Type type() {
        return Type.node;
    }

    public Nodes belongsTo() {
        return (Nodes)owner;
    }


    @Override
    public Duality duality() {
        return belongsTo().duality();
    }

    @Override
    public Halfedges halfedges() {
        return halfedges;
    }

    @Override
    public Halfedges halfedges(Halfedge.Direction direction) {
        return halfedges;
    }

    @Override
    public Graph down() {
        return null;
    }

    @Override
    public Halfedge up() {
        return null;
    }

    @Override
    public void setDown(Graph down) {
        throw new RuntimeException("Invalid operation");
    }
    @Override
    public void setUp(Halfedge up) {
        throw new RuntimeException("Invalid operation");
    }
}
