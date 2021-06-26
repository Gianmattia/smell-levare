package logic.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import logic.applicationController.MapController;
import logic.bean.PlaceBean;
import logic.exceptions.EmptyFieldException;

public class GraphicControllerMapArtist implements Initializable{
	@FXML
    private Button eurPlace;

    @FXML
    private Button pignetoPlace;

    @FXML
    private Button villaPlace;

    @FXML
    private Button statuarioPlace;

    @FXML
    private Label nameLabel;

    @FXML
    private Label indirizzoLabel;

    @FXML
    private Label capienzaLabel;

    @FXML
    private TextField titleText;

    @FXML
    private TextArea descriptionText;

    @FXML
    private Button submitButton;
    
    MapController mc = new MapController();
    List<PlaceBean> list = mc.freePlaces();

    @FXML
    void eurClick(ActionEvent event) {
    	int pos = 0;
    	for(int i=0; i<list.size(); i++) {
    		if(list.get(i).getName().equalsIgnoreCase("Eur")) {
    			pos=i;
    		}
    	}
    	display(pos);
    }

    @FXML
    void pignetoClick(ActionEvent event) {
    	int pos = 0;
    	for(int i=0; i<list.size(); i++) {
    		if(list.get(i).getName().equalsIgnoreCase("Pigneto")) {
    			pos=i;
    		}
    	}
    	display(pos);
    }

    @FXML
    void statuarioClick(ActionEvent event) {
    	int pos = 0;
    	for(int i=0; i<list.size(); i++) {
    		if(list.get(i).getName().equalsIgnoreCase("Statuario")) {
    			pos=i;
    		}
    	}
    	display(pos);
    }

    @FXML
    void submit(ActionEvent event) throws EmptyFieldException {
    	//this method creates a new event based on the information gathered
    	mc.submitEvent(titleText.getText(), nameLabel.getText(), descriptionText.getText());
    }
    
    
    void display(int pos) {
    	//setup
    	nameLabel.setVisible(true);
		indirizzoLabel.setVisible(true);
		capienzaLabel.setVisible(true);
		titleText.setVisible(true);
		descriptionText.setVisible(true);
		submitButton.setVisible(true);
		
    	nameLabel.setText(list.get(pos).getName());
    	Integer cap = list.get(pos).getCapacity();
    	capienzaLabel.setText(cap.toString());
    	indirizzoLabel.setText(list.get(pos).getAddress());
    }

    @FXML
    void villaClick(ActionEvent event) {
    	int pos = 0;
    	for(int i=0; i<list.size(); i++) {
    		if(list.get(i).getName().equalsIgnoreCase("Villa")) {
    			pos=i;
    		}
    	}
    	display(pos);
        
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//every button (and textbox and label) starts not visible
		eurPlace.setVisible(false);
		pignetoPlace.setVisible(false);
		villaPlace.setVisible(false);
		statuarioPlace.setVisible(false);
		nameLabel.setVisible(false);
		indirizzoLabel.setVisible(false);
		capienzaLabel.setVisible(false);
		titleText.setVisible(false);
		descriptionText.setVisible(false);
		submitButton.setVisible(false);
		for(int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals("Eur")) {
				eurPlace.setVisible(true);
			}
			else if (list.get(i).getName().equals("Statuario")) {
				statuarioPlace.setVisible(true);
			}
			else if (list.get(i).getName().equals("Pigneto")) {
				pignetoPlace.setVisible(true);
			}
			else if (list.get(i).getName().equals("Villa")) {
				villaPlace.setVisible(true);
			}
		}
	}

}
