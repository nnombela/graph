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
public class GraphImpl extends ContainerImpl<Node> implements Graph {
    private Node up;

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
}
