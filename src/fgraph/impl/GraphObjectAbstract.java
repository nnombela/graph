package fgraph.impl;

import fgraph.*;

import javax.swing.text.TableView;

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

    public int index() {
        switch (type()) {
            case halfe: return halfes().index((Halfe)this);
            case halfes: return ((Halfes)this).direction().ordinal();
            case node: return nodes().index((Node) this);
            case nodes: return ((Nodes)this).duality().ordinal();
            case graph: return ordinal();
        }
        throw new RuntimeException();
    }

    public String id() {
        String id = type().name() + ':' + index();
        return owner != null? owner.id() + id : id;
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

    public Halfes halfes() {
        return (Halfes)closest(Type.halfes);
    }

    public Halfe halfe() {
        return (Halfe)closest(Type.halfe);
    }

    public int ordinal() {
        return owner !=null? owner.ordinal() : -1;
    }

}
