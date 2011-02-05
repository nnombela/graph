package rgraph.util;

import rgraph.*;

/**
 * Created by IntelliJ IDEA.
 * User: nnombela
 * Date: 1/02/11
 * Time: 12:16
 * To change this template use File | Settings | File Templates.
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
    public GraphFactory factory() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void free() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
