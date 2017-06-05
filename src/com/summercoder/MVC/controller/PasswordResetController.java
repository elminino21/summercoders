package com.summercoder.MVC.controller;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.summercoder.MVC.controller.switcher.ControlledScreen;
import com.summercoder.MVC.controller.switcher.ScreensController;
import com.summercoder.MVC.views.GUITestester;
import com.summercoder.appsupport.Sender;
import com.summercoder.users.validator.EmailValidator;
import com.summercoder.users.validator.PasswordValidator;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;


public class PasswordResetController  implements Initializable, ControlledScreen
{
	private ScreensController myController;
	
   
	@FXML
	private AnchorPane root;
        @FXML
        JFXTextField  textfieldEmail;
        @FXML
        private Label massageLabel;
	@FXML
	private JFXDrawer drawer;
	@FXML
	private JFXHamburger hamberger;
        private VBox side;
	
	
        @Override
	public void initialize(URL location, ResourceBundle resources) {
                root.getStyleClass().add("root");
		 sidePanelSetter(); /** the the side panel in the drawer */
		setEvents();
	}
        
      @FXML
	private void sendPress(ActionEvent event)
	{

            if( sentEmail() == true )
            {
                Sender mgn = new Sender(textfieldEmail.getText(), "This is a test email(body)", "test title" );
                myController.setScreen(GUITestester.screen1ID);
            }else
            {
                AudioClip plonkSound = new AudioClip("file:APPFiles/sounds/error.mp3");
                plonkSound.play();
                clearField();
            }
        textfieldEmail.clear();
		event.consume();
	}

	private void clearField()
    {
        textfieldEmail.clear();
    }
        
        private boolean sentEmail()
        {
            EmailValidator email = new EmailValidator();
            
            boolean answer = false;
            
           if( (textfieldEmail.getText() ==null || textfieldEmail.getText().isEmpty()) )
            {
                 massageLabel.setText("Enter Email to proceed"); 
            
            }else if(  !email.validate( textfieldEmail.getText())     )
            {
                       massageLabel.setText("Invalid email entered");
            }else{
                answer = true;
            }
            
            return answer;
     
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

        drawer.setOnDrawerClosed( (e)->  drawer.toBack() );
        if( !drawer.isHidden()  )
        {
            drawer.close();


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
                        drawerClose();
                        clearField();
                         switch(node.getId()) {
                             case "account": myController.setScreen(GUITestester.screen3ID);
                             break;
                       
                             case "exit": 
                                  Stage stage = Stage.class.cast(Control.class.cast(e.getSource()).getScene().getWindow());
                                 stage.close();
                             break;
                             case "about": myController.setScreen(GUITestester.screen6ID);
                             break;
                             case "support": myController.setScreen(GUITestester.screen5ID);
                             
                                
                         }
                        
                    });
               
               }

           } 
        }
	
}


