package fgraph.impl.factories;

import fgraph.*;
import fgraph.impl.graph.GraphImpl;
import fgraph.impl.link.LinkImpl;
import fgraph.impl.node.NodeImpl;

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
    public Set<Family> families() {
        return asSet(new Family[] {  });
    }

    @Override
    public String name() {
        return "graph";
    }

    @Override
    public GraphObject create(GraphObject.Type type, int ordinal) {
        if (type == GraphObject.Type.link) {
            return new LinkImpl();
        } else if (type == GraphObject.Type.node) {
            return new NodeImpl();
        } else if (type == GraphObject.Type.graph) {
            return new GraphImpl(this);
        }
        throw new RuntimeException("Unknown type " + type);
    }
}
