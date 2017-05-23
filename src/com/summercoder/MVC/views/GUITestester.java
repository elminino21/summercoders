package com.summercoder.MVC.views;

import com.summercoder.MVC.controller.switcher.ScreensController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * this class it is just for testing perpuses
 * @author Jose Gonzalez
 *Parent root= FXMLLoader.load(getClass().getResource("mention the path to your fxml file");
 */
public class GUITestester extends Application{
	
	
	    public static String screen1ID = "login";
	    public static String screen1File = "/com/summercoder/MVC/views/Loginview.fxml";
	    public static String screen2ID = "main";
	    public static String screen2File = "/com/summercoder/MVC/views/MainView.fxml";
            public static String screen3ID = "newlogin";
	    public static String screen3File = "/com/summercoder/MVC/views/NewUserView.fxml";
	    
	    

	@Override
	public void start(Stage stage) throws Exception
	{
			
	ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(GUITestester.screen1ID, GUITestester.screen1File);
        mainContainer.loadScreen(GUITestester.screen2ID, GUITestester.screen2File);
        mainContainer.loadScreen(GUITestester.screen3ID, GUITestester.screen3File);
      
        mainContainer.setScreen(GUITestester.screen1ID);
        
                
        stage.setTitle("Summer Coders");
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Lobster");
        scene.getStylesheets().add("style.css");
       
        stage.setScene(scene);
        
        stage.show();
		
		
	}
	
	
	/**
	 * not need, but I added in case youare not using an IDE comparable with javafx
	 * @param args
	 */
	public static void main(String[] args) {
        launch(args);
    }
}
