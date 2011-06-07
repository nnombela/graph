package fgraph.impl;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 1/06/11
 */
public abstract class HalfedgeAbstract extends GraphObjectAbstract implements Halfedge {

    public Type type() {
        return Type.halfedge;
    }

    public void free() {
        for (Join join : Join.values()) {
            disjoin(join);
        }
        super.free();
    }

    public Node linksTo() {
        return pair().node();
    }

    public Halfedge join(Halfedge halfedge) {
        return join(Join.direct, halfedge);
    }

    public Halfedge pair() {
        return pair(Join.direct);
    }

    public boolean disjoin() {
        return disjoin(Join.direct);
    }


    public boolean is(Direction direction) {
        return direction == direction();
    }

    public Direction direction() {
        return node().direction((Container<Halfedge>)belongsTo());
    }
}
