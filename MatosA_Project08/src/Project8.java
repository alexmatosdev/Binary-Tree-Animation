import java.util.ArrayList;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/*
 * Class: CMSC214 
 * Instructor: Cristopher Fallon
 * Date: 3/27/2022
 * Description: This class uses File to decrypt a previously encrypted class
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Alex Matos
*/

public class Project8 extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    BST<Integer> tree = new BST<>(); // Create a tree

    BorderPane pane = new BorderPane();
    BTView view = new BTView(tree); // Create a View
    pane.setCenter(view);

    TextField tfKey = new TextField();
    tfKey.setPrefColumnCount(3);
    tfKey.setAlignment(Pos.BASELINE_RIGHT);
    Button btInsert = new Button("Insert");
    Button btDelete = new Button("Delete");
    Button shwInorder = new Button("Show Inorder");
    Button shwPreorder = new Button("Show Preorder");
    Button shwPostorder = new Button("Show Postorder");
    HBox hBox = new HBox(8);
    hBox.getChildren().addAll(new Label("Enter a key: "),
      tfKey, btInsert, btDelete,shwInorder,shwPreorder,shwPostorder);
    hBox.setAlignment(Pos.CENTER);
    pane.setBottom(hBox);

    btInsert.setOnAction(e -> {
      int key = Integer.parseInt(tfKey.getText());
      if (tree.search(key)) { // key is in the tree already
        view.displayTree();
        view.setStatus(key + " is already in the tree");
      } 
      else {
        tree.insert(key); // Insert a new key
        view.displayTree();
        view.setStatus(key + " is inserted in the tree");
      }
    });

    btDelete.setOnAction(e -> {
      int key = Integer.parseInt(tfKey.getText());
      if (!tree.search(key)) { // key is not in the tree
        view.displayTree();
        view.setStatus(key + " is not in the tree");
      } 
      else {
        tree.delete(key); // Delete a key
        view.displayTree();
        view.setStatus(key + " is deleted from the tree");
      }
    });
    
    shwInorder.setOnAction(e -> {
    	HBox hBox2 = new HBox();
    	Label shwTxt = new Label("Inorder : " + tree.inorderList(new ArrayList<Integer>(), tree.root).toString());
    	hBox2.getChildren().add(shwTxt);
    	hBox2.setAlignment(Pos.TOP_CENTER);
    	pane.setTop(hBox2);
    });

    shwPreorder.setOnAction(e -> {
    	HBox hBox2 = new HBox();
    	Label shwTxt = new Label("Preorder : " + tree.preorderList(new ArrayList<Integer>(), tree.root).toString());
    	hBox2.getChildren().add(shwTxt);
    	hBox2.setAlignment(Pos.TOP_CENTER);
    	pane.setTop(hBox2);
    });
    
    shwPostorder.setOnAction(e -> {
    	HBox hBox2 = new HBox();
    	Label shwTxt = new Label("Postorder : " + tree.postorderList(new ArrayList<Integer>(), tree.root).toString());
    	hBox2.getChildren().add(shwTxt);
    	hBox2.setAlignment(Pos.TOP_CENTER);
    	pane.setTop(hBox2);
    });
    
    // Create a scene and place the pane in the stage
    Scene scene = new Scene(pane, 600, 300);
    primaryStage.setTitle("BSTAnimation"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}