package edu.pitt.is1017.spaceinvaders;

import java.sql.*;
import java.net.URL;

public class Tester {

	public static void main(String[] args) {
		//create insert query
		//create connection
		User newUser = new User("Dunlop", "Fuzzy", "fud007@pitt.edu", "test123");
		newUser.setFirstName("Wuzzy");
		newUser.saveUserInfo();
	}

}
