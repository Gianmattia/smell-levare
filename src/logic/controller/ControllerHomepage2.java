package logic.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import logic.applicationController.MapController;
import logic.bean.EventBean;
import logic.entity.Event;

public class ControllerHomepage2 implements Initializable{
	@FXML
    private AnchorPane rootpane3;

    @FXML
    private Label nameLabel1;

    @FXML
    private Label descriptionLabel1;

    @FXML
    private Label nameLabel2;

    @FXML
    private Label descriptionLabel2;

    @FXML
    private Label nameLabel3;

    @FXML
    private Label descriptionLabel3;
    
    MapController mc = new MapController();
	List<EventBean> list = mc.liveEventsList();
	int dim = list.size();
    //3 random entity are created among the live events
    Event first;
    Event second;
    Event third;

    @FXML
    void caricainfo(MouseEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nameLabel1.setText("");
		nameLabel2.setText("");
		nameLabel3.setText("");
		descriptionLabel1.setText("");
		descriptionLabel2.setText("");
		descriptionLabel3.setText("");
		
		int j = 3;
		if (dim<j) {
			j=dim;
		}
		Collections.shuffle(list);
		for (int i = 0; i < j; i++) {
			if (i==0) {
				nameLabel1.setText(list.get(i).getName());
				descriptionLabel1.setText(list.get(i).getDescription());
				first = new Event(list.get(i).getName(), list.get(i).getArtist(), list.get(i).getDescription(),list.get(i).getPlace());
				}
			else if (i==1) {
				nameLabel2.setText(list.get(i).getName());
				descriptionLabel2.setText(list.get(i).getDescription());
				second=new Event(list.get(i).getName(), list.get(i).getArtist(), list.get(i).getDescription(),list.get(i).getPlace());
				}
			else if (i==2) {
				nameLabel3.setText(list.get(i).getName());
				descriptionLabel3.setText(list.get(i).getDescription());
				third=new Event(list.get(i).getName(), list.get(i).getArtist(), list.get(i).getDescription(),list.get(i).getPlace());
				}
		}
	}
}
