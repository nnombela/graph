package fgraph.impl.factories;

import fgraph.GraphFactory;
import fgraph.GraphObject;
import fgraph.impl.*;

import java.util.Set;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 7/06/11
 */
public class DualGraphFactoryImpl extends GraphFactory {

    static {
        register(new DualGraphFactoryImpl());
    }

    public boolean has(Family family) {
        return has(this, family);
    }


    @Override
    public Set<Family> families() {
        return asSet(new Family[] { Family.fractal, Family.dual });
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
            return new NodeImpl();
        } else if (type == GraphObject.Type.graph) {
            return new DualGraphImpl();
        }
        throw new RuntimeException("Unknown type " + type);
    }
}
