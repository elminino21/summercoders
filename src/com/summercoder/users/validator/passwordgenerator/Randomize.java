/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summercoder.users.validator.passwordgenerator;

/**
 * returned pasword needs to be 8 digit logn, have at least a capital letter and number
 * @author Juan
 */
public interface Randomize
{
    boolean randomizer(String passwod);
}
