package fgraph.impl.graph;

import fgraph.*;
import fgraph.impl.GraphObjectAbstract;

import java.util.Set;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class GraphImpl extends GraphObjectAbstract implements Graph {
    protected Nodes nodes;

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

    @Override
    public GraphFactory factory() {
        return GraphFactory.get("graph");
    }

    public Nodes nodes() {
        return nodes;
    }

    public Nodes nodes(Node.Duality duality) {
        return nodes;
    }

    public Node up() {
        return null;
    }

    @Override
    public void setUp(Node up) {
        throw new RuntimeException("Invalid operation");
    }

    @Override
    public Graph next() {
        return null;
    }

    @Override
    public Set<Graph> before() {
        return null;
    }

    public int ordinal() {
        return 0;
    }
}