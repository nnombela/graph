package fgraph.impl.graph;

import fgraph.GraphFactory;
import fgraph.Node;
import fgraph.Nodes;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class FracDualGraphImpl extends FracGraphImpl {

    public FracDualGraphImpl(int ordinal) {
        this(new DuoNodesImpl(), ordinal);
    }

    public FracDualGraphImpl(Nodes nodes, int ordinal) {
        super(nodes, ordinal);
    }

    @Override
    public GraphFactory factory() {
        return GraphFactory.get("fractal-dual-graph");
    }

    public Nodes nodes(Node.Duality duality) {
        return ((DuoNodesImpl)nodes).nodes(duality);
    }
}
