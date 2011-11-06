package fgraph.impl.node;

import fgraph.GraphObject;
import fgraph.Link;
import fgraph.Links;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class DuoLinksImpl extends LinksAbstract {
    LinksImpl[] containers = new LinksImpl[] { new LinksImpl(), new LinksImpl() };

    public Links links(Link.Direction direction) {
        return containers[direction.ordinal()];
    }

    public void setOwner(GraphObject owner) {
        containers[0].setOwner(owner);
        containers[1].setOwner(owner);
    }

    public Link get(int index) {
        int size0 = containers[0].size();
        return index < size0? containers[0].get(index) : containers[1].get(index - size0);
    }

    public int size() {
        return containers[0].size() + containers[1].size();
    }

    public Link add(Link g) {
        return containers[0].add(g);
    }

    @Override
    public Link addNew() {
        return containers[0].addNew();
    }

    public boolean remove(Link g) {
        return containers[0].remove(g) || containers[1].remove(g);
    }

    public boolean swap(Link g1, Link g2) {
        return containers[0].swap(g1, g2) || containers[1].swap(g1, g2);
    }

    public void free() {
        containers[0].free();
        containers[1].free();
        super.free();
    }
}
