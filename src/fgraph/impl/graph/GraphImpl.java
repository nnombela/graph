package fgraph.impl.graph;

import fgraph.*;
import fgraph.impl.GraphObjectAbstract;


/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class GraphImpl extends GraphObjectAbstract implements Graph {
    protected GraphFactory factory;
    protected Nodes nodes;
    protected String label;

    public GraphImpl(String label, GraphFactory factory) {
        this(label, factory, new NodesImpl());
    }

    public GraphImpl(String label, GraphFactory factory, Nodes nodes) {
        this.label = label != null? label : super.label();
        this.factory = factory;
        this.nodes = nodes;
        ((GraphObjectAbstract)nodes).setOwner(this);
    }

    public String label() {
        return label;
    }

    public Type type() {
        return Type.graph;
    }

    @Override
    public GraphFactory factory() {
        return factory;
    }

    @Override
    public int index() {
        return 0;
    }

    public Nodes nodes() {
        return nodes;
    }

    public Nodes nodes(Node.Duality duality) {
        return nodes;
    }

    @Override
    public Node bind(Graph graph) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Node bind(Graph graph, Node.Duality duality, Link.Direction direction) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void unbind(Graph graph) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public Node up() {
        return null;
    }



    public int ordinal() {
        return 0;
    }
}
