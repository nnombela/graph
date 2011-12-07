package fgraph;

import fgraph.impl.factories.*;
import java.util.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 5/01/11
 */
public abstract class GraphFactory {
    static {
        register(new DiGraphFactoryImpl());
        register(new DualDiGraphFactoryImpl());
        register(new DualGraphFactoryImpl());
        register(new FracDiGraphFactoryImpl());
        register(new FracDualDiGraphFactoryImpl());
        register(new FracDualGraphFactoryImpl());
        register(new GraphFactoryImpl());
    }

    public enum Family {
        directed, dual, fractal;

        public boolean is(Family family) {
            return this == family;
        }
    }

    protected static Map<String, GraphFactory> factories = Collections.synchronizedMap(new HashMap<String, GraphFactory>());

    public static Collection<GraphFactory> factories() {
        return factories.values();
    }

    public static GraphFactory get(String name) {
        return factories.get(name);
    }

    public boolean contains(Family family) {
        return families().contains(family);
    }

    public static Set<Family> asSet(Family[] families) {
        Set<Family> set = new HashSet<Family>(families.length);
        for(Family f : families) {
            set.add(f);
        }
        return set;
    }


    public static List<GraphFactory> get(Set<Family> families) {
        List<GraphFactory> list = new ArrayList<GraphFactory>();
        for (GraphFactory factory : factories.values()) {
            if (factory.families().equals(families)) {
                list.add(factory);
            }
        }
        return list;
    }

    protected static void register(GraphFactory gf) {
        factories.put(gf.name(), gf);
    }

    protected static void deregister(GraphFactory gf) {
        factories.remove(gf.name());
    }

    public abstract Set<Family> families();

    public abstract String name();

    public abstract GraphObject create(GraphObject.Type type, String label, int ordinal);

    public GraphObject create(GraphObject.Type type, String label) {
        return create(type, label, 0);
    }

    public GraphObject create(GraphObject.Type type, int ordinal) {
        return create(type, null, ordinal);
    }

    public GraphObject create(GraphObject.Type type) {
        return create(type, null, 0);
    }
}
