package fgraph.impl;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class DualContainerImpl<G extends GraphObject> extends ContainerAbstract<G> {
    private ContainerImpl<G> left;
    private ContainerImpl<G> right;

    public DualContainerImpl(GraphObject belongsTo, Type type) {
        super(belongsTo, type);
        this.left = new ContainerImpl<G>(belongsTo, type);
        this.right = new ContainerImpl<G>(belongsTo, type);
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

    public boolean remove(G g) {
        return left.remove(g) || right.remove(g);
    }

    public boolean swap(G g1, G g2) {
        return left.swap(g1, g2) || right.swap(g1, g2);
    }

}
