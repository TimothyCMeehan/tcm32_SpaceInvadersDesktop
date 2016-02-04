package edu.pitt.is1017.spaceinvaders;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RegisterGUI {
	
	private JFrame mainFrame; // Frame
	
	private JLabel lblFirstName; // FirstName Label
	private JTextField txtFirstName; // FirstName TextField
	
	private JLabel lblLastName; // LastName Label
	private JTextField txtLastName; // LastName TextField
	
	private JLabel lblEmail; // Email Label
	private JTextField txtEmail; // Email TextField
	
	private JLabel lblPassword; // Password Label
	private JTextField txtPassword; // Password TextField
	
	private JLabel lblConfirm; // Confirm Label
	private JTextField txtConfirm; // Confirm TextField
	
	private JButton btnRegister; //Button to Register new user
	private JButton btnCancel; // Button to cancel out of program
	
	private final int LABEL_START = 20;
	private final int LABEL_LENGTH = 130;
	
	private final int TBOX_START = 150;
	private final int TBOX_LENGTH = 230;
	
	private final int Y_START = 20;
	private final int Y_UNIT = 40;
	

	public RegisterGUI(){
		// class constructor calls the GUI builder method
		buildGUI();
	}//end of class constructor
	
	public static void main(String[] args) {
		//main method calls the class constructor
		RegisterGUI startUp = new RegisterGUI();

	}//end of main method
	
	public void buildGUI(){
		
		mainFrame = new JFrame("SpaceInvaders - Registration"); // Instantiate frame
		mainFrame.setSize(TBOX_START + TBOX_LENGTH + LABEL_START, 300); //set frame size
		mainFrame.setLayout(null); // set frame to absolute layout
		
		// The following block of code is an event handler that allows you to actually close the frame window
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}        
		}); // end event handler
		
		lblFirstName = new JLabel("First Name:", JLabel.LEFT);//initializes label
		lblFirstName.setBounds(LABEL_START, Y_START, LABEL_LENGTH, 30); // Set label size and position
		
		txtFirstName = new JTextField("");//initializes textbox
		txtFirstName.setBounds(TBOX_START, Y_START, TBOX_LENGTH, 30); // Set textbox size and position
		
		lblLastName = new JLabel("Last Name:", JLabel.LEFT);//initializes label
		lblLastName.setBounds(LABEL_START, Y_START + Y_UNIT, LABEL_LENGTH, 30); // Set label size and position
		
		txtLastName = new JTextField("");//initializes textbox
		txtLastName.setBounds(TBOX_START, Y_START + Y_UNIT, TBOX_LENGTH, 30); // Set textbox size and position
		
		lblEmail = new JLabel("Email:", JLabel.LEFT);//initializes label
		lblEmail.setBounds(LABEL_START, Y_START + (Y_UNIT * 2), LABEL_LENGTH, 30); // Set label size and position
		
		txtEmail = new JTextField("");//initializes textbox
		txtEmail.setBounds(TBOX_START, Y_START + (Y_UNIT * 2), TBOX_LENGTH, 30); // Set textbox size and position
		
		lblPassword = new JLabel("Password:", JLabel.LEFT);//initializes label
		lblPassword.setBounds(LABEL_START, Y_START + (Y_UNIT * 3), LABEL_LENGTH, 30); // Set label size and position
		
		txtPassword = new JTextField("");//initializes textbox
		txtPassword.setBounds(TBOX_START, Y_START + (Y_UNIT * 3), TBOX_LENGTH, 30); // Set textbox size and position
		
		lblConfirm = new JLabel("Confirm Password:", JLabel.LEFT);//initializes label
		lblConfirm.setBounds(LABEL_START, Y_START + (Y_UNIT * 4), LABEL_LENGTH, 30); // Set label size and position
		
		txtConfirm = new JTextField("");//initializes textbox
		txtConfirm.setBounds(TBOX_START, Y_START + (Y_UNIT * 4), TBOX_LENGTH, 30); // Set textbox size and position
		
		btnRegister = new JButton("Register"); //creates button to Register new User
		btnRegister.setBounds(TBOX_START, Y_START + (Y_UNIT * 5), 100, 32); //sets button position and size
		
		btnCancel = new JButton("Cancel"); //creates button to cancel out of program
		btnCancel.setBounds(282, Y_START + (Y_UNIT * 5), 100, 32); //sets button position and size
		
		//add labels, texfields, and buttons to main frame
		
		mainFrame.add(lblFirstName);
		mainFrame.add(txtFirstName);
		
		mainFrame.add(lblLastName);
		mainFrame.add(txtLastName);
		
		mainFrame.add(lblEmail);
		mainFrame.add(txtEmail);
		
		mainFrame.add(lblPassword);
		mainFrame.add(txtPassword);
		
		mainFrame.add(lblConfirm);
		mainFrame.add(txtConfirm);
		
		mainFrame.add(btnRegister);
		mainFrame.add(btnCancel);
		
		//make frame visible
		mainFrame.setVisible(true);
				
	}

}
