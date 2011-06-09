package fgraph.impl;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 8/06/11
 */
public class NodeImpl extends ContainerImpl<Halfedge> implements Node {
    protected Graph down;
    protected Halfedge up;

    @Override
    public GraphFactory factory() {
        return GraphFactory.get("default");
    }

    public void free() {
        if (up != null) {
            up.free();
        }
        if (down != null) {
            down.free();
        }
        super.free();
    }

    @Override
    public Duality duality() {
        return ((Nodes)owner).duality();
    }

    @Override
    public Halfedges halfedges(Halfedge.Direction direction) {
        return this;
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
    public Halfedge.Direction direction() {
        return null;
    }

    @Override
    public Node reverse() {
        return this;
    }

    @Override
    public Node inverse() {
        return up().direct().node();
    }

    @Override
    public void setDown(Graph down) {
        if (this.down == null || down == null) {
            this.down = down;
        } else {
            throw new RuntimeException("Invalid Operation. Down node is already set by " + this.down);
        }
    }
    @Override
    public void setUp(Halfedge up) {
        if (this.up == null || up == null) {
            this.up = up;
        } else {
            throw new RuntimeException("Invalid Operation. Down node is already set by " + this.up);
        }
    }
}
