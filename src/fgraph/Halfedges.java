package fgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 8/06/11
 */
public interface Halfedges extends GraphObject {
    Halfedge get(int index);

    interface Accessor {
        void set(Halfedge g, Object obj);
        Object get(Halfedge g);

        Object[] objects();
    }

    interface Iterator {
        Halfedge next();
        boolean hasNext();
        Halfedge current();
        int index();
    }

    interface Closure {
        void execute(Halfedge g);
    }

    interface Condition {
        boolean check(Halfedge g);
    }

    Iterator iterator();

    Accessor accessor();

    void forEach(Closure closure);

    Halfedge find(Condition condition);

    int index(Halfedge g);
    int size();

    boolean contains(Halfedge g);

    Halfedge add(Halfedge g);
    Halfedge addNew();
    boolean remove(Halfedge g);
    boolean swap(Halfedge g1, Halfedge g2);

    Node belongsTo();

    // Directed
    Halfedge.Direction direction();
    Halfedges reverse();

    // Fractal
    Halfedges inverse();
}
