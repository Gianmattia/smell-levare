package logic.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import logic.appcontroller.HostShowSponsorController;
import logic.dao.SponsorDao;
import logic.exceptions.PendingRequestException;

public class ControllerHostShowSponsor implements Initializable {
	 @FXML
     private AnchorPane rootpane5;

     @FXML
     private AnchorPane mainPane;

     @FXML
     private ListView<String> listViewArtists; //cambiato ? con String

     @FXML
     private AnchorPane artistPane;

     @FXML
     private Label descriptionArtistlabel;

     @FXML
     private ListView<String> listViewSponsor;

     @FXML
     private Button sendRequestButton;

     @FXML
     private Label partnerLabel;
     
     @FXML
     private TextField titleTextBox;

     @FXML
     private TextArea descriptionTextBox;

     @FXML
     void sendRequest(ActionEvent event) {
    	 //this sends a request to the partner and to the artist selected, that when approved becomes a SponsoredShow
    	 String artist = listViewArtists.getSelectionModel().getSelectedItem();
    	 String title = titleTextBox.getText();
    	 String description = descriptionTextBox.getText();
    	 String partner = partnerLabel.getText();
    	 SponsorDao sd = new SponsorDao();
    	 try {
			sd.createSSQueue(title, artist, partner, description);
		} catch (PendingRequestException e) {
			//implementare logica di errore
			e.printStackTrace();
		}
	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//fill listViewArtists
		HostShowSponsorController hssc = new HostShowSponsorController();
		listViewArtists.getItems().addAll(hssc.buildArtistStringArray());
		listViewArtists.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				//this listener method makes the description of the selected artist appear in the description pane
				String description;
				description=hssc.getDescription(listViewArtists.getSelectionModel().getSelectedItem());
				descriptionArtistlabel.setText(description);
				
			}
			
		});
		//fill listViewSponsor
		listViewSponsor.getItems().addAll(hssc.buildSponsorStringArray());
		listViewSponsor.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				partnerLabel.setText(listViewSponsor.getSelectionModel().getSelectedItem());
				
			}
			
		});
	}	
}
