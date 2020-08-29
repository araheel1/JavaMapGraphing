import java.util.ArrayList;

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
        
        public static Node getNode(char c) {
            ArrayList<Node> nodes = Graph.getNodes();
            for (Node n : nodes) {
                if (n.symbol == c) {
                    return n;
                }
            }
            return null; // Requires validation for unavailable node symbol
        }
    }