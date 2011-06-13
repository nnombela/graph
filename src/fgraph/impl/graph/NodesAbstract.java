package fgraph.impl.graph;

import fgraph.*;
import fgraph.impl.GraphObjectAbstract;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 28/05/11
 */
public abstract class NodesAbstract extends GraphObjectAbstract implements Nodes {

    public Type type() {
        return Type.halfedges;
    }

    public Graph belongsTo() {
        return (Graph)owner;
    }

    public Node.Duality duality() {
        Graph graph = graph();
        Nodes vertices = graph.nodes(Node.Duality.hypervertex);
        Nodes edges = graph.nodes(Node.Duality.hyperedge);

        return (this == vertices)? Node.Duality.hypervertex : (this == edges)? Node.Duality.hyperedge : null;
    }

    public Nodes dual() {
        Graph graph = graph();
        Nodes vertices = graph.nodes(Node.Duality.hypervertex);
        Nodes edges = graph.nodes(Node.Duality.hyperedge);

        return (this == vertices)? edges : (this == edges)? vertices : this;
    }

    public void free() {
        forEach(new Closure() {
            public void execute(Node g) {
                g.free();
            }
        });
        super.free();
    }

    public Iterator iterator() {
        return new Iterator() {
            private int cursor = -1;

            public Node next() {
                return get(++cursor);
            }

            public Node current() {
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

            public void set(Node g, Object obj) {
                objs[index(g)] = obj;
            }

            public Object get(Node g) {
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

    public Node find(Condition condition) {
        for(Iterator iterator = iterator(); iterator.hasNext();) {
            if (condition.check(iterator.next())) {
                return iterator.current();
            }
        }
        return null;
    }

    public int index(Node g) {
        for(int i = 0; i < size(); ++i) {
            if (get(i) == g) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Node g) {
        return index(g) != -1;
    }

}
