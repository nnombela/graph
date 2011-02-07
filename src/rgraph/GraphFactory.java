package rgraph;

import java.util.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 5/01/11
 */
public class GraphFactory {
    private static Set<GraphFactory> factories = Collections.synchronizedSet(new HashSet<GraphFactory>());

    static Set<GraphFactory> getFactories() {
        return factories;
    }

    static void register(GraphFactory gf) {
        factories.add(gf);
    }

    static void deregister(GraphFactory gf) {
        factories.remove(gf);
    }


    String getName() {
        throw new RuntimeException("Not implemented");
    }

    Graph createGraph() {
        throw new RuntimeException("Not implemented");
    }
}
