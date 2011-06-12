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
public class GraphImpl extends GraphObjectAbstract implements Graph {
    protected Nodes nodes;
    protected Node up;
    protected int ordinal;

    public GraphImpl() {
        this(new NodesImpl());
    }
    public GraphImpl(Nodes nodes) {
        this.nodes = nodes;
        nodes.setOwner(this);
    }

    public Type type() {
        return Type.graph;
    }

    public GraphImpl(int ordinal) {
        this.ordinal = ordinal;
    }

    @Override
    public GraphFactory factory() {
        return GraphFactory.get("graph");
    }

    public void free() {
        free(up);
        super.free();
    }

    public Nodes nodes() {
        return nodes;
    }

    public Nodes nodes(Node.Duality duality) {
        return nodes;
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

    public int ordinal() {
        return ordinal;
    }
}
