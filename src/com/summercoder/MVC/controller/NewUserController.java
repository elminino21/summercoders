package com.summercoder.MVC.controller;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.summercoder.MVC.controller.switcher.ControlledScreen;
import com.summercoder.MVC.controller.switcher.ScreensController;
import com.summercoder.MVC.model.UserTableInfo;
import com.summercoder.MVC.views.GUITestester;
import com.summercoder.users.validator.EmailValidator;
import com.summercoder.users.validator.PasswordValidator;
import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import com.sun.javafx.application.HostServicesDelegate;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.jfoenix.controls.*;

public class NewUserController implements Initializable, ControlledScreen
{
	private ScreensController myController;
	
   
	@FXML
	private AnchorPane root;
        @FXML
        private Label massageText;
	@FXML
	private JFXDrawer drawer;
	@FXML
	private JFXHamburger hamberger;
	 private VBox side;
	 @FXML
    private JFXTextField fname;
    @FXML
    private JFXTextField lname;
    @FXML
    private JFXTextField userID;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXPasswordField password1;
    @FXML
    private JFXPasswordField password2;
	
	
        @Override
	public void initialize(URL location, ResourceBundle resources) {
                root.getStyleClass().add("root");
                 sidePanelSetter(); /** the the side panel in the drawer */
		setEvents();
	}
        
    @FXML
	private void signupPressed(ActionEvent event)
	{

        if(checkFiels() == true  )
        {
            this.getAllFields();
            myController.setScreen(GUITestester.screen1ID);
            this.clearAllFiels();
        }
		event.consume();
	}


   
    @FXML
    private void panelclicked(MouseEvent event) 
	{
		System.out.println("root panel clicked");
		this.drawerClose();
		event.consume();  
    }



	
	@FXML
    private void drawerclicked(MouseEvent event) 
	{
		event.consume();    
    }
	
	@FXML
    private void hamburgerClicked(MouseEvent event) 
	{
		this.openDrawer();
		event.consume();  
    }

	/**
	 * oepn or closes the drawer.
	 */
	
	private void drawerClose( )
	{
		
        if( !drawer.isHidden()  )
        {
        	drawer.close();
        	drawer.toBack();
        	
        }
	}
	/**
	 * open drawer if closed
	 */
	private void openDrawer()
	{
		drawer.open();
		drawer.toFront();
		
	}

	@Override
	public void setScreenParent(ScreensController screenPage) {
		 myController = screenPage;
		
	}
        
        
        private void sidePanelSetter()
        {
               try {
               side = FXMLLoader.load(getClass().getResource("/com/summercoder/MVC/views/LoginViewDrawer.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(LongInController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           drawer.setSidePane(side);
          
           
          
        }
        
        private void setEvents()
        {
             for(Node node :side.getChildren())
           {
               if(node.getAccessibleText() != null)
               {
                  
                    node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) ->{
                        
                         switch(node.getId()) {
                             case "account": myController.setScreen(GUITestester.screen1ID);
                             break;
                             case "exit": 
                                 Stage stage = Stage.class.cast(Control.class.cast(e.getSource()).getScene().getWindow());
                                 stage.close();
                             break;
                             case "about": myController.setScreen(GUITestester.screen1ID);
                               break;
                             case "support": myController.setScreen(GUITestester.screen5ID);
                                 
                         }
                        
                    });
               
               }
              
           } 
        }


    /**
     * let's the user know if any field is missing
     * @return
     */
    private boolean checkFiels()
    {
        EmailValidator emailValidator = new EmailValidator();
        PasswordValidator pass = new PasswordValidator();

        boolean answer = false;

        if( hasInput()  )
        {
            massageText.setText("Complete all fields before proceeding");

        }else if( !emailValidator.validate( email.getText())   )
        {
            massageText.setText("Invalid email address");
        }else if( !pass.validate( password1.getText())   )
        {
            massageText.setText("Password must be 8 digit long, has a capital letter and at least a number");
        }
        else if(  !password1.getText().equals( password2.getText() )  )
        {
            massageText.setText("Entered Passwords do not match");
        } else{
            answer = true;
        }

        return answer;
    }

    /**
     * creates new user from fiels
     */
    private void getAllFields()
    {
        UserTableInfo newUser = new UserTableInfo();
        newUser.addNewUser( fname.getText(),  lname.getText(),  userID.getText(),  email.getText(),  password1.getText() );

    }

    private void clearAllFiels()
    {
        fname.clear();
        lname.clear();
        userID.clear();
        email.clear();
        password1.clear();
        password2.clear();

    }




    /**
     * returns false if any input field is empty or nulll
     *
     * @return
     */
    private boolean hasInput()
    {
        return ( fname.getText() == null ||fname.getText().isEmpty() ) || (lname.getText() ==null ||lname.getText().isEmpty() )
                || (userID.getText() ==null ||userID.getText().isEmpty() ) || (email.getText() ==null && email.getText().isEmpty() )
                || (password1.getText() ==null || password1.getText().isEmpty() ) || (password2.getText() ==null || password2.getText().isEmpty() );
    }


	
}

