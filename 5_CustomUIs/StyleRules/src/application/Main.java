package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	Circle cir1;
	Circle cir2;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//===========================
			
			Button btn1 = new Button();
			btn1.setText("click me");
			
			Button btn2 = new Button();
			btn2.setText("now click me");
			btn2.setId("center"); //Give btn2 an id for css ++++++++
			
			btn1.setOnAction((ActionEvent e)->{
				btn1.setVisible(false); //make btn invisible
			});
			
			btn2.setOnAction((ActionEvent e)->{
				cir2.setFill(Color.DEEPPINK); //fill cir2 with pink
				btn1.setVisible(true); //make btn1 visible
			});
		
			
			cir1 = new Circle(100,100,40);
			cir1.setId("center"); //Give cir1 an id for css ++++++++
			
			cir2 = new Circle(100,100,60);
			cir2.setId("center"); //Give cir2 an id for css ++++++++
		
			//----------
			StackPane stack1 = new StackPane();
			StackPane stack2 = new StackPane();
			
			//add 1st circle & btn to first StackPane:
			stack1.getChildren().addAll(cir1, btn1); 
			
			//add 2nd circle & btn to first StackPane:
			stack2.getChildren().addAll(cir2, btn2); 
			
			BorderPane pane = new BorderPane();
			//set the 1st stack at the top of the border pane:
			pane.setTop(stack1);
			//set the 2nd stack in the center of the border pane:
			pane.setCenter(stack2);
			//----------
			
			//===========================
			
			
			Scene scene = new Scene(pane,400,400);
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
