package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane(); 
			Scene scene = new Scene(root,400,400, Color.WHITE);
			
			//================
			//create a MenuBar (to add a menu to):
			MenuBar menuBar = new MenuBar();
			menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
			root.setTop(menuBar); //add menubar to top of root ++++++++++++++
			
			//create a menu (to add menu items to)
			Menu fileMenu = new Menu("File");
			
			//create the menu items:
			MenuItem newMenuItem = new MenuItem("New");
			MenuItem saveMenuItem = new MenuItem("Save");
			MenuItem exitMenuItem = new MenuItem("Exit");
			
			//add menu items to menu:
			fileMenu.getItems().addAll(newMenuItem, saveMenuItem, new SeparatorMenuItem(), exitMenuItem);
			
			
			//=================
			
			
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
