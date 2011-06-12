package fgraph.impl;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 8/06/11
 */
public class FracNodeImpl extends NodeImpl {
    protected Graph down;
    protected Halfedge up;

    @Override
    public GraphFactory factory() {
        return GraphFactory.get("fractal-graph");
    }

    public FracNodeImpl() {
        this(new HalfedgesImpl());
    }

    public FracNodeImpl(Halfedges halfedges) {
        super(halfedges);
    }


    public void free() {
        free(up);
        free(down);
        super.free();
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
