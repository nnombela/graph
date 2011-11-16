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
    public Link bind(Node node) {
        if (graph() != node.graph()) {

            return null;
            // TODO
        } else {
            return super.bind(node);
        }
    }

    @Override
    public void unbind(final Node node) {
        if (graph() == node.graph()) {
            // TODO
        } else {
            super.unbind(node);
        }
    }

    public void setDown(Graph down) {
        if (this.down != null) {
            this.down = down;
        } else {
            throw new RuntimeException("Invalid Operation");
        }
    }

    public void setUp(Link up) {
        if (this.up != null) {
            this.up = up;
        } else {
            throw new RuntimeException("Invalid Operation");
        }
    }

}
