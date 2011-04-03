package fgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */
public interface Graph extends Container<Node> {
    Container<Node> nodes(Node.Duality duality);
    Node.Duality duality(Container<Node> nodes);

    Container<Node> dual(Container<Node> nodes);

    Node up();

    Node link(Graph graph);
    Node link(Graph graph, Node.Duality duality);
    Node unlink(Graph graph);
}
