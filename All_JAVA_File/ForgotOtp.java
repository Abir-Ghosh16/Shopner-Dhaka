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

public class ForgotOtp extends JFrame implements ActionListener{
	private Font fontstyle;
	private Font fontstyle2;
	private JTextField otpField1;
	private JTextField otpField2;
	private JTextField otpField3;
	private JTextField otpField4;
	private JTextField otpField5;
	private JTextField otpField6;
	private JButton send,back;
	private int otp;
	private String to;
	private JFrame f;
   ForgotOtp(String to,int otp)
   {
   f = new JFrame("Varification otp frame");
   
        fontstyle = new Font("cambria", Font.PLAIN, 18);
        fontstyle2 = new Font("cambria", Font.PLAIN, 15);
		
		this.otp=otp;
		this.to=to;
   
        JLabel otpLabel = new JLabel("Enter OTP");
        otpLabel.setBounds(255, 250, 170, 30);
        otpLabel.setFont(fontstyle);
		otpLabel.setForeground(Color.white);

        otpField1 = new JTextField();
        otpField1.setBounds(160, 300, 40, 35);
		otpField1.setOpaque(false);
        otpField1.setForeground(Color.white);
		otpField1.setFont(fontstyle2);
		otpField1.setHorizontalAlignment(JTextField.CENTER);
      
        otpField2 = new JTextField();
        otpField2.setBounds(210, 300, 40, 35);
		otpField2.setOpaque(false);
        otpField2.setForeground(Color.white);
		otpField2.setFont(fontstyle2);
		otpField2.setHorizontalAlignment(JTextField.CENTER);
		
		otpField3 = new JTextField();
        otpField3.setBounds(260, 300, 40, 35);
		otpField3.setOpaque(false);
        otpField3.setForeground(Color.white);
		otpField3.setFont(fontstyle2);
		otpField3.setHorizontalAlignment(JTextField.CENTER);
		
		otpField4 = new JTextField();
        otpField4.setBounds(310, 300, 40, 35);
		otpField4.setOpaque(false);
        otpField4.setForeground(Color.white);
		otpField4.setFont(fontstyle2);
		otpField4.setHorizontalAlignment(JTextField.CENTER);
		
		otpField5 = new JTextField();
        otpField5.setBounds(360, 300, 40, 35);
		otpField5.setOpaque(false);
        otpField5.setForeground(Color.white);
		otpField5.setFont(fontstyle2);
		otpField5.setHorizontalAlignment(JTextField.CENTER);
		
		otpField6 = new JTextField();
        otpField6.setBounds(410, 300, 40, 35);
		otpField6.setOpaque(false);
        otpField6.setForeground(Color.white);
		otpField6.setFont(fontstyle2);
		otpField6.setHorizontalAlignment(JTextField.CENTER);
		
		
		back = new JButton("Back to log in");
        back.setBounds(190, 346, 230, 30);
        back.setBorderPainted(false);
        back.setForeground(Color.BLACK);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setFont(fontstyle2);
       // ImageIcon icon = new ImageIcon("back1.png");
       // back.setIcon(icon);
        back.addActionListener(this);
		
        send = new JButton("Send");
        send.setBounds(190, 380, 230, 50);
        send.setBorderPainted(false);
        //login.setBackground(Color.BLACK);
       // login.setForeground(Color.GRAY);
		ImageIcon icon1 = new ImageIcon(".\\All_Image\\fvarifi.png");
        send.setIcon(icon1);
        send.addActionListener(this);
   
        ImageIcon imageIcon = new ImageIcon(".\\All_Image\\L1.png");
        Image image = imageIcon.getImage();

        JLabel background;
        ImageIcon img = new ImageIcon(".\\All_Image\\ForgotOtp.png");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1106, 595);

        f.add(otpLabel);
        f.add(otpField1);
		f.add(otpField2);
		f.add(otpField3);
		f.add(otpField4);
		f.add(otpField5);
		f.add(otpField6);
        f.add(send);
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
        if (e.getSource() == send) 
		{
			String inputotp = otpField1.getText()+otpField2.getText()+otpField3.getText()+otpField4.getText()+otpField5.getText()+otpField6.getText();
	         if(inputotp.equals(String.valueOf(otp)))
			 {
				JOptionPane.showMessageDialog(null, "Verification Successful");
				f.setVisible(false);
                ForgotNew f3 = new ForgotNew(to);
				//f3.setVisible(true);
			 }
	  
	         else
			 {
				 JOptionPane.showMessageDialog(null, "OTP doesn't match");
				 
			 }
		}
		else if (e.getSource() == back)
			{
			    f.setVisible(false);
                Login f3 = new Login();
			}
		
}}