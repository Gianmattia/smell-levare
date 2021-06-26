package logic.controller;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import logic.applicationController.LoginController;
import logic.bean.GeneralUserBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class GraphicControllerLogin{
	@FXML
	private AnchorPane loginroot;
	 
	@FXML
    private Button loginButton;
	@FXML
    private PasswordField passwordBox;
	@FXML
    private TextField usernameTextField;
	@FXML
    private MenuButton typeMenuButton;

    @FXML
    private MenuItem standardUserButton;

    @FXML
    private MenuItem artistButton;

    @FXML
    private MenuItem sponsorButton;
	
	int identity = 0; //used for understanding which dao to activate, it cannot be 0 -> develop a custom exception! 

	  
	 @FXML
	 public void loginClicked(ActionEvent event) throws Exception {

		 if (identity==0) {
			 //the user did not select any identity, implement an exception
		 }
		 else if (identity==1) {
			 //std user selected
			 LoginController lc = new LoginController();
			 lc.setupSessionUser(identity, this.usernameTextField.getText(), this.passwordBox.getText());
			 FXMLLoader loader=new FXMLLoader(getClass().getResource("/logic/boundary/LoggedUser.fxml"));
			 LoggedUserController luc = new LoggedUserController();
			 loader.setController(luc);
			 Scene scene=this.usernameTextField.getScene();
			 scene.setRoot(loader.load());
			 
		 }
		 else if (identity==2) {
			 //artist selected
			 LoginController lc = new LoginController();
			 lc.setupSessionUser(identity, this.usernameTextField.getText(), this.passwordBox.getText());
			 FXMLLoader loader=new FXMLLoader(getClass().getResource("/logic/boundary/LoggedArtist.fxml"));
			 LoggedArtistController lac = new LoggedArtistController();
			 loader.setController(lac);
			 Scene scene=this.usernameTextField.getScene();
			 scene.setRoot(loader.load());
		 }
		 else if (identity==3) {
			 //sponsor selected
			 LoginController lc = new LoginController();
			 lc.setupSessionUser(identity, this.usernameTextField.getText(), this.passwordBox.getText());
			 FXMLLoader loader=new FXMLLoader(getClass().getResource("/logic/boundary/LoggedSponsor.fxml"));
			 LoggedSponsorController lsc = new LoggedSponsorController();
			 loader.setController(lsc);
			 Scene scene=this.usernameTextField.getScene();
			 scene.setRoot(loader.load());
		 }
	    }
	 
	 @FXML
	 public void caricaregistrazione() throws IOException {
		 
		 AnchorPane pane =FXMLLoader.load(getClass().getResource("/logic/boundary/Registrazione.fxml"));
		 loginroot.getChildren().setAll(pane);
		 
		 
	 }
	 
	 
	 @FXML
	    void artistButtonClick(ActionEvent event) {
		 	typeMenuButton.setText("Artist");
		 	identity=2; //2 is for artist
		 	
	    }
	 
	 @FXML
	    void sponsorButtonClick(ActionEvent event) {
		 	typeMenuButton.setText("Sponsor");
		 	identity=3; //3 is for sponsor
	    }

	 @FXML
	    void standardUserButtonClick(ActionEvent event) {
		 	typeMenuButton.setText("Standard User");
		 	identity=1; //1 is for std user
	    }

}