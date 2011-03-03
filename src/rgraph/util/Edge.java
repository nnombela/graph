package rgraph.util;

import rgraph.*;

import static rgraph.Halfedge.Direction.*;
/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 1/02/11
 */
public class Edge implements GraphObject {
    public Node[] endpoints = new Node[2];

    private Node[] createEndpoints(Halfedge halfedge) {
        return new Node[] { halfedge.belongsTo(), halfedge.isBinded()? halfedge.bindedTo() : null };
    }

    public Edge(Halfedge halfedge) {
        this.endpoints = halfedge.is(adjacent)? createEndpoints(halfedge) : createEndpoints(halfedge.pair());
    }

    public Node[] endpoints() {
        return endpoints;
    }

    public Node source() {
        return endpoints[0];
    }

    public Node target() {
        return endpoints[1];
    }

    @Override
    public boolean is(Type type) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean is(Family family) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Type type() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Family[] families() {
        return new Family[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public GraphFactory factory() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void free() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public GraphObject belongsTo() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long ordinal() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
