package fgraph;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 3/01/11
 */


// The name link (half-edge) is kind of ugly, maybe I should rename it to link, port, endpoint, or let (inlet/outlet)

public interface Link extends GraphObject {
    void bind(Link link);
    void unbind(Link link);
    void unbind();

    Node to();
    Node node();

    Links belongsTo();
    Link pair();

    // ---- Direction
    enum Direction {
        none, in, out;

        public Direction reverse() {
            return this == in? out : this == out? in : none;
        }

        public boolean is(Direction direction) {
            return this == direction;
        }
    }

    Link reverse();
    Direction direction();

    // ---- Fractal

    Link inverse();
    Node down();
}
