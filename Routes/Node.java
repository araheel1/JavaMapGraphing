import java.util.ArrayList;

public class Node {
        private String name;
        private int row, col;
        private ArrayList<Object[]> links = new ArrayList<Object[]>();
        private ArrayList<Node> subnodes = new ArrayList<>();

        public Node(String name, int row, int col) {
            this.name = name;
            this.row = row;
            this.col = col;
        }

        public boolean addLink(Node v) {
            //if (Graph.getNodes().contains(v)) {
                double dist = Math.sqrt(Math.pow(this.row-v.row, 2) + Math.pow(this.col-v.col, 2));
                Object[] vals = {v, dist};
                links.add(vals);
                return true;
            //}
            //return false;
        }

        public void addSubnode(Node n) {
            subnodes.add(n);
        }

        public ArrayList<Node> getSubnodes() {
          return subnodes;
        }

        public Character getSymbol() {
            return name.charAt(0);
        }

        public String getName() {
            return name;
        }

        public static Node getNode(String c, ArrayList<Node> nodes) {
            //ArrayList<Node> nodes = Graph.getNodes();
            for (Node n : nodes) {
                if (n.name.equals(c)) {
                    System.out.println(c);
                    return n;
                }
                if (n.getSubnodes().size() > 0) {
                    Node nx = getNode(c, n.getSubnodes());
                    if (nx != null) {
                        return nx;
                    }
                }
            }
            return null; // Requires validation for unavailable node symbol
        }


	public int getRow() {
            return row; // Requires validation for unavailable node symbol
        }

	public int getCol() {
            return col; // Requires validation for unavailable node symbol
        }


	public ArrayList<Object[]> getLinks() {
	    return links;
	}
    }
