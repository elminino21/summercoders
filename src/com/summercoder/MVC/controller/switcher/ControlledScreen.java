package com.summercoder.MVC.controller.switcher;

public interface ControlledScreen {
	
	//This method will allow the injection of the Parent ScreenPane
    public void setScreenParent(ScreensController screenPage);
}
