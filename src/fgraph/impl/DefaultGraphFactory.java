package fgraph.impl;

import fgraph.impl.factories.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 13/06/11
 */
public class DefaultGraphFactory extends GraphFactoryImpl {
    static {
        register(new DiGraphFactoryImpl());
        register(new DualDiGraphFactoryImpl());
        register(new DualGraphFactoryImpl());
        register(new FracDiGraphFactoryImpl());
        register(new FracDualDiGraphFactoryImpl());
        register(new FracDualGraphFactoryImpl());
        register(new GraphFactoryImpl());
    }

}
