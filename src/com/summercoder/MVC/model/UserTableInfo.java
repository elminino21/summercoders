package com.summercoder.MVC.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by elminino on 5/28/17.
 */
public class UserTableInfo extends ModelBase{


    public  String tableName; /* name of the current table */

    public UserTableInfo(String tableName) {
        super(tableName);
        this.tableName = tableName;
    }

    /**
     * creates new user fields
     * @param fname
     * @param lname
     * @param userID
     * @param email
     * @param password
     */
    public void addNewUser(String fname, String lname, String userID, String email, String password )
    {

        if( super.connection == null)
        {
            super.getConnection();
        }

        try {


            String query = "INSERT INTO " + tableName + " ( fname, lname, userID, email, password ) VALUES(?,?, ?,?, ?)";
            PreparedStatement preState = super.connection.prepareStatement(query);

            preState.setString(1, fname);
            preState.setString(2, lname);
            preState.setString(3, userID);
            preState.setString(4, email);
            preState.setString(5, password);


            preState.execute();
            preState.close();

            Statement statement = connection.createStatement();
            String sql = "INSERT INTO USERS ( id , password ) " +
                    "VALUES (  'student@gmail.com', 'Student12' );";
            statement.executeUpdate(sql);


        }catch(SQLException e)
        {
            System.out.println("exception on add new user");
        }


    }

    /**
     * adds test data to the resendly created table
     * @throws SQLException
     */

    @Override
    public  void addTestData()
    {

        try{

            Statement statement = connection.createStatement();
            String sql = "INSERT INTO "+ tableName +" (  fname , lname , id , , email,  password  ) " +
                    "VALUES ( 'Student', , 'Student' , 'Student', 'student@gmail.com', 'Student12' );";
            statement.executeUpdate(sql);

        }catch(SQLException e)
        {
            System.out.println("");
        }
    }


    @Override
    public void createTable()
    {
        System.out.println("Creating new table");
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE " + tableName + "( fname VARCHAR(50), lname VARCHAR(50), id VARCHAR(50), , email VARCHAR(50) password VARCHAR(50) );");

        } catch (SQLException e) {
            System.out.print("fail to create tabel question");
            e.printStackTrace();
        }
    }







}
