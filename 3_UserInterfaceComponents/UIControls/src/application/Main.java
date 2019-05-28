package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//==============================================
			//All controls found in: Javafx.scene.control API
			
			//create the controls:
			Button btn = new Button();
			btn.setText("I'm a button");
			Label lbl = new Label("I'm a label");
			TextField tf = new TextField("Enter text here");
			Hyperlink hl = new Hyperlink("I'm a hyperlink");
			RadioButton rb = new RadioButton("Radion Button");
			rb.setStyle("-fx-base: #61a2b1");
			CheckBox cb = new CheckBox("Check Box");
			ProgressBar pb = new ProgressBar();
			ScrollBar sb = new ScrollBar();
			Image myImg = new Image("application/skull.png");
			Button btn2 = new Button("Search", new ImageView(myImg));
			PasswordField pw = new PasswordField();
			
			//use a grid to place controls in the window:
			GridPane grid = new GridPane();
			
			//set grid attributes:
			grid.setAlignment(Pos.CENTER); //center-aligning GridPane +++++++++++++++++++++
			grid.setHgap(20);
			grid.setVgap(50);
			grid.setPadding(new Insets(25,25,25,25));
			
			//add controls to grid using col & row numbers:
			grid.add(btn, 0,0); //col 0, row 0
			grid.add(lbl, 1,0); //col 1, row 0
			grid.add(tf, 2,0);
			grid.add(rb, 0,1);
			grid.add(cb, 1,1);
			grid.add(hl, 2,1);
			grid.add(pb, 0,2);
			grid.add(sb, 1,2);
			grid.add(btn2, 2,2);
			grid.add(pw, 0,3,3,1); //SPANNING AN ELEMENT: col 0, row 3, span 3 cols, span 1 row. ++++++++++++++++++++++++++++++
			
			//==============================================
			
			Scene scene = new Scene(grid,400,400);
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
