package com.summercoder.users;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class User implements  IUser {


    private SimpleLongProperty userIndex; /** will be use to link to all the tables related to he user information */
    private final Name name = new Name();
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


    public User( Gender gender, String email, Date age) {

        this.gender = gender;
        this.email = new SimpleStringProperty(email);
        this.age = age;
    }


    @Override
    public void setAllProperties( Name name, String email, Gender gender, Date age)
    {

        this.gender = gender;
        this.email = new SimpleStringProperty(email);
        this.age = age;
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

    public long getUserIndex() {
        return userIndex.get();
    }

    public SimpleLongProperty userIndexProperty() {
        return userIndex;
    }

    public void setUserIndex(long userIndex) {
        this.userIndex.set(userIndex);
    }

}
