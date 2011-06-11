package fgraph;

import java.util.Set;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */
public interface Graph extends Nodes {
    Nodes nodes(Node.Duality duality);

    Node up();
    void setUp(Node up);

    Graph next();
    Set<Graph> before();
}
