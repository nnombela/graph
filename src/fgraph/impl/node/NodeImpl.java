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
    protected String label;

    public NodeImpl(String label) {
        this(label, new LinksImpl());
    }

    public NodeImpl(String label, Links links) {
        this.label = label != null? label : super.label();
        this.links = links;
        ((GraphObjectAbstract)links).setOwner(this);
    }

    public String label() {
        return label;
    }

    @Override
    public GraphFactory factory() {
        return GraphFactory.get("graph");
    }

    @Override
    public int index() {
        return belongsTo().index(this);
    }

    public Type type() {
        return Type.node;
    }

    @Override
    public Graph graph() {
        return belongsTo().belongsTo();
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
        return bind(node, Link.Direction.out);
    }

    @Override
    public Link bind(Node node, Link.Direction direction) {
        Link link = links(direction).addNew();
        link.bind(node.links(direction.reverse()).addNew());
        return link;
    }

    @Override
    public void unbind(final Node node) {
        Link link = links().find(new Links.Condition() {
            public boolean check(Link g) {
               return g.to() == node;
            }
        });
        if (link != null) {
            link.unbind(link.pair());
        } else {
            throw new RuntimeException("Invalid Operation");
        }
    }

    @Override
    public Links links(Link.Direction direction) {
        return links;
    }

    @Override
    public Node inverse() {
        return up() != null && up().pair() != null? up().pair().down() : null;
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
