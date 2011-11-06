package fgraph.util;

import fgraph.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 13/06/11
 */
public class Json {
    public static String toJson(Graph graph) {
        //return "{label: '', family: '(fractal|dual|directed)', (nodes|hvert_nodes|hedge_nodes): [$ref1, $ref2, ...], up: $ref}";
        StringBuilder builder = new StringBuilder();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("label", graph.label());
        map.put("family", graph.factory().families().toArray());
        toJson(builder, map);


        return builder.toString();
    }

    public static String toJson(Nodes nodes) {
        return "[$node_label1, $node_label2]";
    }

    public static String toJson(Node node) {
        return "{label: '',  (links|in_links|out_links): [], up: $link_label, down: $graph_label}";
    }

    public static String toJson(Links links) {
        return "[$link_label1, $link_label2]"; // can be label or the whole object
    }

    public static String toJson(Link link) {
        return "{label: '', pair: $link_label1, reverse: $link_label2, inverse: $link_label3, down: $node_label }";
    }



    private static void toJson(StringBuilder builder, String name, Object value) {
        builder.append(name).append(": ");
        toJson(builder, value);
    }

    private static void toJson(StringBuilder builder, Object value) {
        if (value == null) {
            builder.append("null");
        } else {
            builder.append(value);
        }
    }

    private static void toJson(StringBuilder builder, Map<String, Object> map) {
        builder.append("{");

        List<String> keys = new ArrayList<String>(map.keySet());
        for (int i = 0; i < keys.size(); ++i) {
            toJson(builder, keys.get(i), map.get(keys.get(i)));
            if (i < keys.size() - 1) {
                builder.append(", ");
            }
        }
        builder.append("}");
    }

    private static void toJson(StringBuilder builder, String string) {
        builder.append("'").append(string).append("'");
    }

    private static void toJson(StringBuilder builder, Object[] array) {
        builder.append("[");
        for (int i = 0; i < array.length; ++i) {
            toJson(builder, array[i]);
            if (i < array.length - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
    }

}
