/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summercoder.users.validator;

import static org.junit.Assert.*;
import com.summercoder.MVC.model.DataBase;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *confirm strings does not have numbers
 * @author elminino
 */
public class RegularStringValidatorTest {
    
    
        private PasswordValidator test;


        @Before
	public void setUp() {
		test = new PasswordValidator();
	}

	@Test
	public void confirmingPass() 
        {
           
		
                          
	}
        
        
        @Test
	public void confirmingFails() 
        {
           
                assertFalse( test.validate("ADFEEEF")     );
                assertFalse( test.validate("jsegmailc3om")     );
                assertFalse( test.validate("augguston0et")     );         
          
                assertFalse( test.validate("j@e@.1gmail.@")     );
                
	}
        
        
        

        @After
	public void tearDown() throws Exception 
	{
            test = null;
            assertNull(test);
        }
        
}
