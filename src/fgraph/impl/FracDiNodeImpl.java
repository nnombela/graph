package fgraph.impl;

import fgraph.GraphFactory;
import fgraph.Halfedge;
import fgraph.Halfedges;
import fgraph.Nodes;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class FracDiNodeImpl extends FracNodeImpl {

    public FracDiNodeImpl() {
        this(new DuoHalfedgesImpl());
    }

    public FracDiNodeImpl(Halfedges halfedges) {
        super(halfedges);
    }

    @Override
    public GraphFactory factory() {
        return GraphFactory.get("directed-graph");
    }

    @Override
    public Halfedges halfedges(Halfedge.Direction direction) {
        return ((DuoHalfedgesImpl)halfedges).halfedges(direction);
    }
}
