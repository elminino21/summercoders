package com.summercoder.MVC.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface  IDataBase {

	ResultSet desisplayAll();
	void close();
}
