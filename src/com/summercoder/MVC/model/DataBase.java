package com.summercoder.MVC.model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * creates a database called appData 
 * The class all adds student id and password. 
 * 
 * @author Jose Gonzalez
 *
 */
public class DataBase implements IDataBase{
	
	private static Connection connection = null;  // variable is static to prevent multiple instaciations
	private static boolean hasData = false;  // checks if a datebase exit on the  current directory
	
	
	/**
	 * use for displaying all the infor in the table
	 * @return information related to the specified customer
	 * @throws ClassNotFoundException
	 * @throws SQLException
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
		  res = state.executeQuery("SELECT * FROM USERS");
		 
		} catch (Exception e ) {
			System.out.println("failed to get connection method USERS");
			e.printStackTrace();	
		}
		 return res;
	}
	
	
	
	/**
	 * attachbliches the connection to the database
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
				 
				
				 this.createUserTable();  // creates new table
							
				 this.studentUserCreator();  	
			 }	 
		 } 
	 }
	
	/**
	 * creates a user table
	 */
	 private void createUserTable()
	 {
		 System.out.println("Creating new table");
		 try {
			 Statement statement = connection.createStatement();
			statement.executeUpdate("CREATE TABLE USERS( id VARCHAR(50),  password VARCHAR(50) );");
		} catch (SQLException e) {
			System.out.print("fail to create tabel question");
			e.printStackTrace();
		}
	 }
	
	 /**
	  * addes user student to the date base
	  * @throws SQLException
	  */
	 private void studentUserCreator() throws SQLException
	 {
		  
		  Statement statement = connection.createStatement();
	      String sql = "INSERT INTO USERS ( rowid, id , password ) " +
	                   "VALUES ( 1, 'student@gmail.com', 'Student12' );"; 
	      statement.executeUpdate(sql);
	     
	 }
	
	/**
	 * adds new users to table
	 * 
	 * @param rowid
	 * @param answer
	 * @param guessCorrectly
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	 @Override
	 public void add( long rowid, String id, String password  ) throws SQLException, ClassNotFoundException
	 {
		 if( connection == null)
			{
				this.getConnection();
			}	
		 												
		 String query = "INSERT INTO USERS ( guessCorrectly, ANSWER) VALUES(?,?)";
		 PreparedStatement  preState = connection.prepareStatement(query);
		 
		// preState.setLong( 1, rowid);
		 preState.setString( 1, id );
		 preState.setString( 2, password );
		
		 preState.execute();	
		 preState.close();
                 
                 Statement statement = connection.createStatement();
	      String sql = "INSERT INTO USERS ( id , password ) " +
	                   "VALUES (  'student@gmail.com', 'Student12' );"; 
	      statement.executeUpdate(sql);
                 
     	
	 }

	 
	 /**
	  * closess the connection
	  */
	 public void close()
	 {
		 try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }


	public boolean hasUser(String email, String passWord) 
        {
            try{
                
            
                if( connection == null)
		{
			
			this.getConnection();
			
		}
                
            }catch(ClassNotFoundException | SQLException e)
            {
                System.out.println("Fail to connect");
            }
            
            try
            {
                Statement stmt = connection.createStatement();
                 boolean isUser = false;
                 ResultSet rs = stmt.executeQuery( "SELECT * FROM USERS;" );
                while ( rs.next()  ) 
                 {
                String id = rs.getString("id");
                String pass = rs.getString("password");
                

                    if(id.equals(email) && pass.equals(passWord))
                        return true;
               
                if(id.equals(email)) isUser = true;
             }
            
                 
                 
            }catch(SQLException e)
            {
                System.out.println("failed to get pasword and id");
            }
            
  
            return false;
      }
        
        
   
        
}
