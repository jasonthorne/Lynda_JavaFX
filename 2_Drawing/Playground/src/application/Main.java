package application;
	

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			
		
			//=================================
			
			//make seesaw line:
			Line seesaw = new Line(60,340,340,140); //x & y pos for start (60,340),  x & y pos for end (340,140).
			seesaw.setStroke(Color.BLACK);
			seesaw.setStrokeWidth(15);
			
			//make circle:
			Circle circle = new Circle(70, 280, 40); //x & y point for the middle of circle (70,280), radius of circle (40)
			circle.setStroke(Color.RED);
			circle.setStrokeWidth(5);
			circle.setFill(Color.ORANGE);
			
			//make rectangle:
			Rectangle rectangle = new Rectangle(240, 90, 80, 70); ///x & y pos (240, 90), width (80), height (70)
			rectangle.setStroke(Color.GREEN);
			rectangle.setStrokeWidth(5);
			rectangle.setFill(Color.YELLOWGREEN);
			
			//make left line:
			Line left = new Line(200,240,160,340); //x & y pos for start (200,240),  x & y pos for end (160,340).
			left.setStrokeWidth(5);
			
			//make right line:
			Line right = new Line(200,240,240,340); //x & y pos for start (200,240),  x & y pos for end (160,340).
			right.setStrokeWidth(5);
			
			//make sun:
			Circle sun = new Circle(-50, -50, 140); //x & y point for middle of circle (-50,-50), radius of circle (140) //purposely off screen to only show half of sun.
			sun.setStroke(Color.YELLOW);
			sun.setFill(Color.YELLOW);
			
			//add shapes to root:
			root.getChildren().addAll(seesaw,circle, rectangle, left, right, sun);
			
			Scene scene = new Scene(root, 400, 400, Color.SKYBLUE); //change background colour to sky blue.
			
			//=================================
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
