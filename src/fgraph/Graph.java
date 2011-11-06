package fgraph;

import java.util.Set;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */
public interface Graph extends GraphObject {
    Nodes nodes();

    // ---- Duality
    Nodes nodes(Node.Duality duality);

    // --- Fractal
    Node bind(Graph graph);
    void unbind(Graph graph);

    Node up();
    Graph next();
    Set<Graph> before();
}
