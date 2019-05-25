package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//+++++++++++++++++++=
			
			//create VBox root:
			VBox root =   new VBox(5);  //(5) is adding padding 
			root.setSpacing(20); //set spacing between the words
			
			
			//create and add text effect node objects to root (VBox):
			root.getChildren().addAll(makeDropShadow(), makeReflection());
			
			
			
			//+++++++++++++++++++=
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Text Effects");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	static Node makeDropShadow() {
		
		//create Text obj:
		Text text = new Text();
		text.setCache(true); //cache the node as a bitmap for increased rendering performance +++++++++
		text.setFill(Color.FIREBRICK);
		text.setText("DropShadow effect");
		text.setFont(Font.font("null", FontWeight.BOLD, 32)); //font family is set to null, 32 is for size (in px) ++++++++++
		
		//create dropshadow effect:
		DropShadow dropshadow = new DropShadow();
		dropshadow.setOffsetX(3.0);
		dropshadow.setOffsetY(3.0);
		dropshadow.setColor(Color.GRAY);
		
		//add dropshadow effect to text:
		text.setEffect(dropshadow);
		
		return text; //return text node
	}
	
	static Node makeReflection() {
		
		//create Text obj:
		Text text = new Text();
		text.setCache(true); //cache the node as a bitmap for increased rendering performance +++++++++
		text.setFill(Color.CORNFLOWERBLUE);
		text.setText("Reflection effect");
		text.setFont(Font.font("null", FontWeight.BOLD, 30)); //font family is set to null, 32 is for size (in px) ++++++++++
		
		//create reflection effect:
		Reflection reflection = new Reflection();
		reflection.setFraction(0.9);
		
		//add reflection effect to text:
		text.setEffect(reflection);
		text.setTranslateY(50);
		
		return text; //return text node
	}
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
