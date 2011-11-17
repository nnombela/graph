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

    public FracDualGraphImpl(String label, GraphFactory factory, int ordinal) {
        this(label, factory, new DuoNodesImpl(), ordinal);
    }

    public FracDualGraphImpl(String label, GraphFactory factory, Nodes nodes, int ordinal) {
        super(label, factory, nodes, ordinal);
    }

    public Nodes nodes(Node.Duality duality) {
        return ((DuoNodesImpl)nodes).nodes(duality);
    }
}
