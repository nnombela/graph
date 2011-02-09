package rgraph.util;

import rgraph.*;

import static rgraph.Link.Direction.*;
/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 1/02/11
 */
public class Edge implements GraphObject {
    public Link adjLink;

    public Edge(Link link) {
        this.adjLink = link.is(adjacent)? link : link.linkedTo();
    }

    public Link[] endpoints() {
        return new Link[] {adjLink, adjLink.linkedTo() };
    }

    public Node source() {
        return adjLink.belongsTo();
    }

    public Node target() {
        return adjLink.linkedTo().belongsTo();
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
