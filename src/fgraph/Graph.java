package fgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */
public interface Graph extends Nodes {
    Nodes nodes(Node.Duality duality);

    Node up();
}
