package fgraph.impl.graph;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class DualGraphImpl extends GraphImpl {

    public DualGraphImpl(String label, GraphFactory factory) {
        super(label, factory, new DuoNodesImpl());
    }

    public Nodes nodes(Node.Duality duality) {
        return ((DuoNodesImpl)nodes).nodes(duality);
    }

}
