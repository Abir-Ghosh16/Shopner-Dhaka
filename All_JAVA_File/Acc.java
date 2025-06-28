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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Acc extends JFrame implements ActionListener {
    private FileWriter fw;
    private Exception ae;
    FileReader fr;
    private JFrame f;
	private JButton back;
    private String email;
	private String file;
	private Font fontstyle2;
	String firstname = "";
	String lastname = "";
	String uname = "";
	String pnumber = "";
	String emailn = "";
	String dob = "";
	
    Acc(String email) {
        f = new JFrame("Account Information");
		this.email = email;
		file = email.substring(0, email.length() - 4);
		
		fontstyle2 = new Font("cambria", Font.PLAIN, 16);
		
        back = new JButton("Back");
        back.setBounds(960, 500, 80, 30);
        back.addActionListener(this);
		
		try (FileReader fr = new FileReader("./All_Text_File/"+file);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(": ");
                if (row[0].equals("First name")) {
                    firstname = row[1];
                } else if (row[0].equals("last name")) {
                    lastname = row[1];
                } else if (row[0].equals("Username")) {
                    uname = row[1];
                } else if (row[0].equals("Phone number")) {
                    pnumber = row[1];
                } else if (row[0].equals("Email")) {
                    emailn = row[1];
                }
				else if (row[0].equals("Date of birth")) {
                    dob = row[1];
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Acc.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		JLabel usernameLabel = new JLabel("Username          :");
        usernameLabel.setBounds(440, 250, 130, 30);
		usernameLabel.setFont(fontstyle2);
		usernameLabel.setForeground(Color.black);
		
		JLabel uLabel = new JLabel(uname);
		//uLabel.setHorizontalAlignment(JLabel.CENTER);
		//uLabel.setLocation(0, 300);
        uLabel.setBounds(575, 250, 120, 30);
		uLabel.setFont(fontstyle2);
		uLabel.setForeground(Color.black);
		
		JLabel firstnameLabel = new JLabel("First name         :");
        firstnameLabel.setBounds(440, 300, 130, 30);
		firstnameLabel.setFont(fontstyle2);
		firstnameLabel.setForeground(Color.black);
		
		JLabel fLabel = new JLabel(firstname);
        fLabel.setBounds(575, 300, 120, 30);
		fLabel.setFont(fontstyle2);
		fLabel.setForeground(Color.black);
		
		JLabel lastnameLabel = new JLabel("Last name          :");
        lastnameLabel.setBounds(440, 350, 130, 30);
		lastnameLabel.setFont(fontstyle2);
		lastnameLabel.setForeground(Color.black);
		
		JLabel lLabel = new JLabel(lastname);
        lLabel.setBounds(575, 350, 120, 30);
		lLabel.setFont(fontstyle2);
		lLabel.setForeground(Color.black);
		
		JLabel mailLabel = new JLabel("Email                    :" );
        mailLabel.setBounds(440, 400, 130, 30);
		mailLabel.setFont(fontstyle2);
		mailLabel.setForeground(Color.black);
		
		JLabel emailLabel = new JLabel(emailn);
        emailLabel.setBounds(575, 400, 200, 30);
		emailLabel.setFont(fontstyle2);
		emailLabel.setForeground(Color.black);
		
		JLabel phonenumberLabel = new JLabel("Phone Number :");
        phonenumberLabel.setBounds(440, 450, 130, 30);
		phonenumberLabel.setFont(fontstyle2);
		phonenumberLabel.setForeground(Color.black);
		
		JLabel phoneLabel = new JLabel(pnumber);
        phoneLabel.setBounds(575, 450, 180, 30);
		phoneLabel.setFont(fontstyle2);
		phoneLabel.setForeground(Color.black);
		
		JLabel dobLabel = new JLabel("Date of birth   :");
        dobLabel.setBounds(440, 490, 130, 30);
		dobLabel.setFont(fontstyle2);
		dobLabel.setForeground(Color.black);
		
		JLabel getdobLabel = new JLabel(dob);
        getdobLabel.setBounds(575, 490, 180, 30);
		getdobLabel.setFont(fontstyle2);
		getdobLabel.setForeground(Color.black);
		
		
		ImageIcon imageIcon = new ImageIcon(".\\All_Image\\L6.png");
        Image image = imageIcon.getImage();

        JLabel background;
        ImageIcon img = new ImageIcon(".\\All_Image\\AccInfo.png");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1106, 595);
		
		f.add(firstnameLabel);
        f.add(lastnameLabel);
		f.add(usernameLabel);
        f.add(phonenumberLabel);
		f.add(mailLabel);
		f.add(fLabel);
        f.add(lLabel);
        f.add(phoneLabel);
		f.add(uLabel);
        f.add(back);
        f.add(emailLabel);
		f.add(dobLabel);
		f.add(getdobLabel);
		f.setIconImage(image);
        f.add(background);
       
        f.setSize(1120, 630);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
			
			    f.setVisible(false);
                MainMenu f2 = new MainMenu(email);
        }
    }

 
}


	
	
	
	
	
	
	
	
