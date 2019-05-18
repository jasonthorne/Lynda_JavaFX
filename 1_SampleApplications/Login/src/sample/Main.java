package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ///Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        //===create grid:
        GridPane grid = new GridPane(); //create a GridPane
        grid.setAlignment(Pos.CENTER); //center align the grid
        //horizontal and vertical gaps of 10 pixels between rows & colums:
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));//add 25 pixel padding inside the cells

        //===create grid elements:
        Text sceneTitle = new Text("Please login: ");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20)); //family, weight, size
        Label userNameLbl = new Label("User Name: ");
        TextField userTextField = new TextField();
        Label passwordLbl = new Label("Password: ");
        PasswordField passwordField = new PasswordField(); //TextField that hides input

        //===add elements to grid:
        grid.add(sceneTitle, 0,0,2,1); //adding sceneTitle at row 0, col 0. Telling it to span two cols, but only 1 row.
        grid.add(userNameLbl, 0,1); //adding userName label at row 0, col 1
        grid.add(userTextField, 1,1);
        grid.add(passwordLbl, 0,2);
        grid.add(passwordField, 1,2);

        grid.setGridLinesVisible(true);//make gridlines visible

        //===grid button:
        Button button = new Button("Sign in");
        HBox hBox = new HBox(10); //make a horizontal box for the button
        hBox.setAlignment(Pos.BOTTOM_RIGHT); //set box alignment
        hBox.getChildren().add(button);//add button to box
        grid.add(hBox,1,4);//add box to grid

        //===text for displaying, after button click:
        final Text actionTarget = new Text(); //empty for now!
        grid.add(actionTarget,1,6);//add text to grid

        //===action event for button (using lambda expression):
        button.setOnAction(event -> {
            actionTarget.setText("Sign in button pressed"); //set text
            actionTarget.setFill(Color.BLUEVIOLET); //change the colour of display text
        });

        //===create scene and stage, and show stage:
        primaryStage.setTitle("Java FX Login Form");
        Scene scene = new Scene(grid, 300, 275); //create scene, and add grid to scene
        scene.getStylesheets().add(Main.class.getResource("Login.css").toExternalForm()); //linking stylesheet to scene +++++++++++
        primaryStage.setScene(scene); //add scene to stage
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
