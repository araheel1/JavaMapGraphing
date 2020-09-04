

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.text.*;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.Console;
import javafx.scene.paint.Color;
import java.util.ArrayList;
//import java.util.Scanner;

/**
 * Write a description of JavaFX class Visualise here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Visualise extends Application
{
    static int MAX_ROW, MAX_COL;

    public void get_info() {
      // GraphDriver.start();
      // Scanner sin = new Scanner(System.in);
       Console input = System.console();
       //Scanner input = new Scanner(System.in);


       System.out.print("Enter max vertical coordinate: ");
       MAX_ROW = Integer.parseInt(input.readLine());
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
               Node n = new Node(node_info.charAt(0), Character.digit(node_info.charAt(2), 10),
               Character.digit(node_info.charAt(4), 10));
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
    }

    /**
     * The start method is the main entry point for every JavaFX application.
     * It is called after the init() method has returned and after
     * the system is ready for the application to begin running.
     *
     * @param  stage the primary stage for this application.
     */
    @Override
    public void start(Stage stage)
    {
       get_info();
        //Application.launch(Visualise.class, params);

        // Create a Button or any control item
        //Button myButton = new Button("Count");

        // Create a new grid pane
        //GridPane pane = new GridPane();
	       Pane canvas = new Pane();
	       canvas.setPrefSize(600,600);
        //pane.setPadding(new Insets(10, 10, 10, 10));
        //pane.setMinSize(750, 750);
        //pane.setVgap(10);
        //pane.setHgap(10);

        //set an action on the button using method reference
        //myButton.setOnAction(this::buttonClick);

        // Add the button and label into the pane
        for (Node n : Graph.getNodes()) {
	          System.out.println(n.getRow()+" "+n.getCol()+" "+n.getSymbol());
            canvas.getChildren().add(new Circle(50*(n.getRow()+1), 50*(n.getCol()+1), 10));
            Text temp_text = new Text(50*(n.getRow()+1)-10, 50*(n.getCol()+1)+40,
            String.valueOf(n.getSymbol()));
            temp_text.setFont(Font.font(30));
            canvas.getChildren().add(temp_text);
      	    ArrayList<Object[]> links = n.getLinks();
      	    for (int x=0; x<links.size(); x++) {
      	        Node n2 = (Node) links.get(x)[0];
      		      canvas.getChildren().add(new Line(50*(n.getRow()+1), 50*(n.getCol()+1),
                50*(n2.getRow()+1), 50*(n2.getCol()+1)));
      	    }
        }
	//pane.add(new Circle(10, Color.RED), 50, 50);
	//canvas.getChildren().add(pane);
        //pane.add(myLabel, 1, 0);
        //pane.add(myButton, 0, 0);

        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(canvas, 800,800);
        stage.setTitle("JavaFX Example");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
    }

    /**
     * This will be executed when the button is clicked
     * It increments the count by 1
     */
}
