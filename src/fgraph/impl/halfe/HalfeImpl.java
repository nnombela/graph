package fgraph.impl.halfe;

import fgraph.*;
import fgraph.impl.Checker;
import fgraph.impl.GraphObjectAbstract;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 1/06/11
 */
public class HalfeImpl extends GraphObjectAbstract implements Halfe {
    protected Halfe direct;

    public Type type() {
        return Type.halfe;
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

    public Halfe direct() {
        return direct;
    }

    public Halfe reverse() {
        return direct;
    }

    public Halfe inverse() {
        return null;
    }

    public Direction direction() {
        return ((Halfes)owner).direction();
    }

    public Halfe pair(Join join) {
        return join == Join.direct? direct : null;
    }

    public Halfe join(Join join, Halfe halfe) {
        if (join != Join.direct) {
            throw new RuntimeException("Invalid operation");
        }

        int degree = Checker.degreeDisjoined(this, join, halfe);

        if (degree > 0) {
            direct = halfe;
            if (degree == 2) {
                halfe.join(join, this);
            }
        }
        return this;
    }

    public boolean disjoin(Join join) {
        Halfe thePair = pair(join);

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

    public Halfes belongsTo() {
        return (Halfes)owner;
    }

    public Node node() {
        return belongsTo().belongsTo();
    }

}
