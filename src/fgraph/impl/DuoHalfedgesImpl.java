package fgraph.impl;

import fgraph.GraphObject;
import fgraph.Halfedge;
import fgraph.Halfedges;

import java.lang.reflect.Array;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class DuoHalfedgesImpl extends HalfedgesAbstract {
    protected HalfedgesImpl[] containers;

    public DuoHalfedgesImpl()  {
        this.containers = new HalfedgesImpl[2];
        this.containers[0] = new HalfedgesImpl();
        this.containers[1] = new HalfedgesImpl();

        this.containers[0].setOwner(this);
        this.containers[1].setOwner(this);
    }

    public Halfedge get(int index) {
        int size0 = containers[0].size();
        return index < size0? containers[0].get(index) : containers[1].get(index - size0);
    }

    public int size() {
        return containers[0].size() + containers[1].size();
    }

    public Halfedge add(Halfedge g) {
        return containers[0].add(g);
    }

    @Override
    public Halfedge addNew() {
        return containers[0].addNew();
    }

    public boolean remove(Halfedge g) {
        return containers[0].remove(g) || containers[1].remove(g);
    }

    public boolean swap(Halfedge g1, Halfedge g2) {
        return containers[0].swap(g1, g2) || containers[1].swap(g1, g2);
    }

    @Override
    public Halfedge.Direction direction() {
        return null;
    }

    @Override
    public Halfedges reverse() {
        return this;
    }

    @Override
    public Halfedges inverse() {
        return node().inverse();
    }

    public void free() {
        containers[0].free();
        containers[1].free();
        super.free();
    }

}
