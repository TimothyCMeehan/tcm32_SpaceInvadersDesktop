package edu.pitt.is1017.spaceinvaders;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 * The LoginGUI class builds the GUI for the login menu. For existing users, it has text fields for email and password. 
 *  For new users, it has a button that links to the register GUI 
 * 
 * @author Timothy Meehan
 *
 */
public class LoginGUI {
	
	private JFrame mainFrame; // Frame
	
	private JLabel lblEmail; // Email Label
	private JTextField txtEmail; // Email TextField
	
	private JLabel lblPassword; // Password Label
	private JTextField txtPassword; // Password TextField
	
	private JButton btnRegister; //Robot One Save Button
	private JButton btnLogin; //Robot Two Save Button
	private JButton btnCancel; // Run Battle button
	
	/**
	 * class constructor
	 */
	public LoginGUI(){
		// class constructor calls the GUI builder method
		buildGUI();
	}//end of class constructor
	
	/**
	 * Main method that calls this class's constructor
	 * @param args
	 */
	public static void main(String[] args) {
		//main method calls the class constructor
		LoginGUI startUp = new LoginGUI();

	}//end of main method
	
	/**
	 * buildGUI method builds the login GUI and assigns actions to the frame's buttons
	 */
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
		btnRegister.addActionListener(new ActionListener(){ //adds action listener to button
			public void actionPerformed(ActionEvent e) {
				
				//call the constructor for the register GUI class
				RegisterGUI registerFrame = new RegisterGUI();
				
				//hide the LoginGUI 
				mainFrame.setVisible(false);
				
			}// end of action performed method
		});// end event handler
		
		btnLogin = new JButton("Login"); //creates button to Login existing User
		btnLogin.setBounds(146, 114, 100, 32); //sets button position and size
		btnLogin.addActionListener(new ActionListener(){ //adds action listener to button
			public void actionPerformed(ActionEvent e) {
				
				//call the constructor of user class and pass it the inputed email and password
				User hero = new User(txtEmail.getText(),txtPassword.getText());
				
				//check to make sure a valid user was entered
				if(hero.getUserID()>0){
					//make the LoginGUI invisible when the game starts
					mainFrame.setVisible(false);
				
					//create new thread for game window
					Thread launchTread = new Thread("Game launch thread"){
						public void run(){
						
							//create a game object and start the game loop
							Game g =new Game(hero);
							g.gameLoop();
							
						}//end of run method
					};//end of thread 
				
					//start the launch thread
					launchTread.start();
					
				}//end of code block executed when user enters valid user ID
				else{
					//clear fields if email or password is not found
					txtEmail.setText("");
					txtPassword.setText("");
				}
				
			}// end of action performed method
		});// end event handler
		
		btnCancel = new JButton("Cancel"); //creates button to cancel out of program
		btnCancel.setBounds(282, 114, 100, 32); //sets button position and size
		btnCancel.addActionListener(new ActionListener(){ //adds action listener to button
			public void actionPerformed(ActionEvent e) {
				//close program
				System.exit(0);
				
			}// end of action performed method
		});// end event handler
		
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
