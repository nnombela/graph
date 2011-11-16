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
    Node bind(Graph graph, Node.Duality duality, Link.Direction direction);
    void unbind(Graph graph);

    Node up();
}
