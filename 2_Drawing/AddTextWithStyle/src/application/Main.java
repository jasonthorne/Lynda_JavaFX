package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,400,450);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//return a HBox with an added string: 
	public static HBox addHBox(String str) {
		
		HBox hBox = new HBox(); //create a HBox obj
		hBox.setId("hBox"); //add an id to textBox (for use with CSS)
		
		Text text = new Text(str); //create text obj (using passed str)
		text.setId("textStyle"); //add an id to text (for use with CSS)
		
		hBox.getChildren().add(text); //add text to HBox
		
		return hBox; //return hBox
	}
	
	//return a VBox with an added string: 
	public static VBox addVBox(String str) {
		
		VBox vBox = new VBox(); //create a VBox obj
		vBox.setId("vBox"); //add an id to textBox (for use with CSS)
		
		Text text = new Text(str); //create text obj (using passed str)
		text.setId("textStyle"); //add an id to text (for use with CSS)
		
		vBox.getChildren().add(text); //add text to VBox
		
		return vBox; //return vBox
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
