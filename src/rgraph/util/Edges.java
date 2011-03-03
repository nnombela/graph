package rgraph.util;

import rgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 1/02/11
 */
public class Edges implements Container<Edge> {

    Edges(Graph graph) {
        graph.forEach(new Closure<Node>() {
            @Override
            public void execute(Node node) {
                node.forEach(new Closure<Halfedge>() {
                    @Override
                    public void execute(Halfedge halfedge) {
                        // Todo: this is wrong
                        add(new Edge(halfedge));
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
    public Halfedge find(Condition condition) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long index(Edge edge) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long size() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean contains(Edge edge) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Edge add(Edge edge) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Edge addNew() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean remove(Edge edge) {
        return false;
    }

    @Override
    public boolean swap(Edge g1, Edge g2) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
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
