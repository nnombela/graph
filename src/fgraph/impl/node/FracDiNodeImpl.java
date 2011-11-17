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

    public FracDiNodeImpl(String label) {
        this(label, new DuoLinksImpl());
    }

    public FracDiNodeImpl(String label, Links links) {
        super(label, links);
    }

    @Override
    public GraphFactory factory() {
        return GraphFactory.get("fractal-directed-graph");
    }

    @Override
    public Links links(Link.Direction direction) {
        return ((DuoLinksImpl) links).links(direction);
    }
}
