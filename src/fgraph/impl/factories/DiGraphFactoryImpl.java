package fgraph.impl.factories;

import fgraph.*;
import fgraph.impl.*;
import java.util.Set;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 7/06/11
 */
public class DiGraphFactoryImpl extends GraphFactory {

    static {
        register(new DiGraphFactoryImpl());
    }

    public boolean has(Family family) {
        return has(this, family);
    }


    @Override
    public Set<Family> families() {
        return asSet(new Family[] { Family.fractal, Family.directed });
    }

    @Override
    public String name() {
        return "digraph";
    }

    @Override
    public GraphObject create(GraphObject.Type type) {
        if (type == GraphObject.Type.halfedge) {
            return new HalfedgeImpl();
        } else if (type == GraphObject.Type.node) {
            return new DiNodeImpl();
        } else if (type == GraphObject.Type.graph) {
            return new GraphImpl();
        }
        throw new RuntimeException("Unknown type " + type);
    }
}
