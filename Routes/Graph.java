
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
    
    public class Node {
        private char symbol;
        private ArrayList<Object[]> links = new ArrayList<Object[]>();
        private final int MAX_DIST = 128;
        
        public Node(char c) {
            this.symbol = c;
        }
        
        public boolean addLink(Node v, char dist) {
            if (Graph.getNodes().contains(v) && dist < MAX_DIST && dist >= 0) {
                Object[] vals = {v, dist};
                links.add(vals);
                return true;
            }
            return false;
        }
    }
}
