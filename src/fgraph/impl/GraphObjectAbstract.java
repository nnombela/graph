package fgraph.impl;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 7/06/11
 */
public abstract class GraphObjectAbstract implements GraphObject {
    protected GraphObject owner;

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
        if (this instanceof Graph) {
            return (Graph)this;
        }

        GraphObject gobj = owner;

        while(gobj != null && !(gobj instanceof Graph)) {
            gobj = owner.belongsTo();
        }
        return (Graph)owner;
    }

    public Node node() {
        if (this instanceof Node) {
            return (Node)this;
        }

        GraphObject gobj = owner;

        while(gobj != null && !(gobj instanceof Node)) {
            gobj = owner.belongsTo();
        }
        return (Node)owner;
    }

    public Halfedge halfedge() {
        if (this instanceof Node) {
            return (Halfedge)this;
        }
        return null;
    }

}
