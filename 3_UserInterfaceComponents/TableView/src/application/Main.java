package application;
	
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
			
			primaryStage.setTitle("Table View");
			
			//make labels:
			Label response = new Label("");
			response.setFont(Font.font("Arial", 14));
			Label title = new Label("Contact list using a TableView\n");
			title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
			title.setTextFill(Color.CADETBLUE);
			
			//make root:
			FlowPane root = new FlowPane();
			root.setAlignment(Pos.CENTER); //set table to be in center of the window
			
			
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
			TableView<Contact> tvContacts;
			
			//add contacts to TableView:
			tvContacts = new TableView<Contact>(contactList);
			
			//====================================IMPORTANT!!
			//Associate the columns with a column heading:
			
			//The 1st column is for the first name:
			TableColumn<Contact, String>fName = new TableColumn<>("First Name");
			
			
			//use the CELL FACTORY to populate the column cells with the data:
			fName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
			tvContacts.getColumns().add(fName);
			
			//--------------
			
			//The 2nd column is for the last name:
			TableColumn<Contact, String>lName = new TableColumn<>("Last Name");
			
			//use the CELL FACTORY to populate the column cells with the data:
			lName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
			tvContacts.getColumns().add(lName);
			
			//--------------
			
			//The 3rd column is for the phone number:
			TableColumn<Contact, String>cell = new TableColumn<>("Phone Number");
			
			//use the CELL FACTORY to populate the column cells with the data:
			cell.setCellValueFactory(new PropertyValueFactory<>("cellPhone"));
			tvContacts.getColumns().add(cell);
			
			//====================================
			
			//set preferred width & height:
			tvContacts.setPrefWidth(300);
			tvContacts.setPrefHeight(300);
			
			//TableView SelectionModel (adding an event listener with associated behavior to table cells) +++++++++++++
			//create the SelectionModel:
			TableView.TableViewSelectionModel<Contact> tvSelContact = tvContacts.getSelectionModel();
			
			//add the listener to the selectionModel:
			tvSelContact.selectedIndexProperty().addListener(new ChangeListener<Number>() {
				
				//override the ChangeListener's changed method:
				@Override
				public void changed(ObservableValue<? extends Number> changed, Number oldVal, Number newVal) {
					
					int index = (int)newVal;
					response.setText ("The cell number for the contact selected is: " + contactList.get(index).getCellPhone());
				}
				
			});
			
			//add labels and TABLEVIEW to root:
			root.getChildren().addAll(title, tvContacts, response);
			
			Scene scene = new Scene(root,400,400);
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
