
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
        private int row, col;
        private ArrayList<Object[]> links = new ArrayList<Object[]>();
        
        public Node(char c, int row, int col) {
            this.symbol = c;
            this.row = row;
            this.col = col;
        }
        
        public boolean addLink(Node v) {
            if (Graph.getNodes().contains(v)) {
                double dist = Math.sqrt(Math.pow(this.row-v.row, 2) + Math.pow(this.col-v.col, 2));
                Object[] vals = {v, dist};
                links.add(vals);
                return true;
            }
            return false;
        }
    }
}
