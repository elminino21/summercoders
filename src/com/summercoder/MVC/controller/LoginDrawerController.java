package com.summercoder.MVC.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.summercoder.MVC.controller.switcher.ControlledScreen;
import com.summercoder.MVC.controller.switcher.ScreensController;
import com.summercoder.MVC.views.GUITestester;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import javax.annotation.PostConstruct;
import javax.management.Notification;

public class LoginDrawerController implements Initializable  {
	
	//private ScreensController myController;
        private StackPane stack;
	@FXML
        private JFXButton about;
	
        
        @FXML
	private void supportPress(ActionEvent event)
	{
           
       
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
  
            alert.setContentText("I have a great message for you!");
            
            alert.showAndWait();
       
 
    
            System.out.print("about click");
           
		
		event.consume();
	}
        
        
        
	@FXML
	private void myAcctPress(ActionEvent event)
	{
         


    
            System.out.print("Account clicked");
           
		
		event.consume();
	}
        
        @FXML
	private void aboutPress(ActionEvent event)
	{
           
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("SummerCoder");
            alert.setContentText("Fun summer project made by a bunch of students with the goal of making an application useful to others in addition to it creators.");

            alert.showAndWait();

            System.out.print("about click");
           
		
		event.consume();
	}
        
        @FXML
	private void exitPress(ActionEvent event)
	{
            
            System.out.print("exit click");
            
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Look, a Confirmation Dialog");
            alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                Stage stage = Stage.class.cast(Control.class.cast(event.getSource()).getScene().getWindow());
                stage.close();
             } else 
            {
                 alert.close();
            }
            
            
         
            
		event.consume();
	}
        
        @Override
	public void initialize(URL url, ResourceBundle rb) 
	{
            /*
            about.setOnAction( (e)->{
                System.out.print("about click");
            });
            */
            
	}

         
	
}