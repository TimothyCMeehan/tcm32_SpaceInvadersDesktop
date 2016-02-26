package edu.pitt.is1017.spaceinvaders;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
/**
 * This class creates an object of type User and stores information about the user in an external database
 * @author timmeehan
 *
 */
public class User {
	
	//class's private properties
	private int userID;
	private String lastName;
	private String firstName;
	private String email;
	private String password;
	private boolean loggedIn = false;
	
	/**
	 * User class constructor whose only inputed value is the user's unique user ID
	 * This ID is used to load all other properties based on info form the database
	 * @param userID
	 */
	public User(int userID) {
		
		//create String that holds MySQL query using inputed email and password
		String selectString = "SELECT * FROM users WHERE userID = " 
			+ userID + ";";
		
		//create a DbUtilities object
		DbUtilities alienDB = new DbUtilities();
		
		//create a ResultSet Object holding the results of the MySQL query
		ResultSet userResult = alienDB.getResultSet(selectString);
		try {
			if(userResult.next()){
						
				this.email = userResult.getString("email");
				this.loggedIn = true;
				this.userID = userID;
				this.firstName = userResult.getString("firstName");
				this.lastName = userResult.getString("lastName");
					
			}// end of if block
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//close connection with database
		alienDB.closeConnection();
				
	}//end of constructor
	
	/**
	 * This class constructor takes an inputed email and password
	 *  and checks to see if these value exist in the database.
	 *  If they do the user's information is added to the object's properties
	 * @param email user's inputed email address
	 * @param password user's inputed password
	 */
	public User(String email, String password) {
		
		//create String that holds MySQL query using inputed email and password
		String selectString = "SELECT * FROM users WHERE email = '" 
				+ email + "' AND password = MD5('" + password + "');";
		
		//create a DbUtilities object
		DbUtilities alienDB = new DbUtilities();
		
		//create a ResultSet Object holding the results of the MySQL query
		ResultSet userResult = alienDB.getResultSet(selectString);
		try {
			//checks to see if the user's information was found
			if(userResult.next()){
				//fills in user info into object's properties
				this.email = email;
				this.password = password;
				this.loggedIn = true;
				this.userID = userResult.getInt("userID");
				this.firstName = userResult.getString("firstName");
				this.lastName = userResult.getString("lastName");
				
				//display confirmation message
				JOptionPane.showMessageDialog(null, "Welcome back, "+ this.firstName +"!");
				
			}// end of if block
			else{//executes if email or password is not found in database
				
				//sets logged in property to false
				this.loggedIn = false;
				
				//displays error message
				JOptionPane.showMessageDialog(null, "Sorry, that email or password was not found"
						+ "\nPlease re-enter your Email and Password");
				
			}//end of else block
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//close connection with database
		alienDB.closeConnection();
		
		
	}//end of constructor
	
	/**
	 * This constructor is used to create a new user and add their information to the user
	 * database
	 * 
	 * @param lastName user's last name
	 * @param firstName user's first name
	 * @param email user's email
	 * @param password user's password
	 */
	public User(String lastName,String firstName, String email, String password) {
		//set objects personal properties to inputed values
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		//should I set logged in to true?
		
		//create string to hold MySQL insert query
		String insertString = "INSERT INTO alieninvasion.users(lastName, firstName, email, password) ";
		insertString += "VALUES ('" + this.lastName + "', '" + this.firstName
				+ "', '" + this.email + "', MD5('" + this.password + "'));";
		
		//create String that holds MySQL query using inputed email and password to find out userID
		String selectString = "SELECT userID FROM alieninvasion.users WHERE email = '" 
						+ email + "' AND password = MD5('" + password + "');";
		
		//open new DbUtilities object
		DbUtilities alienDB = new DbUtilities();
		
		//execute database query using insertString
		alienDB.executeQuery(insertString);
		
		//create a ResultSet Object holding the results of the MySQL query written in selectString
		ResultSet userResult = alienDB.getResultSet(selectString);
		
		try {
			this.userID = userResult.getInt("userID");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//close connection with database
		alienDB.closeConnection();
		
		
		//System.out.println(insertString);
		
	}//end of constructor
	
	/**
	 * this methods updates the user info found on the database to match the object's private properties
	 */
	public void saveUserInfo(){
		 
		//create a string that contains the MySQL statement
		 String updateString = "UPDATE alieninvasion.users "
				+ "SET lastName = '" + this.lastName +"' , firstName = '" + this.firstName + "' , email = '"
				+ this.email +"' , password = MD5('"+ this.password + "') "
				+ "WHERE userID = " + this.userID + ";";
		
		 //creates a DbUtilities object
		DbUtilities alienDB = new DbUtilities();
		
		//execute query using MySQL statement string named updateString
		alienDB.executeQuery(updateString);
		
		//System.out.println(updateString);
		
	}//end of method
	
	//Class getters and setters
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public int getUserID() {
		return userID;
	}

}
