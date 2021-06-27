package logic.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import logic.appcontroller.SessionSponsorController;
import logic.utils.SessionSponsor;

public class ControllerHomepageSponsor implements Initializable{
	
    @FXML
    private AnchorPane rootpaneHPS;
    
    @FXML
    private Button dismissButtonHPS;

    @FXML
    private Label titleLabelHPS;
    
    @FXML
    private Button editButtonHPS;

    @FXML
    private Label usernameHPS;

    @FXML
    private Label activity;

    @FXML
    private Label capacity;

    @FXML
    private Label description;

    @FXML
    private TextField usernameEditbox;

    @FXML
    private TextField passwordEditbox1;

    @FXML
    private Button saveButton;

    @FXML
    private TextArea descriptionTexrBar;

    @FXML
    private TextField capacityEditbox;

    @FXML
    void dismissShow(ActionEvent event) {
    	//add dismiss show
    }

    @FXML
    void editClick(ActionEvent event) {
    	if(!usernameEditbox.isVisible()) {
    		usernameEditbox.setVisible(true);
    		passwordEditbox1.setVisible(true);
    		saveButton.setVisible(true);
    		descriptionTexrBar.setVisible(true);
    		capacityEditbox.setVisible(true);
    	}
    	else {
    		usernameEditbox.setVisible(false);
    		passwordEditbox1.setVisible(false);
    		saveButton.setVisible(false);
    		descriptionTexrBar.setVisible(false);
    		capacityEditbox.setVisible(false);
    	}
    }

    @FXML
    void saveClick(ActionEvent event) {
    	//dummy
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//hide edit section
		usernameEditbox.setVisible(false);
		passwordEditbox1.setVisible(false);
		saveButton.setVisible(false);
		descriptionTexrBar.setVisible(false);
		capacityEditbox.setVisible(false);
		//implement a singleton class for sponsors (SessionSponsor)
		SessionSponsorController ssc = new SessionSponsorController();
		ssc.sessionSponsorSetup();
		SessionSponsor ss = SessionSponsor.getInstance();
		usernameHPS.setText(ss.getUsername());
		activity.setText(ss.getActivity());
		capacity.setText(ss.getCapacity());
		description.setText(ss.getDescription());
	}
}
