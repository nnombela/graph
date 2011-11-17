package fgraph.impl.link;

import fgraph.GraphFactory;
import fgraph.Link;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 1/06/11
 */
public class DiLinkImpl extends LinkImpl {
    protected LinkImpl reverse;

    public DiLinkImpl(String label) {
        super(label);
    }

    @Override
    public GraphFactory factory() {
        return GraphFactory.get("directed-graph");
    }

    @Override
    public void bind(Link link) {
        if (belongsTo().reverse() == link.belongsTo()) {
            bind(Binding.reverse, (LinkImpl)link);
        } else {
            super.bind(link);
        }
    }

    public void unbind(Link link) {
        if (reverse() == link) {
            unbind(Binding.reverse, (LinkImpl)link);
        } else {
            super.unbind(link);
        }
    }

    protected LinkImpl pair(Binding binding) {
        return binding == Binding.reverse? reverse : super.pair(binding);
    }

    protected void setPair(Binding binding, LinkImpl pair) {
        if (binding == Binding.reverse) {
            this.reverse = pair;
        } else {
            super.setPair(binding, pair);
        }
    }

    public void free() {
        unbind(Binding.reverse, reverse);
        super.free();
    }

    public Link reverse() {
        return reverse;
    }

}
