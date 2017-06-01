package com.summercoder.database;

import static org.junit.Assert.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.*;
import org.junit.Before;
import org.junit.Test;

import com.summercoder.MVC.model.DataBase;

import junit.framework.TestCase;

public class DatabaseTest {
	/**
	 * @instanceVariables
	 */
	DataBase data;
	ResultSet result;
	
	/**
	 * not the annotation @Before let's java know that this method should be run first. 
	 */
	@Before
	public void setUp() 
	{
		 data = new DataBase();
		 result = data.desisplayAll();
	}
	
	/**
	 * all the @test are ran one after the other
	 */
	
        @Test
	public void test() throws ClassNotFoundException   {
		
		try {
			assertEquals(true, result.next());
                        
						
		}catch (SQLException   e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * the annotation @After is to make sure the appplication is closing as intended
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception 
	{
		
		result.close();
		data.close();
		
		if(result.isClosed())
		{
			result = null;
			data = null;
		}
		
		assertNull(data);
		assertNull(result);

	}

}
