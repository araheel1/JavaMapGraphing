

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
    //static int MAX_ROW, MAX_COL;
    static int drawlevel = 0;
    static Node curr_node = null;

    public void get_info(boolean primary_node, Node main_node) {
      // GraphDriver.start();
      // Scanner sin = new Scanner(System.in);
       Console input = System.console();
       //Scanner input = new Scanner(System.in);


       /*System.out.print("Enter max vertical coordinate: ");
       MAX_ROW = Integer.parseInt(input.readLine());
       //MAX_ROW = Integer.parseInt(input.readLine());
       System.out.print("Enter max horizontal coordinate: ");
       MAX_COL = Integer.parseInt(input.readLine());*/
       System.out.println("\nEnter node info below in the following format: ");
       System.out.println("[NODE SYMBOL],[ROW],[COLUMN]");
       System.out.println("Enter 'EOL' to finish node initialisation. \n");
       String node_info = "AAAAA";
       int node_count = 0;

       while (!(node_info.equals("N") || node_info.equals("n") || node_info.equals("No") || node_info.equals("no"))) {
           node_count += 1;
           System.out.println("Add node "+node_count+"? ");
           node_info = (input.readLine());
           if (!(node_info.equals("N") || node_info.equals("n") || node_info.equals("No") || node_info.equals("no"))) {
               System.out.println("Enter node name: ");
               String name = input.readLine();
               System.out.println("Enter node x-position: ");
               int x = Integer.parseInt(input.readLine());
               System.out.println("Enter node y-position: ");
               int y = Integer.parseInt(input.readLine());
               Node n = new Node(name, x, y);
               if (primary_node) {
                   Graph.addNode(n); // Requires input validation
               }
               else {
                 main_node.addSubnode(n);
               }

               System.out.println("Add sub-nodes? ");
               String decision = input.readLine();
               if (decision.equals("Y") || decision.equals("y") || decision.equals("Yes") || decision.equals("yes")) {
                   get_info(false, n);
               }
           }
       }


       String node_linkage = "";
       String node_linkage_1 = "";
       String node_linkage_2 = "";
       System.out.println("\nEnter node links below in the following format: ");
       System.out.println("[NODE 1],[NODE 2]");
       System.out.println("Enter 'EOL' to finish node link input. \n");
       while (!(node_linkage.equals("N") || node_linkage.equals("n") ||
       node_linkage.equals("No") || node_linkage.equals("no"))) {
           System.out.println("Add new link? ");
           node_linkage = (input.readLine());
           if (!(node_linkage.equals("N") || node_linkage.equals("n") ||
           node_linkage.equals("No") || node_linkage.equals("no"))) {
               System.out.println("Enter link node one: ");
               node_linkage_1 = (input.readLine());
               System.out.println("Enter link node two: ");
               node_linkage_2 = (input.readLine());
           }
           if (!(node_linkage.equals("N") || node_linkage.equals("n") ||
           node_linkage.equals("No") || node_linkage.equals("no"))) {
               Node n1 = Node.getNode(node_linkage_1, Graph.getNodes());
               Node n2 = Node.getNode(node_linkage_2, Graph.getNodes());
               n1.addLink(n2);
           }
       }
    }



    public void draw(Stage stage) {
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
      ArrayList<Node> nodes_to_draw;
      if (drawlevel == 0) {
        nodes_to_draw = Graph.getNodes();
      }
      else {
        nodes_to_draw = curr_node.getSubnodes();
      }
      for (Node n : nodes_to_draw) {
          //System.out.println(n.getRow()+" "+n.getCol()+" "+n.getSymbol());
          ArrayList<Object[]> links = n.getLinks();
          for (int x=0; x<links.size(); x++) {
              Node n2 = (Node) links.get(x)[0];
              canvas.getChildren().add(new Line(50*(n.getRow()+1), 50*(n.getCol()+1),
              50*(n2.getRow()+1), 50*(n2.getCol()+1)));
          }
          //canvas.getChildren().add(new Circle(50*(n.getRow()+1), 50*(n.getCol()+1), 10));
          //Button bx = new Button(""+n.getSymbol());
          Button bx = new Button(n.getName());
          bx.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00); -fx-background-radius: 60; -fx-background-insets: 0; -fx-text-fill: white; -fx-font-size: 30px;");
          bx.setLayoutX(50*(n.getRow())+25);
          bx.setLayoutY(50*(n.getCol())+25);
          canvas.getChildren().add(bx);
          bx.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
              drawlevel += 1;
              curr_node = n;
              draw(stage);
            }
          });
          /*Text temp_text = new Text(50*(n.getRow()+1)-10, 50*(n.getCol()+1)+40,
          String.valueOf(n.getSymbol()));
          temp_text.setFont(Font.font(30));
          canvas.getChildren().add(temp_text);*/
      }
      //pane.add(new Circle(10, Color.RED), 50, 50);
      //canvas.getChildren().add(pane);
      //pane.add(myLabel, 1, 0);
      //pane.add(myButton, 0, 0);

      // JavaFX must have a Scene (window content) inside a Stage (window)
      Button back = new Button("Back");
      back.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00); -fx-background-radius: 60; -fx-background-insets: 0; -fx-text-fill: white; -fx-font-size: 30px;");
      back.setLayoutX(10);
      back.setLayoutY(10);
      canvas.getChildren().add(back);
      back.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
          drawlevel = 0;
          curr_node = null;
          draw(stage);
        }
      });

      Scene scene = new Scene(canvas, 800,800);
      stage.setTitle("JavaFX Example");
      stage.setScene(scene);

      // Show the Stage (window)
      stage.show();
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
       get_info(true, null);
       draw(stage);
    }

    /**
     * This will be executed when the button is clicked
     * It increments the count by 1
     */
}
