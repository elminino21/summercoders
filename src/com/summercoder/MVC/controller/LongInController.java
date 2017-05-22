package com.summercoder.MVC.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXDrawer.DrawerDirection;
import com.summercoder.MVC.controller.switcher.ControlledScreen;
import com.summercoder.MVC.controller.switcher.ScreensController;
import com.summercoder.MVC.views.GUITestester;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class LongInController  implements Initializable, ControlledScreen  {
	
	private ScreensController myController;
	
	@FXML
	private AnchorPane rootPane;
	@FXML
	private JFXDrawer drawer;
	@FXML
	private JFXHamburger hamberger;
	@FXML private VBox drawerPane;
	
	@FXML
	private void loginPress(ActionEvent event)
	{
		myController.setScreen(GUITestester.screen2ID);
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
		
		drawer.setSidePane(drawerPane); /** the the side panel in the drawer */
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
	
	public void setScreenParent(ScreensController screenParent)
	{
		myController = screenParent;
	}

	

	
}
