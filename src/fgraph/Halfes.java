package fgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 8/06/11
 */
public interface Halfes extends GraphObject {
    Halfe get(int index);

    interface Accessor {
        void set(Halfe g, Object obj);
        Object get(Halfe g);

        Object[] objects();
    }

    interface Iterator {
        Halfe next();
        boolean hasNext();
        Halfe current();
        int index();
    }

    interface Closure {
        void execute(Halfe g);
    }

    interface Condition {
        boolean check(Halfe g);
    }

    Iterator iterator();

    Accessor accessor();

    void forEach(Closure closure);

    Halfe find(Condition condition);

    int index(Halfe g);
    int size();

    boolean contains(Halfe g);

    Halfe add(Halfe g);
    Halfe addNew();
    boolean remove(Halfe g);
    boolean swap(Halfe g1, Halfe g2);

    Node belongsTo();

    // Directed
    Halfe.Direction direction();
    Halfes reverse();

    // Fractal
    Halfes inverse();
}
