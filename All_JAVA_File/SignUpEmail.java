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
import java.io.File;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Random;

public class SignUpEmail extends JFrame implements ActionListener{
	private Font fontstyle;
	private Font fontstyle2;
	private JTextField emailField;
	private JButton next;
    private JButton back;
	private File filee;
	private JFrame f;
   SignUpEmail()
   {
   f = new JFrame("Varification email frame");
   
   fontstyle = new Font("Chesna Grotesk", Font.PLAIN, 15);
   fontstyle2 = new Font("cambria", Font.PLAIN, 15);
   
        JLabel emailLabel = new JLabel("Enter email account");
        emailLabel.setBounds(230, 250, 170, 30);
        emailLabel.setFont(fontstyle);
		emailLabel.setForeground(Color.black);

        emailField = new JTextField();
        emailField.setBounds(185, 300, 230, 35);
        emailField.setToolTipText("Please enter your Email Account");
		emailField.setOpaque(false);
        emailField.setForeground(Color.white);
		emailField.setFont(fontstyle2);
		
        next = new JButton("next");
        next.setBounds(185, 370, 230, 50);
        next.setBorderPainted(false);
        //login.setBackground(Color.BLACK);
       // login.setForeground(Color.GRAY);
		ImageIcon icon1 = new ImageIcon(".\\All_Image\\getotp.png");
        next.setIcon(icon1);
        next.addActionListener(this);
		
        back = new JButton("back");
        back.setBounds(185, 440, 230, 50);
        back.setBorderPainted(false);
        back.setForeground(Color.BLUE);
        ImageIcon icon = new ImageIcon(".\\All_Image\\back1.png");
        back.setIcon(icon);
        back.addActionListener(this);
   
        ImageIcon imageIcon = new ImageIcon(".\\All_Image\\L1.png");
        Image image = imageIcon.getImage();

        JLabel background;
        ImageIcon img = new ImageIcon(".\\All_Image\\signemail.png");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1106, 595);

        f.add(emailLabel);
        f.add(emailField);
        f.add(next);
        f.add(back);
        f.setIconImage(image);
        f.add(background);

        f.setSize(1120, 630);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
   
   }
   public void actionPerformed(ActionEvent e) {
	   
	   
        if (e.getSource() == next) {
			
			String email= emailField.getText();
			String file = email.substring(0, email.length() - 4);
			File filee = new File("./All_Text_File/"+file);
            if(filee.exists() && !filee.isDirectory()) 
			{ 
		    JOptionPane.showMessageDialog(null,"This email is already associated with another account");
			}
			else
			{
			
      
      //String to = emailField.getText();
	  String to = email;
      // Sender's email ID needs to be mentioned
      String from = "Your Gmail";
      final String username = "Your username";
      final String password = "Your App Password for accessing Google SMTP";

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "smtp.gmail.com";
Properties props = new Properties();

props.put("mail.smtp.host", "smtp.gmail.com");
props.put("mail.smtp.socketFactory.port", "465");
props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.port", "465");

      // Get the Session object.
      Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
		  @Override
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });
	  
  Random random = new Random();
  int otp= random.nextInt(999999);
  
      try {
         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);

         // Set To: header field of the header.
         message.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse(to));

         // Set Subject: header field
         message.setSubject("Please verify your email address for Shopner Dhaka");

         // Now set the actual message
         message.setText("Use " +otp+ " as your verification code for Shopner Dhaka. ");

         // Send message
         Transport.send(message);

         System.out.println("Sent message successfully....");
		        f.setVisible(false);
                SignUpOtp f2 = new SignUpOtp(to,otp);

      }
	       catch (MessagingException ae)
		   {
           throw new RuntimeException(ae);
           }
		}}
   else if (e.getSource() == back)
			{
			    f.setVisible(false);
                Login f3 = new Login();
			}
   }
}
