

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.Console;
import java.util.Scanner;

/**
 * Write a description of JavaFX class Visualise here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Visualise extends Application
{
    // We keep track of the count, and label displaying the count:
    private int count = 0;
    private Label myLabel = new Label("0");

    /**
     * The start method is the main entry point for every JavaFX application. 
     * It is called after the init() method has returned and after 
     * the system is ready for the application to begin running.
     *
     * @param  stage the primary stage for this application.
     */
    static int MAX_ROW, MAX_COL;
    @Override
    public void start(Stage stage)
    {
       // GraphDriver.start();
        Scanner sin = new Scanner(System.in);
        
        Console input = System.console();
        //Scanner input = new Scanner(System.in);
        System.out.print("Enter max vertical coordinate: ");
        MAX_ROW = (sin.nextInt());
        //MAX_ROW = Integer.parseInt(input.readLine());
        System.out.print("Enter max horizontal coordinate: ");
        MAX_COL = Integer.parseInt(input.readLine());
        System.out.println("\nEnter node info below in the following format: ");
        System.out.println("[NODE SYMBOL],[ROW],[COLUMN]");
        System.out.println("Enter 'EOL' to finish node initialisation. \n");
        String node_info = "AAAAA";
        int node_count = 0;
        
        while (!node_info.equals("EOL")) {
            node_count += 1;
            System.out.println("Node "+node_count+": ");
            node_info = (input.readLine());
            if (!node_info.equals("EOL")) {
                Node n = new Node(node_info.charAt(0), node_info.charAt(2), node_info.charAt(4));
                Graph.addNode(n); // Requires input validation
            }
        }
        
        String node_linkage = "";
        System.out.println("\nEnter node links below in the following format: ");
        System.out.println("[NODE 1],[NODE 2]");
        System.out.println("Enter 'EOL' to finish node link input. \n");
        while (!node_linkage.equals("EOL")) {
            System.out.println("Enter link: ");
            node_linkage = (input.readLine());
            if (!node_linkage.equals("EOL")) {
                Node n1 = Node.getNode(node_linkage.charAt(0));
                Node n2 = Node.getNode(node_linkage.charAt(2));
                n1.addLink(n2);
            }
        }
        //Application.launch(Visualise.class, params);
        
        // Create a Button or any control item
        Button myButton = new Button("Count");

        // Create a new grid pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(750, 750);
        pane.setVgap(10);
        pane.setHgap(10);

        //set an action on the button using method reference
        myButton.setOnAction(this::buttonClick);

        // Add the button and label into the pane
        pane.add(myLabel, 1, 0);
        pane.add(myButton, 0, 0);

        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(pane, 800,800);
        stage.setTitle("JavaFX Example");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
    }

    /**
     * This will be executed when the button is clicked
     * It increments the count by 1
     */
    private void buttonClick(ActionEvent event)
    {
        // Counts number of button clicks and shows the result on a label
        count = count + 1;
        myLabel.setText(Integer.toString(count));
    }
}
