package All_JAVA_File;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.imageio.*;
import java.awt.Font;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class ContactUs extends JFrame implements ActionListener
 {

    private Font fontstyle,fontstyle2;
   private JButton send;
    private JButton back;
    private JTextField usernameField;
    private JTextArea area;
    private JFrame f;
	private JTextField emailField;
	 private JLabel addressLabel;
     private JTextArea addressArea;
	 private JTextArea phoneArea;
	 private JLabel phoneLabel;
	 private JTextArea gmailArea;
	 private String email;
	 
	 
    ContactUs(String email) {
        f = new JFrame("Contact US");
		this.email = email;

        fontstyle = new Font("Open Sans", Font.BOLD, 18);
		fontstyle2 = new Font("Arial", Font.BOLD, 15);

        final JLabel label = new JLabel();
        label.setBounds(750, 380, 200, 50);
		
		
        JLabel usernameLabel = new JLabel("Full Name:");
        usernameLabel.setBounds(750, 200, 120, 30);
        usernameLabel.setFont(fontstyle);
		usernameLabel.setForeground(Color.CYAN);
        
		
        usernameField = new JTextField();
        usernameField.setBounds(750, 233, 300, 30);
        usernameField.setToolTipText("Please Enter Your Full Name");
		usernameField.setFont(fontstyle2);
		usernameField.setForeground(Color.white);
		usernameField.setOpaque(false);

        JLabel emailLabel = new JLabel ("Email:");
		emailLabel.setBounds(750,273,120,30);
		emailLabel.setFont(fontstyle);
		emailLabel.setForeground(Color.CYAN);
		
		emailField = new JTextField();
		emailField.setBounds(750,306,300,30);
		emailField.setToolTipText("Please Enter Your Email Address");
		emailField.setFont(fontstyle2);
		emailField.setForeground(Color.white);
		emailField.setOpaque(false);
		
        
        JLabel passwordLabel = new JLabel("Please Type your Massage:");
        passwordLabel.setBounds(750, 343, 600,30);
		passwordLabel.setFont(fontstyle);
		passwordLabel.setForeground(Color.CYAN);
		

        area = new JTextArea();
        area.setBounds(750,376,300,130);
        area.setToolTipText("Type your Massage"); 
		area.setFont(fontstyle2);
		area.setOpaque(false);
		area.setLineWrap(true);
		area.setForeground(Color.WHITE);
		Border border = new LineBorder(Color.WHITE, 1, true);
		area.setBorder(border);
		
	
		JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(200, 222, 200, 30);
        addressLabel.setFont(fontstyle);
		addressLabel.setForeground(Color.CYAN);
		
        addressArea = new JTextArea("43/A Srijoni Road,Mirpur 14, Dhaka ");
        addressArea.setLineWrap(true);
        addressArea.setEditable(false);
        addressArea.setOpaque(false);
        addressArea.setBounds(200, 252,2000, 250);
		addressArea.setForeground(Color.WHITE);

        JLabel phoneLabel  = new JLabel("Contact Number:");  
        phoneLabel.setBounds(200,315, 200, 30);
        phoneLabel.setFont(fontstyle);
		phoneLabel.setForeground(Color.CYAN);
		
        phoneArea = new JTextArea("01713032129, 01718041957");
        phoneArea.setLineWrap(true);
        phoneArea.setEditable(false);
        phoneArea.setOpaque(false);
		phoneArea.setForeground(Color.WHITE);
        phoneArea.setBounds(200,345,2000, 250);
        
		
		
		JLabel gmailLabel  = new JLabel("Email:");  
        gmailLabel.setBounds(200,410, 120, 30);
        gmailLabel.setFont(fontstyle);
		gmailLabel.setForeground(Color.CYAN);
		
        gmailArea = new JTextArea("ShopnerDhaka@gmail.com");
        gmailArea.setLineWrap(true);
        gmailArea.setEditable(false);
        gmailArea.setOpaque(false);
		gmailArea.setForeground(Color.WHITE);
        gmailArea.setBounds(200,440,2000, 250);
     

	  
       send = new JButton("Send");
        send.setBounds(750,539,80,30);
        send.setBorderPainted(false);
		ImageIcon icon1 = new ImageIcon(".\\All_Image\\L4.png");
        send.setIcon(icon1);
      send.addActionListener(this);
		
 
        back = new JButton("Back");
        back.setBounds(135, 539, 80, 30);
        back.setBorderPainted(false);
        back.setForeground(Color.black);
        ImageIcon icon = new ImageIcon(".\\All_Image\\L3.png");
		back.addActionListener(this);
        

        ImageIcon imageIcon = new ImageIcon(".\\All_Image\\L1.png");
        Image image = imageIcon.getImage();

        JLabel background;
        ImageIcon img = new ImageIcon(".\\All_Image\\Contact Us.png");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1106, 595);

        f.add(area);
        f.add(usernameLabel);
        f.add(label);
        f.add(passwordLabel);
		f.add(emailField);
		f.add(emailLabel);
        f.add(send);
        f.add(back);
        f.add(usernameField);
		f.add(addressLabel);
		f.add(addressArea);
		f.add(phoneLabel);
		f.add(phoneArea);
		f.add(gmailArea);
		f.add(gmailLabel);
       f.setIconImage(image);
        f.add(background);
		 
        
		//f.add(l1);
		//f.add(addressLabel);
		//f.add(12);
		//f.add(13);
		//f.add(14);
       // f.add(b21);		
        f.setSize(1120, 630);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
        public void actionPerformed(ActionEvent e) {
        if (e.getSource() == send) {
			
			String messageArea = area.getText();
			String name=usernameField.getText();
			String givenemail =emailField.getText();
			
			if (messageArea.equals("")||name.equals("")||givenemail.equals("")) {
                JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty");
            } else {
			
			int sel = JOptionPane.showConfirmDialog(f,"Are you sure the given information is correct?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
          if(sel== JOptionPane.YES_OPTION)
		  {
			
			
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String date = dtf.format(now);
            
                try {
                    FileWriter fw = new FileWriter(".\\All_Text_File\\Contactus.txt", true);

                    fw.write(email + "        " + name + "        " + givenemail + "        " + messageArea+"        "+date);
                    fw.write(System.getProperty("line.separator"));
                    fw.close();
                    f.setVisible(false);
                    new MainMenu(email);
                } catch (IOException ex) {
                    Logger.getLogger(ContactUs.class.getName()).log(Level.SEVERE, null, ex);
                }
	  }
	  else if(sel==JOptionPane.NO_OPTION)
	  {
		  
	  }
        }}
		else if(e.getSource() == back)
		{
			    f.setVisible(false);
                MainMenu f3 = new MainMenu(email);
		}
    }
   
  
}     

    
