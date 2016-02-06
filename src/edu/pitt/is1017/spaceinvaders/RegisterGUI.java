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
 * The Register GUI class builds the GUI for the register menu.  It contains user information fields
 * and button that creates a new user using the inputed values 
 * @author Timothy Meehan
 *
 */
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
	
	private final int LABEL_START = 20;//X position of start of label within JFrame
	private final int LABEL_LENGTH = 130;//length of label in JFrame
	
	private final int TBOX_START = 150;//x position of start of text box within JFrame
	private final int TBOX_LENGTH = 230;//length of text box in JFrame
	
	private final int Y_START = 20;//Y position of start of objects within JFrame
	private final int Y_UNIT = 40;// vertical increment unit between objects in JFrame
	
	/**
	 * class constructor calls the build GUI method
	 */
	public RegisterGUI(){
		// class constructor calls the GUI builder method
		buildGUI();
	}//end of class constructor
	
	/**
	 * main method used only for testing purposes
	 * @param args
	 */
	public static void main(String[] args) {
		//main method calls the class constructor
		RegisterGUI startUp = new RegisterGUI();

	}//end of main method
	
	/**
	 * buildGUI method builds the register GUI and assigns actions to the frame's buttons
	 */
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
		btnRegister.addActionListener(new ActionListener(){ //adds action listener to button
			public void actionPerformed(ActionEvent e) {
				if(txtConfirm.getText().equals(txtPassword.getText())){
					
					//call constructor for Hero and pass it the values held by the text fields
					User hero = new User(txtLastName.getText(),txtFirstName.getText(),txtEmail.getText(),txtPassword.getText());
					
					//display message for successful registry
					JOptionPane.showMessageDialog(null, "Successfully Registered!");
					
				}else{
					
					//display message alerting user to error in typing password
					JOptionPane.showMessageDialog(null, "Sorry, inputed passwords do not match");
				}
			}
		});// end event handler
		
		btnCancel = new JButton("Cancel"); //creates button to cancel out of program
		btnCancel.setBounds(282, Y_START + (Y_UNIT * 5), 100, 32); //sets button position and size
		btnCancel.addActionListener(new ActionListener(){ //adds action listener to button
			public void actionPerformed(ActionEvent e) {
				
				//ends program
				System.exit(0);
			}
		});// end event handler
		
		//add labels, text fields, and buttons to main frame
		
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
