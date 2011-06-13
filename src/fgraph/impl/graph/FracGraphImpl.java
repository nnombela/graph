package fgraph.impl.graph;

import fgraph.Graph;
import fgraph.GraphFactory;
import fgraph.Node;
import fgraph.Nodes;
import fgraph.impl.Checker;
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

    @Override
    public void setUp(Node up) {
        this.up = Checker.setUp(this, up);
    }

    @Override
    public Graph next() {
        return up.graph();
    }

    @Override
    public Set<Graph> before() {
        final Set<Graph> graphs = new HashSet<Graph>();

        nodes().forEach(new Nodes.Closure() {
            public void execute(Node g) {
                if (g.down() != null) {
                    graphs.add(g.down().graph());
                }
            }
        });
        return graphs;
    }

    public int ordinal() {
        return ordinal;
    }
}
