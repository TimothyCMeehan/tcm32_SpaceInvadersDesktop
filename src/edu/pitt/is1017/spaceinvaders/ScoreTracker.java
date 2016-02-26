package edu.pitt.is1017.spaceinvaders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import javax.swing.JOptionPane;
/**
 * Score Tracker class keeps track of users score as they defend against the aliens
 * @author timmeehan
 *
 */
public class ScoreTracker {
	private User user;
	private int currentScore;
	private int highestScore;
	private String gameID;
	
	/**
	 * Class constructor takes a user object and looks up their high score on the database
	 * @param user
	 */
	public ScoreTracker(User user){
		//set corresponding class property
		this.user = user;
		//initialize current score to zero
		this.currentScore = 0;
		//create unique game ID
		gameID = UUID.randomUUID().toString();
		
		//add select query to find highest score from user
		//SELECT max(scoreValue) FROM finalscores WHERE fk_userID = 92; 
		String selectString = "SELECT max(scoreValue) FROM alieninvasion.finalscores WHERE fk_userID = " + this.user.getUserID() + ";";
		
		//open new DbUtilities object
		DbUtilities alienDB = new DbUtilities();
		
		//create a ResultSet Object holding the results of the MySQL query written in selectString
		ResultSet userResult = alienDB.getResultSet(selectString);
		
		try {
			if(userResult.next()){
				//set highest score property
				this.highestScore = userResult.getInt("max(scoreValue)");
			}
			else{
				//if this is the user's first game set high score to 0
				this.highestScore = 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//close connection with database
		alienDB.closeConnection();
		
	}
	
	/**
	 * This method will be called every time a shot either hits a target or misses and is erased from the game screen
	 * @param point //passed value is either 1 to add one to the score or -1 to subtract for a miss
	 */
	public void recordScore(int point){
		//add inputed point value to current score
		this.currentScore += point;
		
		//declare and instantiate local variable to hold database shot type value
		int sType = 1;
		
		//if shot was a hit make shot type value one
		if(point==1){
			sType = 1;
		}else{
			//if shot was a miss make shot value zero
			sType = 0;
		}
		
		//add table insert
		//create string to hold MySQL insert query
		String insertString = "INSERT INTO alieninvasion.runningscores(gameID, scoreType, scoreValue, fk_userID, dateTimeEntered) ";
		insertString += "VALUES('" + this.gameID +"', "+ sType +", "+ this.currentScore + ", " + this.user.getUserID() + ", NOW());";
				
		//open new DbUtilities object
		DbUtilities alienDB = new DbUtilities();
						
		//execute database query using insertString
		alienDB.executeQuery(insertString);
	}
	
	
	/**
	 * method is called when a game is completed.  method stores final sscore in the database and displays user statistics
	 */
	public void recordFinalScore(){
		//add table insert
		//create string to hold MySQL insert query
		String insertString = "INSERT INTO alieninvasion.finalscores(gameID, scoreValue, fk_userID, dateTimeEntered) ";
		insertString += "VALUES('" + this.gameID +"', "+ this.currentScore + ", " + this.user.getUserID() + ", NOW());";
		
		//create string to hold MySQL select query for finding top score among all users
		String selectString = "SELECT lastName, firstName, MAX(scoreValue) FROM alieninvasion.finalscores "
				+ "JOIN alieninvasion.users ON fk_userID = userID GROUP BY lastName, firstName "
				+ "ORDER BY MAX(scoreValue) DESC LIMIT 1;";
		
		//open new DbUtilities object
		DbUtilities alienDB = new DbUtilities();
				
		//execute database query using insertString
		alienDB.executeQuery(insertString);
		
		//create a ResultSet Object holding the results of the MySQL query written in selectString
		ResultSet userResult = alienDB.getResultSet(selectString);
		
		try {
			if(userResult.next()){
				
				//output message showing score values
				JOptionPane.showMessageDialog(null, "Your score this game: " + this.currentScore
						+ "\nYour high score: "+ this.highestScore
						+ "\nHighest Scorer: " + userResult.getString("firstName") + " "
						+ userResult.getString("lastName") + " " + userResult.getString("max(scoreValue)"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//close connection with database
		alienDB.closeConnection();
		
		
		
	}
	/**
	 * getter method for current score property
	 * @return
	 */
	public int getCurrentScore() {
		return currentScore;
	}

	/**
	 * getter method for high score property
	 * @return
	 */
	public int getHighestScore() {
		return highestScore;
	}

}
