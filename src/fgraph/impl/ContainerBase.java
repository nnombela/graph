package fgraph.impl;

import fgraph.Container;
import fgraph.GraphFactory;
import fgraph.GraphObject;

/**
 * Created by IntelliJ IDEA.
 * User: nnombela
 * Date: 28/05/11
 * Time: 19:11
 * To change this template use File | Settings | File Templates.
 */
public class ContainerBase<G extends GraphObject> implements Container<G> {
    protected GraphObject[] gobjs = new GraphObject[1];
    protected int size = 0;

    protected G get(int index) {
        return (G) gobjs[index];
    }

    protected void set(G g, int index) {
        gobjs[index] = g;
    }


    public Iterator<G> iterator() {
        return new Iterator<G>() {
            private int cursor = -1;

            public G next() {
                return get(++cursor);
            }

            public boolean hasNext() {
                return cursor + 1 < size();
            }
        };
    }

    public Accessor<G> accessor() {
        return new Accessor<G>() {
            private Object[] objs = new Object[size()];

            public void set(G g, Object obj) {
                objs[index(g)] = obj;
            }

            public Object get(G g) {
                return objs[index(g)];
            }

            public Object[] objects() {
                Object[] array = new Object[objs.length];
                System.arraycopy(objs, 0, array, 0, objs.length);
                return array;
            }
        };
    }

    public void forEach(Closure<G> closure) {
        for(Iterator<G> iterator = iterator(); iterator.hasNext();) {
            closure.execute(iterator.next());
        }
    }

    public G find(Condition<G> condition) {
        for(Iterator<G> iterator = iterator(); iterator.hasNext();) {
            G g = iterator.next();
            if (condition.check(g)) {
                return g;
            }
        }
        return null;
    }

    public int index(G g) {
        for(int i = 0; i < size(); ++i) {
            if (get(i) == g) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public boolean contains(G g) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public G add(G g) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public G addNew() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean remove(G g) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean swap(G g1, G g2) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean is(Type type) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean is(Family family) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Type type() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Family[] families() {
        return new Family[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    public GraphFactory factory() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void free() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public GraphObject belongsTo() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
