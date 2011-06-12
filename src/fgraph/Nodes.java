package fgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 8/06/11
 */
public interface Nodes extends GraphObject {

    Node get(int index);

    interface Accessor {
        void set(Node g, Object obj);
        Object get(Node g);

        Object[] objects();
    }

    interface Iterator {
        Node next();
        boolean hasNext();
        Node current();
        int index();
    }

    interface Closure {
        void execute(Node g);
    }

    interface Condition {
        boolean check(Node g);
    }

    Iterator iterator();

    Accessor accessor();

    void forEach(Closure closure);

    Node find(Condition condition);

    int index(Node g);
    int size();

    boolean contains(Node g);

    Node add(Node g);
    Node addNew();
    boolean remove(Node g);
    boolean swap(Node g1, Node g2);

    Graph belongsTo();

    // Dual
    Node.Duality duality();
    Nodes dual();
}
