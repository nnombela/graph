package fgraph.impl;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 7/06/11
 */
public abstract class GraphObjectAbstract implements GraphObject {
    protected GraphObject owner;

    public Type type() {
        return null;
    }

    public boolean is(Type type) {
        return type == type();
    }

    public GraphFactory factory() {
        return GraphFactory.get("default");
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

    public Graph graph() {
        return this instanceof Graph? (Graph)this : owner != null? owner.graph() : null;
    }

    public Node node() {
        return this instanceof Node? (Node)this : owner != null? owner.node() : null;
    }

    public Halfedge halfedge() {
        return this instanceof Halfedge? (Halfedge)this : null;
    }

}
