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

public class Menu extends JFrame implements ActionListener {  
	
	private JButton acc;
    private JButton SignIn;
	private JFrame f2;
	private Font font2;
	private String email;
	
    Menu(String email) {    
        f2 = new JFrame("SecondFrame Screen"); 
	    font2 = new Font("Arial", Font.BOLD, 18); 
        this.email = email;
		 
        acc = new JButton("Account");  
        acc.setBounds(50, 50, 100, 40); 
        acc.setBorderPainted(false);
        acc.setBackground(Color.BLACK);
        acc.setForeground(Color.GRAY);
        acc.addActionListener(this); // Add action listener to the acc button
	      
	    JButton b22 = new JButton("Forget Password");  
        b22.setBounds(950, 250, 150, 30);
        b22.setBorderPainted(false);
        b22.setForeground(Color.BLUE);
        ImageIcon icon = new ImageIcon("L2.png"); 
        b22.setIcon(icon);
          
	    ImageIcon ImageIcon = new ImageIcon("M.png");
        Image Image = ImageIcon.getImage();
      
	    JLabel Background;
	    ImageIcon img = new ImageIcon("M.png");
	    Background = new JLabel("", img, JLabel.CENTER);
	    Background.setBounds(0, 0, 1106, 595);
		  
        f2.add(acc); 
        f2.add(b22);
	    f2.setIconImage(Image);
        f2.add(Background);
	      
        f2.setSize(1120, 630); 
        f2.setLayout(null);
        f2.setLocationRelativeTo(null);     
        f2.setVisible(true);
	    f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }   
	
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == acc) {
		    f2.setVisible(false);
            Acc f3 = new Acc(email);
			//f3.setVisible(true);
		}	
	}
}
