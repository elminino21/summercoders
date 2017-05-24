package com.summercoder.MVC.controller;

import com.jfoenix.controls.JFXDialog;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXPopup;
import com.summercoder.MVC.controller.switcher.ControlledScreen;
import com.summercoder.MVC.controller.switcher.ScreensController;
import com.summercoder.MVC.views.GUITestester;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;

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
	private void  forgotPasswordPressed(MouseEvent event)
	{
            
            System.out.println("forgot password pressed");
        
            
            myController.setScreen(GUITestester.screen4ID);
            
            
            
		
		event.consume();
	}
        
        @FXML
	private void loginPress(ActionEvent event)
	{
            
            
		myController.setScreen(GUITestester.screen2ID);
		event.consume();
	}
        
        @FXML
	private void newUserPressed(MouseEvent event)
	{
                //System.out.print
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
                             case "account": myController.setScreen(GUITestester.screen3ID);
                             break;
                             case "exit": myController.setScreen(GUITestester.screen3ID);
                             break;
                             case "about": myController.setScreen(GUITestester.screen3ID);
                             break;
                             case "support": myController.setScreen(GUITestester.screen5ID);
                                
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

	

	
}
