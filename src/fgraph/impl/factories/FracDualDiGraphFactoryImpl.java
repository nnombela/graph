package fgraph.impl.factories;

import fgraph.GraphFactory;
import fgraph.GraphObject;
import fgraph.impl.graph.FracDualGraphImpl;
import fgraph.impl.link.FracDiLinkImpl;
import fgraph.impl.node.FracDiNodeImpl;

import java.util.Set;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 7/06/11
 */
public class FracDualDiGraphFactoryImpl extends GraphFactory {

    static {
        register(new FracDualDiGraphFactoryImpl());
    }

    @Override
    public Set<Family> families() {
        return asSet(new Family[] { Family.fractal, Family.dual, Family.directed });
    }

    @Override
    public String name() {
        return "fractal-dual-directed-graph";
    }

    @Override
    public GraphObject create(GraphObject.Type type, int ordinal) {
        if (type == GraphObject.Type.link) {
            return new FracDiLinkImpl();
        } else if (type == GraphObject.Type.node) {
            return new FracDiNodeImpl();
        } else if (type == GraphObject.Type.graph) {
            return new FracDualGraphImpl(ordinal);
        }
        throw new RuntimeException("Unknown type " + type);
    }
}
