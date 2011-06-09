package fgraph.impl;

import fgraph.Graph;
import fgraph.GraphFactory;
import fgraph.Node;
import fgraph.Nodes;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class NodesImpl extends ContainerImpl<Node> implements Nodes {

    public Node.Duality duality() {
        Graph graph = graph();
        Nodes vertices = graph.nodes(Node.Duality.hypervertex);
        Nodes edges = graph.nodes(Node.Duality.hyperedge);

        return this == vertices? Node.Duality.hypervertex :  this == edges? Node.Duality.hyperedge : null;
    }

    public Nodes dual() {
        Graph graph = graph();
        Nodes vertices = graph.nodes(Node.Duality.hypervertex);
        Nodes edges = graph.nodes(Node.Duality.hyperedge);

        return this == vertices? edges : this == edges? vertices : graph;
    }
}
