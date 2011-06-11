package fgraph.impl;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class GraphImpl extends NodesImpl implements Graph {
    protected Node up;
    protected int ordinal;

    public GraphImpl(int ordinal) {
        this.ordinal = ordinal;
    }

    @Override
    public GraphFactory factory() {
        return GraphFactory.get("default");
    }

    public void free() {
        if (up != null) {
            up.free();
        }
        super.free();
    }

    public Nodes nodes(Node.Duality duality) {
        return this;
    }

    public Node up() {
        return up;
    }

    public Node.Duality duality() {
        return null;
    }

    public Nodes dual() {
        return null;
    }

    @Override
    public void setUp(Node up) {
        this.up = Checker.setUp(this, up);
    }

    public int ordinal() {
        return ordinal;
    }
}
