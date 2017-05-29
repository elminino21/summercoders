package com.summercoder.MVC.model;

import java.sql.*;

/**
 * Created by elminino on 5/28/17.
 */
public abstract class ModelBase implements  IDataBase
{
    private static Connection connection = null;  // variable is static to prevent multiple instaciations
    private static boolean hasData = false;  // checks if a datebase exit on the  current directory


    /**
     * gets connection to database
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private Connection getConnection() throws ClassNotFoundException, SQLException {

        // Class.forName("org.sqlite.JDBC"); // statement no needed anymore in java 8, java loads the driver by itself now
        // database path, if it's new database, it will be created in the project folder
        connection = DriverManager.getConnection("jdbc:sqlite:APPFiles/sql/appDataBase.sqlite");
        System.out.println("connection open successfully");
        this.initialize();

        return connection;
    }
    /**
     * creates the database if itdoes exiet
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    private void initialize() throws SQLException, ClassNotFoundException
    {
        if( !hasData ) {
            hasData = true;
            // check for database table
            Statement state = connection.createStatement();

            ResultSet resulSet = state.executeQuery("SELECT NAME FROM sqlite_master WHERE type='table' AND name='USERS'");
            if( !resulSet.next()) // check if the database has data
            {
                /**
                 * creates table
                 *
                 */


            }
        }
    }

    public ResultSet desisplayAll()
    {
        return null;
    }
    public  void close()
    {
        try {
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
