package com.summercoder.MVC.controller;

import com.jfoenix.controls.JFXDialog;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXTextField;
import com.summercoder.MVC.controller.switcher.ControlledScreen;
import com.summercoder.MVC.controller.switcher.ScreensController;
import com.summercoder.MVC.model.DataBase;
import com.summercoder.MVC.views.GUITestester;
import com.summercoder.users.validator.EmailValidator;
import com.summercoder.users.validator.PasswordValidator;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

public class LongInController  implements Initializable, ControlledScreen  {
	
	private ScreensController myController;
	private JFXDialog pop;
	@FXML
	private AnchorPane root;
	@FXML
	private JFXDrawer drawer;
	@FXML
	private JFXHamburger hamberger;
	VBox side;  
        @FXML
	private Label massageLabel;
       @FXML
       private JFXTextField textfieldEmail;
       @FXML
       private JFXPasswordField  passInput;
	
	
       @FXML
	private void loginPress(ActionEvent event)
	{

           login(event);
	}

	private void login(Event e)
    {
//        if(checkFiels() == true && IsUser() == true )
//        {
            myController.setScreen(GUITestester.screen2ID);
//        }else
//        {
//            AudioClip plonkSound = new AudioClip("file:APPFiles/sounds/error.mp3");
//            plonkSound.play();
//        }
        clearFields();
        e.consume();
    }



        private boolean checkFiels()
        {
            EmailValidator email = new EmailValidator();
            PasswordValidator pass = new PasswordValidator();
            boolean answer = false;
            if( (textfieldEmail.getText() ==null ||textfieldEmail.getText().isEmpty()) && (passInput.getText() ==null ||passInput.getText().isEmpty()) )
            {
                massageLabel.setText("Enter Email and Password to proceed");      
                
            }else if( (textfieldEmail.getText() ==null ||textfieldEmail.getText().isEmpty()) )
            {
                 massageLabel.setText("Enter Email to proceed"); 
            }
            else if( (passInput.getText() ==null ||passInput.getText().isEmpty()) )
            {
                 massageLabel.setText("Enter password to proceed"); 
            }else if(   !email.validate( textfieldEmail.getText())   ||   !pass.validate( passInput.getText())   )
            {
                       massageLabel.setText("Invalid password or email entered"); 
            }else{
                answer = true;
            }
            
            return answer;
        }



        
        /**
         * confirms the we have that user on our data base
         * @return 
         */
        private boolean IsUser()
        {
          DataBase user = new DataBase(); 
           return  user.hasUser(textfieldEmail.getText(), passInput.getText());         
        }
                
         @FXML
	private void  forgotPasswordPressed(MouseEvent event)
	{
            
            System.out.println("forgot password pressed");
            myController.setScreen(GUITestester.screen4ID);    
		
		event.consume();
	}
        
        
        @FXML
	private void newUserPressed(MouseEvent event)
	{
		myController.setScreen(GUITestester.screen3ID);
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
	
	@Override
	public void initialize(URL url, ResourceBundle rb) 
	{               
		   root.getStyleClass().add("root");
		sidePanelSetter();
                setEvents();
        getFieldCommand();
        getPassCommand();

	}
        private void getFieldCommand()
        {
            textfieldEmail.setOnKeyPressed( (event) -> onEnterPress( event) );

        }

        private void onEnterPress(KeyEvent event)
        {
            if (event.getCode().equals(KeyCode.ENTER))
            {
                login(event);

            }
        }

    private void getPassCommand()
    {
        passInput.setOnKeyPressed( (event) -> onEnterPress( event) );

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
                        
                         switch(node.getAccessibleText()) {
                             case "account":
                                 myController.setScreen(GUITestester.screen3ID);
                             break;
                             case "about": 
                                 myController.setScreen(GUITestester.screen6ID);
                             break;
                             case "support": 
                                 myController.setScreen(GUITestester.screen5ID);
                             break;
                             case "exit": 
                                 Stage stage = Stage.class.cast(Control.class.cast(e.getSource()).getScene().getWindow());
                                 stage.close();
                          
                         }
                        
                    });
               
               }
              
           } 
        }
	
	
	/**
	 * oepn or closes the drawer.
	 */
	
	private void drawerClose( )
	{
		
        if( !drawer.isHidden()  )
        {
        	drawer.close();
                
                if(drawer.isHidding()) 
                {
                    drawer.toBack();
                    
                }    	
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
	
	public void setScreenParent(ScreensController screenParent)
	{
		myController = screenParent;
	}

    private void clearFields()
    {
        textfieldEmail.clear();
        passInput.clear();;
    }

	
}
