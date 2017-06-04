package com.summercoder.MVC.model;

import java.sql.*;

/**
 * Created by @Author elminino on 5/28/17.
 * base class for creating new tables
 */
public abstract class ModelBase implements  IDataBase
{

    protected static Connection connection = null;  // variable is static to prevent multiple instaciations
    protected static boolean hasData = false;  // checks if a datebase exit on the  current directory
    private String tableName;

    public ModelBase(String tableName )
    {
        this.tableName = tableName;
    }

    /**
     * gets connection to database
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    protected Connection getConnection()
    {

        // Class.forName("org.sqlite.JDBC"); // statement no needed anymore in java 8, java loads the driver by itself now
        // database path, if it's new database, it will be created in the project folder
        try
        {


            connection = DriverManager.getConnection("jdbc:sqlite:APPFiles/sql/appDataBase.sqlite");
            System.out.println("connection open successfully");
            this.initialize();
        }catch (  SQLException e)
        {
            System.out.println("exception get connection method");
        }

        return connection;
    }

    /**
     * creates the database if itdoes exiet
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    protected void initialize()
    {
        try{


            if( !hasData ) {
                hasData = true;
                // check for database table
                Statement state = connection.createStatement();

                ResultSet resulSet = state.executeQuery("SELECT NAME FROM sqlite_master WHERE type='table' AND name='"+ tableName + "'"   );
                if( !resulSet.next()) // check if the database has data
                {
                    /**
                     *
                     * creates tables and adds  test data
                     *
                     */
                    System.out.println("added test data");
                     this.createTable();
                     this.addTestData();

                }
            }

        }catch(SQLException  e )
        {
            System.out.println("exeption ");
        }
    }


    /**
     * Displays all the information on the selected table
     * @return
     */
    public ResultSet desisplayAll()
    {
        ResultSet res = null;
        try {

            if( connection == null)
            {

                this.getConnection();

            }
            Statement state = connection.createStatement();
            res = state.executeQuery("SELECT * FROM " + tableName);

        } catch (Exception e ) {
            System.out.println("failed to get connection method " + tableName);
            e.printStackTrace();
        }
        return res;
    }

    /**
     * closes the connection to the data base;
     */
    public  void close()
    {
        try {
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * adds test data to the table
     * @throws SQLException
     */
    abstract void addTestData() throws SQLException;

    abstract void createTable();



}
