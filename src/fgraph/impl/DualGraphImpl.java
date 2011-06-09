package fgraph.impl;

import fgraph.Container;
import fgraph.Graph;
import fgraph.Node;
import fgraph.Nodes;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class DualGraphImpl extends DuoContainerImpl<Node> implements Graph {
    protected Node up;

    public void free() {
        if (up != null) {
            up.free();
        }
        super.free();
    }

    public DualGraphImpl() {
        super(new GraphImpl(), new GraphImpl());

        left.setOwner(this);
        right.setOwner(this);
    }

    public Type type() {
        return Type.graph;
    }

    public Nodes nodes(Node.Duality duality) {
        return duality == Node.Duality.hypervertex? (Nodes)left : (Nodes)right;
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
}