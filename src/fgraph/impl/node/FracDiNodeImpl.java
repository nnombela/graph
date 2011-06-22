package fgraph.impl.node;

import fgraph.GraphFactory;
import fgraph.Halfe;
import fgraph.Halfes;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class FracDiNodeImpl extends FracNodeImpl {

    public FracDiNodeImpl() {
        this(new DuoHalfesImpl());
    }

    public FracDiNodeImpl(Halfes halfes) {
        super(halfes);
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
