package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//make labels:
			Label response = new Label("");
			Label title = new Label("Contact list using a TableView\n");
			title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
			title.setTextFill(Color.CADETBLUE);
			
			//make root:
			FlowPane root = new FlowPane();
			root.setAlignment(Pos.CENTER); //set table to be in center of the window
			
			Scene scene = new Scene(root,400,400);
			
			//Create an "observable" list of Contacts
			ObservableList<Contact> contactList = FXCollections.observableArrayList(
				new Contact("Peggy", "Fisher", "333-555-222-111"),
				new Contact("Bob", "Billford", "777-111-000-444"),
				new Contact("Susan", "Boyle", "999-888-222-333"),
				new Contact("Frank", "Galagher", "444-555-222-666"),
				new Contact("Jim", "Cricket", "222-666-333-111"),
				new Contact("Ben", "Nevis", "888-111-222-555"),
				new Contact("Ted", "Super", "444-333-222-999"),
				new Contact("Rick", "Roll", "333-777-888-111"),
				new Contact("Neil", "Hippy", "111-555-333-222"),
				new Contact("Hamish", "McBeth", "333-222-444-888")
			);
			
			
			//create a tableView for contacts:
			TableView<Contact> myTableView;
			
			//add contacts to TableView:
			myTableView = new TableView<Contact>(contactList);
			
			//TableView
			
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
