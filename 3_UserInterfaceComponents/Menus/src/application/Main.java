package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
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
			
			//================
		
			//create a MenuBar (to add a menu to):
			MenuBar menuBar = new MenuBar();
			menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
			//--------------------------
			//REGULAR MENU:
			//create a menu (to add menu items to)
			Menu fileMenu = new Menu("File");
			
			//create the menu items:
			MenuItem newMenuItem = new MenuItem("New");
			MenuItem saveMenuItem = new MenuItem("Save");
			MenuItem printMenuItem = new MenuItem("Print");
			MenuItem exitMenuItem = new MenuItem("Exit");
			
			//add an event to exitMenuItem:
			exitMenuItem.setOnAction(actionEvent->Platform.exit()); //close platform
			
			//add menu items to menu (and add a separator line using a 'SeparatorMenuItem' obj):
			fileMenu.getItems().addAll(newMenuItem, saveMenuItem, printMenuItem, new SeparatorMenuItem(), exitMenuItem);
			
			//--------------------------
			//CHECKBOX MENU:
			
			//create another menu:
			Menu languageMenu = new Menu("Language");
			
			//create the checkbox menu items:
			CheckMenuItem javaMenuItem = new CheckMenuItem("Java");
			CheckMenuItem pythonMenuItem = new CheckMenuItem("Python");
			CheckMenuItem htmlMenuItem = new CheckMenuItem("HTML");
			CheckMenuItem fxMenuItem = new CheckMenuItem("JavaFX");
			fxMenuItem.setSelected(true); //set this menu item to be checked by default
			
			//add menu items to menu (and add a separator line using a 'SeparatorMenuItem' obj):
			languageMenu.getItems().addAll(javaMenuItem, pythonMenuItem, htmlMenuItem, new SeparatorMenuItem(), fxMenuItem);
			
			//--------------------------
			//SUB MENU:
			
			//create another menu:
			Menu tutorialMenu = new Menu("Tutorial");
			
			//create menu items & add them to menu:
			tutorialMenu.getItems().addAll(
					new MenuItem("Buttons"),
					new MenuItem("Menus"),
					new MenuItem("Images")
			);
			
			
			//add this menu to another menu (as a menu item):
			languageMenu.getItems().add(tutorialMenu);
			
			
			//add menus to menuBar - '.add()' if only adding one menu to menuBar:
			menuBar.getMenus().addAll(fileMenu, languageMenu);
			
			root.setTop(menuBar); //add menubar to top of root ++++++++++++++
			
			Scene scene = new Scene(root,400,400, Color.WHITE);
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
