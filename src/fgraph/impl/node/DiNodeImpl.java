package fgraph.impl.node;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class DiNodeImpl extends NodeImpl {

    public DiNodeImpl(String label) {
        super(label, new DuoLinksImpl());
    }

    @Override
    public GraphFactory factory() {
        return GraphFactory.get("directed-graph");
    }

    @Override
    public Links links(Link.Direction direction) {
        return ((DuoLinksImpl) links).links(direction);
    }
}
