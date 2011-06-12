package fgraph.impl;

import fgraph.*;

import java.util.HashSet;
import java.util.Set;

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

    protected static Set<Graph> before(Graph graph) {
        final Set<Graph> graphs = new HashSet<Graph>();

        graph.nodes().forEach(new Nodes.Closure() {
            public void execute(Node g) {
                if (g.down() != null) {
                    graphs.add(g.down().graph());
                }
            }
        });
        return graphs;
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
