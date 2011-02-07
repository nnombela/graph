package rgraph;

/**
 * Created by IntelliJ IDEA.
 * User: nnombela
 * Date: 3/01/11
 * Time: 15:32
 * To change this template use File | Settings | File Templates.
 */
public interface Graph extends Container<Node> {
    Container<Node> nodes(Node.Hyper hyper);
    Node.Hyper hyper(Container<Node> nodes);

    Container<Node> dual(Container<Node> nodes);

    Node down();
}
