package fgraph;

import java.util.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 5/01/11
 */
public abstract class GraphFactory {
    protected static Set<GraphFactory> factories = Collections.synchronizedSet(new HashSet<GraphFactory>());

    static Set<GraphFactory> factories() {
        return factories;
    }

    static void register(GraphFactory gf) {
        factories.add(gf);
    }

    static void deregister(GraphFactory gf) {
        factories.remove(gf);
    }


    public abstract String name();

    public abstract GraphObject create(GraphObject.Type type);
}
