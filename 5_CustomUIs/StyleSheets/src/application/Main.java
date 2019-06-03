package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;


public class Main extends Application {
	
	Label lblOutput;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//=========================================
			
			Label lbl = new Label("Press the button to see a message");
			lblOutput = new Label(null);
			lblOutput.setId("textstyle"); //giving the label an ID (for CSS styling) +++++++++++++++ 
			
			Button btn = new Button();
			btn.setText("click me...");
			btn.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					lblOutput.setText("sup, dawg!");
					
				}
				
			});
			
			FlowPane root = new FlowPane();
			root.setAlignment(Pos.CENTER);
			root.setVgap(10);
			root.setHgap(10);
			root.setOrientation(Orientation.VERTICAL);
			root.getChildren().addAll(lbl, btn, lblOutput);
			
			
			Scene scene = new Scene(root,300,250);
			
			//ANOTHER WAY of importing stylesheet: ++++++++++++++++++++
			scene.getStylesheets().add("application/application.css");
			
			//=========================================
			
			//template way of importing stylesheet:
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
