package fgraph.impl.factories;

import fgraph.*;
import fgraph.impl.graph.DualGraphImpl;
import fgraph.impl.halfedge.DiHalfedgeImpl;
import fgraph.impl.node.DiNodeImpl;

import java.util.Set;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 7/06/11
 */
public class DualDiGraphFactoryImpl extends GraphFactory {

    static {
        register(new DualDiGraphFactoryImpl());
    }

    @Override
    public Set<Family> families() {
        return asSet(new Family[] { Family.dual, Family.directed });
    }

    @Override
    public String name() {
        return "dual-directed-graph";
    }

    @Override
    public GraphObject create(GraphObject.Type type, int ordinal) {
        if (type == GraphObject.Type.halfedge) {
            return new DiHalfedgeImpl();
        } else if (type == GraphObject.Type.node) {
            return new DiNodeImpl();
        } else if (type == GraphObject.Type.graph) {
            return new DualGraphImpl();
        }
        throw new RuntimeException("Unknown type " + type);
    }
}
