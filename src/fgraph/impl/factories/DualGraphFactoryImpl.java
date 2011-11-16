package fgraph.impl.factories;

import fgraph.GraphFactory;
import fgraph.GraphObject;
import fgraph.impl.graph.DualGraphImpl;
import fgraph.impl.link.LinkImpl;
import fgraph.impl.node.NodeImpl;

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


    @Override
    public Set<Family> families() {
        return asSet(new Family[] { Family.dual });
    }

    @Override
    public String name() {
        return "dual-graph";
    }

    @Override
    public GraphObject create(GraphObject.Type type, int ordinal) {
        if (type == GraphObject.Type.link) {
            return new LinkImpl();
        } else if (type == GraphObject.Type.node) {
            return new NodeImpl();
        } else if (type == GraphObject.Type.graph) {
            return new DualGraphImpl(this);
        }
        throw new RuntimeException("Unknown type " + type);
    }
}
