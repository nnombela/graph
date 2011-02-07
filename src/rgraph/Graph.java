package rgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */
public interface Graph extends Container<Node> {
    Container<Node> nodes(Hyper hyper);

    Container<Node> dual(Container<Node> nodes);

    Node down();
}
