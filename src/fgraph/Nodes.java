package fgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 8/06/11
 */
public interface Nodes extends Container<Node> {

//    interface Iterator extends Container.Iterator<Node> {
//    }
//    interface Closure extends Container.Closure<Node> {
//    }

    Node.Duality duality();

    Nodes dual();
}
