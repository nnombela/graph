package rgraph;

/**
 * Created by IntelliJ IDEA.
 * User: nnombela
 * Date: 3/01/11
 * Time: 15:33
 * To change this template use File | Settings | File Templates.
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
