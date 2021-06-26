package logic.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import logic.applicationController.MapController;
import logic.bean.EventBean;
import logic.entity.Event;

public class GraphicControllerMap implements Initializable {
	//declarations
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
    private Label artistLabel;

    @FXML
    private Label descriptionLabel;
    
    MapController mc = new MapController();
	List<EventBean> list = mc.liveEventsList();
	//entity declaration CAMBIARE NON CI POSSONO ESSERE ENTITA' NEL CONTROLLORE GRAFICO
	Event eur;
	Event pigneto;
	Event villa;
	Event statuario;
    
    
    @FXML
    void eurClick(ActionEvent event) {
    	nameLabel.setText(eur.getName());
    	artistLabel.setText(eur.getArtist());
    	descriptionLabel.setText(eur.getDescription());
    	}

    @FXML
    void pignetoClick(ActionEvent event) {
    	nameLabel.setText(pigneto.getName());
    	artistLabel.setText(pigneto.getArtist());
    	descriptionLabel.setText(pigneto.getDescription());
    }

    @FXML
    void statuarioClick(ActionEvent event) {
    	nameLabel.setText(statuario.getName());
    	artistLabel.setText(statuario.getArtist());
    	descriptionLabel.setText(statuario.getDescription());
    }

    @FXML
    void villaClick(ActionEvent event) {
    	nameLabel.setText(villa.getName());
    	artistLabel.setText(villa.getArtist());
    	descriptionLabel.setText(villa.getDescription());
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//every button starts not visible
		eurPlace.setVisible(false);
		pignetoPlace.setVisible(false);
		villaPlace.setVisible(false);
		statuarioPlace.setVisible(false);
		//set visible a button if the corrisponding event is live
		for(int i = 0; i < list.size(); i++) {
			if (list.get(i).getPlace().equals("Eur")) {
				eurPlace.setVisible(true);
				eur = new Event(list.get(i).getName(), list.get(i).getArtist(), list.get(i).getDescription(),list.get(i).getPlace());
			}
			else if (list.get(i).getPlace().equals("Pigneto")) {
				pignetoPlace.setVisible(true);
				pigneto = new Event(list.get(i).getName(), list.get(i).getArtist(), list.get(i).getDescription(),list.get(i).getPlace());
			}
			else if (list.get(i).getPlace().equals("Villa")) {
				villaPlace.setVisible(true);
				villa = new Event(list.get(i).getName(), list.get(i).getArtist(), list.get(i).getDescription(),list.get(i).getPlace());
			}
			else if (list.get(i).getPlace().equals("Statuario")) {
				statuarioPlace.setVisible(true);
				statuario = new Event(list.get(i).getName(), list.get(i).getArtist(), list.get(i).getDescription(),list.get(i).getPlace());
			}
			
		}
		
	}
	
	
	
	
}
