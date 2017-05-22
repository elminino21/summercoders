package com.summercoder.MVC.controller;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;

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

public class MainController implements Initializable, ControlledScreen
{
	private ScreensController myController;
	@FXML
    private PieChart piechart;
    private ObservableList<PieChart.Data> pieChartData; 
	private Random rand = new Random();
	@FXML
	private AnchorPane rootPane;
	@FXML
	private JFXDrawer drawer;
	@FXML
	private JFXHamburger hamberger;
	@FXML private VBox drawerPane;
	
    @FXML
    private void papenclick(MouseEvent event) {
         
    	this.addTestData();
        
        piechart.setData(pieChartData);
    }
	
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		this.addTestData();
		piechart.legendVisibleProperty().setValue(false);
		 piechart.setData(pieChartData);
		 drawer.setSidePane(drawerPane); /** the the side panel in the drawer */
		
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
	
}
