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

    public String label() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(type()).append(":").append(hashCode());
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

    public int ordinal() {
        return owner != null? owner.ordinal() : -1;
    }

}
