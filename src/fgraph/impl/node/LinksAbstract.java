package fgraph.impl.node;

import fgraph.*;
import fgraph.impl.GraphObjectAbstract;

/**
 * Created by IntelliJ IDEA.
 * User: nnombela
 * Date: 28/05/11
 * Time: 19:11
 * To change this template use File | Settings | File Templates.
 */
public abstract class LinksAbstract extends GraphObjectAbstract implements Links {

    public Type type() {
        return Type.links;
    }

    public Node belongsTo() {
        return (Node)owner;
    }

    @Override
    public int index() {
        return direction().ordinal();
    }

    @Override
    public Link.Direction direction() {
        Node node = belongsTo();
        Links outs = node.links(Link.Direction.out);
        Links ins = node.links(Link.Direction.in);
        return (this == outs)? Link.Direction.out : (this == ins)? Link.Direction.in : Link.Direction.none;
    }

    public Links reverse() {
        Node node = belongsTo();
        Links outs = node.links(Link.Direction.out);
        Links ins = node.links(Link.Direction.in);
        return (this == outs)? ins :  (this == ins)? outs : this;
    }

    @Override
    public Links inverse() {
        return belongsTo().up().pair().belongsTo();
    }

    public void free() {
        forEach(new Closure() {
            public void execute(Link g) {
                g.free();
            }
        });
        super.free();
    }

    public Iterator iterator() {
        return new Iterator() {
            private int cursor = -1;

            public Link next() {
                return get(++cursor);
            }

            public Link current() {
                return get(cursor);
            }

            public int index() {
                return cursor;
            }

            public boolean hasNext() {
                return cursor + 1 < size();
            }
        };
    }

    public Accessor accessor() {
        return new Accessor() {
            private Object[] objs = new Object[size()];

            public void set(Link g, Object obj) {
                objs[index(g)] = obj;
            }

            public Object get(Link g) {
                return objs[index(g)];
            }

            public Object[] objects() {
                Object[] array = new Object[objs.length];
                System.arraycopy(objs, 0, array, 0, objs.length);
                return array;
            }
        };
    }

    public void forEach(Closure closure) {
        for(Iterator iterator = iterator(); iterator.hasNext();) {
            closure.execute(iterator.next());
        }
    }

    public Link find(Condition condition) {
        for(Iterator iterator = iterator(); iterator.hasNext();) {
            if (condition.check(iterator.next())) {
                return iterator.current();
            }
        }
        return null;
    }

    public int index(Link g) {
        for(int i = 0; i < size(); ++i) {
            if (get(i) == g) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Link g) {
        return index(g) != -1;
    }

}
