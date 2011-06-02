package fgraph.impl;

import fgraph.Container;
import fgraph.GraphFactory;
import fgraph.GraphObject;

/**
 * Created by IntelliJ IDEA.
 * User: nnombela
 * Date: 28/05/11
 * Time: 19:11
 * To change this template use File | Settings | File Templates.
 */
public class ContainerImpl<G extends GraphObject> extends ContainerAbstract<G> {
    protected GraphObject[] objs = new GraphObject[1];
    protected int size = 0;

    public ContainerImpl(GraphObject belongsTo, Type type) {
        super(belongsTo, type);
    }

    public G get(int index) {
        return (G) objs[index];
    }

    protected void set(G g, int index) {
        objs[index] = g;
    }

    protected void reserve(int capacity) {
        if (objs.length < capacity) {
            GraphObject[] newObjs = new GraphObject[capacity];
            System.arraycopy(objs, 0, newObjs, 0, size);
            objs = newObjs;
        }
    }

    protected void accommodate() {
        if (objs.length == size()) {
            reserve((3 * (objs.length + 1)) / 2);
        }
    }

    public int size() {
        return size;
    }

    public boolean contains(G g) {
        return index(g) != -1;
    }

    public G add(G g) {
        accommodate();
        set(g, size++);
        return g;
    }

    public G addNew() {
        return add((G)factory().create(type));
    }

    public boolean remove(G g) {
        int i = index(g);
        if (i != -1) {
            set(get(--size), i);
            objs[size] = null;
            return true;
        } else {
            return false;
        }
    }

    public boolean swap(G g1, G g2) {
        int index1 = index(g1);
        int index2 = index(g2);
        if (index1 > 0 && index2 > 0) {
            set(g2, index1);
            set(g1, index2);
            return true;
        } else {
            return false;
        }
    }
}
