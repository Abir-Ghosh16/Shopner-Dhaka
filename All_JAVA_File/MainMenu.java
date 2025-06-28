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

public class MainMenu extends JFrame implements ActionListener {  
	
	private JButton login;
    private JButton SignIn;
	private JFrame f2;
	private Font font2;
	private JLabel roadLabel;
	private Font fontstyle,fontstyle2;
	private JLabel waterlogLabel;
	private String email;
	private JButton roadbutton, mosquitobutton, garbagebutton, streetlightbutton, waterlogbutton, drainagebutton,emergencybutton;
	private JButton illegalStructurebutton, publictoiletbutton,accountbutton,contactbutton,waterbillbutton,electricitybillbutton,gasbillbutton,aboutusbutton,eventbutton,logoutbutton;
	
	MainMenu(String email) {    
        f2=new JFrame("Main Menu");
		this.email = email;
     
		fontstyle=new Font("Arial", Font.PLAIN, 15);
		fontstyle2=new Font("Arial", Font.BOLD, 18);
		
	 
	    ImageIcon roadIcon = new ImageIcon(".\\All_Image\\roadbutton.png");
        Image Image1 = roadIcon.getImage().getScaledInstance(81,66, java.awt.Image.SCALE_SMOOTH);
        roadIcon = new ImageIcon(Image1);
	 
        roadbutton = new JButton(roadIcon);
        roadbutton.setBounds(224,108,81,66);
        roadbutton.setBorderPainted(false);
		roadbutton.setContentAreaFilled(false);
		
	    JLabel roadLabel = new JLabel ("Road");
	    roadLabel.setBounds(245,170,130,70);
	    roadLabel.setFont(fontstyle);
	    roadLabel.setForeground(Color.BLACK);
	   
	   
	   
	    ImageIcon mosquitoIcon = new ImageIcon(".\\All_Image\\mosquitobutton.png");
        Image Image2 = mosquitoIcon.getImage().getScaledInstance(81,66, java.awt.Image.SCALE_SMOOTH);
        mosquitoIcon = new ImageIcon(Image2);
	   
        mosquitobutton = new JButton(mosquitoIcon);
        mosquitobutton.setBounds(338,108,81,66); 
        mosquitobutton.setBorderPainted(false);
		mosquitobutton.setContentAreaFilled(false);
		
		JLabel mosquitoLabel = new JLabel ("Mosquito");
	    mosquitoLabel.setBounds(349,170,130,70);
	    mosquitoLabel.setFont(fontstyle);
	    mosquitoLabel.setForeground(Color.BLACK);
		
		
		
		ImageIcon garbageIcon = new ImageIcon(".\\All_Image\\garbagebutton.png");
        Image Image3 = garbageIcon.getImage().getScaledInstance(81,66, java.awt.Image.SCALE_SMOOTH);
        garbageIcon = new ImageIcon(Image3);
		
        garbagebutton = new JButton(garbageIcon);  
        garbagebutton.setBounds(452,108,81,66);
        garbagebutton.setBorderPainted(false);
		garbagebutton.setContentAreaFilled(false);
		
		JLabel garbageLabel = new JLabel ("Garbage");
	    garbageLabel.setBounds(465,170,130,70);
	    garbageLabel.setFont(fontstyle);
	    garbageLabel.setForeground(Color.BLACK);
	   
	   
	   
	   
	    ImageIcon streetIcon = new ImageIcon(".\\All_Image\\lightbutton.png");
        Image Image4 = streetIcon.getImage().getScaledInstance(81,66, java.awt.Image.SCALE_SMOOTH);
        streetIcon = new ImageIcon(Image4);
	   
        streetlightbutton = new JButton(streetIcon);  
        streetlightbutton.setBounds(563, 108,81,66); 
        streetlightbutton.setBorderPainted(false);
		streetlightbutton.setContentAreaFilled(false);
		
       	JLabel streetLabel = new JLabel ("Streetlight");
	    streetLabel.setBounds(569,170,130,70);
	    streetLabel.setFont(fontstyle);
	    streetLabel.setForeground(Color.BLACK);
	   
	   
	   
	   
	    ImageIcon publicToiletIcon = new ImageIcon(".\\All_Image\\toiletbutton.png");
        Image Image5 = publicToiletIcon.getImage().getScaledInstance(81,66, java.awt.Image.SCALE_SMOOTH);
        publicToiletIcon = new ImageIcon(Image5);
	   
	    publictoiletbutton = new JButton(publicToiletIcon);  
        publictoiletbutton.setBounds(672,108,81,66); 
        publictoiletbutton.setBorderPainted(false);
		publictoiletbutton.setContentAreaFilled(false);
		
		JLabel publicToiletLabel = new JLabel ("Public Toilet");
	    publicToiletLabel.setBounds(673,170,130,70);
	    publicToiletLabel.setFont(fontstyle);
	    publicToiletLabel.setForeground(Color.BLACK);
	   
	   
	   
	   
	    ImageIcon drainageIcon = new ImageIcon(".\\All_Image\\drainagebutton.png");
        Image Image6 = drainageIcon.getImage().getScaledInstance(81,66, java.awt.Image.SCALE_SMOOTH);
        drainageIcon = new ImageIcon(Image6);
	   
	    drainagebutton = new JButton(drainageIcon);  
        drainagebutton.setBounds(784,108,81,66); 
        drainagebutton.setBorderPainted(false);
		drainagebutton.setContentAreaFilled(false);
		
		JLabel drainageLabel = new JLabel ("Drainage");
	    drainageLabel.setBounds(796,170,130,70);
	    drainageLabel.setFont(fontstyle);
	    drainageLabel.setForeground(Color.BLACK);
	   
	   
	   
	   
	    ImageIcon illegalStructureIcon = new ImageIcon(".\\All_Image\\illegal.png");
        Image Image7 = illegalStructureIcon.getImage().getScaledInstance(81,66, java.awt.Image.SCALE_SMOOTH);
        illegalStructureIcon = new ImageIcon(Image7);
	   
	    illegalStructurebutton = new JButton(illegalStructureIcon);  
        illegalStructurebutton.setBounds(896,108,81,66); 
        illegalStructurebutton.setBorderPainted(false);
		illegalStructurebutton.setContentAreaFilled(false);
		
		JLabel illegalStructureLabel = new JLabel ("Illegal Structure");
	    illegalStructureLabel.setBounds(886,170,130,70);
	    illegalStructureLabel.setFont(fontstyle);
	    illegalStructureLabel.setForeground(Color.BLACK);
	   
	   
	   
	   
	    ImageIcon waterlogIcon = new ImageIcon(".\\All_Image\\waterlogbutton.png");
        Image Image8 = waterlogIcon.getImage().getScaledInstance(81,66, java.awt.Image.SCALE_SMOOTH);
        waterlogIcon = new ImageIcon(Image8);
		
        waterlogbutton = new JButton(waterlogIcon);  
        waterlogbutton.setBounds(1008,108,81,66);
        waterlogbutton.setBorderPainted(false);
		waterlogbutton.setContentAreaFilled(false);
		
		JLabel waterlogLabel = new JLabel ("Waterlog");
	    waterlogLabel.setBounds(1018,170,130,70);
	    waterlogLabel.setFont(fontstyle);
	    waterlogLabel.setForeground(Color.BLACK);
	   
	     
		 
		 
		ImageIcon electricityIcon = new ImageIcon(".\\All_Image\\electricitybillbutton.png");
        Image Image9 = electricityIcon.getImage().getScaledInstance(81,66, java.awt.Image.SCALE_SMOOTH);
        electricityIcon = new ImageIcon(Image9);
	   
	    electricitybillbutton = new JButton(electricityIcon);  
        electricitybillbutton.setBounds(224,290,81,66); 
        electricitybillbutton.setBorderPainted(false);
		electricitybillbutton.setContentAreaFilled(false);
		
		JLabel electricityLabel = new JLabel ("Electricity bill");
	    electricityLabel.setBounds(223,352,130,70);
	    electricityLabel.setFont(fontstyle);
	    electricityLabel.setForeground(Color.BLACK);
	   
	   
	   
	   
	    ImageIcon waterIcon = new ImageIcon(".\\All_Image\\waterbillbutton.png");
        Image Image10 = waterIcon.getImage().getScaledInstance(81,66, java.awt.Image.SCALE_SMOOTH);
        waterIcon = new ImageIcon(Image10);
	   
        waterbillbutton = new JButton(waterIcon);  
        waterbillbutton.setBounds(336,290,81,66); 
        waterbillbutton.setBorderPainted(false);
		waterbillbutton.setContentAreaFilled(false);
		
		JLabel waterLabel = new JLabel ("Water bill");
	    waterLabel.setBounds(345,352,130,70);
	    waterLabel.setFont(fontstyle);
	    waterLabel.setForeground(Color.BLACK);
	   
         
		 
		 
		ImageIcon gasIcon = new ImageIcon(".\\All_Image\\gasbillbutton.png");
        Image Image11 = gasIcon.getImage().getScaledInstance(81,66, java.awt.Image.SCALE_SMOOTH);
        gasIcon = new ImageIcon(Image11);
        
        gasbillbutton = new JButton(gasIcon);  
        gasbillbutton.setBounds(448,290,81,66); 
        gasbillbutton.setBorderPainted(false);
        gasbillbutton.setContentAreaFilled(false);
		
		JLabel gasLabel = new JLabel ("Gas bill");
	    gasLabel.setBounds(464, 352, 130, 70);
	    gasLabel.setFont(fontstyle);
	    gasLabel.setForeground(Color.BLACK);
	   
	   
	   
	   
	    ImageIcon emergencyIcon = new ImageIcon(".\\All_Image\\emergencybutton.png");
        Image Image12 = emergencyIcon.getImage().getScaledInstance(81,66, java.awt.Image.SCALE_SMOOTH);
        emergencyIcon = new ImageIcon(Image12);
	   
	    emergencybutton = new JButton(emergencyIcon); 
        emergencybutton.setBounds(220,472,81,66); 
        emergencybutton.setBorderPainted(false);
        emergencybutton.setContentAreaFilled(false);
	   
	    JLabel contactLabel = new JLabel ("Emergency Numbers");
	    contactLabel.setBounds(197,534,200,70);
	    contactLabel.setFont(fontstyle);
	    contactLabel.setForeground(Color.BLACK);
	   
	   
	   
	   
	    ImageIcon accountIcon = new ImageIcon(".\\All_Image\\Accountbutton.png");
        Image Image13 = accountIcon.getImage().getScaledInstance(182,44, java.awt.Image.SCALE_SMOOTH);
        accountIcon = new ImageIcon(Image13);
	   
	    accountbutton = new JButton(accountIcon);
	    accountbutton.setBounds(5,84,182,44);
	    accountbutton.setBorderPainted(false);
		accountbutton.setContentAreaFilled(false);
	    
	
	
	
	    /*ImageIcon eventIcon = new ImageIcon("All_Image\\Eventbutton.png");
        Image Image14 = eventIcon.getImage().getScaledInstance(182,44, java.awt.Image.SCALE_SMOOTH);
        eventIcon = new ImageIcon(Image14);
	
	    eventbutton = new JButton(eventIcon);
	    eventbutton.setBounds(5,133,182,44);
	    eventbutton.setBorderPainted(false);
		eventbutton.setContentAreaFilled(false);
		*/
		
		
        
		ImageIcon aboutusIcon = new ImageIcon(".\\All_Image\\Aboutusbutton.png");
        Image Image15 = aboutusIcon.getImage().getScaledInstance(182,44, java.awt.Image.SCALE_SMOOTH);
        aboutusIcon = new ImageIcon(Image15);
	
	    aboutusbutton = new JButton(aboutusIcon);
	    aboutusbutton.setBounds(5,133,182,44);
	    aboutusbutton.setBorderPainted(false);
		aboutusbutton.setContentAreaFilled(false);
	    
	
	
	
	
	    ImageIcon logoutIcon = new ImageIcon(".\\All_Image\\logoutbutton.png");
        Image Image16 = logoutIcon.getImage().getScaledInstance(182,44, java.awt.Image.SCALE_SMOOTH);
        logoutIcon = new ImageIcon(Image16);
	
	    logoutbutton = new JButton(logoutIcon);
	    logoutbutton.setBounds(5,182,182,44);
	    logoutbutton.setBorderPainted(false);
		logoutbutton.setContentAreaFilled(false);
	    
	
	
	    contactbutton = new JButton("Contact Us");
	    contactbutton.setBounds(947,8,170,40);
	    contactbutton.setBorderPainted(false);
        contactbutton.setContentAreaFilled(false);
	    contactbutton.setForeground(Color.black);
        contactbutton.setFont(fontstyle2);
	
		
		ImageIcon ImageIcon = new ImageIcon(".\\All_Image\\L2.png");
        Image Image = ImageIcon.getImage();
		
		JLabel Background;
        ImageIcon img = new ImageIcon(".\\All_Image\\Mainmenu.png");
        Background = new JLabel ("",img,JLabel.CENTER);
        Background.setBounds(0,0,1120,630);

        f2.add(roadbutton); 
		f2.add(roadLabel);
        f2.add(mosquitobutton);
		f2.add(logoutbutton);
		f2.add(mosquitoLabel);
        f2.add(garbagebutton);
		f2.add(garbageLabel);
        f2.add(streetlightbutton);
		f2.add(streetLabel);
        f2.add(waterlogbutton);
		f2.add(waterlogLabel);
        f2.add(drainagebutton);
		f2.add(drainageLabel);
        f2.add(illegalStructurebutton);
		f2.add(illegalStructureLabel);
        f2.add(publictoiletbutton);
		f2.add(publicToiletLabel);
        f2.add(waterbillbutton);
		f2.add(waterLabel);
        f2.add(electricitybillbutton);
		f2.add(electricityLabel);
        f2.add(gasbillbutton);
		f2.add(gasLabel);
		f2.add(emergencybutton);
		f2.add(accountbutton);
		f2.add(aboutusbutton);
		f2.add(contactLabel);
		f2.add(contactbutton);
		f2.add(roadLabel);
        f2.setIconImage(Image);
        f2.add(Background);
        f2.setSize(1120, 630);
        f2.setLocationRelativeTo(null);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.setVisible(true);
		
		roadbutton.addActionListener(this);
		mosquitobutton.addActionListener(this);
		garbagebutton.addActionListener(this);
		streetlightbutton.addActionListener(this);
		waterlogbutton.addActionListener(this);
		drainagebutton.addActionListener(this);
		illegalStructurebutton.addActionListener(this);
		publictoiletbutton.addActionListener(this);
		waterbillbutton.addActionListener(this);
		electricitybillbutton.addActionListener(this);
		gasbillbutton.addActionListener(this);
		accountbutton.addActionListener(this);
		emergencybutton.addActionListener(this);
		aboutusbutton.addActionListener(this);
		contactbutton.addActionListener(this);
		logoutbutton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
	      
	  
		if (e.getSource() == roadbutton) {
			f2.setVisible(false);
            Road f4 = new Road(email);	
		}
		else if (e.getSource() == mosquitobutton) {
			f2.setVisible(false);
                Mosquito f4 = new Mosquito(email);
		}
		else if (e.getSource() == garbagebutton) {
			f2.setVisible(false);
			Garbage f4 = new Garbage(email);
		}
		else if (e.getSource() == streetlightbutton) {
			f2.setVisible(false);
			Street_Light f6 = new Street_Light(email);
		}
		else if (e.getSource() == publictoiletbutton) {
			f2.setVisible(false);
		Publictoilet f6 = new Publictoilet(email);
		}
		else if (e.getSource() == drainagebutton) {
			f2.setVisible(false);
			Drainage f6 = new Drainage(email);
		}
		else if (e.getSource() == illegalStructurebutton) {
			f2.setVisible(false);
			
			Illegalstructure f6 = new Illegalstructure(email);
		}
		else if (e.getSource() == waterlogbutton) {
			f2.setVisible(false);
			Waterlog f6 = new Waterlog(email);
		}
		else if (e.getSource() == electricitybillbutton) {
		    f2.setVisible(false);
			 String imagepath=".\\All_Image\\Electricity Bill.png";
			 String filpath=".\\All_Text_File\\electricbill.txt";
		     SearchBill f6 = new SearchBill(email,imagepath,filpath);
		}
        else if (e.getSource() == waterbillbutton) {
			f2.setVisible(false);
		     String imagepath=".\\All_Image\\WaterBill.png";
			 String filpath=".\\All_Text_File\\waterbill.txt";
		     SearchWaterBill f6 = new SearchWaterBill(email,imagepath,filpath);
		}
		else if (e.getSource() == gasbillbutton) {
			f2.setVisible(false);
			 String imagepath=".\\All_Image\\GasBill.png";
			 String filpath=".\\All_Text_File\\gasbill.txt";
		     SearchGasBill f6 = new SearchGasBill(email,imagepath,filpath);
		}
		else if (e.getSource() == emergencybutton) {
			f2.setVisible(false);
			Emergency f5=new Emergency(email);
		} 
		else if (e.getSource() == accountbutton) {
			f2.setVisible(false);
		    Acc f6 = new Acc(email);
		}
	
		else  if (e.getSource() == contactbutton) {
			
			    f2.setVisible(false);
                ContactUs f3 = new ContactUs(email);
       
        }
		else  if (e.getSource() == aboutusbutton) {
			
			    f2.setVisible(false);
                Aboutus f3 = new Aboutus(email);
        
        }
	else if (e.getSource() == logoutbutton) {
			f2.setVisible(false);
            Login f4 = new Login();
		}
		
	}
	
	
}




