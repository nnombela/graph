package fgraph.impl.halfedge;

import fgraph.*;
import fgraph.impl.Checker;
import fgraph.impl.GraphObjectAbstract;

import javax.swing.plaf.TreeUI;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 1/06/11
 */
public class HalfedgeImpl extends GraphObjectAbstract implements Halfedge {
    protected Halfedge direct;

    public Type type() {
        return Type.halfedge;
    }

    @Override
    public GraphFactory factory() {
        return GraphFactory.get("default");
    }

    public void free() {
        disjoin(Join.direct);
        super.free();
    }

    public Node linksTo() {
        return direct.node();
    }

    public Halfedge direct() {
        return direct;
    }

    public Halfedge reverse() {
        return direct;
    }

    public Halfedge inverse() {
        return null;
    }

    public Direction direction() {
        return ((Halfedges)owner).direction();
    }

    public Halfedge pair(Join join) {
        return join == Join.direct? direct : null;
    }

    public Halfedge join(Join join, Halfedge halfedge) {
        if (join != Join.direct) {
            throw new RuntimeException("Invalid operation");
        }

        int degree = Checker.degreeDisjoined(this, join, halfedge);

        if (degree > 0) {
            direct = halfedge;
            if (degree == 2) {
                halfedge.join(join, this);
            }
        }
        return this;
    }

    public boolean disjoin(Join join) {
        Halfedge thePair = pair(join);

        if (thePair != null) {
            direct = null;
            thePair.disjoin(join);
            return true;
        } else {
            return false;
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
