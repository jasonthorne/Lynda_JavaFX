package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class SampleController {
	
	@FXML
    private Text actionTarget; //Text that the program will set on click.

    @FXML
    private void handleSubmitButtonAction(ActionEvent event) { //action event handler for button
        System.out.println("You clicked it, baby!");
        actionTarget.setText("Sign in button was pressed!");
    }
	
}
