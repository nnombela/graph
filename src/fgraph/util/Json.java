package fgraph.util;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 13/06/11
 */
public class Json {
    public static String toJson(Graph graph) {
        return "{id: '', family: '(fractal|dual|directed)', (nodes|hverts|hedges): [$id1, $id2, ...], up: $id}";
    }

    public static String toJson(Nodes nodes) {
        return "[$node_id1, $node_id2]";
    }

    public static String toJson(Node node) {
        return "{id: '',  (halfes|adjs|incs): [], up: $id, down: $id}";
    }

    public static String toJson(Halfes halfes) {
        return "[$halfe_id1, $halfe_id2]";
    }

    public static String toJson(Halfe halfe) {
        return "{id: '', converse: $id1, reverse: $id2, inverse: $id3, down: $id }";
    }


}
