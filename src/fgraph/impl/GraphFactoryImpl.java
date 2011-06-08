package fgraph.impl;

import fgraph.GraphFactory;
import fgraph.GraphObject;

import java.util.HashSet;
import java.util.Set;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 7/06/11
 */
public class GraphFactoryImpl extends GraphFactory {

    static {
        register(new GraphFactoryImpl());
    }

    @Override
    public boolean has(Family family) {
        for (Family f : families()) {
            if (f == family) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<Family> families() {
        Set<Family> families = new HashSet<Family>();
        families.add(Family.directed);
        families.add(Family.dual);
        families.add(Family.fractal);
        return families;
    }

    @Override
    public String name() {
        return "directed-dual-fractal";
    }

    @Override
    public GraphObject create(GraphObject.Type type) {
        if (type == GraphObject.Type.halfedge) {
            return new HalfedgeImpl();
        } else if (type == GraphObject.Type.node) {
            return new FracDiNodeImpl();
        } else if (type == GraphObject.Type.graph) {
            return new GraphImpl();
        }
        throw new RuntimeException("Unknown type " + type);
    }
}
