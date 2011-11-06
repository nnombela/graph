package fgraph.impl;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 7/06/11
 */
public abstract class GraphObjectAbstract implements GraphObject {
    protected GraphObject owner;

    public GraphFactory factory() {
        return owner.factory();
    }

//    public int index() {
//        switch (type()) {
//            case link: return links().index((Link)this);
//            case links: return ((Links)this).direction().ordinal();
//            case node: return nodes().index((Node) this);
//            case nodes: return ((Nodes)this).duality().ordinal();
//            case graph: return ordinal();
//        }
//        throw new RuntimeException();
//    }

    public String label() {
        StringBuilder buffer = new StringBuilder();
        if (owner != null) {
            buffer.append('[').append(owner.label()).append("]:");
        }
        buffer.append(type().name()).append(':').append(index());
        return buffer.toString();
    }

    protected static void free(GraphObject gobj) {
        if (gobj != null) {
            gobj.free();
        }
    }

    public void free() {
        owner = null;
    }

    public GraphObject belongsTo() {
        return owner;
    }

    public void setOwner(GraphObject owner) {
        if (this.owner == null) {
            this.owner = owner;
        } else {
            throw new RuntimeException("Already owned by " + owner);
        }
    }


    public GraphObject belongsTo(Type type) {
        return this.type() == type? this : owner.belongsTo(type);
    }

    public Graph graph() {
        return (Graph) belongsTo(Type.graph);
    }

    public Nodes nodes() {
        return (Nodes) belongsTo(Type.nodes);
    }

    public Node node() {
        return (Node) belongsTo(Type.node);
    }

    public Links links() {
        return (Links) belongsTo(Type.links);
    }

    public Link link() {
        return (Link) belongsTo(Type.link);
    }

    public int ordinal() {
        return owner !=null? owner.ordinal() : -1;
    }

}
