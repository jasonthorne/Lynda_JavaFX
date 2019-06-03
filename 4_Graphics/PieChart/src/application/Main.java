package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.FlowPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	//+++++++++++++++++++++++++REMEBER!: default colours can be changed!! (to match with mtg colours for example)
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//Change to other inbuilt styleSheet (default one is MODENA):
			//setUserAgentStylesheet(STYLESHEET_CASPIAN);
			
			FlowPane root = new FlowPane();
			
			//====================
			//Create a list of data for displaying in chart:
			
			//create an observableList Obj using the data type 'PieChart'
			ObservableList<PieChart.Data> pieData;
			
			//instantiate pieData list using an observableArrayList of PieChart data:
			pieData = FXCollections.observableArrayList(
					new PieChart.Data("Rent", 500),
					new PieChart.Data("Electric", 125),
					new PieChart.Data("Groceries", 235),
					new PieChart.Data("Entertainment", 200),
					new PieChart.Data("Cell Phone", 80)
			);
			
			//create a pieChart object (giving it the pie data):
			PieChart myPie = new PieChart(pieData);
			myPie.setTitle("Monthly Expenses");
			
			//add pieChart to root:
			root.getChildren().add(myPie);
			
			//====================
			
			
			Scene scene = new Scene(root,500,500);
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
