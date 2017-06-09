package com.summercoder.users;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by elminino on 6/6/17.
 */
public class Name {
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty MI;



	public Name(Builder builder)
{
	this.firstName = builder.firstName;
	this.lastName = builder.lastName;
	this.MI = builder.MI;
	
}


public static class Builder
{
	private  SimpleStringProperty firstName;
	private  SimpleStringProperty lastName;
	private  SimpleStringProperty MI;

	public Builder()
	{
		if (firstName == null || lastName == null)
		{
			throw new IllegalArgumentException("first name and last name can't be null");
		}
	
	}
	
	public Builder setFirstName(String firstName)
		{
			this.firstName = new SimpleStringProperty(firstName);
			return this;
		}

	public Builder setLastname(String firstName)
	{
		this.firstName = new SimpleStringProperty(firstName);
		return this;
	}
	public Builder setMI(String firstName)
	{
		this.firstName = new SimpleStringProperty(firstName);
		return this;
	}


	public Name build()
	{
		return new Name(this);
	}

}


	public String getFirstName() {
		return firstName.get();
	}

	public SimpleStringProperty firstNameProperty() {
		return firstName;
	}

	public String getLastName() {
		return lastName.get();
	}

	public SimpleStringProperty lastNameProperty() {
		return lastName;
	}

	public String getMI() {
		return MI.get();
	}

	public SimpleStringProperty MIProperty() {
		return MI;
	}

    
}
