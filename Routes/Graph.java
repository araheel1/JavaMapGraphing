
/**
 * Write a description of class Graph here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;

public class Graph {
    private ArrayList<Character[]> links = new ArrayList<Character[]>();
    private ArrayList<Character> nodes = new ArrayList<>();
    
    public void addPath(char v1, char v2, char dist) {
        Character[] vals = {v1, v2, dist};
        links.add(vals);
    }
    
    public void addNode(char n) {
        nodes.add(n);
    }
}
