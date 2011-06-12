package fgraph.impl;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class DiNodeImpl extends NodeImpl {
    public DiNodeImpl() {
        super(new DuoHalfedgesImpl());
    }

    @Override
    public GraphFactory factory() {
        return GraphFactory.get("digraph");
    }

    @Override
    public Halfedges halfedges(Halfedge.Direction direction) {
        return ((DuoHalfedgesImpl)halfedges).halfedges(direction);
    }
}
