package fgraph.impl.link;

import fgraph.Link;
import fgraph.Node;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 1/06/11
 */
public class FracDiLinkImpl extends DiLinkImpl {
    protected LinkImpl inverse;
    protected Node down;

    @Override
    public void bind(Link link) {
        if (node().inverse() == link.node()) {
            bind(Binding.inverse, (LinkImpl)link);
        } else {
            super.bind(link);
        }
    }

    public void unbind(Link link) {
        if (inverse() == link) {
            unbind(Binding.inverse, (LinkImpl)link);
        } else {
            super.unbind(link);
        }
    }

    protected LinkImpl pair(Binding binding) {
        return binding == Binding.inverse? pair : super.pair(binding);
    }

    protected void setPair(Binding binding, LinkImpl pair) {
        if (binding == Binding.inverse) {
            this.inverse = pair;
        } else {
            this.setPair(binding, pair);
        }
    }

    public void free() {
        unbind(Binding.inverse, inverse);
        super.free();
    }

    public Link inverse() {
        return inverse;
    }

    public Node down() {
        return down;
    }

}
