package fgraph.impl.node;

import fgraph.*;
import fgraph.impl.GraphObjectAbstract;
import fgraph.impl.link.LinkImpl;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 8/06/11
 */
public class LinksImpl extends LinksAbstract {
    protected Link[] objs = new Link[2];
    protected int size = 0;

    public Link get(int index) {
        return objs[index];
    }

    @Override
    public Link[] toArray() {
        Link[] array = new Link[size];
        System.arraycopy(objs, 0, array, 0, size);
        return array;
    }

    protected void set(Link g, int index) {
        objs[index] = g;
    }

    protected void reserve(int capacity) {
        if (objs.length < capacity) {
            Link[] newObjs = new Link[capacity];
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


    public Link add(Link g) {
        accommodate();
        set(g, size++);
        ((GraphObjectAbstract)g).setOwner(this);
        return g;
    }

    @Override
    public Link addNew() {
        return add((Link)factory().create(Type.link, ordinal()));
    }

    public boolean remove(Link g) {
        int i = index(g);
        if (i != -1) {
            set(get(--size), i);
            objs[size] = null;
            return true;
        } else {
            return false;
        }
    }

    public boolean swap(Link g1, Link g2) {
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
