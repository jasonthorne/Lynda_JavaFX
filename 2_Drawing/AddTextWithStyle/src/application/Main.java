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
			
			//create BorderPane:
			BorderPane pane = new BorderPane(); //(BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			
			//Add boxes with strings to each section of the BorderPane:
			pane.setTop(addHBox("Top")); //add a Hbox with string to the top section of the BorderPane
			pane.setLeft(addVBox("Left")); //add a Vbox with string to the top section of the BorderPane
			pane.setRight(addVBox("Right")); //add a Vbox with string to the top section of the BorderPane
			pane.setBottom(addHBox("Bottom")); //add a Hbox with string to the top section of the BorderPane
			
			
			Scene scene = new Scene(pane,400,450);
			
			//added styling to H & V boxes in stylesheet below ++++++++
			scene.getStylesheets().add(getClass().getResource("textStyle.css").toExternalForm());
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
