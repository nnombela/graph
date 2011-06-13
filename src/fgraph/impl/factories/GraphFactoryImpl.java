package fgraph.impl.factories;

import fgraph.*;
import fgraph.impl.graph.GraphImpl;
import fgraph.impl.halfedge.HalfedgeImpl;
import fgraph.impl.node.NodeImpl;

import java.util.Set;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 7/06/11
 */
public class GraphFactoryImpl extends GraphFactory {

    static {
        register(new DiGraphFactoryImpl());
        register(new DualDiGraphFactoryImpl());
        register(new DualGraphFactoryImpl());
        register(new FracDiGraphFactoryImpl());
        register(new FracDualDiGraphFactoryImpl());
        register(new FracDualGraphFactoryImpl());
        register(new GraphFactoryImpl());
    }

    @Override
    public Set<Family> families() {
        return asSet(new Family[] {  });
    }

    @Override
    public String name() {
        return "graph";
    }

    @Override
    public GraphObject create(GraphObject.Type type, int ordinal) {
        if (type == GraphObject.Type.halfedge) {
            return new HalfedgeImpl();
        } else if (type == GraphObject.Type.node) {
            return new NodeImpl();
        } else if (type == GraphObject.Type.graph) {
            return new GraphImpl();
        }
        throw new RuntimeException("Unknown type " + type);
    }
}
