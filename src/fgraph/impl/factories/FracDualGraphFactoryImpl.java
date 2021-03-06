package fgraph.impl.factories;

import fgraph.GraphFactory;
import fgraph.GraphObject;
import fgraph.impl.graph.FracDualGraphImpl;
import fgraph.impl.link.FracLinkImpl;
import fgraph.impl.node.FracNodeImpl;

import java.util.Set;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 7/06/11
 */
public class FracDualGraphFactoryImpl extends GraphFactory {

    static {
        register(new FracDualGraphFactoryImpl());
    }

    @Override
    public Set<Family> families() {
        return asSet(new Family[] { Family.fractal, Family.dual });
    }

    @Override
    public String name() {
        return "fractal-dual-graph";
    }

    public GraphObject create(GraphObject.Type type, String label, int ordinal) {
        if (type == GraphObject.Type.link) {
            return new FracLinkImpl(label);
        } else if (type == GraphObject.Type.node) {
            return new FracNodeImpl(label);
        } else if (type == GraphObject.Type.graph) {
            return new FracDualGraphImpl(label, this, ordinal);
        }
        throw new RuntimeException("Unknown type " + type);
    }
}
