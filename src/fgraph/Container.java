package fgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 5/01/11
 */
public interface Container<G extends GraphObject> extends GraphObject {

    G get(int index);

    interface Accessor<G extends GraphObject> {
        void set(G g, Object obj);
        Object get(G g);

        Object[] objects();
    }

    interface Iterator<G extends GraphObject> {
        G next();
        boolean hasNext();
        G current();
        int index();
    }

    interface Closure<G extends GraphObject> {
        void execute(G g);
    }

    interface Condition<G extends GraphObject> {
        boolean check(G g);
    }

    Iterator iterator();

    Accessor accessor();

    void forEach(Closure<G> closure);

    G find(Condition<G> condition);

    int index(G g);
    int size();

    boolean contains(G g);

    G add(G g);
    G addNew();
    boolean remove(G g);
    boolean swap(G g1, G g2);
}
