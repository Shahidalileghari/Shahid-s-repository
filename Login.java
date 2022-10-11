import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
	
	JButton loginButton,signupButton,cancelButton;
    public Login() {
		 super("Login Page");
    	getContentPane().setBackground(Color.white);
    	setLayout(null);
    	
    	//username
    	
    	JLabel lblusername=new JLabel("Username");
    	lblusername.setBounds(300,20,100,20);
    	add(lblusername);
    	JTextField usrnameField=new JTextField();
    	usrnameField.setBounds(400,20,150,20);
    	add(usrnameField);
    	//password
    	
    	JLabel lblpassword=new JLabel("Password");
    	lblpassword.setBounds(300,60,100,20);
    	add(lblpassword);
    	
    	JTextField passwordField=new JTextField();
    	passwordField.setBounds(400,60,150,20);
    	add(passwordField);
    	
    	//login in as
    	
    	JLabel lbllogin=new JLabel("Login in as");
    	 lbllogin.setBounds(300,100,100,20);
    	add( lbllogin);
    	
//    	JTextField loginField=new JTextField();
//    	loginField.setBounds(400,100,150,20);
//    	add(loginField);
    	Choice loginChoice=new Choice();
    	loginChoice.setBounds(400,100,150,20);
    	loginChoice.add("Admin");
    	loginChoice.add("Customer");
    	add(loginChoice);
    	
    	 loginButton=new JButton("Login");
    	loginButton.setBounds(330,160,100,20);
    	loginButton.addActionListener(this);
    	add(loginButton);
    	
    	 cancelButton=new JButton("Cancel");
    	cancelButton.setBounds(450,160,100,20);
    	cancelButton.addActionListener(this);
    	add(cancelButton);
    	
    	 signupButton=new JButton("Signup");
    	signupButton.setBounds(375,200,100,20);
    	signupButton.addActionListener(this);
    	add(signupButton);
    	
    	setSize(640,300);
    	setLocation(400,200);
    	setVisible(true);
	}
    
    public void actionPerformed(ActionEvent e)
    {
    	if (e.getSource()==loginButton) {
			//setVisible(true);
			
			
		} 
    	else if(e.getSource()==signupButton) 
    	{
			
                  setVisible(false);
                 
                 new Signup();
		}
    	
		else if(e.getSource()==cancelButton)
			{
		setVisible(false);
			}
    }
    
    
	public static void main(String[] args) {
		 new Login();
	

	}

}
