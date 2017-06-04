package com.summercoder.users;

import java.util.Date;

public class User implements  IUser {

    private String firstName;
    private String lastName;
    private String password;
    private Gender gender;
    private String email;
    private Date age;


    public User()
    {
        /*

         */
    }

    public User(String password, String email) {
        this.password = password;
        this.email = email;
    }


    public User(String firstName, String lastName, Gender gender, String email, Date age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.age = age;
    }


    @Override
    public void setAllProperties(String fName, String LName, String email, Gender gender, Date age)
    {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
