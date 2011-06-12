package fgraph.impl;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 1/06/11
 */
public class HalfedgeImpl extends GraphObjectAbstract implements Halfedge {
    protected Halfedge[] pair = new Halfedge[3];  // direct, reverse, inverse

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

    public Halfedge join(Join join, Halfedge halfedge) {
        int degree = Checker.degreeDisjoined(this, join, halfedge);

        if (degree > 0) {
            pair[join.ordinal()] = halfedge;
            if (degree == 2) {
                halfedge.join(join, this);
            }
        }
        return this;
    }

    public void disjoin(Join join) {
        Halfedge thePair = pair(join);

        if (thePair != null) {
            pair[join.ordinal()] = null;
            thePair.disjoin(join);
        }
    }

    public Node down() {
        return null;
    }

    @Override
    public void setDown(Node down) {
        throw new RuntimeException("Invalid operation");
    }

    public Halfedges belongsTo() {
        return (Halfedges)owner;
    }


}
