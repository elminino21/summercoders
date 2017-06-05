/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summercoder.TestSuit;

import com.summercoder.database.DatabaseTest;
import com.summercoder.database.ItemsTableTest;
import com.summercoder.database.PreferencesTablesTest;
import com.summercoder.database.UserTableInfoTest;
import com.summercoder.users.validator.EmailValidator;
import com.summercoder.users.validator.EmailValidatorTest;
import com.summercoder.users.validator.PasswordValidatorTest;
import com.summercoder.users.validator.RegularStringValidatorTest;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 *
 * @author elminino
 */
@RunWith(Suite.class)
@SuiteClasses({PasswordValidatorTest.class, EmailValidatorTest.class, RegularStringValidatorTest.class, DatabaseTest.class, UserTableInfoTest.class,
ItemsTableTest.class, PreferencesTablesTest.class, PreferencesTablesTest.class})
public class MainTest  {
    
    
}
