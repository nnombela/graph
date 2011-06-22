package fgraph.util;

import fgraph.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 13/06/11
 */
public class Json {
    public static String toJson(Graph graph) {
        return "{graph: { id: '', family: '(fractal|dual|directed)', (nodes|hverts|hedges): {} }, up: $id} }";
    }

    public static String toJson(Nodes nodes) {
        return "[$node_1, $node_2]";
    }

    public static String toJson(Node node) {
        return "{node: {id: '',  (halfes|adjs|incs): [], }";
    }

    public static String toJson(Halfes halfes) {
        return "[$halfe_1, $halfe_2]";
    }

    public static String toJson(Halfe halfe) {
        return "{halfe: { id: '', direct: $id1, reverse: $id2, inverse: $id3, down: $id }";
    }


}
