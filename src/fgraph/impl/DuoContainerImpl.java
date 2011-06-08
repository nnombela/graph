package fgraph.impl;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class DuoContainerImpl<G extends GraphObject> extends ContainerAbstract<G> {
    protected ContainerImpl<G> left;
    protected ContainerImpl<G> right;

    public DuoContainerImpl(ContainerImpl<G> left, ContainerImpl<G> right) {
        this.left = left;
        this.right = right;
    }

    public void setOwner(GraphObject owner) {
        this.left.setOwner(owner);
        this.right.setOwner(owner);
    }

    public G get(int index) {
        return index < left.size()? left.get(index) : right.get(index - left.size());
    }

    public int size() {
        return left.size() + right.size();
    }

    public G add(G g) {
        return left.add(g);
    }

    @Override
    public G addNew() {
        return left.addNew();
    }

    public boolean remove(G g) {
        return left.remove(g) || right.remove(g);
    }

    public boolean swap(G g1, G g2) {
        return left.swap(g1, g2) || right.swap(g1, g2);
    }

    public void free() {
        left.free();
        right.free();
        super.free();
    }

}
