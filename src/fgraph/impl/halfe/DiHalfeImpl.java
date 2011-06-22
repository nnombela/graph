package fgraph.impl.halfe;

import fgraph.GraphFactory;
import fgraph.Halfe;
import fgraph.Halfes;
import fgraph.Node;
import fgraph.impl.Checker;
import fgraph.impl.GraphObjectAbstract;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 1/06/11
 */
public class DiHalfeImpl extends GraphObjectAbstract implements Halfe {
    protected Halfe[] pair = new Halfe[3];  // direct, reverse, inverse

    public Type type() {
        return Type.halfe;
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

    public Halfe direct() {
        return pair[0];
    }

    public Halfe reverse() {
        return pair[1];
    }

    public Halfe inverse() {
        return pair[2];
    }

    public Direction direction() {
        return ((Halfes)owner).direction();
    }

    public Halfe pair(Join join) {
        return pair[join.ordinal()];
    }

    public Halfe join(Join join, Halfe halfe) {
        int degree = Checker.degreeDisjoined(this, join, halfe);

        if (degree > 0) {
            pair[join.ordinal()] = halfe;
            if (degree == 2) {
                halfe.join(join, this);
            }
        }
        return this;
    }

    public boolean disjoin(Join join) {
        Halfe thePair = pair(join);

        if (thePair != null) {
            pair[join.ordinal()] = null;
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
