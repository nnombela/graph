package fgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 8/06/11
 */
public interface Links extends GraphObject {
    Link get(int index);

    interface Accessor {
        void set(Link g, Object obj);
        Object get(Link g);

        Object[] objects();
    }

    interface Iterator {
        Link next();
        boolean hasNext();
        Link current();
        int index();
    }

    interface Closure {
        void execute(Link g);
    }

    interface Condition {
        boolean check(Link g);
    }

    Iterator iterator();

    Accessor accessor();

    void forEach(Closure closure);

    Link find(Condition condition);

    int index(Link g);
    int size();

    boolean contains(Link g);

    Link add(Link g);
    Link addNew();
    boolean remove(Link g);
    boolean swap(Link g1, Link g2);

    Node belongsTo();

    // ---- Direction

    Link.Direction direction();
    Links reverse();

    // ---- Fractal

    Links inverse();
}
