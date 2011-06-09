package fgraph.impl;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class GraphImpl extends ContainerImpl<Node> implements Graph {
    private Node up;

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
        if (this.up == null || up == null) {
            this.up = up;
        } else {
            throw new RuntimeException("Invalid Operation. Down node is already set by " + this.up);
        }
    }
}
