package fgraph.impl;

import fgraph.GraphFactory;
import fgraph.GraphObject;

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
    public String name() {
        return "default";
    }

    @Override
    public GraphObject create(GraphObject.Type type) {
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
