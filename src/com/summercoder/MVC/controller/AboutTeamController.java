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
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 *
 * @author elminino
 */
public class AboutTeamController implements Initializable, ControlledScreen
{
	private ScreensController myController;

	@FXML
	private AnchorPane root;
	@FXML
	private JFXDrawer drawer;
	@FXML
	private JFXHamburger hamberger;
         private VBox side;
         
         private Circle circle;
         
         
         private void setnewDisplayer()
         {
             /*
             Image img = new Image("http://img09.deviantart.net/b261/i/2012/295/6/e/stock_red_heart_leave_autumn_png_by_nexu4-d5iknba.png", true);
            circle.setFill(new ImagePattern(img));
             circle.setStroke(Color.SEAGREEN);
            circle.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
            */
             
              circle = new Circle(100,100,100);
        circle.setStroke(Color.SEAGREEN);
        Image im = new Image("file:APPFiles/images/placeholder.JPG",false);
        circle.setFill(new ImagePattern(im));
        circle.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
            
              AnchorPane.setTopAnchor(circle, 100.0);
            AnchorPane.setLeftAnchor(circle, 100.0);
            AnchorPane.setTopAnchor(circle, 100.0);
            AnchorPane.setRightAnchor(circle, 100.0);
            root.getChildren().add(circle);
            
           
         }

	
 
    @Override
	public void initialize(URL location, ResourceBundle resources) {
                root.getStyleClass().add("root");
		this.setnewDisplayer();
		  sidePanelSetter(); /** the the side panel in the drawer */
		setEvents();
                goToLink();
		
	}
        
        private void goToLink()
        {
            circle.setOnMouseClicked( e->{
                
                if(Desktop.isDesktopSupported())
                    {
                        try
                        {
                            System.out.println("trying to open brower");
                            URI uri = new URI("https://www.linkedin.com/in/villagonzalez");
                            Desktop.getDesktop().browse(uri);
                         }catch (IOException | URISyntaxException b) { 
                         System.out.println("unsupported operation");
                         }
                    }
                                         });
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
