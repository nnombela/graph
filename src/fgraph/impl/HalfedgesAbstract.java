package fgraph.impl;

import fgraph.*;

/**
 * Created by IntelliJ IDEA.
 * User: nnombela
 * Date: 28/05/11
 * Time: 19:11
 * To change this template use File | Settings | File Templates.
 */
public abstract class HalfedgesAbstract extends GraphObjectAbstract implements Halfedges {

    public Type type() {
        return Type.halfedges;
    }

    public void free() {
        forEach(new Closure() {
            public void execute(Halfedge g) {
                g.free();
            }
        });
        super.free();
    }

    public Iterator iterator() {
        return new Iterator() {
            private int cursor = -1;

            public Halfedge next() {
                return get(++cursor);
            }

            public Halfedge current() {
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

            public void set(Halfedge g, Object obj) {
                objs[index(g)] = obj;
            }

            public Object get(Halfedge g) {
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

    public Halfedge find(Condition condition) {
        for(Iterator iterator = iterator(); iterator.hasNext();) {
            if (condition.check(iterator.next())) {
                return iterator.current();
            }
        }
        return null;
    }

    public int index(Halfedge g) {
        for(int i = 0; i < size(); ++i) {
            if (get(i) == g) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Halfedge g) {
        return index(g) != -1;
    }

}
