package fgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 5/01/11
 */
public interface Container<G extends GraphObject> extends GraphObject {

    interface Accessor<G> {
        void set(G g, Object obj);
        Object get(G g);

        Object[] objects();
    }

    interface Iterator<G> {
        G next();
        boolean hasNext();
    }

    interface Closure<G> {
        void execute(G g);
    }

    interface Condition<G> {
        boolean check(G g);
    }

    Iterator iterator();

    Accessor accessor();

    void forEach(Closure closure);

    G find(Condition condition);

    long index(G g);
    long size();

    boolean contains(G g);

    G add(G g);
    G addNew();
    boolean remove(G g);
    boolean swap(G g1, G g2);
}
