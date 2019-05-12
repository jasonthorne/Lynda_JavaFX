package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application { //ALL JavaFx applications must extend the Application class.

    /*Application class gives three lifecycle methods that can be overridden (init, stop & start)
    /Start is the main entry point for all javafx applications, and MUST be overridden as it's defined as abstract */
    @Override
    public void start(Stage primaryStage) throws Exception{ //start receives a STAGE param.

        //EVERY javaFx program receives 1 STAGE.
        //At least 1 SCENE is then added to the stage.
        //A ROOT is then added to the scene .
        //Other elements (like buttons) are the added to the root element.

        Button myButton = new Button(); //creating a button element
        myButton.setText("Click me, baby!");

        //traditional way of adding event handler to button:
        /*
        myButton.setOnAction(new EventHandler<ActionEvent>() { //adding eventhandler to button's action listener
            @Override
            public void handle(ActionEvent event) {
                System.out.println("woohoo!");
            }
        });
        */

        //Lambda way of adding event handler to button:
        myButton.setOnAction(event ->  System.out.println("woohoo!"));

        ///Parent root = FXMLLoader.load(getClass().getResource("sample.fxml")); //loading FXML file (not being used here)

        StackPane root = new StackPane(); //creating a stackpane root element object
        root.getChildren().add(myButton); //adding 'myButton' child node to root

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275)); //adding SCENE object(which contains our stackpane ROOT) to the STAGE
        primaryStage.show(); //show the stage. DON'T FORGET THIS :P
    }


    public static void main(String[] args) {
        launch(args); //this is what launches the program! (everything is passed as args from the calling program)
    }
}
