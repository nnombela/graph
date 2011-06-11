package fgraph.impl;

import fgraph.*;

import java.util.HashSet;
import java.util.Set;

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
        free(up);
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

    @Override
    public Graph next() {
        return up().graph();
    }

    @Override
    public Set<Graph> before() {
        return before(this);
    }
}
