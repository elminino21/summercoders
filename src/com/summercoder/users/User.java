package com.summercoder.users;

import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class User implements  IUser {

    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty password;
    private SimpleStringProperty email;
    private Gender gender;
    private Date age;



    public User()
    {
        /*

         */
    }

    public User(String password, String email) {
        this.password = new SimpleStringProperty(password);
        this.email = new SimpleStringProperty(email);
    }


    public User(String firstName, String lastName, Gender gender, String email, Date age) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.gender = gender;
        this.email = new SimpleStringProperty(email);
        this.age = age;
    }


    @Override
    public void setAllProperties(String fName, String LName, String email, Gender gender, Date age)
    {

    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

}
