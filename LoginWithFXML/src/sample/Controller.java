package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller{ //implements Initializable { //implementation of Initializable added by me!!

    //============Added by me!
    @FXML
    private Text actiontarget; //Text that the program will set on click.

    @FXML
    private void handleSubmitButtonAction(ActionEvent event) { //action event handler for button
        //System.out.println("You clicked it, baby!");
        actiontarget.setText("Sign in button was pressed!");
    }
    //===========

    //@Override
   // public void initialize(URL location, ResourceBundle resources) {

    //}
}
