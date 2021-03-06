package fgraph.impl.link;

import fgraph.*;
import fgraph.impl.GraphObjectAbstract;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 1/06/11
 */
public class LinkImpl extends GraphObjectAbstract implements Link {
    protected LinkImpl pair;
    protected String label;

    public LinkImpl(String label) {
        this.label = label != null? label : super.label();
    }

    public String label() {
        return label;
    }

    public Type type() {
        return Type.link;
    }

    @Override
    public GraphFactory factory() {
        return GraphFactory.get("default");
    }

    public void free() {
        unbind(pair);
        super.free();
    }

    public Node to() {
        return pair.node();
    }

    public Link pair() {
        return pair;
    }

    public Link reverse() {
        return this;
    }

    public Link inverse() {
        return null;
    }

    public Direction direction() {
        return ((Links)owner).direction();
    }

    @Override
    public void bind(Link link) {
        if (belongsTo(Type.graph) == link.belongsTo(Type.graph)) {
            bind(Binding.pair, (LinkImpl)link);
        } else {
            throw new RuntimeException("Invalid Operation");
        }
    }

    @Override
    public void unbind(Link link) {
        if (pair() == link) {
            unbind(Binding.pair, (LinkImpl)link);
        } else {
            throw new RuntimeException("Invalid Operation");
        }
    }

    @Override
    public void unbind() {
        unbind(Binding.pair, (LinkImpl)pair());
    }

    // --------- Helper methods to bind/unbind
    protected enum Binding {
        pair, reverse, inverse
    }

    // throws an error if they can not be joined, 0 for disjoined, 1 half-way joined, 2 two-way joined
    protected int joinDegree(Binding binding, LinkImpl that) {
        LinkImpl thisPair = this.pair(binding);
        LinkImpl thatPair = that.pair(binding);

        if (thisPair == null) {  // are disjoined
            if (thatPair == null) {
                return 0;    // are two-way disjoined
            } else if (thatPair == this) {
                return 1;   // are half-way disjoined
            } else {
                throw new RuntimeException("Invalid Operation.");
            }
        } else if (thisPair == that && thatPair == this) {  // are already two-way joined
            return 2; // are already two-way joined
        }
        throw new RuntimeException("Invalid Operation.");
    }

    protected LinkImpl pair(Binding binding) {
        return pair;
    }

    protected void setPair(Binding binding, LinkImpl pair) {
        this.pair = pair;
    }

    protected Link bind(Binding binding, LinkImpl link) {
        int degree = joinDegree(binding, link);

        if (degree != 2) {
            setPair(binding, link);
            if (degree == 0) {
                link.bind(binding, this);
            }
        }
        return this;
    }

    protected Link unbind(Binding binding, LinkImpl link) {
        int degree = joinDegree(binding, link);

        if (degree != 0) {
            setPair(binding, null);
            if (degree == 2) {
                link.unbind(binding, this);
            }
        }
        return this;
    }

    // ---- End of helper methods to bind/unbind

    public Node down() {
        return null;
    }

    public Links belongsTo() {
        return (Links)owner;
    }

    public Node node() {
        return belongsTo().belongsTo();
    }

    public int index() {
        return belongsTo().index(this);
    }

}
