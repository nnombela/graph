package fgraph.impl.factories;

import fgraph.*;
import fgraph.impl.graph.GraphImpl;
import fgraph.impl.link.DiLinkImpl;
import fgraph.impl.node.DiNodeImpl;

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

    @Override
    public Set<Family> families() {
        return asSet(new Family[] { Family.directed });
    }

    @Override
    public String name() {
        return "directed-graph";
    }

    @Override
    public GraphObject create(GraphObject.Type type, String label, int ordinal) {
        if (type == GraphObject.Type.link) {
            return new DiLinkImpl(label);
        } else if (type == GraphObject.Type.node) {
            return new DiNodeImpl(label);
        } else if (type == GraphObject.Type.graph) {
            return new GraphImpl(label, this);
        }
        throw new RuntimeException("Unknown type " + type);
    }
}
