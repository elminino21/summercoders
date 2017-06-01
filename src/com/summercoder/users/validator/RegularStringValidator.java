/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summercoder.users.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author elminino
 */
public class RegularStringValidator implements IValidate{

	private Pattern pattern;
	private Matcher matcher;

	private static final String PATTERN = "\\d";

	public RegularStringValidator() {
		pattern = Pattern.compile(PATTERN);
	}
        
  
	public boolean validate(final String input)
        {
		matcher = pattern.matcher(input);
		return !matcher.matches();
	}
        
}