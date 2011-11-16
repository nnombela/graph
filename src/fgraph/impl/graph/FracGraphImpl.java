package fgraph.impl.graph;

import fgraph.*;
import fgraph.impl.GraphObjectAbstract;

import java.util.HashSet;
import java.util.Set;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class FracGraphImpl extends GraphImpl {
    protected Node up;
    protected int ordinal;

    @Override
    public GraphFactory factory() {
        return GraphFactory.get("fractal-graph");
    }

    public FracGraphImpl(int ordinal) {
        super(new NodesImpl());
        this.ordinal = ordinal;
    }

    public FracGraphImpl(Nodes nodes, int ordinal) {
        super(nodes);
        this.ordinal = ordinal;
    }

    public void free() {
        GraphObjectAbstract.free(up);
        super.free();
    }

    public Node up() {
        return up;
    }

    public void setUp(Node up) {
        if (this.up != null) {
            this.up = up;
        } else {
            throw new RuntimeException("Invalid Operation");
        }
    }


    public int ordinal() {
        return ordinal;
    }
}
