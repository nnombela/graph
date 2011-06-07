package fgraph;

import java.util.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 5/01/11
 */
public abstract class GraphFactory {
    protected static Map<String, GraphFactory> factories = Collections.synchronizedMap(new HashMap<String, GraphFactory>());

    public static Collection<GraphFactory> factories() {
        return factories.values();
    }

    public static GraphFactory get(String name) {
        return factories.get(name);
    }

    protected static void register(GraphFactory gf) {
        factories.put(gf.name(), gf);
    }

    protected static void deregister(GraphFactory gf) {
        factories.remove(gf.name());
    }


    public abstract String name();

    public abstract GraphObject create(GraphObject.Type type);
}
