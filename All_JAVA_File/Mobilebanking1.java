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


public class Mobilebanking1 extends JFrame implements ActionListener{    
JFrame f;    
	private JButton bkash,nagad,upay,rocket;
	private JFrame f2;
	private String getProvider,getBillNumber,name,email,filepath,imagepath;
	float bill;
	
Mobilebanking1(String getProvider,float bill,String getBillNumber,String name,String email, String filepath,String imagepath){    
         
        f2=new JFrame("Mobile Banking 1");
        this.getProvider=getProvider;
		this.bill=bill;
		this.getBillNumber=getBillNumber;
		this.name=name;
		this.email=email;
		this.filepath=filepath;
		this.imagepath=imagepath;
        
	
	 
	    ImageIcon bkashIcon = new ImageIcon(".\\All_Image\\Bkashbutton.png");
        Image Image2 = bkashIcon.getImage().getScaledInstance(520,265, java.awt.Image.SCALE_SMOOTH);
        bkashIcon = new ImageIcon(Image2);
	 
        bkash = new JButton(bkashIcon);  
        bkash.setBounds(20,20,520,265);
        bkash.setBorderPainted(false);
		bkash.addActionListener(this);
        
		ImageIcon nagadIcon = new ImageIcon(".\\All_Image\\nagadbutton.png");
        Image Image3 = nagadIcon.getImage().getScaledInstance(520,265, java.awt.Image.SCALE_SMOOTH);
        nagadIcon = new ImageIcon(Image3);
		
	    nagad = new JButton(nagadIcon);  
        nagad.setBounds(560,20,520,265); 
        nagad.setBorderPainted(false);
		nagad.addActionListener(this);
        
		
		ImageIcon rocketIcon = new ImageIcon(".\\All_Image\\rocketbutton.png");
        Image Image4 = rocketIcon.getImage().getScaledInstance(520,265, java.awt.Image.SCALE_SMOOTH);
        rocketIcon = new ImageIcon(Image4);
		
		rocket = new JButton(rocketIcon);  
        rocket.setBounds(20,305,520,265);
        rocket.setBorderPainted(false);
		rocket.addActionListener(this);
        
		
		ImageIcon upayIcon = new ImageIcon(".\\All_Image\\upaybutton.png");
        Image Image5 = upayIcon.getImage().getScaledInstance(520,265, java.awt.Image.SCALE_SMOOTH);
        upayIcon = new ImageIcon(Image5);
		
		upay = new JButton(upayIcon);  
        upay.setBounds(560,305,520,265);
        upay.setBorderPainted(false);
		upay.addActionListener(this);
        

    
		
		ImageIcon ImageIcon = new ImageIcon(".\\All_Image\\L6.png");
        Image Image = ImageIcon.getImage();
		
		JLabel Background;
        ImageIcon img = new ImageIcon(".\\All_Image\\mobilebanking1.png");
        Background = new JLabel ("",img,JLabel.CENTER);
        Background.setBounds(0,0,1106,595);

        f2.add(bkash); 
        f2.add(nagad);
		f2.add(upay);
        f2.add(rocket);      
		f2.setIconImage(Image);
        f2.add(Background);
        
        f2.setSize(1120,630); 
        f2.setLayout(null);
        f2.setLocationRelativeTo(null);     
        f2.setVisible(true);
        f2.setDefaultCloseOperation(EXIT_ON_CLOSE);

	
}    
public void actionPerformed(ActionEvent e) {
	      
	  
		if (e.getSource() == bkash) {
			f2.setVisible(false);
			String path=".\\All_Image\\bkash.png";
			String service="Bkash";
            Mobilebanking2 f4 = new Mobilebanking2(getProvider,bill,path,service,getBillNumber,name,email,filepath,imagepath);
		}
		else if (e.getSource() == nagad) {
			f2.setVisible(false);
            String path=".\\All_Image\\Nagad.png";
			String service="Nagad";
            Mobilebanking2 f5 = new Mobilebanking2(getProvider,bill,path,service,getBillNumber,name,email,filepath,imagepath);
		}
		else if (e.getSource() == rocket) {
			f2.setVisible(false);
			String path=".\\All_Image\\Rocket.png";
			String service="Rocket";
            Mobilebanking2 f6 = new Mobilebanking2(getProvider,bill,path,service,getBillNumber,name,email,filepath,imagepath);
		}
		else if (e.getSource() == upay) {
			f2.setVisible(false);
			String path=".\\All_Image\\Upay.png";
			String service="Upay";
            Mobilebanking2 f7 = new Mobilebanking2(getProvider,bill,path,service,getBillNumber,name,email,filepath,imagepath);
		}
 
}
}