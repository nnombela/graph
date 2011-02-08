package rgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */
public interface Node extends Container<Link> {
    enum Hyper { vertex, edge }

    Container<Link> links(Link.Direction direction);
    Link.Direction direction(Container<Link> links);

    Container<Link> reverse(Container<Link> links);
    Container<Link> inverse(Container<Link> links);

    Graph belongsTo();

    boolean is(Hyper hyper);
    Hyper hyper();

    Graph up();
    Link down();
}
