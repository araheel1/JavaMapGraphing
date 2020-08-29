
/**
 * Write a description of class Graph here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;

public class Graph {
    private static ArrayList<Node> nodes = new ArrayList<>();
    
    public static void addNode(Node n) {
        nodes.add(n);
    }
    
    public static ArrayList<Node> getNodes() {
        return nodes;
    }
    
    
}
