package rgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */
public interface Node extends Container<Link> {
    Container<Link> links(Direction direction);

    Container<Link> reverse(Container<Link> links);
    Container<Link> inverse(Container<Link> links);

    Graph belongsTo();

    boolean is(Hyper hyper);
    Hyper type();

    Graph up();
    Link down();
}
