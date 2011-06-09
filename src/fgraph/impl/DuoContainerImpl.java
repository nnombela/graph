package fgraph.impl;

import fgraph.*;

import java.lang.reflect.Array;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class DuoContainerImpl<G extends GraphObject> extends ContainerAbstract<G> {
    protected ContainerImpl<G>[] containers;

    public DuoContainerImpl(Class clazz)  {
        try {
            this.containers =(ContainerImpl<G>[]) Array.newInstance(clazz, 2);
            this.containers[0] = (ContainerImpl<G>) clazz.newInstance();
            this.containers[1] = (ContainerImpl<G>) clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        this.containers[0].setOwner(this);
        this.containers[1].setOwner(this);
    }

    public G get(int index) {
        int size0 = containers[0].size();
        return index < size0? containers[0].get(index) : containers[1].get(index - size0);
    }

    public int size() {
        return containers[0].size() + containers[1].size();
    }

    public G add(G g) {
        return containers[0].add(g);
    }

    @Override
    public G addNew() {
        return containers[0].addNew();
    }

    public boolean remove(G g) {
        return containers[0].remove(g) || containers[1].remove(g);
    }

    public boolean swap(G g1, G g2) {
        return containers[0].swap(g1, g2) || containers[1].swap(g1, g2);
    }

    public void free() {
        containers[0].free();
        containers[1].free();
        super.free();
    }

}
