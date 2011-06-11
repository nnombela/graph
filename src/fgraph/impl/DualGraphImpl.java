package fgraph.impl;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class DualGraphImpl extends DuoNodesImpl implements Graph {
    protected Node up;
    protected int ordinal;

    @Override
    public GraphFactory factory() {
        return GraphFactory.get("dual-graph");
    }

    public void free() {
        if (up != null) {
            up.free();
        }
        super.free();
    }

    public DualGraphImpl(int ordinal) {
        this.ordinal = ordinal;
    }

    public Type type() {
        return Type.graph;
    }

    public Nodes nodes(Node.Duality duality) {
        return containers[duality.ordinal()];
    }

    public Node up() {
        return up;
    }

    @Override
    public void setUp(Node up) {
        this.up = Checker.setUp(this, up);
    }
}
