package fgraph.impl;

import fgraph.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        free(up);
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

    @Override
    public Graph next() {
        return up().graph();
    }

    @Override
    public Set<Graph> before() {
        return before(this);
    }

    public int ordinal() {
        return ordinal;
    }
}
