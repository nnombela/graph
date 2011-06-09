package fgraph.impl;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 1/06/11
 */
public class HalfedgeImpl extends GraphObjectAbstract implements Halfedge {
    protected Halfedge[] pair = new Halfedge[3];  // direct, reverse, inverse
    protected Node down;

    public Type type() {
        return Type.halfedge;
    }

    @Override
    public GraphFactory factory() {
        return GraphFactory.get("default");
    }

    public void free() {
        for (Join join : Join.values()) {
            disjoin(join);
        }
        if (down != null) {
            down.free();
        }
        super.free();
    }

    public Node linksTo() {
        return pair[0].node();
    }

    public Halfedge direct() {
        return pair[0];
    }

    public Halfedge reverse() {
        return pair[1];
    }

    public Halfedge inverse() {
        return pair[2];
    }


    public Direction direction() {
        return ((Halfedges)owner).direction();
    }

    public Halfedge pair(Join join) {
        return pair[join.ordinal()];
    }

    // throws an error if they can not be joined, true if the other side is still disjoin and false otherwise
    private boolean areDisjoined(Halfedge pair, Halfedge other) {
        if (pair == null) {
            if (other == null) {
                return true;
            } else if (other == this) {
                return false;
            } else {
                throw new RuntimeException("Invalid Operation. First you need to disjoin " + other);
            }
        } else if (pair == other) {
            return false;
        }
        throw new RuntimeException("Invalid Operation. First you need to disjoin " + pair);
    }


    public Halfedge join(Join join, Halfedge halfedge) {
        int i = join.ordinal();

        if (areDisjoined(pair[i], halfedge.direct())) {
            pair[i] = halfedge;
            halfedge.join(join, this);
        } else {
            pair[i] = halfedge;
        }
        return this;
    }

    public boolean disjoin(Join join) {
        int i = join.ordinal();

        Halfedge p = pair[i];
        if (p != null) {
            pair[i] = null;
            p.disjoin(join);
            return true;
        } else {
            return false;
        }
    }

    public Node down() {
        return down;
    }

    @Override
    public void setDown(Node down) {
        if (this.down == null || down == null) {
            this.down = down;
        } else {
            throw new RuntimeException("Invalid Operation. Down node is already set by " + this.down);
        }
    }

}
