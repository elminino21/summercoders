package com.summercoder.MVC.model;

public interface IConnectionObject {
	
	public void setup()throws Exception;
	public void close()throws Exception;
	public void connect()throws Exception;
}
