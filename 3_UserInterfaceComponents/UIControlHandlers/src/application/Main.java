package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//=========================================
			//create gridpane:
			GridPane root = new GridPane();
			root.setPadding(new Insets(15,15,15,15));
			root.setVgap(10);
			root.setHgap(10);
			
			//add a title to the page:
			Text title = new Text("Leave a comment!");
			title.setFill(Paint.valueOf("#2a5058"));
			title.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
			
			//add a label & textField for the username:
			Label name = new Label("Enter your name: ");
			TextField userName = new TextField();
			HBox hb = new HBox();
			hb.getChildren().addAll(name, userName);
			hb.setSpacing(25);
			
			//add a label & textField for the user comment:
			Label lblComment = new Label("Enter your comment: ");
			TextField comment = new TextField();
			
			//add a submit & clear button: 
			Button submit = new Button("Submit");
			Button clear = new Button("Clear");
			
			//add a drop shadow effect:
			DropShadow shadow = new DropShadow();
			
			//label for confirmation message:
			Label lblResponse = new Label();
			
			//+++++++++++++++++++++++++++++++++++++++++++++++
			//attach an event handler to the submit button for a hover effect: 
			submit.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) ->{
				submit.setEffect(shadow);
			});
			
			//attach a 'mouse exited' event handler, to remove the drop shadow effect:
			submit.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) ->{
				submit.setEffect(null);
			});
			
			//make same event handlers for clear button:
			clear.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) ->{
				clear.setEffect(shadow);
			});
			
			clear.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) ->{
				clear.setEffect(null);
			});
			
			
			//click event for when the user submits a comment:
			submit.setOnAction((ActionEvent e) ->{
				
				//check that a comment was entered:
				if(comment.getText()!=null && !comment.getText().isEmpty()) {
					lblResponse.setText(userName.getText() + " " + "Thanks for your comment :)");
				}else {
					lblResponse.setText("You haven't left a comment :(");
				}
			});
			
			//click event for when the user clicks clear button:
			clear.setOnAction((ActionEvent e) ->{
				userName.clear();
				comment.clear();
				lblResponse.setText(null);
			});
			
			//+++++++++++++++++++++++++++++++++++++++++++++++
			
	
			//add elements to root:
			root.add(title, 0,0,2,1); //SPANNING AN ELEMENT: col 0, row 0, span 2 cols, span 1 row. ++++++++++++++++++++++++++++++
			root.add(hb, 0,1);
			root.add(lblComment, 0,2);
			root.add(comment, 0,3);
			root.add(submit, 0,4);
			root.add(clear, 1,4);
			root.add(lblResponse, 0,6,2,1);
			
			//=========================================
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
