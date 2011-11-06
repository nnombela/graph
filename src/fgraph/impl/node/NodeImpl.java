package fgraph.impl.node;

import fgraph.*;
import fgraph.impl.GraphObjectAbstract;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 8/06/11
 */
public class NodeImpl extends GraphObjectAbstract implements Node {
    protected Links links;

    @Override
    public GraphFactory factory() {
        return GraphFactory.get("graph");
    }

    @Override
    public int index() {
        return belongsTo().index(this);
    }

    public NodeImpl() {
        this(new LinksImpl());
    }

    public NodeImpl(Links links) {
        this.links = links;
        ((GraphObjectAbstract)links).setOwner(this);
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
    public Links links() {
        return links;
    }

    @Override
    public Link bind(Node node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void unbind(Node node) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Links links(Link.Direction direction) {
        return links;
    }

    @Override
    public Node inverse() {
        return links.inverse().belongsTo();
    }

    @Override
    public Graph down() {
        return null;
    }

    @Override
    public Link up() {
        return null;
    }

}
