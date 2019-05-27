package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//====================================
			/*
			//StackPane layout with circle:
			
			StackPane root = new StackPane();
			//create circle:
			Circle circle = new Circle(150, 125, 70); //place in center of window, with radius of 70
			root.getChildren().add(circle); //add circle to root
			
			*/
			//====================================
			//BorderPane layout with circle:
			
			BorderPane root = new BorderPane();	
			
			//create circle:
			Circle circle = new Circle(150, 125, 70); //place in center of window, with radius of 70
			root.setCenter(circle); //add circle to root (adding to center of BorderPane)
			
			//====================================
			
			Scene scene = new Scene(root,300,250);
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
