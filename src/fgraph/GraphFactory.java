package fgraph;

import org.omg.IOP.CodecPackage.FormatMismatch;

import java.util.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 5/01/11
 */
public abstract class GraphFactory {
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

    public static boolean has(GraphFactory factory, Family family) {
        for (Family f : factory.families()) {
            if (f == family) {
                return true;
            }
        }
        return false;
    }

    public static Set<Family> asSet(Family[] families) {
        Set<Family> set = new HashSet<Family>();
        for(int i = 0; i < families.length; ++i) {
            set.add(families[i]);
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

    public abstract boolean has(Family family);

    public abstract Set<Family> families();

    public abstract String name();

    public abstract GraphObject create(GraphObject.Type type);
}
