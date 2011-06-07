package fgraph.impl;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import fgraph.GraphFactory;
import fgraph.GraphObject;

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
}
