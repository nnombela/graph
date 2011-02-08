package rgraph.util;

import rgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 1/02/11
 */
public class Hedge implements GraphObject {
    public Link sourceLink;
    public Link targetLink;

    public Hedge(Link sourceLink, Link targetLink) {
        this.sourceLink = sourceLink;
        this.targetLink = targetLink;
    }

    public Node source() {
        return sourceLink.belongsTo();
    }

    public Node target() {
        return targetLink.belongsTo();
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
}
