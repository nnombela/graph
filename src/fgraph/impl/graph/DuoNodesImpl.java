package fgraph.impl.graph;

import fgraph.GraphObject;
import fgraph.Node;
import fgraph.Nodes;


/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 2/06/11
 */
public class DuoNodesImpl extends NodesAbstract {
    protected NodesImpl[] containers = new NodesImpl[] { new NodesImpl(), new NodesImpl() };

    public Nodes nodes(Node.Duality duality) {
        return containers[duality.ordinal()];
    }

    public void setOwner(GraphObject owner) {
        this.containers[0].setOwner(owner);
        this.containers[1].setOwner(owner);
    }

    public Node get(int index) {
        int size0 = containers[0].size();
        return index < size0? containers[0].get(index) : containers[1].get(index - size0);
    }

    public int size() {
        return containers[0].size() + containers[1].size();
    }

    public Node add(Node g) {
        return containers[0].add(g);
    }

    @Override
    public Node addNew() {
        return containers[0].addNew();
    }

    public boolean remove(Node g) {
        return containers[0].remove(g) || containers[1].remove(g);
    }

    public boolean swap(Node g1, Node g2) {
        return containers[0].swap(g1, g2) || containers[1].swap(g1, g2);
    }

    public void free() {
        containers[0].free();
        containers[1].free();
        super.free();
    }

}
