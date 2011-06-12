package fgraph.impl;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class NodesImpl extends NodesAbstract {
    protected Node[] objs = new Node[1];
    protected int size = 0;

    public Node get(int index) {
        return objs[index];
    }

    protected void set(Node g, int index) {
        objs[index] = g;
    }

    protected void reserve(int capacity) {
        if (objs.length < capacity) {
            Node[] newObjs = new Node[capacity];
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


    public Node add(Node g) {
        accommodate();
        set(g, size++);
        g.setOwner(this);
        return g;
    }

    @Override
    public Node addNew() {
        return add((Node)factory().create(Type.node, ordinal()));
    }

    public boolean remove(Node g) {
        int i = index(g);
        if (i != -1) {
            set(get(--size), i);
            objs[size] = null;
            return true;
        } else {
            return false;
        }
    }

    public boolean swap(Node g1, Node g2) {
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
