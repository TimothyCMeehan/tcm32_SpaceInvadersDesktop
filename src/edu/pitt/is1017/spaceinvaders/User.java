package edu.pitt.is1017.spaceinvaders;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class User {
	
	private int userID = 8;
	private String lastName;
	private String firstName;
	private String email;
	private String password;
	private boolean loggedIn = false;
	
	public User(int userID) {
		this.userID = userID;
		//retrieve data from database corresponding to received userID
		//and set appropriate class properties
		
	}
	
	public User(String email, String password) {
		
		//create String that holds MySQL query using inputed email and password
		String selectString = "SELECT * FROM users WHERE email = '" 
				+ email + "' AND password = MD5('" + password + "');";
		
		//create a DbUtilities object
		DbUtilities alienDB = new DbUtilities();
		
		//create a ResultSet Object holding the results of the MySQL query
		ResultSet userResult = alienDB.getResultSet(selectString);
		try {
			if(userResult.next()){
				
				this.email = email;
				this.password = password;
				this.loggedIn = true;
				this.userID = userResult.getInt("userID");
				this.firstName = userResult.getString("firstName");
				this.lastName = userResult.getString("lastName");
				
				JOptionPane.showMessageDialog(null, "Welcome back, "+ this.firstName +"!");
				
			}// end of if block
			else{
				
				JOptionPane.showMessageDialog(null, "Sorry, that email or password was not found");
				
			}//end of else block
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//close connection with database
		alienDB.closeConnection();
		
		
	}
	
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
		
		//open new DbUtilities object
		DbUtilities alienDB = new DbUtilities();
		
		//execute database query using insertString
		alienDB.executeQuery(insertString);
		
		//System.out.println(insertString);
		
	}
	
	public void saveUserInfo(){
		String updateString = "";
		updateString = "UPDATE alieninvasion.users "
				+ "SET lastName = '" + this.lastName +"' , firstName = '" + this.firstName + "' , email = '"
				+ this.email +"' , password = MD5('"+ this.password + "') "
				+ "WHERE userID = " + this.userID + ";";
		
		DbUtilities alienDB = new DbUtilities();
		alienDB.executeQuery(updateString);
		
		//System.out.println(updateString);
	}
	
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
