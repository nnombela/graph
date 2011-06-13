package fgraph.impl.factories;

import fgraph.GraphFactory;
import fgraph.GraphObject;
import fgraph.impl.graph.FracGraphImpl;
import fgraph.impl.halfedge.FracDiHalfedgeImpl;
import fgraph.impl.node.FracDiNodeImpl;

import java.util.Set;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 7/06/11
 */
public class FracDiGraphFactoryImpl extends GraphFactory {

    static {
        register(new FracDiGraphFactoryImpl());
    }

    @Override
    public Set<Family> families() {
        return asSet(new Family[] { Family.fractal, Family.directed });
    }

    @Override
    public String name() {
        return "fractal-directed-graph";
    }

    @Override
    public GraphObject create(GraphObject.Type type, int ordinal) {
        if (type == GraphObject.Type.halfedge) {
            return new FracDiHalfedgeImpl();
        } else if (type == GraphObject.Type.node) {
            return new FracDiNodeImpl();
        } else if (type == GraphObject.Type.graph) {
            return new FracGraphImpl(ordinal);
        }
        throw new RuntimeException("Unknown type " + type);
    }
}
