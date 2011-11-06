package fgraph.impl.node;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 8/06/11
 */
public class FracNodeImpl extends NodeImpl {
    protected Graph down;
    protected Link up;

    @Override
    public GraphFactory factory() {
        return GraphFactory.get("fractal-graph");
    }

    public FracNodeImpl() {
        this(new LinksImpl());
    }

    public FracNodeImpl(Links links) {
        super(links);
    }


    public void free() {
        free(up);
        free(down);
        super.free();
    }

    @Override
    public Graph down() {
        return down;
    }

    @Override
    public Link up() {
        return up;
    }

}
