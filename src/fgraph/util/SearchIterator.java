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
public class SearchIterator implements Nodes.Iterator {
    public static final int BFS_1 = 0;
    public static final int DFS_1 = 1;
    public static final int BFS_2 = 2;
    public static final int DFS_2 = 3;

    protected LinkedList<Node> stack = new LinkedList<Node>();
    protected Nodes.Accessor visited;
    protected Closure closure;
    protected Node current;
    int index = 0;

    public SearchIterator(Node root, int type) {
        Nodes nodes = (type == BFS_1 || type == DFS_1)? root.graph().nodes() : root.nodes();
        this.visited = nodes.accessor();
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
        return current;
    }

    @Override
    public int index() {
        return index;
    }


    public Node next() {
        if (hasNext()) {
            current = stack.removeFirst();
            ++index;
            current.nodes().forEach(closure);
            return current;
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
                throw new RuntimeException("Unknown type: " + type);
        }
    }

    protected abstract class Closure implements Halfedges.Closure, Nodes.Closure {
        public void execute(Halfedge hlink) {
            Node connTo = hlink.linksTo();
            if (connTo != null && visited.get(connTo) == null) {
                visited.set(connTo, Boolean.TRUE);
                execute(connTo);
            }
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
                connTo.nodes().forEach(closure);
            }
        };
    }

}
