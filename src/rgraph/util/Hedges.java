package rgraph.util;

import rgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 1/02/11
 */
public class Hedges implements Container<Hedge> {

    Hedges(Graph graph) {
        graph.forEach(new Closure<Node>() {
            @Override
            public void execute(Node node) {
                node.forEach(new Closure<Link>() {
                    @Override
                    public void execute(Link link) {
                        if (link.isLinked()) {
                            add(new Hedge(link, link.linkedTo()));
                        }
                    }
                });
            }
        });
    }

    @Override
    public Iterator iterator() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Accessor accessor() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void forEach(Closure closure) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Link find(Condition condition) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long index(Hedge hedge) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long size() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean contains(Hedge hedge) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Hedge add(Hedge hedge) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Hedge addNew() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void remove(Hedge hedge) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Hedge bind(Hedge hedge) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Hedge unbind(Hedge hedge) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
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
