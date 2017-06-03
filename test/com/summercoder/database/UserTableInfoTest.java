package com.summercoder.database;

import com.summercoder.MVC.model.DataBase;
import com.summercoder.MVC.model.UserTableInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by elminino on 6/2/17.
 */
public class UserTableInfoTest {
    /**
     * @instanceVariables
     */
    UserTableInfo data;
    UserTableInfo result;

    /**
     * not the annotation @Before let's java know that this method should be run first.
     */
    @Before
    public void setUp()
    {

    }

    /**
     * all the @test are ran one after the other
     */

    @Test
    public void test() throws ClassNotFoundException   {


    }

    /**
     * the annotation @After is to make sure the appplication is closing as intended
     *
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception
    {



    }
}
