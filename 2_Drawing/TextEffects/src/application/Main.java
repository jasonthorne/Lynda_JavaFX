package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
			root.getChildren().addAll(makePerspective(), makeDropShadow(), makeReflection());
			
			
			
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
	
	
	static Node makePerspective() {
		
		//create a group obj:
		Group group = new Group();
		
		//create a PerspectiveTransform obj:
		PerspectiveTransform perspectiveTransform = new PerspectiveTransform();
		//set coords:
		perspectiveTransform.setUlx(10.0f);
		perspectiveTransform.setUly(10.0f);
		perspectiveTransform.setUrx(210.0f);
		perspectiveTransform.setUry(40.0f);
		perspectiveTransform.setLrx(210.0f);
		perspectiveTransform.setLry(60.0f);
		perspectiveTransform.setLlx(10.0f);
		perspectiveTransform.setLly(90.0f);
		
		//set the perspective effect to the group:
		group.setEffect(perspectiveTransform);
		group.setCache(true); //cache the node as a bitmap for increased rendering performance +++++++++
		
		//create rectangle:
		Rectangle rectangle = new Rectangle();
		rectangle.setX(10.0f);
		rectangle.setY(10.0f);
		rectangle.setWidth(280.0f);
		rectangle.setHeight(80.0f);
		rectangle.setFill(Color.DODGERBLUE);
		
		//create text:
		Text text = new Text();
		text.setX(20.0f);
		text.setY(65.0f);
		text.setText("Perspective effect");
		text.setFill(Color.WHITE);
		text.setFont(Font.font("null", FontWeight.BOLD, 36)); //font family is set to null, 32 is for size (in px) ++++++++++

		//add rectangle and text to group (which has been given the perspective transform effect)
		group.getChildren().addAll(rectangle, text);
		
		return group; //return group node
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
