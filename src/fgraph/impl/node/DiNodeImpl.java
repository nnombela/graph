package fgraph.impl.node;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class DiNodeImpl extends NodeImpl {
    public DiNodeImpl() {
        super(new DuoHalfesImpl());
    }

    @Override
    public GraphFactory factory() {
        return GraphFactory.get("directed-graph");
    }

    @Override
    public Halfes halfes(Halfe.Direction direction) {
        return ((DuoHalfesImpl) halfes).halfedges(direction);
    }
}
