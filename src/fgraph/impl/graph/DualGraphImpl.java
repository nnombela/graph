package fgraph.impl.graph;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class DualGraphImpl extends GraphImpl {

    public DualGraphImpl() {
        super(new DuoNodesImpl());
    }

    @Override
    public GraphFactory factory() {
        return GraphFactory.get("dual-graph");
    }

    public Nodes nodes(Node.Duality duality) {
        return ((DuoNodesImpl)nodes).nodes(duality);
    }

}