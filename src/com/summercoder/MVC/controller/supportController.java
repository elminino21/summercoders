/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summercoder.MVC.controller;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.summercoder.MVC.controller.switcher.ControlledScreen;
import com.summercoder.MVC.controller.switcher.ScreensController;
import com.summercoder.MVC.views.GUITestester;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author elminino
 */
public class supportController implements Initializable, ControlledScreen
{
	private ScreensController myController;

	@FXML
	private AnchorPane root;
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
	private void sendPressed(ActionEvent event)
	{
              
		myController.setScreen(GUITestester.screen1ID);
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
                             case "account": myController.setScreen(GUITestester.screen3ID);
                             break;
                             case "exit": myController.setScreen(GUITestester.screen1ID);
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
