package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			BorderPane root = new BorderPane();
			
			//create a Text title:
			Text title = new Text("California");
			title.setFont(Font.font("Veranda", FontWeight.BOLD, 24));
			title.setFill(Color.FIREBRICK);
			
			//create an Image obj:
			Image caPic = new Image("application/Desert-to-sea logo.gif");
			
			//Create an imageView & add our image to it (IMPORTANT - imageView needed for adding image to root):
			ImageView imgView = new ImageView(caPic);
			
			//add title and imageView to root:
			root.setTop(title);
			root.setCenter(imgView);
			
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
