package application;
	
import java.util.Arrays;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.FlowPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//Change to other inbuilt styleSheet (default one is MODENA):
			//setUserAgentStylesheet(STYLESHEET_CASPIAN);
			
			//===============
			//Taken from: https://www.tutorialspoint.com/javafx/bar_chart.htm
			
			
			//define the X axis:
			CategoryAxis xAxis = new CategoryAxis();
			
			//add the categories to the X axis:
			xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(
					"January",
					"Febuary",
					"March"
			)));
			
			//give x axis a label:
			xAxis.setLabel("Months"); 
			
			
			//Define the Y axis:
			NumberAxis yAxis = new NumberAxis();
			
			//give y axis a label:
			yAxis.setLabel("Sales"); 
			
			//-----------
			
			//Create the bar chart (passing it the x & y axis objects):
			BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
			
			//give bar chart a title:
			barChart.setTitle("Bob & Frank's Car sales"); 
			
			//----------
			
			//Instantiate the XYChart.Series classes, and add their data:
			
			XYChart.Series<String, Number> series1 = new XYChart.Series<>();
			series1.setName ("Bob");
			series1.getData().add(new XYChart.Data<>("January", 20));
			series1.getData().add(new XYChart.Data<>("Febuary", 15));
			series1.getData().add(new XYChart.Data<>("March", 10));
			
			XYChart.Series<String, Number> series2 = new XYChart.Series<>();
			series2.setName ("Frank");
			series2.getData().add(new XYChart.Data<>("January", 18));
			series2.getData().add(new XYChart.Data<>("Febuary", 8));
			series2.getData().add(new XYChart.Data<>("March", 20));
			
			//----------
			
			//add the sets of data to the bar chart:
			barChart.getData().addAll(series1, series2);
			
			
			//add the bar chart to the root:
			FlowPane root = new FlowPane(barChart);
			
			//===============
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
