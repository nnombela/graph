package fgraph.impl.node;

import fgraph.GraphFactory;
import fgraph.Link;
import fgraph.Links;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class FracDiNodeImpl extends FracNodeImpl {

    public FracDiNodeImpl() {
        this(new DuoLinksImpl());
    }

    public FracDiNodeImpl(Links links) {
        super(links);
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
