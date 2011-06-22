package fgraph.impl.node;

import fgraph.*;
import fgraph.impl.GraphObjectAbstract;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 8/06/11
 */
public class NodeImpl extends GraphObjectAbstract implements Node {
    protected Halfes halfes;

    @Override
    public GraphFactory factory() {
        return GraphFactory.get("graph");
    }

    public NodeImpl() {
        this(new HalfesImpl());
    }
    public NodeImpl(Halfes halfes) {
        this.halfes = halfes;
        halfes.setOwner(this);
    }

    public Type type() {
        return Type.node;
    }

    public Nodes belongsTo() {
        return (Nodes)owner;
    }


    @Override
    public Duality duality() {
        return belongsTo().duality();
    }

    @Override
    public Halfes halfes() {
        return halfes;
    }

    @Override
    public Halfes halfes(Halfe.Direction direction) {
        return halfes;
    }

    @Override
    public Node inverse() {
        return halfes.inverse().belongsTo();
    }

    @Override
    public Graph down() {
        return null;
    }

    @Override
    public Halfe up() {
        return null;
    }

    @Override
    public void setDown(Graph down) {
        throw new RuntimeException("Invalid operation");
    }
    @Override
    public void setUp(Halfe up) {
        throw new RuntimeException("Invalid operation");
    }
}
