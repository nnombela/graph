package fgraph.util;

import fgraph.*;
import java.util.*;

/**
 * SearchIterator --
 * User: nnombela
 * Date: 10-jul-2005
 * Time: 22:32:53
 * Comment --
 */
public class SearchIterator implements Nodes.Iterator<Node> {
    public static final int BFS_1 = 0;
    public static final int DFS_1 = 1;
    public static final int BFS_2 = 2;
    public static final int DFS_2 = 3;

    protected LinkedList stack = new LinkedList();
    protected Nodes.Accessor visited;
    protected Closure closure;

    public SearchIterator(Node root, int type) {
        this.visited = (type == BFS_1 || type == DFS_1)?
                root.graph().accessor() : root.accessor();
        this.closure = getClosure(type);

        visited.set(root, Boolean.TRUE);
        stack.addLast(root);
    }

    public SearchIterator(Node root) {
        this(root, BFS_1);
    }

    public boolean hasNext() {
        return stack.size() > 0;
    }

    @Override
    public Node current() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int index() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }


    public Node next() {
        if (hasNext()) {
            Node helem = (Node)stack.removeFirst();
            helem.forEach(closure);
            return helem;
        }
        throw new NoSuchElementException();
    }

    private Closure getClosure(int type) {
        switch(type) {
            case BFS_1: return getBfsClosure();
            case DFS_1: return getDfsClosure();
            case BFS_2: return get2ndClosure(getBfsClosure());
            case DFS_2: return get2ndClosure(getDfsClosure());

            default:
                throw new RuntimeException("Unknowned type: " + type);
        }
    }

    protected abstract class Closure implements Container.Closure {
        public void execute(Halfedge hlink) {
            executeIfNotVisited(hlink.linksTo());
        }

        private void executeIfNotVisited(Node connTo) {
            if (connTo != null && visited.get(connTo) == null) {
                visited.set(connTo, Boolean.TRUE);
                execute(connTo);
            }
        }

        public abstract void execute(Node node);

        @Override
        public void execute(GraphObject graphObject) {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    protected Closure getBfsClosure() {
        return new Closure() {
            public void execute(Node helem) {
                stack.addLast(helem);
            }
        };
    }

    protected Closure getDfsClosure() {
        return new Closure() {
            public void execute(Node helem) {
                stack.addFirst(helem);
            }
        };
    }

    protected Closure get2ndClosure(final Closure closure) {
        return new Closure() {
            public void execute(Node connTo) {
                connTo.forEach(closure);
            }
        };
    }

}
