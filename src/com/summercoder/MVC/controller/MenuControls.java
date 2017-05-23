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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author elminino
 */
public abstract class MenuControls implements IMenuControls, ControlledScreen {
    
    
        protected ScreensController myController;
	protected Pane root;
	@FXML
	protected JFXDrawer drawer;
	@FXML
	protected JFXHamburger hamberger;
	@FXML protected VBox drawerPane;
	
        public MenuControls(Pane root, JFXHamburger hamberger,  JFXDrawer drawer, VBox drawerPane)
        {
            this.root = root;
            this.hamberger = hamberger;
            this.drawer = drawer;
            this.drawerPane = drawerPane;
            
            this.setup();
        }
        
        private void setup()
        {
            drawer.setSidePane(drawerPane); /** the the side panel in the drawer */
              root.getStyleClass().add("root");
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
	
	public void drawerClose( )
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
         @Override
	public void openDrawer()
	{
		drawer.open();
		drawer.toFront();
		
	}
	
        @Override
	public void setScreenParent(ScreensController screenParent)
	{
		myController = screenParent;
	}

    
    
}
