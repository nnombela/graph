package rgraph;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: nnombela
 * Date: 5/01/11
 * Time: 13:58
 * To change this template use File | Settings | File Templates.
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
