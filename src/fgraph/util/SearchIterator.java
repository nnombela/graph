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
    public enum Type { BFS_1, DFS_1, BFS_2, DFS_2 }

    protected LinkedList<Node> stack = new LinkedList<Node>();
    protected Nodes.Accessor visited;
    protected Closure closure;
    protected Node current;
    int index = 0;
    Type type;

    public SearchIterator(Node root, Type type) {
        Nodes nodes = (type == Type.BFS_1 || type == Type.DFS_1)? root.graph().nodes() : root.nodes();
        this.visited = nodes.accessor();
        this.closure = createClosure(type);
        this.type = type;

        visited.set(root, true);
        stack.addLast(root);
    }

    public SearchIterator(Node root) {
        this(root, Type.BFS_1);
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

    private Closure createClosure(Type type) {
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
        public void execute(Halfedge halfedge) {
            Node node = halfedge.linksTo();

            if (node != null && visited.get(node) == null) {
                visited.set(node, true);
                execute(node);
            }
        }
    }

    protected Closure getBfsClosure() {
        return new Closure() {
            public void execute(Node node) {
                stack.addLast(node);
            }
        };
    }

    protected Closure getDfsClosure() {
        return new Closure() {
            public void execute(Node node) {
                stack.addFirst(node);
            }
        };
    }

    protected Closure get2ndClosure(final Closure closure) {
        return new Closure() {
            public void execute(Node node) {
                node.nodes().forEach(closure);
            }
        };
    }

}
