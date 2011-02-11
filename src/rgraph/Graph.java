package rgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */
public interface Graph extends Container<Node> {
    Container<Node> nodes(Node.Hyper hyper);
    Node.Hyper hyper(Container<Node> nodes);

    Container<Node> dual(Container<Node> nodes);

    Node up();

    Node bind(Graph graph);
    Node bind(Graph graph, Node.Hyper hyper);
    Node unbind(Graph graph);
}
