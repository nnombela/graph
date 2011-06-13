package fgraph.impl.halfedge;

import fgraph.GraphFactory;
import fgraph.Node;
import fgraph.impl.Checker;
import fgraph.impl.halfedge.DiHalfedgeImpl;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 1/06/11
 */
public class FracDiHalfedgeImpl extends DiHalfedgeImpl {
    protected Node down;

    @Override
    public GraphFactory factory() {
        return GraphFactory.get("fractal-graph");
    }

    public void free() {
        free(down);
        super.free();
    }

    public Node down() {
        return down;
    }

    @Override
    public void setDown(Node down) {
        this.down = Checker.setDown(this, down);
    }
}
