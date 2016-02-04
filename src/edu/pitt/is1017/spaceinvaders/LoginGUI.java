package edu.pitt.is1017.spaceinvaders;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
//Still needed: add functionality to buttons
public class LoginGUI {
	
	private JFrame mainFrame; // Frame
	
	private JLabel lblEmail; // Email Label
	private JTextField txtEmail; // Email TextField
	
	private JLabel lblPassword; // Password Label
	private JTextField txtPassword; // Password TextField
	
	private JButton btnRegister; //Robot One Save Button
	private JButton btnLogin; //Robot Two Save Button
	private JButton btnCancel; // Run Battle button

	public LoginGUI(){
		// class constructor calls the GUI builder method
		buildGUI();
	}//end of class constructor
	
	public static void main(String[] args) {
		//main method calls the class constructor
		LoginGUI startUp = new LoginGUI();

	}//end of main method
	
	public void buildGUI(){
		
		mainFrame = new JFrame("SpaceInvaders - Login"); // Instantiate frame
		mainFrame.setSize(400, 200); //set frame size
		mainFrame.setLayout(null); // set frame to absolute layout
		
		// The following block of code is an event handler that allows you to actually close the frame window
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}        
		}); // end event handler
		
		lblEmail = new JLabel("Email:", JLabel.LEFT);//initializes label
		lblEmail.setBounds(20, 20, 100, 30); // Set label size and position
		
		txtEmail = new JTextField("");//initializes textbox
		txtEmail.setBounds(150, 20, 230, 30); // Set textbox size and position
		
		lblPassword = new JLabel("Password:", JLabel.LEFT);//initializes label
		lblPassword.setBounds(20, 60, 100, 30); // Set label size and position
		
		txtPassword = new JTextField("");//initializes textbox
		txtPassword.setBounds(150, 60, 230, 30); // Set textbox size and position
		
		btnRegister = new JButton("Register"); //creates button to Register new User
		btnRegister.setBounds(10, 114, 100, 32); //sets button position and size
		
		btnLogin = new JButton("Login"); //creates button to Login existing User
		btnLogin.setBounds(146, 114, 100, 32); //sets button position and size
		
		btnCancel = new JButton("Cancel"); //creates button to cancel out of program
		btnCancel.setBounds(282, 114, 100, 32); //sets button position and size
		
		//add labels, textboxes, and buttons to main frame
		mainFrame.add(lblEmail);
		mainFrame.add(txtEmail);
		
		mainFrame.add(lblPassword);
		mainFrame.add(txtPassword);
		
		mainFrame.add(btnRegister);
		mainFrame.add(btnLogin);
		mainFrame.add(btnCancel);
		
		//make frame visible
		mainFrame.setVisible(true);
		
	}//end of buildGUI method

}//end of class
