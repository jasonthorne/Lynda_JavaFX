package application;
	
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FlowPane root = new FlowPane(10,10);
			root.setAlignment(Pos.CENTER);
			
			//==================================
			Label response = new Label("Select a college or university:");
			
			Text title = new Text("PA Colleges and Universities");
			title.setFill(Paint.valueOf("#2A5058"));
			title.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
			
			
			//Create a list view reference:
			ListView<String> myListView;
			
			//Create an "observable" list of items (for adding to listView above):
			ObservableList<String>colleges = 
					FXCollections.observableArrayList("Penn State", "Drexel",
					"Widener", "Shippensburg", "Bloomsberg", "Penn Tech", 
					"Lockhaven", "Kutztown");
			
			//instantiate the ListView reference, and add to it the observable list above:
			myListView = new ListView<String>(colleges);
			myListView.setPrefSize(300,150); //set a pref size for ListView
			
			//+++++++++++IMPORTANT!+++++++++++
			//create a selection model (to allow selecting of list items):
			MultipleSelectionModel<String> mySelectModel = myListView.getSelectionModel();
			
			//find the value that the user selected from selectionModel. 
			//adding a listener to the selected item (for creating a response to a selection)
			mySelectModel.selectedItemProperty().addListener(new ChangeListener<String>() {
				
				public void changed(ObservableValue<? extends String> changed, String oldVal, String newVal) {
					response.setText("You selected: " + newVal); //change value of label (based on selected item)
				}
			});
			//++++++++++++++++++++++++++++++++
			
			//add everything to root (ORDER MATTERS!!):
			root.getChildren().add(title);
			root.getChildren().add(myListView);
			root.getChildren().add(response);
			
			//==================================
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
