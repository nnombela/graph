package fgraph.impl;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 8/06/11
 */
public class NodeImpl extends GraphObjectAbstract implements Node {
    protected Halfedges halfedges;
    protected Graph down;
    protected Halfedge up;

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

    public void free() {
        free(up);
        free(down);
        super.free();
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
        return down;
    }

    @Override
    public Halfedge up() {
        return up;
    }

    @Override
    public void setDown(Graph down) {
        this.down = Checker.setDown(this, down);
    }
    @Override
    public void setUp(Halfedge up) {
        this.up = Checker.setUp(this, up);
    }
}
