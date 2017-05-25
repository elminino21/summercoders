/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summercoder.users.validator;

import junit.framework.TestCase;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author elminino
 */
public class PasswordValidatorTest {
    
    private PasswordValidator test;


        @Before
	public void setUp() {
		test = new PasswordValidator();
	}

	@Test
	public void confirmingPass() 
        {
           
		assertTrue( test.validate("ThisTest9")     );
                assertTrue( test.validate("jAe46231@gmail.com")     );
                assertTrue( test.validate("ugg24657435435465453T464684654354saddfdfafd")     );
                
                
                
                
                
	}
        
        
        @Test
	public void confirmingFails() 
        {
           
		assertFalse( test.validate("jo    se")     );
                assertFalse( test.validate("jse@.gmail.com")     );
                assertFalse( test.validate("auggusto@*.com")     );
                assertFalse( test.validate("QEWRQWAsfd")     );
                assertFalse( test.validate("jse@.gmail.com")     );
                assertFalse( test.validate("auggusto@*.net")     );         
                
                assertFalse( test.validate("jose")     );
                assertFalse( test.validate("j@e@.gmail.@")     );
                
	}
        
        
        

        @After
	public void tearDown() throws Exception 
	{
            test = null;
            assertNull(test);
        }
        

    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
}
