package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		
			Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root, 300, 275);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
