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
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
