package fgraph.impl.node;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 8/06/11
 */
public class HalfesImpl extends HalfesAbstract {
    protected Halfe[] objs = new Halfe[1];
    protected int size = 0;

    public Halfe get(int index) {
        return objs[index];
    }

    protected void set(Halfe g, int index) {
        objs[index] = g;
    }

    protected void reserve(int capacity) {
        if (objs.length < capacity) {
            Halfe[] newObjs = new Halfe[capacity];
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


    public Halfe add(Halfe g) {
        accommodate();
        set(g, size++);
        g.setOwner(this);
        return g;
    }

    @Override
    public Halfe addNew() {
        return add((Halfe)factory().create(Type.halfe, ordinal()));
    }

    public boolean remove(Halfe g) {
        int i = index(g);
        if (i != -1) {
            set(get(--size), i);
            objs[size] = null;
            return true;
        } else {
            return false;
        }
    }

    public boolean swap(Halfe g1, Halfe g2) {
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
