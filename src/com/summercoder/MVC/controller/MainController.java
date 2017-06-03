package com.summercoder.MVC.controller;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXSnackbar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import com.jfoenix.controls.JFXTabPane;
import com.summercoder.MVC.controller.switcher.ControlledScreen;
import com.summercoder.MVC.controller.switcher.ScreensController;
import com.summercoder.MVC.views.GUITestester;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.stage.Stage;

public class MainController implements Initializable, ControlledScreen
{
	private ScreensController myController;
	@FXML
    private PieChart piechart;
    private ObservableList<PieChart.Data> pieChartData; 
	private Random rand = new Random();
	@FXML
	private AnchorPane root;
	@FXML
	private JFXDrawer drawer;
	@FXML
	private JFXHamburger hamberger;


         private VBox side;

	
    @FXML
    private void papenclick(MouseEvent event) 
    {
         
    	this.addTestData();
        setSnackbar();
        piechart.setData(pieChartData);
    }
	
    @Override
	public void initialize(URL location, ResourceBundle resources) {
        root.getStyleClass().add("root");
		this.addTestData();
		piechart.legendVisibleProperty().setValue(false);
        piechart.setData(pieChartData);
        sidePanelSetter(); /** the the side panel in the drawer */
		setEvents();
		this.setSnackbar();
		
	}
    private void addTestData()
    {
    	
    	pieChartData = 
                FXCollections.observableArrayList(
                    new PieChart.Data("Robert", rand.nextInt() % 100 ),
                    new PieChart.Data("Nick", rand.nextInt() % 100),
                    new PieChart.Data("Tyler", rand.nextInt() % 100),
                    new PieChart.Data("James", rand.nextInt() % 100),
                    new PieChart.Data("Jay", rand.nextInt() % 100));
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

        private void setSnackbar()
        {

             JFXSnackbar snackbar = new JFXSnackbar( );
            snackbar.registerSnackbarContainer(root);
            snackbar.toFront();
            snackbar.prefWidth(600);

            snackbar.show("I AM A POP UP MESSAGE", 10000);

        }

	
}
