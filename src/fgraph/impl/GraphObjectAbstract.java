package fgraph.impl;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 7/06/11
 */
public abstract class GraphObjectAbstract implements GraphObject {
    protected GraphObject owner;

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


    public GraphObject closest(Type type) {
        return this.type() == type? this : owner.closest(type);
    }

    public Graph graph() {
        return (Graph)closest(Type.graph);
    }

    public Nodes nodes() {
        return (Nodes)closest(Type.nodes);
    }

    public Node node() {
        return (Node)closest(Type.node);
    }

    public Halfedges halfedges() {
        return (Halfedges)closest(Type.halfedges);
    }

    public Halfedge halfedge() {
        return (Halfedge)closest(Type.halfedge);
    }

    public int ordinal() {
        return owner !=null? owner.ordinal() : -1;
    }

}
