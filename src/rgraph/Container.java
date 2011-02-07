package rgraph;

import javax.swing.text.GapContent;

/**
 * Created by IntelliJ IDEA.
 * User: nnombela
 * Date: 5/01/11
 * Time: 13:51
 * To change this template use File | Settings | File Templates.
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

    Link find(Condition condition);

    long index(G g);
    long size();

    boolean contains(G g);

    G add(G g);
    G addNew();
    void remove(G g);

    G bind(Container<G> g);
    G unbind(Container<G>   g);
}
