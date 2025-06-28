package All_JAVA_File;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.imageio.*;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class SignUp extends JFrame implements ActionListener {

    private Font fontstyle;
	private Font fontstyle2;
    private JButton next;
    private JButton back;
    private JTextField firstnameField;
	private JTextField lastnameField;
	private JTextField phoneField;
	private JTextField emailField;
    private JPasswordField passwordField;
	private JPasswordField repasswordField;
	private JComboBox day;
	private JComboBox month;
	private JComboBox year;
	private ImageIcon img;
	private JLabel background;
	private JCheckBox checkBox1;
	boolean selected;
	private FileWriter fw;
	private Exception ae;
	FileReader fr;
	private String to;
	private String file;
	
    private JFrame f;

    SignUp (String to) {
        f = new JFrame("SignUp");
		
        this.to=to;
		file = to.substring(0, to.length() - 4);

		
        fontstyle = new Font("Arial", Font.BOLD, 18);
		fontstyle2 = new Font("cambria", Font.BOLD, 15);

        final JLabel label = new JLabel();
        label.setBounds(750, 380, 200, 50);

        JLabel firstnameLabel = new JLabel("First name:");
        firstnameLabel.setBounds(50, 120, 120, 30);
        firstnameLabel.setFont(fontstyle);
		firstnameLabel.setForeground(Color.white);

        firstnameField = new JTextField();
        firstnameField.setBounds(50, 152, 200, 30);
		firstnameField.setOpaque(false);
        firstnameField.setForeground(Color.white);
		firstnameField.setFont(fontstyle2);
        firstnameField.setToolTipText("Enter your First name");

        JLabel lastnameLabel = new JLabel("Last name:");
        lastnameLabel.setBounds(290, 120, 100, 30);
        lastnameLabel.setFont(fontstyle);
		lastnameLabel.setForeground(Color.white);

        lastnameField = new JTextField();
        lastnameField.setBounds(290, 152, 200, 30);
		lastnameField.setOpaque(false);
        lastnameField.setForeground(Color.white);
		lastnameField.setFont(fontstyle2);
        lastnameField.setToolTipText("Enter your Last name");

        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(50, 200, 150, 30);
        phoneLabel.setFont(fontstyle);
		phoneLabel.setForeground(Color.white);

        phoneField = new JTextField();
        phoneField.setBounds(50, 232, 200, 30);
		phoneField.setOpaque(false);
        phoneField.setForeground(Color.white);
		phoneField.setFont(fontstyle2);
        phoneField.setToolTipText("Enter your phone number");
		
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 280, 100, 30);
		passwordLabel.setFont(fontstyle);
		passwordLabel.setForeground(Color.white);

        passwordField = new JPasswordField();
        passwordField.setBounds(50, 312, 200, 30);
		passwordField.setOpaque(false);
        passwordField.setForeground(Color.white);
		passwordField.setFont(fontstyle2);
        passwordField.setToolTipText("Enter a strong password");
		
		JLabel repasswordLabel = new JLabel("Confirm Password:");
        repasswordLabel.setBounds(290, 280, 180, 30);
		repasswordLabel.setFont(fontstyle);
		repasswordLabel.setForeground(Color.white);

        repasswordField = new JPasswordField();
        repasswordField.setBounds(290, 312, 200, 30);
		repasswordField.setOpaque(false);
        repasswordField.setForeground(Color.white);
		repasswordField.setFont(fontstyle2);
        repasswordField.setToolTipText("Retype your password");
		
		JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(50, 380, 120, 30);
        dob.setFont(fontstyle);
		dob.setForeground(Color.white);
		
		String country[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};        
        day = new JComboBox<>(country);    
        day.setBounds(182, 382,90,25);
		day.setOpaque(false);
		
        String country1[]={"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};        
        month=new JComboBox<>(country1);     
        month.setBounds(292, 382,90,25); 
	    month.setOpaque(false);
		
		String country2[]={"1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023"};        
        year=new JComboBox<>(country2);    
        year.setBounds(402, 382,90,25); 
	    year.setOpaque(false);

        next = new JButton("Submit");
        next.setBounds(50, 455, 442, 30);
        next.setBorderPainted(false);
        next.setBackground(new java.awt.Color(0, 76, 180));
        next.setForeground(Color.white);
		next.addActionListener(this);
		
		JLabel Label2 = new JLabel("Already have an account? ");
        Label2.setBounds(160, 480, 200, 30);
        Label2.setFont(fontstyle2);
        
        back = new JButton("Log in");
        back.setBounds(320, 480, 80, 30);
        back.setBorderPainted(false);
        back.setForeground(Color.BLUE);
		back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.addActionListener(this);
		 
        JCheckBox checkBox1 = new JCheckBox("Accept Terms And Conditions");  
        checkBox1.setBounds(160,410, 250,50);
		checkBox1.setFont(fontstyle2);
		checkBox1.setOpaque(false);
		checkBox1.setForeground(Color.white);
		checkBox1.setSelected(true);
        selected = checkBox1.isSelected();
		
        ImageIcon imageIcon = new ImageIcon(".\\All_Image\\L1.png");
        Image image = imageIcon.getImage();

        JLabel background;
        ImageIcon img = new ImageIcon(".\\All_Image\\Sign.png");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0,0,1106,595);

        f.add(firstnameLabel);
		f.add(firstnameField);
		f.add(lastnameLabel);
		f.add(lastnameField);
		f.add(phoneLabel);
		f.add(phoneField);
		f.add(passwordLabel);
		f.add(passwordField);
        f.add(repasswordLabel);
        f.add(repasswordField);
		f.add(dob);
		f.add(day);
		f.add(month);
		f.add(year);
        f.add(next);
		f.add(Label2);
        f.add(back);
	    f.add(checkBox1);
        f.setIconImage(image);
        f.add(background);
		 
        f.setSize(1120, 630);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
   
public void actionPerformed (ActionEvent e)
    {
		String firstname = firstnameField.getText();
		String lastname = lastnameField.getText();
		String username= firstnameField.getText()+" "+lastnameField.getText();
		String pnumber = phoneField.getText();
		String email = to;
		String password =new String(passwordField.getText());
		String repassword =new String(repasswordField.getText());
		String dob = (String) day.getSelectedItem()+"-"+(String) month.getSelectedItem()+"-"+(String) year.getSelectedItem();	  
    if(e.getSource() == next) 
	    {	
		    try {
           	fw = new FileWriter("./All_Text_File/"+file);	
			
			if( firstname.equals("") || lastname.equals("") || pnumber.equals("") || password.equals("") || repassword.equals("") || dob.equals(""))
            {
                JOptionPane.showMessageDialog(null,"One Or More Fields Are Empty");
            }
			else{         
                  if(password.equals(repassword))
                    { 
				         if(selected)
						 {
			                fw.write("First name: "+firstname);
			                fw.write(System.getProperty("line.separator"));
			                fw.write("last name: "+lastname);
		                 	fw.write(System.getProperty("line.separator"));
							fw.write("Username: "+username);
			                fw.write(System.getProperty("line.separator"));
	                 		fw.write("Phone number: "+pnumber);
	                 		fw.write(System.getProperty("line.separator"));
			                fw.write("Email: "+email);
		                   	fw.write(System.getProperty("line.separator"));
		                 	fw.write("Password: "+password);
					    	fw.write(System.getProperty("line.separator"));	
						    fw.write("Date of birth: "+dob);
	                        fw.write(System.getProperty("line.separator"));
			                fw.write("__________________");
							fw.write(System.getProperty("line.separator"));
		                    fw.close();
			                JOptionPane.showMessageDialog(null, "Sign up successfull");
							f.setVisible(false);
                            Login f3 = new Login();
						 }
						 else
						 {
							 JOptionPane.showMessageDialog(null,"The Confirmation Password Does Not Match");
						 }
					}
				  else
                    {
                            JOptionPane.showMessageDialog(null,"The Confirmation Password Does Not Match");          
			        }
			}}
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }}
			
			else if (e.getSource() == back)
			{
			    f.setVisible(false);
                Login f3 = new Login();
				//f3.setVisible(true);
			}
			
}}
       
       
                
        
    
