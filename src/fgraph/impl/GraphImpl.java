package fgraph.impl;

import fgraph.Container;
import fgraph.Graph;
import fgraph.Halfedge;
import fgraph.Node;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class GraphImpl extends DualContainerImpl<Node> implements Graph {
    protected Node up;

    public GraphImpl() {
        left.setOwner(this);
        right.setOwner(this);
    }

    public void free() {
        left.free();
        right.free();
        super.free();
    }


    public Type type() {
        return Type.graph;
    }

    public Container<Node> nodes(Node.Duality duality) {
        return duality == Node.Duality.hypervertex? left : right;
    }

    public Node.Duality duality(Container<Node> nodes) {
        return nodes == left? Node.Duality.hypervertex : Node.Duality.hyperedge;
    }

    public Container<Node> dual(Container<Node> nodes) {
        return nodes == left? right : nodes == right?  left : this;
    }

    public Node up() {
        return up;
    }

}
