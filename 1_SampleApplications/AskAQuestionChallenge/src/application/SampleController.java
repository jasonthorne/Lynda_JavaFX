package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class SampleController {
	
	@FXML
    private Text actionTarget; //Text that the program will set on click.
	
	String[] answerArray = {"Hell no!", "Awwwwhh yeah!", "How the hell should I know!?", "Maybe...", "Only if it rains next Wednesday."}; //answer options

    @FXML
    private void handleSubmitButtonAction(ActionEvent event) { //action event handler for button
        System.out.println("You clicked it, baby!");
        Random rand = new Random(); //instance of random
        String answer = answerArray[rand.nextInt(answerArray.length)]; //randomly pick an answer
        actionTarget.setText(answer); //show answer
    }
}
