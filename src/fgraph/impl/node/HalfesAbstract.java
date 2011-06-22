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
public abstract class HalfesAbstract extends GraphObjectAbstract implements Halfes {

    public Type type() {
        return Type.halfes;
    }

    public Node belongsTo() {
        return (Node)owner;
    }
    @Override
    public Halfe.Direction direction() {
        Node node = belongsTo();
        Halfes adjs = node.halfes(Halfe.Direction.adjacent);
        Halfes incs = node.halfes(Halfe.Direction.incident);
        return (this == adjs)? Halfe.Direction.adjacent : (this == incs)? Halfe.Direction.incident : Halfe.Direction.adjacent;
    }

    public Halfes reverse() {
        Node node = belongsTo();
        Halfes adjs = node.halfes(Halfe.Direction.adjacent);
        Halfes incs = node.halfes(Halfe.Direction.incident);
        return (this == adjs)? incs :  (this == incs)? adjs : this;
    }

    @Override
    public Halfes inverse() {
        return belongsTo().up().direct().belongsTo();
    }

    public void free() {
        forEach(new Closure() {
            public void execute(Halfe g) {
                g.free();
            }
        });
        super.free();
    }

    public Iterator iterator() {
        return new Iterator() {
            private int cursor = -1;

            public Halfe next() {
                return get(++cursor);
            }

            public Halfe current() {
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

            public void set(Halfe g, Object obj) {
                objs[index(g)] = obj;
            }

            public Object get(Halfe g) {
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

    public Halfe find(Condition condition) {
        for(Iterator iterator = iterator(); iterator.hasNext();) {
            if (condition.check(iterator.next())) {
                return iterator.current();
            }
        }
        return null;
    }

    public int index(Halfe g) {
        for(int i = 0; i < size(); ++i) {
            if (get(i) == g) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Halfe g) {
        return index(g) != -1;
    }

}
