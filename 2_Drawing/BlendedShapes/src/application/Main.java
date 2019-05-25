package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			StackPane root =  new StackPane();
			root.getChildren().add(blendModeObjects()); //(BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,250,250);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Blended Shapes");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//returning a (group) node to add to the root ++++++++++++++++
	static Node blendModeObjects() {
		
		//create a group object:
		Group group = new Group(); 
		
		//===========
		//circle1:
		Circle circle1 = new Circle(50, 50, 25); //x point, y point, radius
		circle1.setFill(Color.DARKGRAY);
		circle1.setBlendMode(BlendMode.MULTIPLY); //'BlendMode' blends where the two shapes meet +++++++++++
		
		//rectangle1:
		Rectangle rectangle1 = new Rectangle(50, 50, 50, 50); //x pos, y pos, width, height
		rectangle1.setFill(Color.BLUEVIOLET);
		
		//===========
		
		//circle2:
		Circle circle2 = new Circle(170, 50, 25); //x point, y point, radius
		circle2.setFill(Color.CORAL);
		
		//rectangle2:
		Rectangle rectangle2 = new Rectangle(170, 50, 50, 50); //x pos, y pos, width, height
		rectangle2.setFill(Color.TEAL);
		
		//===========
		//using white rectangle to remove a piece from the circle. Add circle first, then rectangle on top.
		
		//circle3:
		Circle circle3 = new Circle(50, 150, 25); //x point, y point, radius
		circle3.setFill(Color.NAVY);
		
		//rectangle3:
		Rectangle rectangle3 = new Rectangle(50, 150, 50, 50); //x pos, y pos, width, height
		rectangle3.setFill(Color.WHITE);
		
		//===========
		
		//set blendmode (for shapes other than circle 1, which is already set)
		group.setBlendMode(BlendMode.SRC_ATOP);
		
		//add shapes to group:
		group.getChildren().addAll(rectangle1, circle1, circle2, rectangle2, circle3, rectangle3);
		
		//return group node:
		return group;
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
