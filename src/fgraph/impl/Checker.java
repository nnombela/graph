package fgraph.impl;

import fgraph.Graph;
import fgraph.Halfe;
import fgraph.Node;

/**
 * This class models...
 * Author: nnombela@gmail.com
 * Date: 10/06/11
 */
public class Checker {

    public static Node setDown(Halfe halfe, Node down) {
        if (halfe.down() != null && down != null) {
            throw new RuntimeException("Invalid operation. Value already set with value " + halfe.down());
        }
        if (down != null && halfe.ordinal() - down.ordinal() != 1) {
            throw new RuntimeException("Invalid operation. Wrong ordinal " + down.ordinal());
        }
        if (down != null && down.up() != null && down.up() != halfe) {
            throw new RuntimeException("Invalid operation. Linked value already set with value " + down.up());
        }
        return down;
    }

    public static Graph setDown(Node node, Graph down) {
        if (node.down() != null && down != null) {
            throw new RuntimeException("Invalid operation. Value already set with value " + node.down());
        }
        if (down != null && node.ordinal() - down.ordinal() != 1) {
            throw new RuntimeException("Invalid operation. Wrong ordinal " + down.ordinal());
        }
        if (down != null && down.up() != null && down.up() != node) {
            throw new RuntimeException("Invalid operation. Linked value already set with value " + down.up());
        }
        return down;
    }

    public static Halfe setUp(Node node, Halfe up) {
        if (node.up() != null && up != null) {
            throw new RuntimeException("Invalid operation. Value already set with value " + node.up());
        }
        if (up != null && up.ordinal() - node.ordinal() != 1) {
            throw new RuntimeException("Invalid operation. Wrong ordinal " + up.ordinal());
        }
        if (up != null && up.down() != null && up.down() != node) {
            throw new RuntimeException("Invalid operation. Linked value already set with value " + up.down());
        }
        return up;
    }

    public static Node setUp(Graph node, Node up) {
        if (node.up() != null && up != null) {
            throw new RuntimeException("Invalid operation. Value already set with value " + node.up());
        }
        if (up != null && up.ordinal() - node.ordinal() != 1) {
            throw new RuntimeException("Invalid operation. Wrong ordinal " + up.ordinal());
        }
        if (up != null && up.down() != null && up.down() != node) {
            throw new RuntimeException("Invalid operation. Linked value already set with value " + up.down());
        }
        return up;
    }

    // throws an error if they can not be joined, true if the other side is still disjoin and false otherwise
    public static int degreeDisjoined(Halfe bra, Halfe.Join join, Halfe ket) {
        Halfe braPair = bra.pair(join);
        Halfe ketPair = ket.pair(join);

        if (braPair == null) {  // are disjoined
            if (ketPair == null) {
                return 2;    // are two-way disjoined
            } else if (ketPair == bra) {
                return 1;   // are half-way disjoined
            } else {
                throw new RuntimeException("Invalid Operation. First you need to disjoin " + ket);
            }
        } else if (braPair == ket && ketPair == bra) {  // are already two-way joined
            return 0; // are already two-way joined
        }
        throw new RuntimeException("Invalid Operation. First you need to disjoin " + bra);
    }


}
