package fgraph.util;

import fgraph.*;
import org.json.simple.JSONValue;

import java.util.*;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 13/06/11
 */
public class JsonFormatter {

    GraphObject parse(String json) {
        Map map= (Map)JSONValue.parse(json);

        return null;
    }

    // Flat

    public static String format(Graph graph) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("type", graph.type());
        map.put("label", graph.label());
        map.put("families", graph.factory().families().toArray());

        if (graph.factory().contains(GraphFactory.Family.dual)) {
            map.put("nodes:hvert", graph.nodes(Node.Duality.hvert));
            map.put("hedge:hedge", graph.nodes(Node.Duality.hedge));

        } else {
            map.put("nodes", graph.nodes());
        }
        if (graph.factory().contains(GraphFactory.Family.fractal)) {
            map.put("up", graph.up());
        }
        return format(map);
    }

    public static String format(Node node) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("type", node.type());
        map.put("label", node.label());

        if (node.factory().contains(GraphFactory.Family.directed)) {
            map.put("links:in", node.links(Link.Direction.in));
            map.put("links:out", node.links(Link.Direction.out));
        } else {
            map.put("links", node.links());
        }
        if (node.factory().contains(GraphFactory.Family.fractal)) {
            map.put("up", node.up());
            map.put("down", node.down());
        }
        return format(map);
    }

    public static String format(Link link) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("type", link.type());
        map.put("label", link.label());
        map.put("pair", link.pair().label());

        if (link.factory().contains(GraphFactory.Family.directed)) {
            map.put("reverse", link.reverse().label());
        }

        if (link.factory().contains(GraphFactory.Family.fractal)) {
            map.put("inverse", link.inverse().label());
            map.put("down", link.down());
        }
        return format(map);
    }

    private static String format(Links links) {
        return format(Arrays.asList(links.toArray()));
    }

    private static String format(Nodes nodes) {
        return format(Arrays.asList(nodes.toArray()));
    }

    private static String format(Object obj) {
        StringBuilder builder = new StringBuilder();
        builder.append('"').append(obj).append('"');
        return builder.toString();
    }

    private static String format(List list) {
        StringBuilder builder = new StringBuilder();
        builder.append('[');

        Iterator it = list.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            builder.append(format(entry.getValue()));
            if (it.hasNext()) {
                builder.append(", ");
            }
        }

        builder.append(']');
        return builder.toString();
    }

    private static String format(Map map) {
        StringBuilder builder = new StringBuilder();
        builder.append('{');

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            builder.append(entry.getKey()).append(": ").append(format(entry.getValue()));
            if (it.hasNext()) {
                builder.append(", ");
            }
        }

        builder.append('}');
        return builder.toString();
    }

}
