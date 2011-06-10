package fgraph.impl;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class DualGraphImpl extends DuoContainerImpl<Node> implements Graph {
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
        super(NodesImpl.class);
        this.ordinal = ordinal;
    }

    public Type type() {
        return Type.graph;
    }

    public Nodes nodes(Node.Duality duality) {
        return (Nodes)containers[duality.ordinal()];
    }

    public Node up() {
        return up;
    }

    @Override
    public Node.Duality duality() {
        return null;
    }

    @Override
    public Nodes dual() {
        return this;
    }

    @Override
    public void setUp(Node up) {
        this.up = Checker.setUp(this, up);
    }
}
