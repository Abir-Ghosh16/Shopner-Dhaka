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

public class Emergency extends JFrame implements ActionListener {  
	
	
	private JFrame f2;
	private Font font2;
	private JLabel roadLabel;
	private Font fontstyle,fontstyle2;
	private JLabel waterlogLabel;
	private String email;
	private JButton descobutton, wasabutton, titasbutton, btclbutton, healthbutton, unionbutton,corruptionbutton;
	private JButton lawbutton, womenbutton,idbutton,govtbutton,btrcbutton,backbutton;
	
	Emergency(String email) {    
        f2=new JFrame("Emergency Numbers");
		this.email = email;
     
		fontstyle=new Font("Arial", Font.PLAIN, 15);
		fontstyle2=new Font("Arial", Font.BOLD, 18);
		
		JPanel panel=new JPanel();  
        panel.setBounds(0,60,1120,570);    
		panel.setLayout(null);
		
		
	 
	    ImageIcon descoIcon = new ImageIcon(".\\All_Image\\DESCO.png");
        Image Image1 = descoIcon.getImage().getScaledInstance(1090,60, java.awt.Image.SCALE_SMOOTH);
        descoIcon = new ImageIcon(Image1);
	 
        descobutton = new JButton(descoIcon);
        descobutton.setBounds(8,5,1090,60);
        descobutton.setBorderPainted(false);
		//descobutton.setContentAreaFilled(false);
		
	   
	    ImageIcon wasaIcon = new ImageIcon(".\\All_Image\\wasa.png");
        Image Image2 = wasaIcon.getImage().getScaledInstance(1090,60, java.awt.Image.SCALE_SMOOTH);
        wasaIcon = new ImageIcon(Image2);
	   
        wasabutton = new JButton(wasaIcon);  
        wasabutton.setBounds(8,70,1090,60); 
        wasabutton.setBorderPainted(false);
	//	wasabutton.setContentAreaFilled(false);
		
		
		ImageIcon titasIcon = new ImageIcon(".\\All_Image\\titas.png");
        Image Image3 = titasIcon.getImage().getScaledInstance(1090,60, java.awt.Image.SCALE_SMOOTH);
        titasIcon = new ImageIcon(Image3);
		
        titasbutton = new JButton(titasIcon);  
        titasbutton.setBounds(8,135,1090,60);
        titasbutton.setBorderPainted(false);
	//	titasbutton.setContentAreaFilled(false);
		
		
	    ImageIcon btclIcon = new ImageIcon(".\\All_Image\\btcl.png");
        Image Image4 = btclIcon.getImage().getScaledInstance(1090,60, java.awt.Image.SCALE_SMOOTH);
        btclIcon = new ImageIcon(Image4);
	   
        btclbutton = new JButton(btclIcon);  
        btclbutton.setBounds(8,200,1090,60); 
        btclbutton.setBorderPainted(false);
	//	btclbutton.setContentAreaFilled(false);
		
	   
	    ImageIcon healthIcon = new ImageIcon(".\\All_Image\\health.png");
        Image Image5 = healthIcon.getImage().getScaledInstance(1090,60, java.awt.Image.SCALE_SMOOTH);
        healthIcon = new ImageIcon(Image5);
	   
	    healthbutton = new JButton(healthIcon);  
        healthbutton.setBounds(8,265,1090,60); 
        healthbutton.setBorderPainted(false);
	//	healthbutton.setContentAreaFilled(false);
		
	   
	   
	    ImageIcon corruptionIcon = new ImageIcon(".\\All_Image\\corruption.png");
        Image Image7 = corruptionIcon.getImage().getScaledInstance(1090,60, java.awt.Image.SCALE_SMOOTH);
        corruptionIcon = new ImageIcon(Image7);
	   
	    corruptionbutton = new JButton(corruptionIcon);  
        corruptionbutton.setBounds(8,395,1090,60); 
        corruptionbutton.setBorderPainted(false);
	//	corruptionbutton.setContentAreaFilled(false);
		
		
	    ImageIcon lawIcon = new ImageIcon(".\\All_Image\\law.png");
        Image Image8 = lawIcon.getImage().getScaledInstance(1090,60, java.awt.Image.SCALE_SMOOTH);
        lawIcon = new ImageIcon(Image8);
		
        lawbutton = new JButton(lawIcon);  
        lawbutton.setBounds(8,460,1090,60);
        lawbutton.setBorderPainted(false);
	//	lawbutton.setContentAreaFilled(false);
		
	   
	    ImageIcon btrcIcon = new ImageIcon(".\\All_Image\\btrc.png");
        Image Image12 = btrcIcon.getImage().getScaledInstance(1090,60, java.awt.Image.SCALE_SMOOTH);
        btrcIcon = new ImageIcon(Image12);
	   
	    btrcbutton = new JButton(btrcIcon);  
        btrcbutton.setBounds(8,330,1090,60); 
        btrcbutton.setBorderPainted(false);
     //   informationbutton.setContentAreaFilled(false);
	 
	 ImageIcon backIcon = new ImageIcon(".\\All_Image\\back.png");
        Image Image13 = backIcon.getImage().getScaledInstance(70,40, java.awt.Image.SCALE_SMOOTH);
        backIcon = new ImageIcon(Image13);
	   
	    backbutton = new JButton(backIcon);  
        backbutton.setBounds(15,10,70,40); 
        backbutton.setBorderPainted(false);
     //   informationbutton.setContentAreaFilled(false);
	   
	    
		
		ImageIcon ImageIcon = new ImageIcon(".\\All_Image\\L2.png");
        Image Image = ImageIcon.getImage();
		
		JLabel Background;
        ImageIcon img = new ImageIcon(".\\All_Image\\emergency.png");
        Background = new JLabel ("",img,JLabel.CENTER);
        Background.setBounds(0,0,1120,630);

        panel.add(descobutton); 
		panel.add(wasabutton);
        panel.add(titasbutton);
		panel.add(btclbutton);
		panel.add(healthbutton);
		panel.add(corruptionbutton);
        panel.add(lawbutton);
        panel.add(btrcbutton);
		f2.add(backbutton);
		f2.add(panel);
        f2.setIconImage(Image);
        f2.add(Background);
        f2.setSize(1120, 630);
        f2.setLocationRelativeTo(null);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.setVisible(true);
		
		backbutton.addActionListener(this);
		descobutton.addActionListener(this);
		wasabutton.addActionListener(this);
		titasbutton.addActionListener(this);
		btclbutton.addActionListener(this);
		healthbutton.addActionListener(this);
		corruptionbutton.addActionListener(this);
		lawbutton.addActionListener(this);
		btrcbutton.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
	      
	  
		if (e.getSource() == backbutton) {
			f2.setVisible(false);
            MainMenu f4 = new MainMenu(email);	
		}
	/*	else if (e.getSource() == wasabutton) {
			f2.setVisible(false);
                //Mosquito f4 = new Mosquito();
		}
		else if (e.getSource() == titasbutton) {
			f2.setVisible(false);
			//Garbage f4 = new Garbage();
		}
		else if (e.getSource() == btclbutton) {
			f2.setVisible(false);
			//Street_Light f6 = new Street_Light();
		}
		else if (e.getSource() == healthbutton) {
			f2.setVisible(false);
		//Publictoilet f6 = new Publictoilet();
		}
		
		else if (e.getSource() == corruptionbutton) {
			f2.setVisible(false);
			
			//Illegalstructure f6 = new Illegalstructure();
		}
		else if (e.getSource() == lawbutton) {
			f2.setVisible(false);
			//Waterlog f6 = new Waterlog();
		}
		
		else if (e.getSource() == btrcbutton) {
			f2.setVisible(false);
		   // Acc f6 = new Acc();
		}
		*/
		
		
	}
	
	
}