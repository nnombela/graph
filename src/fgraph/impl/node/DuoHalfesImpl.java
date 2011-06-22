package fgraph.impl.node;

import fgraph.GraphObject;
import fgraph.Halfe;
import fgraph.Halfes;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class DuoHalfesImpl extends HalfesAbstract {
    HalfesImpl[] containers = new HalfesImpl[] { new HalfesImpl(), new HalfesImpl() };

    public Halfes halfedges(Halfe.Direction direction) {
        return containers[direction.ordinal()];
    }

    public void setOwner(GraphObject owner) {
        containers[0].setOwner(owner);
        containers[1].setOwner(owner);
    }

    public Halfe get(int index) {
        int size0 = containers[0].size();
        return index < size0? containers[0].get(index) : containers[1].get(index - size0);
    }

    public int size() {
        return containers[0].size() + containers[1].size();
    }

    public Halfe add(Halfe g) {
        return containers[0].add(g);
    }

    @Override
    public Halfe addNew() {
        return containers[0].addNew();
    }

    public boolean remove(Halfe g) {
        return containers[0].remove(g) || containers[1].remove(g);
    }

    public boolean swap(Halfe g1, Halfe g2) {
        return containers[0].swap(g1, g2) || containers[1].swap(g1, g2);
    }

    public void free() {
        containers[0].free();
        containers[1].free();
        super.free();
    }
}
