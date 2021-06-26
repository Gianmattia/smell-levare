package logic.controller;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import logic.appcontroller.ReviewController;
import logic.bean.ReviewBean;
import logic.exceptions.DuplicateReviewException;

public class ReviewsGraphicController implements Initializable{
	//non uso pi� vedirecensioni e recensioni scritte
	 @FXML
	    private AnchorPane rootpane5;

	    @FXML
	    private TextField research;

	    @FXML
	    private Button searchButton;

	    

	    @FXML
	    private AnchorPane reviewsPane;

	    @FXML
	    private Label authorLabel1;

	    @FXML
	    private Label authorLabel2;

	    @FXML
	    private Label authorLabel3;

	    @FXML
	    private Label descriptionLabel1;

	    @FXML
	    private Label descriptionLabel2;

	    @FXML
	    private Label descriptionLabel3;

	    @FXML
	    private Button refreshButton;
	    
	    @FXML
	    private Label notFoundLabel;
	    
	    @FXML
	    private AnchorPane writingPane;
	    
	    @FXML
	    private TextArea textArea;

	    @FXML
	    private Button submitButton;

	    @FXML
	    private TextField artistText;

	    
	    List<ReviewBean> lrb = new ArrayList<>();

	    @FXML
	    void artistReviews(ActionEvent event) {
	    	//no more used
	    }

	    @FXML
	    void refresh(ActionEvent event) {
	    	//to be implemented
	    }
	    
	    @FXML
	    void searchButtonClicked(ActionEvent event) {
	    	//to clear previous researches
	    	String def = "default";
	    	authorLabel1.setText(def);
	    	descriptionLabel1.setText(def);
	    	authorLabel2.setText(def);
	    	descriptionLabel2.setText(def);
	    	authorLabel3.setText(def);
	    	descriptionLabel3.setText(def);
	    	writingPane.setVisible(false);//can't write a review while browsing other reviews
	    	String barName = research.getText(); //gets searched name
	    	ReviewController rc = new ReviewController();
	    	lrb = rc.getReviews(barName);
	    	reviewsPane.setVisible(true); //this is the pane where reviews are displayed
	    	if(!lrb.isEmpty()) {
	    		authorLabel1.setText(lrb.get(0).getAuthor());
	    		descriptionLabel1.setText(lrb.get(0).getReview());
	    		lrb.remove(0);
	    	}
	    	
	    	if(!lrb.isEmpty()) {
	    		authorLabel2.setText(lrb.get(0).getAuthor());
	    		descriptionLabel2.setText(lrb.get(0).getReview());
	    		lrb.remove(0);
	    	}
	    	if(!lrb.isEmpty()) {
	    		authorLabel3.setText(lrb.get(0).getAuthor());
	    		descriptionLabel3.setText(lrb.get(0).getReview());
	    		lrb.remove(0);
	    	}
	    }

	    @FXML
	    void submitReview(ActionEvent event){
	    	if(textArea.getText().isBlank() || artistText.getText().isBlank()) {
	    		//implementa eccezione o controllo perch� non sono state inserite review e/o artista riferito
	    	}
	    	else {
	    		ReviewController rc = new ReviewController();
	    		try {
					rc.saveReview( artistText.getText(), textArea.getText());
				} catch (DuplicateReviewException e) {
					//da implementare
					e.printStackTrace();
				}
	    	}
	    }

	    
	    
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			//These elements start not visible
			reviewsPane.setVisible(false);
			refreshButton.setVisible(false);
			notFoundLabel.setVisible(false);
			
		}
}