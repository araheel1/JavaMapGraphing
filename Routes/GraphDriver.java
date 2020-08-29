
/**
 * Write a description of class GraphDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.ArrayList;
import javafx.application.Application;

public class GraphDriver
{
    static int MAX_ROW, MAX_COL;
    public static void main(String[] params) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter max vertical coordinate: ");
        MAX_ROW = input.nextInt();
        System.out.print("Enter max horizontal coordinate: ");
        MAX_COL = input.nextInt();
        System.out.println("\nEnter node info below in the following format: ");
        System.out.println("[NODE SYMBOL],[ROW],[COLUMN]");
        System.out.println("Enter 'EOL' to finish node initialisation. \n");
        String node_info = "";
        int node_count = 0;
        
        while (node_info != "EOL") {
            node_count += 1;
            System.out.println("Node "+node_count+": ");
            node_info = input.nextLine();
            if (node_info != "EOL") {
                Node n = new Node(node_info.charAt(0), node_info.charAt(2), node_info.charAt(4));
                Graph.addNode(n); // Requires input validation
            }
        }
        
        String node_linkage = "";
        System.out.println("\nEnter node links below in the following format: ");
        System.out.println("[NODE 1],[NODE 2]");
        System.out.println("Enter 'EOL' to finish node link input. \n");
        while (node_linkage != "EOL") {
            System.out.println("Enter link: ");
            node_info = input.nextLine();
            if (node_linkage != "EOL") {
                Node n1 = Node.getNode(node_info.charAt(0));
                Node n2 = Node.getNode(node_info.charAt(2));
                n1.addLink(n2);
            }
        }
    }
}
