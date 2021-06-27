package logic.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class ErrorDescriptionController implements Initializable {
	  @FXML
	  private AnchorPane rootpane5;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		AnchorPane ap;
		try {
			ap = FXMLLoader.load(getClass().getResource("/logic/boundary/Homepageartisti.fxml"));
			rootpane5.getChildren().setAll(ap);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
