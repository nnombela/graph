package fgraph.util;

import fgraph.*;

import java.util.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 13/06/11
 */
public class JsonFormatter {

    public static String toJson(Graph graph) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("label", graph.label());
        map.put("family", graph.factory().families().toArray());

        if (graph.factory().has(GraphFactory.Family.dual)) {
            map.put("hvert_nodes", graph.nodes(Node.Duality.hvert));
            map.put("hedge_nodes", graph.nodes(Node.Duality.hedge));

        } else {
            map.put("nodes", graph.nodes());
        }
        if (graph.factory().has(GraphFactory.Family.fractal)) {
            map.put("up", graph.up());
        }
        return toJson(map);
    }

    public static String toJson(Nodes nodes) {
        StringBuilder builder = new StringBuilder();
        builder.append('[');

        Nodes.Iterator it = nodes.iterator();
        while(it.hasNext()) {
            builder.append(toJson(it.next()));
            if (it.hasNext()) {
                builder.append(", ");
            }
        }

        builder.append(']');
        return builder.toString();
    }

    public static String toJson(Node node) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("label", node.label());

        if (node.factory().has(GraphFactory.Family.directed)) {
            map.put("in_links", node.links(Link.Direction.in));
            map.put("out_links", node.links(Link.Direction.out));
        } else {
            map.put("links", node.links());
        }
        if (node.factory().has(GraphFactory.Family.fractal)) {
            map.put("up", node.up());
            map.put("down", node.down());
        }
        return toJson(map);
    }

    public static String toJson(Links links) {
        StringBuilder builder = new StringBuilder();
        builder.append('[');

        Links.Iterator it = links.iterator();
        while(it.hasNext()) {
            builder.append(toJson(it.next()));
            if (it.hasNext()) {
                builder.append(", ");
            }
        }

        builder.append(']');
        return builder.toString();
    }

    public static String toJson(Link link) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("label", link.label());
        map.put("pair", link.pair().label());

        if (link.factory().has(GraphFactory.Family.directed)) {
            map.put("reverse", link.reverse().label());
            map.put("inverse", link.inverse().label());
        }

        if (link.factory().has(GraphFactory.Family.fractal)) {
            map.put("down", link.down());
        }
        return toJson(map);
    }

    private static String toJson(Object obj) {
        return obj.toString();
    }

    private static String toJson(List list) {
        StringBuilder builder = new StringBuilder();
        builder.append('[');

        Iterator it = list.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            builder.append(toJson(entry.getValue()));
            if (it.hasNext()) {
                builder.append(", ");
            }
        }

        builder.append(']');
        return builder.toString();
    }

    private static String toJson(Map map) {
        StringBuilder builder = new StringBuilder();
        builder.append('{');

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            builder.append(entry.getKey()).append(": ").append(toJson(entry.getValue()));
            if (it.hasNext()) {
                builder.append(", ");
            }
        }

        builder.append('}');
        return builder.toString();
    }

}
