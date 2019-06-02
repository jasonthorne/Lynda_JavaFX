package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.transform.Rotate;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class Main extends Application {
	
	//for other effects, check out: JAVAFX.SECENE.TRANSFORM +++++++++++ 
	
	//rotate angle must be defined outside of start (so it's current value is available inside the .setOnAction method): ++++++++++++++++
	double angle = 0.0;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//==================
			
			//create a transform Obj called 'rotate':
			Rotate rotate = new Rotate();
			
			//create button:
			Button btnRotate = new Button("click to rotate");
			
			//add the transform to button:
			btnRotate.getTransforms().add(rotate);
			
			//create and set eventhandler (to rotate button):
			btnRotate.setOnAction((ActionEvent e)->{
				
				angle += 15; //increase angle by 15 degrees
				rotate.setAngle(angle); //set the buttons's new angle
				//rotate on the button on it's pivot point (pivot point being the center of the button)
				rotate.setPivotX(btnRotate.getWidth()/2); //x point is center of width
				rotate.setPivotY(btnRotate.getHeight()/2); //y point is center of height
			});
			
			
			FlowPane root = new FlowPane();
			
			//center align root:
			root.setAlignment(Pos.CENTER);
			root.setPadding(new Insets(25,25,25,25)); //add padding to root
			
			//add button to root:
			root.getChildren().add(btnRotate);
			//==================
			
			
			Scene scene = new Scene(root,400,400);
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
