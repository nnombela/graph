package fgraph.impl;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 1/06/11
 */
public class HalfedgeImpl implements Halfedge {
    private Halfedge[] pair = new Halfedge[3];  // direct, reverse, inverse
    private Container<Halfedge> container;

    public boolean is(Type type) {
        return Type.halfedge == type;
    }

    public boolean is(Family family) {
        return belongsTo().is(family);
    }

    public Type type() {
        return Type.halfedge;
    }

    public Family[] families() {
        return container.families();
    }

    public GraphFactory factory() {
        return belongsTo().factory();
    }

    public void free() {
        disjoin(Join.direct);
        disjoin(Join.reverse);
        disjoin(Join.inverse);
    }

    public Node belongsTo() {
        return (Node)container.belongsTo();
    }

    public Node linksTo() {
        return pair[0].belongsTo();
    }

    public Halfedge pair() {
        return pair[0];
    }

    public Halfedge join(Halfedge halfedge) {
        return join(Join.direct, halfedge);
    }


    public boolean disjoin() {
        return disjoin(Join.direct);
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
        if (areDisjoined(pair[join.ordinal()], halfedge.pair())) {
            pair[join.ordinal()] = halfedge;
            halfedge.join(this);
        } else {
            pair[join.ordinal()] = halfedge;
        }
        return this;
    }

    public boolean disjoin(Join join) {
        Halfedge p = pair[join.ordinal()];
        if (p != null) {
            pair[join.ordinal()] = null;
            p.disjoin(join);
            return true;
        } else {
            return false;
        }
    }

    public boolean is(Direction direction) {
        return direction == direction();
    }

    public Direction direction() {
        return belongsTo().direction(container);
    }

    public Node down() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
