/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summercoder.users.validator;

import java.sql.SQLException;
import org.junit.After;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;



/**
 * Email validator Testing
 *
 * @author mkyong
 *
 */
public class EmailValidatorTest {

	private EmailValidator test;


        @Before
	public void setUp() {
		test = new EmailValidator();
	}

	@Test
	public void confirmingPass() 
        {
           
		assertTrue( test.validate("jse@gmail.net")     );
                assertTrue( test.validate("jse@gmail.com")     );
                assertTrue( test.validate("auggusto@hotmail.com")     );
                
                
                
                
	}
        
        
        @Test
	public void confirmingFails() 
        {
           
		assertFalse( test.validate("jose")     );
                assertFalse( test.validate("jse@.gmail.com")     );
                assertFalse( test.validate("auggusto@*.com")     );
                assertFalse( test.validate("QEWRQWAsfd")     );
                assertFalse( test.validate("jse@.gmail.com")     );
                assertFalse( test.validate("auggusto@*.net")     );         
                
	}
        
        
        

        @After
	public void tearDown() throws Exception 
	{
            test = null;
            assertNull(test);
        }
        
        
}